/**
 * 
 */
package com.euretos.brain;

import javax.xml.bind.annotation.XmlElement;
import com.google.gson.JsonObject;

public class SourceElt {
	private String source = null;
	private String id = null;
	
	public SourceElt(){
	}
	
	public SourceElt(String item) {
		String[] pieces = item.split("\\|");
		if ( pieces.length == 2 ){
			setSource( pieces[0] );
			setId( pieces[1] );
		}
		else if ( pieces.length == 1 ){
			setId(pieces[0]);
		}
	}

	public SourceElt(JsonObject object) {
		this.parse( object );
	}

	private void parse( JsonObject object ){
		if ( object.get("documentIdentifier") != null ){
			this.setId( object.get("documentIdentifier").getAsString() );
			this.setSource( "PUBMED" );
		}
	}
	
	@XmlElement( name = "source", required = true, nillable = true )
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	@XmlElement( name = "id", required = true, nillable = true )
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
}
