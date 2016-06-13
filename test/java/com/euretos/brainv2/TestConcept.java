package com.euretos.brainv2;

import java.util.Arrays;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestConcept {

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
    public void testGetConceptsByTerm() {
	ConceptQuery conceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> concepts = brain.getConcepts(conceptQuery);
	TestCase.assertEquals(concepts.size(), 1);
	logger.info("concepts:["+StringUtils.join(concepts,",\n")+"]");
    }

    @Test
    public void testGetConceptsByCUI() {
	ConceptQuery conceptQuery = new ConceptQuery("C0024530", null, null, Arrays.asList(new String[]{"Disorders"}), null, null);
	Set<Concept> concepts = brain.getConcepts(conceptQuery);
	TestCase.assertEquals(concepts.size(), 1);
	logger.info("concepts:["+StringUtils.join(concepts,",\n")+"]");
    }

    @Test
    public void testGetConceptsById(){
	Set<Concept> concepts = brain.getConcepts("174139",null);
	logger.info("concept:"+concepts.iterator().next());
    }
    
    @Test
    public void testGetConceptsAdditionalFields() {
	Set<String> additionalFields = brain.getConceptsAdditionalFields();
	TestCase.assertTrue(additionalFields.size()>1);
	logger.info("additionalFields:["+StringUtils.join(additionalFields,",\n")+"]");
    }

    @Test
    public void testGetConceptsSearchKeys() {
	Set<String> searchKeys = brain.getConceptsSearchKeys();
	TestCase.assertTrue(searchKeys.size()>1);
	logger.info("searchKeys:["+StringUtils.join(searchKeys,",\n")+"]");
    }



}
