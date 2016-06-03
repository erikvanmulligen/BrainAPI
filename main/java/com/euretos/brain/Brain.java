/**
 * 
 */
package com.euretos.brain;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class Brain {
    static JsonSerializer<Date> ser = new JsonSerializer<Date>() {
	@Override
	public JsonElement serialize(Date src, Type arg1, JsonSerializationContext arg2) {
	    return src == null ? null : new JsonPrimitive(src.getTime());
	}
    };

    static JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
	@Override
	public Date deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
	    return json == null ? null : new Date(json.getAsLong());
	}
    };

    private static String username = null;
    private static String password = null;
    private static String endpoint = null;
    private static String token = null;
    private static long connectTime = 0;
    private static Gson gson = new GsonBuilder().registerTypeAdapter( Date.class, ser ).registerTypeAdapter( Date.class, deser ).create();
    private static LRUMap<String,PublicationInfo> publicationMap = new LRUMap<String,PublicationInfo>(1000);
    private static LRUMap<String, List<String>> entitiesMap = new LRUMap<String,List<String>>(20);

    private static HashMap<String,SemanticCategoryInfo> semanticCategoriesMap = null; 

    public Brain( String aEndpoint, String aUsername, String aPassword ){
	username = aUsername;
	password = aPassword;
	endpoint = aEndpoint;
	boolean status = connect();
	if ( ! status ){
	    Logger.error( "login failed" );
	}
    }

    public List<PathElement> getDirectPaths( List<String> sourceUuids, List<String> targetUuids, Integer page, Integer size ){
	PostResponse response = Utils.postUrl( endpoint + "/relationships/direct?" + page + "&size=" + size, gson.toJson( new SearchSpecification( sourceUuids, targetUuids ) ), token );
	System.out.println(response.getContent());
	return response.getStatus() == 200 ? gson.fromJson( response.getContent(), DirectRelationshipResponse.class ).convert() : null;
    }

    public List<PathElement> getDirectPaths( String source, String target, Integer page, Integer size ){
	return getDirectPaths(getUUID( source ), getUUID( target ), page, size);
    }

    public List<Path> getIndirectPaths( List<String> sourceUuids, List<String> targetUuids, Integer page, Integer size ){
	PostResponse response = Utils.postUrl( endpoint + "/relationships/indirect?page=" + page + "&size=" + size, gson.toJson( new SearchSpecification( sourceUuids, targetUuids ) ), token );
	//System.out.println(response.getContent());
	return response.getStatus() == 200 ? gson.fromJson( response.getContent(), IndirectRelationshipResponse.class ).convertToPaths(true, null) : null;
    }

    public List<PathElement> getIndirectPaths( String source, String target, Integer page, Integer size ){
	PostResponse response = Utils.postUrl( endpoint + "/relationships/indirect?page=" + page + "&size=" + size, gson.toJson( new SearchSpecification( getUUID( source ), getUUID( target ) ) ), token );
	return response.getStatus() == 200 ? gson.fromJson( response.getContent(), IndirectRelationshipResponse.class ).convert() : null;
    }

    public List<PathElement> getTwoStepPaths( String source, String target, Integer page, Integer size ){
	PostResponse response = Utils.postUrl( endpoint + "/relationships/twostep?page=" + page + "&size=" + size, gson.toJson(new SearchSpecification( getUUID(source),  getUUID(target) ) ), token );
	return response.getStatus() == 200 ? gson.fromJson( response.getContent(), TwoStepRelationshipResponse.class ).convert() : null;
    }

    public boolean connect(){
	if ( ( System.currentTimeMillis() - connectTime ) > ( 1000 * 60 * 5 ) ){
	    Logger.info("connect");
	    PostResponse response = Utils.postUrl(endpoint + "/login/authenticate", gson.toJson(new AuthenticateObject(username, password)), token );
	    if ( response.getStatus() == 200 ){
		LoginResponse loginResponse = gson.fromJson(response.getContent(), LoginResponse.class);
		token = loginResponse.getToken();
		connectTime = System.currentTimeMillis();
		Logger.info("connected");
		return token != null;
	    }
	    return false;
	}
	return true;
    }

    public ConceptResponse getConcept( String uuid ) {
	ConceptResponse result = new ConceptResponse();
	PostResponse response = Utils.getUrl( endpoint + "/concept/" + uuid, token );
	if ( response.getStatus() == 200 ){
	    result = gson.fromJson(response.getContent(), ConceptResponse.class);
	}
	return result;
    }

    public List<String> getUUID( String term ){
	if ( ! entitiesMap.containsKey( term ) ){
	    List<String> result = new ArrayList<String>();
	    PostResponse response = Utils.postUrl( endpoint + "/concept/search", gson.toJson(new ModelObject(term)), token );
	    if ( response.getStatus() == 200 ){
		ModelItem[] modelItems = gson.fromJson(response.getContent(), ModelItem[].class);
		for (int i = 0 ; i< modelItems.length ;i++ ){
		    result.add(modelItems[i].getId());
		}
		entitiesMap.put( term, result );
		return result;
	    }
	    return null;
	}
	else{
	    return entitiesMap.get( term );
	}
    }

    public List<String> getUUID( String term, String category ){
	if ( ! entitiesMap.containsKey( term ) ){
	    List<String> result = new ArrayList<String>();
	    PostResponse response = Utils.postUrl( endpoint + "/concept/searchWithSemantic", gson.toJson( new ModelObject( term, category ) ), token );
	    if (response.getStatus() == 200){
		ModelItem[] modelItems = gson.fromJson( response.getContent(), ModelItem[].class );
		for (int i = 0 ; i < modelItems.length ;i++ ){
		    result.add( modelItems[i].getId() );
		}
		entitiesMap.put( term, result );
		return result;
	    }
	    return null;
	}
	else{
	    return entitiesMap.get( term );
	}
    }

    public List<ProvenanceElt> getProvenance(String uuid) {
	List<ProvenanceElt> result = new ArrayList<ProvenanceElt>();

	PostResponse response = Utils.postUrl( endpoint + "/triple/getTriples", gson.toJson(new UuidsObject(uuid)), token );
	if (response.getStatus() == 200){
	    Triples triples = gson.fromJson(response.getContent(), Triples.class);
	    for ( Triples.Triple triple : triples.getTriples()){
		ProvenanceElt provenanceElt = new ProvenanceElt();
		provenanceElt.setTarget(triple.getObjectUuid());
		provenanceElt.setTargetName(triple.getObjectName());
		provenanceElt.setSources(getPublications(triple.getPublications()));
		result.add(provenanceElt);
	    }
	}

	return result;
    }

    public Integer getProvenanceCount(String uuid) {
	Integer result = 0;
	PostResponse response = Utils.postUrl( endpoint + "/triple/getTriples", gson.toJson(new UuidsObject(uuid)), token );
	if (response.getStatus() == 200){
	    Triples triples = gson.fromJson(response.getContent(), Triples.class);
	    for ( Triples.Triple triple : triples.getTriples()){
		result += triple.getPublications() != null ? triple.getPublications().size() : 0;
	    }
	}
	return result;
    }

    private List<SourceElt> getPublications( List<String> publications) {
	List<SourceElt> result = new ArrayList<SourceElt>();
	PostResponse response = Utils.postUrl( endpoint + "/publications", gson.toJson( new IdsObject(publications) ), token );
	if ( response.getStatus() == 200 ){
	    JsonArray jarray = new JsonParser().parse( response.getContent() ).getAsJsonObject().getAsJsonArray( "publications" );
	    for (int i = 0 ; i < jarray.size() ; i++ ){
		result.add(new SourceElt( jarray.get(i).getAsJsonObject() ) );
	    }
	}
	return result;
    }

    private TreeMap<String,PublicationInfo> getAllPublications( Set<String> publicationsIds) {
	TreeMap<String,PublicationInfo> result = new TreeMap<String,PublicationInfo>();
	PostResponse response = Utils.postUrl( endpoint + "/publications", gson.toJson( new IdsObject(publicationsIds) ), token );
	if ( response.getStatus() == 200 ){
	    JsonArray publications = new JsonParser().parse( response.getContent() ).getAsJsonObject().getAsJsonArray( "publications" );
	    for ( int i = 0 ; i < publications.size() ; i++ ){
		JsonObject publication = publications.get(i).getAsJsonObject();
		String id = publication.get("id").getAsString();
		JsonObject publicationInfo = publication.get("publicationInfo").getAsJsonObject();
		JsonElement scientificValue = publication.get("measures").getAsJsonObject().get("scientific_value");
		result.put( id, new PublicationResponse( publicationInfo ).convert( scientificValue != null ? scientificValue.toString() : null ) );
	    }
	}
	return result;
    }

    /**
     * @param string
     * @param semanticCategory
     */
    public PathResponse searchDirectKeyword( Integer page, Integer size, String uuid, String semanticCategory) {
	PathResponse pathResponse = new PathResponse();
	PostResponse response = Utils.postUrl( endpoint + "/keyword-analysis/direct?page=" + page + "&size=" + size, gson.toJson(new SearchDirectInput(uuid, getSemanticCategory( semanticCategory ))), token );

	if ( response.getStatus() == 200 ){

	    SearchDirectResponse searchDirectResponse = new SearchDirectResponse( new JsonParser().parse( response.getContent() ).getAsJsonObject() );

	    pathResponse.setFirst( searchDirectResponse.getFirst() );
	    pathResponse.setLast( searchDirectResponse.getLast() );
	    pathResponse.setTotalElements( searchDirectResponse.getTotalElements() );
	    pathResponse.setTotalPages( searchDirectResponse.getTotalPages() );
	    pathResponse.setSort( searchDirectResponse.getSort() );
	    pathResponse.setNumberOfElements( searchDirectResponse.getNumberOfElements() );
	    pathResponse.setSize( searchDirectResponse.getSize() );
	    pathResponse.setNumber( searchDirectResponse.getNumber() );

	    /*
	     * copy the searchDirectResponse results to the final response
	     */
	    for ( SearchDirectElementResponse searchDirectResponseElement : searchDirectResponse.getContent() ){
		Path path = new Path();
		path.setSourceName( searchDirectResponseElement.getConceptName() );
		path.setSourceUuid( searchDirectResponseElement.getConceptUuid() );
		path.setTargetName( searchDirectResponseElement.getLinkedConcept().getName() );
		path.setTargetUuid( searchDirectResponseElement.getLinkedConcept().getUuid() );

		PathElt triple = new PathElt();
		triple.setSourceName( searchDirectResponseElement.getConceptName() );
		triple.setSourceUuid( searchDirectResponseElement.getConceptUuid() );
		triple.setTargetName( searchDirectResponseElement.getLinkedConcept().getName() );
		triple.setTargetUuid( searchDirectResponseElement.getLinkedConcept().getUuid() );

		for ( PublicationInfoResponse publication : searchDirectResponseElement.getPublications() ){
		    PublicationInfo publicationInfo = new PublicationInfo( publication.getUuid() );
		    publicationInfo.setTitle( publication.getPublicationInfo().getDocumentTitle() );
		    publicationInfo.setId( publication.getPublicationInfo().getDocumentIdentifier() );
		    publicationInfo.setSourceId( publication.getPublicationInfo().getPublicationSourceId() );
		    triple.addPublication( publicationInfo );
		}
		path.addTriple( triple );
		pathResponse.addPath(path);
	    }
	}

	return pathResponse;
    }

    public PathResponse searchKeywordToSemanticTypeDirect( Integer page, Integer size, String sourceUuid, String category, String algorithm, String sort, Boolean publications, Boolean predicates ) {
	PathResponse pathResponse = new PathResponse();
	PostResponse response = Utils.postUrl( endpoint + "/keywordToSemanticType/direct?page=" + page + "&size=" + size, gson.toJson( new KeywordToSemanticTypeInput( sourceUuid, category, algorithm, sort ) ), token );

	if ( response.getStatus().equals( 200 ) ){
	    DirectRelationshipResponse directRelationshipResponse = new DirectRelationshipResponse( new JsonParser().parse( response.getContent() ).getAsJsonObject() );

	    pathResponse.setFirst( directRelationshipResponse.getFirst() );
	    pathResponse.setLast( directRelationshipResponse.getLast() );
	    pathResponse.setNumber( directRelationshipResponse.getNumber() );
	    pathResponse.setNumberOfElements( directRelationshipResponse.getNumberOfElements() );
	    pathResponse.setSize( directRelationshipResponse.getSize() );
	    pathResponse.setSort( directRelationshipResponse.getSort() );
	    pathResponse.setTotalElements( directRelationshipResponse.getTotalElements() );
	    pathResponse.setTotalPages( directRelationshipResponse.getTotalPages() );
	    pathResponse.setMaxScore( directRelationshipResponse.getMaxPathWeight() );
	    pathResponse.setPaths( directRelationshipResponse.convertToPaths( predicates, directRelationshipResponse.getMaxPathWeight() ) );

	    if ( publications ){
		resolvePublications(pathResponse);
	    }
	}

	return pathResponse;
    }

    private Set<String> getPublicationIds(TreeMap<String, List<String>> triple2publication) {
	HashSet<String> result = new HashSet<String>();
	for (  Entry<String, List<String>> elt : triple2publication.entrySet() ){
	    if ( elt != null && elt.getValue() != null){
		result.addAll(elt.getValue());
	    }
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    private TreeMap<String, List<String>> getTriples(Set<String> tripleIds) {
	TreeMap<String, List<String>> result = new TreeMap<String,List<String>>();
	Type listType = new TypeToken<List<String>>() {}.getType();

	PostResponse response = Utils.postUrl( endpoint + "/triple/getTriples", gson.toJson( new UuidsInput( tripleIds ) ), token);
	if ( response.getStatus().equals( 200 ) ){
	    JsonArray triples = new JsonParser().parse( response.getContent() ).getAsJsonObject().get("triples").getAsJsonArray();
	    for ( int i = 0 ; i < triples.size() ; i++ ){
		JsonObject object = triples.get(i).getAsJsonObject();
		List<String> publications = (List<String>)new Gson().fromJson(object.get("publications"), listType);
		if ( publications == null ){
		    publications = new ArrayList<String>();
		}
		result.put( object.get("id").getAsString(),  publications);
	    }

	}
	return result;
    }

    public PathResponse searchKeywordToSemanticTypeIndirect( Integer page, Integer size, String sourceUuid, String category, String algorithm, String sort, Boolean publications, Boolean predicates ) {
	PathResponse pathResponse = new PathResponse();
	PostResponse response = Utils.postUrl( endpoint + "/keywordToSemanticType/indirect?page=" + page + "&size=" + size, gson.toJson( new KeywordToSemanticTypeInput( sourceUuid, category, algorithm, sort ) ), token );

	if ( response.getStatus().equals( 200 ) ){

	    IndirectRelationshipResponse indirectRelationshipResponse = new IndirectRelationshipResponse( new JsonParser().parse( response.getContent() ).getAsJsonObject() );

	    pathResponse.setFirst( indirectRelationshipResponse.getFirst() );
	    pathResponse.setLast( indirectRelationshipResponse.getLast() );
	    pathResponse.setNumber( indirectRelationshipResponse.getNumber() );
	    pathResponse.setNumberOfElements( indirectRelationshipResponse.getNumberOfElements() );
	    pathResponse.setSize( indirectRelationshipResponse.getSize() );
	    pathResponse.setSort( indirectRelationshipResponse.getSort() );
	    pathResponse.setTotalElements( indirectRelationshipResponse.getTotalElements() );
	    pathResponse.setTotalPages( indirectRelationshipResponse.getTotalPages() );
	    pathResponse.setMaxScore( indirectRelationshipResponse.getMaxPathWeight() );
	    pathResponse.setPaths( indirectRelationshipResponse.convertToPaths( predicates, indirectRelationshipResponse.getMaxPathWeight() ) );

	    if ( publications ){
		resolvePublications( pathResponse );
	    }
	}


	return pathResponse;
    }

    private void resolvePublications(PathResponse pathResponse) {
	/*
	 * collect publications
	 */
	Set<String> tripleIds = new HashSet<String>();
	for ( Path path : pathResponse.getPaths() ){
	    for ( PathElt triple : path.getTriples() ){
		tripleIds.add( triple.getTripleUuid() );
	    }
	}

	TreeMap<String,List<String>> triple2publication = getTriples( tripleIds );
	TreeMap<String,PublicationInfo> publicationInfo = getAllPublications( getPublicationIds( triple2publication ) );
	/* add publications to triples */
	for ( Path path : pathResponse.getPaths() ){
	    for ( PathElt triple : path.getTriples() ){
		for ( String publicationId : triple2publication.get(triple.getTripleUuid()) ){
		    triple.addPublication( publicationInfo.get(publicationId) );
		}
	    }
	}
    }

    public List<String> getPublicationsPerTriple(String tripleUuid) {
	List<String> result = new ArrayList<String>();
	PostResponse response = Utils.postUrl( endpoint + "/triple/getPublicationUuids", gson.toJson( new UuidsInput( tripleUuid ) ), token);

	if ( response.getStatus().equals( 200 ) ){
	    JsonArray publicationIds = new JsonParser().parse( response.getContent() ).getAsJsonArray();
	    for ( int i = 0 ; i < publicationIds.size() ; i++ ){
		result.add( publicationIds.get( i ).getAsString() );
	    }
	}
	return result;
    }

    public List<String> getPublicationIdsForTriples( Set<String> tripleUuids){
	List<String> result = new ArrayList<String>();
	PostResponse response = Utils.postUrl( endpoint + "/triple/getPublicationUuids", gson.toJson( new UuidsInput( tripleUuids ) ), token);
	if ( response.getStatus().equals( 200 ) ){
	    JsonArray publicationIds = new JsonParser().parse( response.getContent() ).getAsJsonArray();
	    for ( int i = 0 ; i < publicationIds.size() ; i++ ){
		result.add( publicationIds.get( i ).getAsString() );
	    }
	}
	return result;
    }

    public PathResponse searchIndirectKeyword( Integer page, Integer size, String uuid, String semanticCategory) {
	PathResponse pathResponse = new PathResponse();

	PostResponse response = Utils.postUrl( endpoint + "/keyword-analysis/indirect?page=" + page + "&size=" + size, 
		gson.toJson( new SearchIndirectInput( uuid, getSemanticCategory( semanticCategory ) )), token);

	if ( response.getStatus() == 200 ){
	    SearchIndirectResponse searchIndirectResponse = new SearchIndirectResponse( new JsonParser().parse( response.getContent() ).getAsJsonObject() );

	    pathResponse.setFirst( searchIndirectResponse.getFirst() );
	    pathResponse.setLast( searchIndirectResponse.getLast() );
	    pathResponse.setTotalElements( searchIndirectResponse.getTotalElements() );
	    pathResponse.setTotalPages( searchIndirectResponse.getTotalPages() );
	    pathResponse.setSort( searchIndirectResponse.getSort() );
	    pathResponse.setNumberOfElements( searchIndirectResponse.getNumberOfElements() );
	    pathResponse.setSize( searchIndirectResponse.getSize() );
	    pathResponse.setNumber( searchIndirectResponse.getNumber() );

	    for ( SearchIndirectElementResponse searchIndirectResponseElement : searchIndirectResponse.getContent() ){
		Path path = new Path();
		path.setSourceName( searchIndirectResponseElement.getLhPublications().getKeywordName() );
		path.setSourceUuid( searchIndirectResponseElement.getLhPublications().getKeywordUuid() );
		path.setTargetName( searchIndirectResponseElement.getRhPublications().getKeywordName() );
		path.setTargetUuid( searchIndirectResponseElement.getRhPublications().getKeywordUuid() );

		PathElt leftTriple = new PathElt();
		leftTriple.setSourceName( searchIndirectResponseElement.getLhPublications().getKeywordName() );
		leftTriple.setSourceUuid( searchIndirectResponseElement.getLhPublications().getKeywordUuid() );
		leftTriple.setTargetName( searchIndirectResponseElement.getLeftConcept().getName() );
		leftTriple.setTargetUuid( searchIndirectResponseElement.getLeftConcept().getUuid() );
		leftTriple.setPredicateName( searchIndirectResponseElement.getLhPublications().getPredicateName() );
		leftTriple.setTripleUuid( searchIndirectResponseElement.getLhPublications().getTripleUuid() );

		for ( PublicationInfo publication : searchIndirectResponseElement.getLhPublications().getPublications() ){
		    PublicationInfo publicationInfo = new PublicationInfo( publication.getUuid() );
		    leftTriple.addPublication( publicationInfo );
		}
		path.addTriple( leftTriple );

		PathElt rightTriple = new PathElt();
		rightTriple.setSourceName( searchIndirectResponseElement.getLeftConcept().getName() );
		rightTriple.setSourceUuid( searchIndirectResponseElement.getLeftConcept().getUuid() );
		rightTriple.setTargetName( searchIndirectResponseElement.getRhPublications().getKeywordName() );
		rightTriple.setTargetUuid( searchIndirectResponseElement.getRhPublications().getKeywordUuid() );
		rightTriple.setPredicateName( searchIndirectResponseElement.getRhPublications().getPredicateName() );
		rightTriple.setTripleUuid( searchIndirectResponseElement.getRhPublications().getTripleUuid() );

		for ( PublicationInfo publication : searchIndirectResponseElement.getRhPublications().getPublications() ){
		    PublicationInfo publicationInfo = new PublicationInfo( publication.getUuid() );
		    rightTriple.addPublication( publicationInfo );
		}
		path.addTriple( rightTriple );
		pathResponse.addPath(path);
	    }
	}

	return pathResponse;
    }

    public SemanticCategoryInfo getSemanticCategory( String semanticCategory ) {
	if ( semanticCategoriesMap == null ){
	    semanticCategoriesMap = new HashMap<String, SemanticCategoryInfo>();
	    PostResponse response = Utils.getUrl(endpoint + "/semantic/categories", token );
	    if ( response.getStatus() == 200 ){
		JsonArray jarray = new JsonParser().parse( response.getContent() ).getAsJsonArray();
		for ( int i = 0 ; i < jarray.size() ; i++ ){
		    SemanticCategoryInfo semanticCategoryInfo = new SemanticCategoryInfo( jarray.get(i).getAsJsonObject() );
		    semanticCategoriesMap.put( semanticCategoryInfo.getCategory(), semanticCategoryInfo );
		}
	    }
	}
	return semanticCategoriesMap.get( semanticCategory );
    }

    public static PublicationInfo getPublication( String uuid ) {

	if ( ! publicationMap.containsKey( uuid ) ){
	    PostResponse response = Utils.getUrl( endpoint + "/publication/" + uuid, token );

	    if ( response.getStatus() == 200 ){
		FullPublicationResponse result = gson.fromJson( response.getContent(), FullPublicationResponse.class );
		PublicationResponse publicationInfo = result.getPublicationInfo();
		if (publicationInfo!=null){
		    publicationMap.put( uuid, publicationInfo.convert( result.getMeasures() ) );
		}
	    }
	    else {
		return null;
	    }
	}
	return publicationMap.get( uuid );
    }

    public PathResponse searchKeyword(String mode, String uuid, String category, Integer page, Integer size) {
	return mode.equalsIgnoreCase("direct") ? searchDirectKeyword(page, size, uuid, category) : searchIndirectKeyword(page, size, uuid, category);
    }

    public PathResponse searchKeywordToSemanticType(String mode, Boolean publications, Boolean predicates, String uuid, String category, String algorithm, String sort, Integer page, Integer size) {
	//Logger.info( "searchKeywordToSemanticType(" + mode + "," + publications + "," + uuid + "," + category + "," + algorithm + "," +  sort + "," + page + "," + size);
	return mode.equalsIgnoreCase("direct") ? searchKeywordToSemanticTypeDirect(page, size, uuid, category, algorithm, sort, publications, predicates) : searchKeywordToSemanticTypeIndirect(page, size, uuid, category, algorithm, sort, publications, predicates);
    }

    public EntityResponse match(String search) {
	EntityResponse entityResponse = new EntityResponse();

	ModelObject model = new ModelObject( search );
	model.setSearchModel("STARTS_WITH");
	PostResponse response = Utils.postUrl( endpoint + "/concept/search", gson.toJson( model ), token );
	if ( response.getStatus() == 200 ){
	    ModelItem[] modelItems = gson.fromJson( response.getContent(), ModelItem[].class );
	    entityResponse.addEntitities( Arrays.asList( modelItems ) );
	}
	return entityResponse;
    }

    public List<String> searchDirectKeywords(int page, int size, String uuid, String semanticCategory) {
	List<String> result = new ArrayList<String>();
	PostResponse response = Utils.postUrl(endpoint + "/keyword-analysis/direct?page=" + page + "&size=" + size, gson.toJson(new SearchDirectInput(uuid, getSemanticCategory( semanticCategory ))), token );

	if ( response.getStatus() == 200 ){
	    SearchDirectResponse searchDirectResponse = new SearchDirectResponse( new JsonParser().parse( response.getContent() ).getAsJsonObject() );

	    /*
	     * copy the searchDirectResponse results to the final response
	     */
	    for ( SearchDirectElementResponse searchDirectResponseElement : searchDirectResponse.getContent() ){
		result.add( searchDirectResponseElement.getLinkedConcept().getUuid() );
	    }
	}

	return result;
    }

    public List<String> searchIndirectKeywords(int page, int size, String uuid, String semanticCategory) {
	List<String> result = new ArrayList<String>();
	PostResponse response = Utils.postUrl(endpoint + "/keyword-analysis/indirect?page=" + page + "&size=" + size, gson.toJson(new SearchDirectInput(uuid, getSemanticCategory( semanticCategory ))), token );

	if ( response.getStatus() == 200 ){
	    SearchIndirectResponse searchIndirectResponse = new SearchIndirectResponse( new JsonParser().parse( response.getContent() ).getAsJsonObject() );

	    /*
	     * copy the searchDirectResponse results to the final response
	     */
	    for ( SearchIndirectElementResponse searchIndirectResponseElement : searchIndirectResponse.getContent() ){
		result.add( searchIndirectResponseElement.getRhPublications().getKeywordUuid() );
	    }
	}

	return result;
    }

}
