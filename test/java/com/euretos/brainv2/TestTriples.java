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

public class TestTriples {

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
    public void testTriples(){
	Set<Concept> sourceConcepts = brain.getConceptsSearch(new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null));
	Set<Concept> targetConcepts = brain.getConceptsSearch(new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null));
	List<List<PathElement>> paths = brain.getConceptToConceptIndirect(sourceConcepts, targetConcepts, 0, 20).getPaths(brain);
	Set<TripleInfo> triples = brain.getTriples(Utils.getTriples(paths.get(0)));
	logger.info(triples);
	TestCase.assertTrue(triples.size()>0);
    }
    
    @Test
    public void testTriple(){
	Set<Concept> sourceConcepts = brain.getConceptsSearch(new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null));
	Set<Concept> targetConcepts = brain.getConceptsSearch(new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null));
	List<List<PathElement>> paths = brain.getConceptToConceptIndirect(sourceConcepts, targetConcepts, 0, 20).getPaths(brain);
	if (paths != null && !paths.isEmpty()){
	    Set<String> tripleIds = Utils.getTriples(paths.get(0));
	    if (tripleIds != null && !tripleIds.isEmpty()){
		TripleInfo triple = brain.getTriple(tripleIds.iterator().next());
		TestCase.assertTrue(triple.getObjectId()!= null && !triple.getObjectId().isEmpty());
		return;
	    }
	}
	TestCase.assertTrue(false);
    }

    @Test
    public void testTriplesAdditionalFields(){
	Set<String> additionalFields = brain.getTriplesAdditionalFields();
	logger.info(StringUtils.join(additionalFields,","));
	TestCase.assertTrue(additionalFields != null && !additionalFields.isEmpty());
    }
}
