package com.euretos.brainv2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestPublications {

    static Brain brain = null;
    private static Logger logger = LogManager.getLogger();
  
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	brain = new Brain("https://www.euretos-brain.com/spine-ws", "vanmulligen@stcorp.nl", "crosby9");
    }
    
    @AfterClass
    public static void processAfterClass() throws Exception{
	brain.disconnect();
    }
    
    @Test
    public void testPublications(){
	Set<Concept> sourceConcepts = brain.getConceptsSearch(new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null));
	Set<Concept> targetConcepts = brain.getConceptsSearch(new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null));
	List<List<PathElement>> paths = brain.getConceptToConceptIndirect(Utils.getConceptIds(sourceConcepts), Utils.getConceptIds(targetConcepts), 0, 20).getPaths(brain);
	Set<PublicationInfo> publications = brain.getPublications(Utils.getPublicationIds(paths.get(0)));
	logger.info(publications);
	TestCase.assertTrue(publications.size()>0);
    }
    
    @Test
    public void testPublication(){
	Set<Concept> sourceConcepts = brain.getConceptsSearch(new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null));
	Set<Concept> targetConcepts = brain.getConceptsSearch(new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null));
	List<List<PathElement>> paths = brain.getConceptToConceptIndirect(Utils.getConceptIds(sourceConcepts), Utils.getConceptIds(targetConcepts), 0, 20).getPaths(brain);
	if (paths != null && !paths.isEmpty()){
	    Set<String> publicationIds = Utils.getPublicationIds(paths.get(0));
	    if (publicationIds != null && !publicationIds.isEmpty()){
		PublicationInfo publication = brain.getPublication(publicationIds.iterator().next());
		logger.info(publication);
		TestCase.assertTrue(publication.getDocumentId()!= null && !publication.getTitle().isEmpty());
		return;
	    }
	}
	TestCase.assertTrue(false);
    }

    @Test
    public void testPublicationsAdditionalFields(){
	Set<String> additionalFields = brain.getPublicationsAdditionalFields();
	logger.info(StringUtils.join(additionalFields,","));
	TestCase.assertTrue(additionalFields != null && !additionalFields.isEmpty());
    }
}
