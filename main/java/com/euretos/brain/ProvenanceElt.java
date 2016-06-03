/**
 * 
 */
package com.euretos.brain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 * (C) 2013,2014 Science and Technology Corporation, Delft, The Netherlands
 *
 * @author Erik van Mulligen
 * 
 *
 */


public class ProvenanceElt {

	private List<SourceElt> sources = new ArrayList<SourceElt>();
	private String target = null;
	private String targetName = null;
	
	@XmlElement( name = "sources", required = true, nillable = true )
	public List<SourceElt> getSources() {
		return sources;
	}

	public void setSources(List<SourceElt> sources) {
		this.sources = sources;
	}

	@XmlElement( name = "target", required = true, nillable = true )
	public String getTarget() {
		return target;
	}
	
	public void setTarget(Integer target) {
		this.target = target.toString();
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@XmlElement( name = "targetName", required = true, nillable = true )
	public String getTargetName() {
		return targetName;
	}
	
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
}
