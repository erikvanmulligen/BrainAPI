/**
 * (C) Science and Technology Corporation, Delft, The Netherlands, 2015
 * All Rights Reserved
 * No part of this program or any of its contents may be reproduced, copied, modified or adapted, 
 * without the prior written consent of the author, unless otherwise indicated for stand-alone materials.
 * 
 * For any mode of sharing, please contact the author at the email below.
 * 
 * Commercial use and distribution of the contents of the website is not allowed without express and 
 * prior written consent of the author.
 * 
 * @author Erik van Mulligen, vanmulligen@stcorp.nl
 * @date
 */

package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

public class Path {

	private List<PathElt> triples = new ArrayList<PathElt>();
	private String sourceName = null;
	private String sourceUuid = null;
	private String targetName = null;
	private String targetUuid = null;
	private Float  pathWeight = null;
	private Float  maxScore = null;
	private Float  score = null;
	
	public List<PathElt> getTriples() {
		return triples;
	}

	public void setTriples(List<PathElt> triples) {
		this.triples = triples;
	}

	public void addTriple( PathElt triple ){
		this.triples.add( triple );
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	//@XmlTransient
	public String getSourceUuid() {
		return sourceUuid;
	}

	public void setSourceUuid(String sourceUuid) {
		this.sourceUuid = sourceUuid;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	//@XmlTransient
	public String getTargetUuid() {
		return targetUuid;
	}

	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}

	public void setPathWeight(Float pathWeight) {
		this.pathWeight  = pathWeight;
	}

	public Float getPathWeight() {
		return pathWeight;
	}

	public Float getScore() {
		if ( this.score == null ){
			this.score = this.pathWeight / this.maxScore;
		}
		return this.score;
	}
	
	public void setScore( Float score ){
		this.score = score;
	}

	public void setMaxScore(Float maxScore) {
		this.maxScore = maxScore;
	}

	@XmlTransient
	public Float getMaxScore() {
		return this.maxScore;
	}

}
