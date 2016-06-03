/**
 * 
 */
package com.euretos.brainv2;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

public class Brain {

    private static Logger logger = LogManager.getLogger();
    private static ConcurrentMap<String, Set<Concept>> conceptsCache = new ConcurrentLinkedHashMap.Builder<String, Set<Concept>>().maximumWeightedCapacity(1000).build();

    private static Type ConceptSetType = new TypeToken<Set<Concept>>() {}.getType();
    private static Type SemanticTypeSetType = new TypeToken<Set<SemanticType>>() {}.getType();
    private static Type SemanticCategorySetType = new TypeToken<Set<SemanticCategory>>() {}.getType();
    private static Type PredicateTypeSetType = new TypeToken<Set<PredicateType>>() {}.getType();
    private static Type ScoringAlgorithmSetType = new TypeToken<Set<String>>() {}.getType();
    private static Type KnowledgeBaseSetType = new TypeToken<Set<String>>() {}.getType();
    private static Type SourceSetType = new TypeToken<Set<String>>() {}.getType();
    private static Type TaxonomySetType = new TypeToken<Set<Taxonomy>>() {}.getType();
    private static Type AdditionalFieldSetType = new TypeToken<Set<String>>() {}.getType();
    private static Type FilterSetType = new TypeToken<Set<String>>() {}.getType();
    private static Type ConnectionCountAdditionalFieldSetType = new TypeToken<Set<String>>() {}.getType();
    private static Type ConnectionCountSemanticTypeSetType = new TypeToken<Set<SemanticTypeCount>>() {}.getType();
    private static Type SearchKeySetType = new TypeToken<Set<String>>() {}.getType();
    private static Type TripleInfoSetType = new TypeToken<Set<TripleInfo>>() {}.getType();
    private static Type PublicationInfoSetType = new TypeToken<Set<PublicationInfo>>() {}.getType();
    

    private static Map<String,PredicateType> predicates = null;
    private static Map<String,SemanticType> semanticTypes = null;
    private static Map<String,SemanticCategory> semanticCategories = null;
    private static Set<String> scoringAlgorithms = null;
    private static Set<String> knowledgeBases = null;
    private static Set<String> sources = null;
    private static Map<String,Taxonomy> taxonomies = null;
    private static Set<Concept> superNodes = null;
    private static Set<String> directConnectionsCountAdditionalFields = null;
    private static Set<String> pathSearchAdditionalFields = null;
    private static Set<String> pathSearchFilters = null;
    private static Pattern pattern = Pattern.compile("T[0-9]{3}");

    private static String username = null;
    private static String password = null;
    private static String endpoint = null;
    private static String token = null;
    private static long connectTime = 0;

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
    private static Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Date.class, ser).registerTypeAdapter(Date.class, deser).create();


    public Brain( String aEndpoint, String aUsername, String aPassword ){
	username = aUsername;
	password = aPassword;
	endpoint = aEndpoint;
	boolean status = connect();
	if (!status){
	    logger.error("login failed");
	}
    }

    public boolean connect(){
	if ( ( System.currentTimeMillis() - connectTime ) > ( 1000 * 60 * 5 ) ){
	    logger.info("connect");
	    PostResponse response = Utils.postUrl(endpoint + "/login/authenticate", gson.toJson(new LoginObject(username, password)), token );
	    if (response.getStatus() == 200){
		LoginResponse loginResponse = gson.fromJson(response.getContent(), LoginResponse.class);
		token = loginResponse.getToken();
		connectTime = System.currentTimeMillis();
		logger.info("connected");
		return token != null;
	    }
	    return false;
	}
	return true;
    }

    public boolean disconnect(){
	token = null;
	connectTime = System.currentTimeMillis();
	logger.info("disconnected");
	return true;
    }

    @SuppressWarnings("unchecked")
    static public Map<String,PredicateType> getPredicates(){
	PostResponse response = null;
	boolean last = false;
	int page = 0;

	if (predicates == null){
	    predicates = new HashMap<String,PredicateType>();
	    predicates.put("-1",new PredicateType("-1", "unknown", null));
	    do {
		response = Utils.getUrl(endpoint + "/external/predicates?page="+page+"&size=20", token);
		if (response.getStatus() == 200){
		    JsonObject msg = new JsonParser().parse(response.getContent()).getAsJsonObject();
		    last = msg.get("last").getAsBoolean();
		    page = msg.get("number").getAsInt() + 1;
		    for (PredicateType predicate : (Set<PredicateType>)gson.fromJson(msg.get("content").toString(), PredicateTypeSetType)){
			predicates.put(predicate.getId(), predicate);
		    }
		}
	    } while (response.getStatus() == 200 && last == false);
	}
	return predicates;
    }

    @SuppressWarnings("unchecked")
    static public Set<String> getScoringAlgorithms(){
	if (scoringAlgorithms == null){
	    scoringAlgorithms = new HashSet<String>();
	    PostResponse response = Utils.getUrl(endpoint + "/external/scoring-algorithms", token);
	    if (response.getStatus() == 200){
		scoringAlgorithms.addAll((Set<String>)gson.fromJson(new JsonParser().parse(response.getContent()).toString(), ScoringAlgorithmSetType));
	    }
	}
	return scoringAlgorithms;
    }

    @SuppressWarnings("unchecked")
    static public Set<String> getKnowledgeBases(){
	if (knowledgeBases == null){
	    knowledgeBases = new HashSet<String>();
	    PostResponse response = Utils.getUrl(endpoint + "/external/knowledge-bases", token);
	    if (response.getStatus() == 200){
		knowledgeBases.addAll((Set<String>)gson.fromJson(new JsonParser().parse(response.getContent()).toString(), KnowledgeBaseSetType));
	    }
	}
	return knowledgeBases;
    }

    @SuppressWarnings("unchecked")
    static public Set<String> getSources(){
	if (sources == null){
	    sources = new HashSet<String>();
	    PostResponse response = Utils.getUrl(endpoint + "/external/sources", token);
	    if (response.getStatus() == 200){
		sources.addAll((Set<String>)gson.fromJson(new JsonParser().parse(response.getContent()).toString(), SourceSetType));
	    }
	}
	return sources;
    }

    @SuppressWarnings("unchecked")
    static public Map<String,Taxonomy> getTaxonomies(){
	PostResponse response = null;
	boolean last = false;
	int page = 0;

	if (taxonomies == null){
	    taxonomies = new HashMap<String,Taxonomy>();
	    do{
		response = Utils.postUrl(endpoint + "/external/taxonomies?page="+page+"&size=100", null, token);
		if (response.getStatus() == 200){
		    JsonObject msg = new JsonParser().parse(response.getContent()).getAsJsonObject();
		    last = true;	/* failure, last always remains false */
		    page = msg.get("number").getAsInt() + 1;
		    logger.info(msg.get("content").toString());
		    for (Taxonomy taxonomy : (Set<Taxonomy>)gson.fromJson(msg.get("content").toString(), TaxonomySetType)){
			taxonomies.put(taxonomy.getName(), taxonomy);
			last = false;
		    }
		}
	    }while (response.getStatus() == 200 && last == false);
	}
	return taxonomies;
    }

    @SuppressWarnings("unchecked")
    static public Map<String,SemanticCategory> getSemanticCategories(){
	PostResponse response = null;
	boolean last = false;
	int page = 0;

	if (semanticCategories == null){
	    semanticCategories = new HashMap<String,SemanticCategory>();
	    do{
		response = Utils.getUrl(endpoint + "/external/predicates?page="+page+"&size=20", token);
		if (response.getStatus() == 200){
		    JsonObject msg = new JsonParser().parse(response.getContent()).getAsJsonObject();
		    last = msg.get("last").getAsBoolean();
		    page = msg.get("number").getAsInt() + 1;
		    logger.info(msg.get("content").toString());
		    for (SemanticCategory semanticCategory : (Set<SemanticCategory>)gson.fromJson(msg.get("content").toString(), SemanticCategorySetType)){
			semanticCategories.put(semanticCategory.getId(), semanticCategory);
		    }
		}
	    }while (response.getStatus() == 200 && last == false);
	}
	return semanticCategories;
    }

    @SuppressWarnings("unchecked")
    public static Map<String,SemanticType> getSemanticTypes(){
	PostResponse response = null;
	boolean last = false;
	int page = 0;

	if (semanticTypes == null){
	    semanticTypes = new HashMap<String,SemanticType>();
	    do{
		response = Utils.getUrl(endpoint + "/external/semantic-types?page="+page+"&size=20", token);
		if (response.getStatus() == 200){
		    JsonObject msg = new JsonParser().parse(response.getContent()).getAsJsonObject();
		    last = msg.get("last").getAsBoolean();
		    page = msg.get("number").getAsInt() + 1;
		    for (SemanticType semanticType : (Set<SemanticType>)gson.fromJson(msg.get("content").toString(), SemanticTypeSetType)){
			semanticTypes.put(semanticType.getId(), semanticType);
		    }
		}
	    } while (response.getStatus() == 200 && last == false);
	}
	return semanticTypes;
    }

    @SuppressWarnings("unchecked")
    public static Set<Concept> getSuperNodes(){
	PostResponse response = null;

	if (superNodes == null){
	    superNodes = new HashSet<Concept>();
	    response = Utils.postUrl(endpoint + "/external/super-nodes", null, token);
	    if (response.getStatus() == 200){
		for (Concept superNode : (Set<Concept>)gson.fromJson(response.getContent(), ConceptSetType)){
		    superNodes.add(superNode);
		}
	    }
	}
	return superNodes;
    }

    public String getToken(){
	return token;
    }

    /*
     * 
     * CONCEPTS interface
     * 
     */

    public Set<Concept> getConceptsSearch(ConceptQuery conceptQuery) {
	if (!conceptsCache.containsKey(conceptQuery.getQueryString())){
	    Set<Concept> result = new HashSet<Concept>();
	    PostResponse response = Utils.postUrl(endpoint + "/external/concepts/search", gson.toJson(conceptQuery), token);
	    if ( response.getStatus() == 200 ){
		result = gson.fromJson(response.getContent(), ConceptSetType);
		conceptsCache.put(conceptQuery.getQueryString(), result);
		for (Concept concept : result){
		    HashSet<Concept> tmp = new HashSet<Concept>();
		    tmp.add(concept);
		    conceptsCache.put(concept.getId(), tmp);
		}
		return result;
	    }
	    return null;
	}
	else{
	    return conceptsCache.get(conceptQuery.getQueryString());
	}
    }

    @SuppressWarnings("unchecked")
    public Set<String> getConceptsAdditionalFields(){
	PostResponse response = Utils.getUrl(endpoint + "/external/concepts/additional-fields", token);
	return response.getStatus() == 200 ? (Set<String>)gson.fromJson(response.getContent(), AdditionalFieldSetType) : null;
    }

    @SuppressWarnings("unchecked")
    public Set<String> getConceptsSearchKeys(){
	PostResponse response = Utils.getUrl(endpoint + "/external/concepts/search-keys", token);
	return response.getStatus() == 200 ? (Set<String>)gson.fromJson(response.getContent(), SearchKeySetType) : null;
    }

    /*
     * concept-to-concept
     */

    public List<List<PathElement>> getConceptToConceptDirect(Set<Concept> sources, Set<Concept> targets, Integer page, Integer size){
	SearchPathSpecification searchPathSpecification = new SearchPathSpecification();
	searchPathSpecification.setLeftInputs(Utils.getConceptIds(sources));
	searchPathSpecification.setRightInputs(Utils.getConceptIds(targets));
	searchPathSpecification.addAdditionalField("predicateIds");
	searchPathSpecification.addAdditionalField("tripleIds");
	searchPathSpecification.addAdditionalField("publicationIds");
	PostResponse response = Utils.postUrl(endpoint + "/external/concept-to-concept/direct?page=" + page + "&size=" + size, gson.toJson(searchPathSpecification), token );
	if (response.getStatus() == 200){
	    return gson.fromJson(response.getContent(), DirectRelationshipResponse.class).convert(this);
	}
	return null;
    }

    public List<List<PathElement>> getConceptToConceptIndirect(Set<Concept> sources, Set<Concept> targets, Integer page, Integer size){
	SearchPathSpecification searchPathSpecification = new SearchPathSpecification();
	searchPathSpecification.setLeftInputs(Utils.getConceptIds(sources));
	searchPathSpecification.setRightInputs(Utils.getConceptIds(targets));
	searchPathSpecification.addAdditionalField("predicateIds");
	searchPathSpecification.addAdditionalField("tripleIds");
	searchPathSpecification.addAdditionalField("publicationIds");
	PostResponse response = Utils.postUrl(endpoint + "/external/concept-to-concept/indirect?page=" + page + "&size=" + size, gson.toJson(searchPathSpecification), token);
	return response.getStatus() == 200 ? gson.fromJson(response.getContent(), DirectRelationshipResponse.class).convert(this) : null;
    }

    /* 
     * concept-to-semantic
     */

    public List<List<PathElement>> getConceptToSemanticDirect(Set<Concept> sources, Set<String> semanticCategories, Set<String> semanticTypes, Integer page, Integer size){
	SearchPathSpecification searchPathSpecification = new SearchPathSpecification();
	searchPathSpecification.setLeftInputs(Utils.getConceptIds(sources));
	Set<String> targets = new HashSet<String>();
	for (String semanticCategory : semanticCategories){
	    targets.add("sc:"+semanticCategory);
	}
	for (String semanticType : semanticTypes){
	    targets.add(!pattern.matcher(semanticType).matches() ? Brain.semanticTypes.get(semanticType).getId() : semanticType);
	}
	searchPathSpecification.setRightInputs(targets);
	searchPathSpecification.addAdditionalField("predicateIds");
	searchPathSpecification.addAdditionalField("tripleIds");
	searchPathSpecification.addAdditionalField("publicationIds");
	PostResponse response = Utils.postUrl(endpoint + "/external/concept-to-semantic/direct?page=" + page + "&size=" + size, gson.toJson(searchPathSpecification), token );
	return response.getStatus() == 200 ? gson.fromJson(response.getContent(), DirectRelationshipResponse.class).convert(this) : null;
    }

    public List<List<PathElement>> getConceptToSemanticIndirect(Set<Concept> sources, Set<String> semanticCategories, Set<String> semanticTypes, Integer page, Integer size){
	SearchPathSpecification searchPathSpecification = new SearchPathSpecification();
	searchPathSpecification.setLeftInputs(Utils.getConceptIds(sources));
	Set<String> targets = new HashSet<String>();
	for (String semanticCategory : semanticCategories){
	    targets.add("sc:"+semanticCategory);
	}
	for (String semanticType : semanticTypes){
	    Matcher m = pattern.matcher(semanticType);
	    if (!m.matches()){
		targets.add(Brain.semanticTypes.get(semanticType).getId());
	    }
	    else{
		targets.add(semanticType);
	    }
	}
	searchPathSpecification.setRightInputs(targets);
	searchPathSpecification.addAdditionalField("predicateIds");
	searchPathSpecification.addAdditionalField("tripleIds");
	searchPathSpecification.addAdditionalField("publicationIds");
	PostResponse response = Utils.postUrl(endpoint + "/external/concept-to-semantic/indirect?page=" + page + "&size=" + size, gson.toJson(searchPathSpecification), token );
	if (response.getStatus() == 200){
	    return gson.fromJson(response.getContent(), DirectRelationshipResponse.class).convert(this);
	}
	return null;
    }

    /*
     * 	direct-connections-count
     */

    public ConnectionCountResponse getDirectConnectionsCount(Set<Concept> concepts){
	ConnectionCountSpecification connectionCountSpecification = new ConnectionCountSpecification();
	connectionCountSpecification.setIds(Utils.getConceptIds(concepts));
	connectionCountSpecification.addAdditionalField("categories");
	connectionCountSpecification.addAdditionalField("predicates");
	PostResponse response = Utils.postUrl(endpoint + "/external/direct-connections-count", gson.toJson(connectionCountSpecification), token);
	if (response.getStatus() == 200){
	    return gson.fromJson(response.getContent(), ConnectionCountResponse.class);
	}
	return null;
    }

    public Set<String> getDirectConnectionsCountAdditionalFields(){
	if (directConnectionsCountAdditionalFields==null){
	    PostResponse response = Utils.getUrl(endpoint + "/external/direct-connections-count/additional-fields", token);
	    if (response.getStatus() == 200){
		logger.info(response.getContent());
		directConnectionsCountAdditionalFields = gson.fromJson(response.getContent(), ConnectionCountAdditionalFieldSetType);
	    }
	}
	return directConnectionsCountAdditionalFields;
    }

    public Set<SemanticTypeCount> getDirectConnectionsCountSemanticTypes(Set<Concept> concepts, Set<String> semanticCategories){
	ConnectionCountSemanticTypeSpecification connectionCountSemanticTypeSpecification = new ConnectionCountSemanticTypeSpecification();
	connectionCountSemanticTypeSpecification.setIds(Utils.getConceptIds(concepts));
	connectionCountSemanticTypeSpecification.setSemanticCategories(semanticCategories);
	PostResponse response = Utils.postUrl(endpoint + "/external/direct-connections-count/semantic-types", gson.toJson(connectionCountSemanticTypeSpecification), token);
	logger.info(response.getContent());
	if (response.getStatus() == 200){
	    return gson.fromJson(response.getContent(), ConnectionCountSemanticTypeSetType);
	}
	return null;
    }
    
    
    public DirectConnections getDirectConnectionsWithScore(Set<Concept> concepts, Set<Set<String>> filterGroups, Integer page, Integer size){
	DirectConnectionWithScoreSpecification directConnectionWithScoreSpecification = new DirectConnectionWithScoreSpecification();
	directConnectionWithScoreSpecification.setIds(Utils.getConceptIds(concepts));
	directConnectionWithScoreSpecification.setFilterGroups(filterGroups);
	PostResponse response = Utils.postUrl(endpoint + "/external/direct-connections-with-scores?page=" + page + "&size=" + size, gson.toJson(directConnectionWithScoreSpecification), token);
	logger.info(response.getContent());
	if (response.getStatus() == 200){
	    return gson.fromJson(response.getContent(), DirectConnections.class);
	}
	return null;
    }
    
    
    /*
     * path search
     */
    
    @SuppressWarnings("unchecked")
    public Set<String> getPathSearchAdditionalFields(){
	if (pathSearchAdditionalFields == null){
	    PostResponse response = Utils.getUrl(endpoint + "/external/path-search/additional-fields", token);
	    pathSearchAdditionalFields = response.getStatus() == 200 ? (Set<String>)gson.fromJson(response.getContent(), AdditionalFieldSetType) : null;
	}
	return pathSearchAdditionalFields;
    }

    @SuppressWarnings("unchecked")
    public Set<String> getPathSearchFilters(){
	if (pathSearchFilters == null){
	    PostResponse response = Utils.getUrl(endpoint + "/external/path-search/filters", token);
	    pathSearchFilters = response.getStatus() == 200 ? (Set<String>)gson.fromJson(response.getContent(), FilterSetType) : null;
	}
	return pathSearchFilters;
    }
    
    public Set<String> getPathSearchPathsInfo(List<Integer> paths) {
	logger.info(StringUtils.join(paths,"->"));
	PathSearchPathsInfoSpecification pathSearchPathsInfoSpecification = new PathSearchPathsInfoSpecification();
	pathSearchPathsInfoSpecification.setPaths(paths);
	PostResponse response = Utils.postUrl(endpoint + "/external/path-search/paths-info", gson.toJson(pathSearchPathsInfoSpecification), token);
	logger.info(response.getContent());
	return null;
    }

    /*
     * triples 
     */
    
    @SuppressWarnings("unchecked")
    public Set<TripleInfo> getTriples(Set<String> triples) {
	TriplesSpecification triplesSpecification = new TriplesSpecification();
	triplesSpecification.setIds(triples);
	PostResponse response = Utils.postUrl(endpoint + "/external/triples", gson.toJson(triplesSpecification), token);
	return (Set<TripleInfo>) ((response.getStatus() == 200) ? gson.fromJson(response.getContent(), TripleInfoSetType) : null);
    }

    public TripleInfo getTriple(String triple) {
	TripleSpecification tripleSpecification = new TripleSpecification();
	tripleSpecification.setId(triple);
	PostResponse response = Utils.postUrl(endpoint + "/external/triples/" + triple, gson.toJson(tripleSpecification), token);
	return (TripleInfo) ((response.getStatus() == 200) ? gson.fromJson(response.getContent(), TripleInfo.class) : null);
    }

    @SuppressWarnings("unchecked")
    public Set<String> getTriplesAdditionalFields() {
	PostResponse response = Utils.getUrl(endpoint + "/external/triples/additional-fields", token);
	return (Set<String>) ((response.getStatus() == 200) ? gson.fromJson(response.getContent(), AdditionalFieldSetType) : null);
    }
    
    /*
     * publications
     */
    
    @SuppressWarnings("unchecked")
    public Set<PublicationInfo> getPublications(Set<String> publicationIds) {
	PublicationsSpecification publicationsSpecification = new PublicationsSpecification();
	publicationsSpecification.setIds(publicationIds);
	PostResponse response = Utils.postUrl(endpoint + "/external/publications", gson.toJson(publicationsSpecification), token);
	return (Set<PublicationInfo>) ((response.getStatus() == 200) ? gson.fromJson(response.getContent(), PublicationInfoSetType) : null);
    }
    
    public PublicationInfo getPublication(String publicationId) {
	PublicationSpecification publicationSpecification = new PublicationSpecification();
	publicationSpecification.setId(publicationId);
	PostResponse response = Utils.postUrl(endpoint + "/external/publications/" + publicationId, gson.toJson(publicationSpecification), token);
	return (PublicationInfo) ((response.getStatus() == 200) ? gson.fromJson(response.getContent(), PublicationInfo.class) : null);
    }

    @SuppressWarnings("unchecked")
    public Set<String> getPublicationsAdditionalFields() {
	PostResponse response = Utils.getUrl(endpoint + "/external/publications/additional-fields", token);
	return (Set<String>) ((response.getStatus() == 200) ? gson.fromJson(response.getContent(), AdditionalFieldSetType) : null);
    }

    /*
     * support functions
     */
    
    public PredicateType getPredicate(String id) {
	return getPredicates().get(id);
    }

    public SemanticType getSemanticType(String id) {
	return getSemanticTypes().get(id);
    }

    public Set<Concept> getConcepts(String id, String term) {
	if (id!=null){
	    if (!conceptsCache.containsKey(id)){
		PostResponse response = Utils.postUrl(endpoint + "/external/concepts", gson.toJson(new SearchConceptByIds(id)), token );
		if (response.getStatus() == 200){
		    Set<Concept> result = gson.fromJson(response.getContent(), ConceptSetType);
		    conceptsCache.put(id, result);
		    return result;
		}
	    }
	    else{
		return conceptsCache.get(id);
	    }
	}
	else if (term != null){
	    if (!conceptsCache.containsKey(term)){
		PostResponse response = Utils.postUrl(endpoint + "/external/concepts/search", gson.toJson(new ConceptQuery(term,null,null,null,null,null)), token );
		if (response.getStatus() == 200){
		    Set<Concept> result = gson.fromJson(response.getContent(), ConceptSetType);
		    conceptsCache.put(term, result);
		    return result;
		}
	    }
	    else{
		return conceptsCache.get(id);
	    }
	}
	return null;
    }

    public Set<Concept> getConcepts(ConceptQuery conceptQuery) {
	String term = conceptQuery.getQueryString();
	if (term != null){
	    if (!conceptsCache.containsKey(term)){
		PostResponse response = Utils.postUrl(endpoint + "/external/concepts/search", gson.toJson(conceptQuery), token );
		if (response.getStatus() == 200){
		    Set<Concept> result = gson.fromJson(response.getContent(), ConceptSetType);
		    conceptsCache.put(term, result);
		    return result;
		}
	    }
	    else{
		return conceptsCache.get(term);
	    }
	}
	return null;
    }

}
