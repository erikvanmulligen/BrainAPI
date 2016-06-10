package com.euretos.brainv2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestPathSearch {

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
    public void testPathSearchAdditionalFields(){
	Set<String> additionalFields = brain.getPathSearchAdditionalFields();
	logger.info(additionalFields);
	TestCase.assertTrue(additionalFields.size()>0);
    }
    
    @Test
    public void testPathSearchFilters(){
	Set<String> filters = brain.getPathSearchFilters();
	logger.info(filters);
	TestCase.assertTrue(filters.size()>0);
    }

    @Test
    public void testPathSearchPathsInfo(){
	Set<Concept> sourceConcepts = brain.getConceptsSearch(new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null));
	Set<Concept> targetConcepts = brain.getConceptsSearch(new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null));
	List<List<PathElement>> paths = brain.getConceptToConceptIndirect(sourceConcepts, targetConcepts, 0, 20).getPaths(brain);
	Set<PathInfo> pathsInfo = brain.getPathSearchPathsInfo(Utils.getPath(paths.get(0)));
	logger.info(pathsInfo);
	TestCase.assertTrue(pathsInfo.size()>0);
    }
}
