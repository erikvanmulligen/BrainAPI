package com.euretos.brainv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestDirectConnection {

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
    public void testDirectConnectionCount(){
	ConceptQuery conceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> concepts = brain.getConceptsSearch(conceptQuery);
	ConnectionCountResponse response = brain.getDirectConnectionsCount(Utils.getConceptIds(concepts));
	logger.info(response);
	TestCase.assertTrue(response.getCategories().size()>0 && response.getPredicates().size()>0);
    }
    
    @Test
    public void testDirectConnectionCountAdditionalFields(){
	Set<String> additionalFields = brain.getDirectConnectionsCountAdditionalFields();
	logger.info(additionalFields);
	TestCase.assertTrue(additionalFields.size()>0);
    }
    
    @Test
    public void testDirectConnectionCountSemanticTypes(){
	ConceptQuery conceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> concepts = brain.getConceptsSearch(conceptQuery);
	Set<String> semanticCategories = new HashSet<String>();
	semanticCategories.add("Disorders");
	Set<SemanticTypeCount> semanticTypes = brain.getDirectConnectionsCountSemanticTypes(Utils.getConceptIds(concepts), semanticCategories);
	logger.info(semanticTypes);
	TestCase.assertTrue(semanticTypes.size()>0);
    }
    
    @Test
    public void testDirectConnectionsWithScore(){
	ConceptQuery conceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> concepts = brain.getConceptsSearch(conceptQuery);
	Set<Set<String>> filters = new HashSet<Set<String>>();
	Set<String> filter = new HashSet<String>();
	filter.add("sc:Disorders");
	filters.add(filter);
	DirectConnections directConnections = brain.getDirectConnectionsWithScore(Utils.getConceptIds(concepts),filters,0,20);
	logger.info(directConnections.getContent());
	TestCase.assertTrue(directConnections.getContent().size()>0);
    }
}
