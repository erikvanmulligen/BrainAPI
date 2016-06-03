package com.euretos.brainv2;

import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBrain {

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
    public void testGetSuperNodes() {
	Set<Concept> superNodes = Brain.getSuperNodes();
	TestCase.assertEquals(superNodes.size(), 242);
	logger.info("superNodes:["+StringUtils.join(superNodes,",\n")+"]");
    }

    @Test
    public void testGetSemanticTypes() {
	Map<String,SemanticType> semanticTypes = Brain.getSemanticTypes();
	TestCase.assertTrue(semanticTypes.size()>0);
	logger.info("semanticCategories:["+StringUtils.join(semanticTypes.values(),",\n")+"]");
    }
    
    @Test
    public void testGetScoringAlgorithms() {
	Set<String> scoringAlgorithms = Brain.getScoringAlgorithms();
	TestCase.assertTrue(scoringAlgorithms.size()>0);
	logger.info("scoringAlgorithms:["+StringUtils.join(scoringAlgorithms,",\n")+"]");
    }

    @Test
    public void testGetKnowledgeBases() {
	Set<String> knowledgeBases = Brain.getKnowledgeBases();
	TestCase.assertTrue(knowledgeBases.size()>0);
	logger.info("knowledgeBases:["+StringUtils.join(knowledgeBases,",\n")+"]");
    }

    @Test
    public void testGetTaxonomies() {
	Map<String,Taxonomy> taxonomies = Brain.getTaxonomies();
	TestCase.assertTrue(taxonomies.size()>0);
	logger.info("taxonomies:["+StringUtils.join(taxonomies.values(),",\n")+"]");
    }

    @Test
    public void testGetSources() {
	Set<String> sources = Brain.getSources();
	TestCase.assertTrue(sources.size()>0);
	logger.info("sources:["+StringUtils.join(sources,",\n")+"]");
    }

    @Test
    public void testGetSemanticCategories() {
	Map<String,SemanticCategory> semanticCategories = Brain.getSemanticCategories();
	System.out.println("["+StringUtils.join(semanticCategories.values(),",")+"]");
	TestCase.assertTrue(semanticCategories.size()>0);
	logger.info("semanticCategories:["+StringUtils.join(semanticCategories.values(),",\n")+"]");
    }

    @Test
    public void testGetPredicates() {
	Map<String,PredicateType> predicates = Brain.getPredicates();
	TestCase.assertTrue(predicates.size()>0);
	logger.info("predicates:["+StringUtils.join(predicates.values(),",\n")+"]");
    }

}
