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

public class TestConceptToConcept {

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
	
	//ConceptQuery sourceConceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	ConceptQuery sourceConceptQuery = new ConceptQuery("M04AA01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> sourceConcepts = brain.getConceptsSearch(sourceConceptQuery);
	logger.debug("source concepts="+sourceConcepts);
	ConceptQuery targetConceptQuery = new ConceptQuery("liver failure, acute", true, null, Arrays.asList(new String[]{"Disorders"}), null, null);
	Set<Concept> targetConcepts = brain.getConceptsSearch(targetConceptQuery);
	logger.debug("target concepts="+targetConcepts);
	List<List<PathElement>> paths = brain.getConceptToConceptDirect(Utils.getConceptIds(sourceConcepts), Utils.getConceptIds(targetConcepts), 0, 20).getPaths(brain);
	logger.info("paths:"+StringUtils.join(paths,"\n"));
	TestCase.assertTrue(paths.size()>0);
    }
    
    @Test
    public void testIndirectPathConcepts(){
	ConceptQuery sourceConceptQuery = new ConceptQuery("M04AA01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	//ConceptQuery sourceConceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> sourceConcepts = brain.getConceptsSearch(sourceConceptQuery);
	//ConceptQuery targetConceptQuery = new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null);
	ConceptQuery targetConceptQuery = new ConceptQuery("liver failure, acute", true, null, Arrays.asList(new String[]{"Disorders"}), null, null);
	Set<Concept> targetConcepts = brain.getConceptsSearch(targetConceptQuery);
	logger.info(targetConcepts);
	List<List<PathElement>> paths = brain.getConceptToConceptIndirect(Utils.getConceptIds(sourceConcepts), Utils.getConceptIds(targetConcepts), 0, 20).getPaths(brain);
	for (List<PathElement> path : paths){
	    logger.info(StringUtils.join(path,","));
	}
	
	TestCase.assertTrue(paths.size()>0);
    }

    @Test
    public void testIndirectPathConcepts2(){
	ConceptQuery sourceConceptQuery = new ConceptQuery("M04AA01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	//ConceptQuery sourceConceptQuery = new ConceptQuery("A02BC01", null, null, Arrays.asList(new String[]{"Chemicals & Drugs"}), null, null);
	Set<Concept> sourceConcepts = brain.getConceptsSearch(sourceConceptQuery);
	//ConceptQuery targetConceptQuery = new ConceptQuery("cytoplasm", true, null, Arrays.asList(new String[]{"Disorders"}), null, null);
	ConceptQuery targetConceptQuery = new ConceptQuery("liver failure, acute", true, null, Arrays.asList(new String[]{"Disorders"}), null, null);
	Set<Concept> targetConcepts = brain.getConceptsSearch(targetConceptQuery);
	logger.info(targetConcepts);
	DirectRelationshipResponse response = brain.getConceptToConceptIndirect(Utils.getConceptIds(sourceConcepts), Utils.getConceptIds(targetConcepts), 0, 20);
	for ( RelationElt relationElt : response.getContent() ){
	    for (Concept concept : relationElt.getConcepts()){
		logger.info(concept.getId()+"\t"+concept.getName()+"\t"+concept.getSemanticCategory());
	    }
	    for ( Relation relation : relationElt.getRelationships()){
		logger.info(relationElt.getScore() + "\t" + relation.getConcept0Id() + "\t" + relation.getConcept1Id() + "\t" + StringUtils.join(relation.getPredicateIds()));
	    }
	}
	TestCase.assertTrue(response.getContent().size()>0);
    }


}
