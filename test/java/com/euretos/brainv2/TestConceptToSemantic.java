package com.euretos.brainv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestConceptToSemantic {

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
    public void testDirectPathConcepts(){
	ConceptQuery sourceConceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> sourceConcepts = brain.getConceptsSearch(sourceConceptQuery);
	Set<String> semanticCategories = new HashSet<String>();
	semanticCategories.add("Disorders");
	Set<String> semanticTypes = new HashSet<String>();
	List<List<PathElement>> paths = brain.getConceptToSemanticDirect(Utils.getConceptIds(sourceConcepts), semanticCategories, semanticTypes, 0, 20).getPaths(brain);
	logger.info("paths:"+StringUtils.join(paths,"\n"));
	TestCase.assertTrue(paths.size()>0);
    }
    
    @Test
    public void testIndirectPathConcepts(){
	ConceptQuery sourceConceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> sourceConcepts = brain.getConceptsSearch(sourceConceptQuery);
	Set<String> semanticCategories = new HashSet<String>();
	semanticCategories.add("Disorders");
	Set<String> semanticTypes = new HashSet<String>();
	List<List<PathElement>> paths = brain.getConceptToSemanticIndirect(Utils.getConceptIds(sourceConcepts), semanticCategories, semanticTypes, 0, 20).getPaths(brain);
	logger.info("paths:"+StringUtils.join(paths,"\n"));
	TestCase.assertTrue(paths.size()>0);
    }
}
