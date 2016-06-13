package com.euretos.brainv2;

public class PublicationInfo {
    private String id = null;
    private String documentId = null;
    private String title = null;
    private String sourceId = null;
    private String sourceName = null;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String toString(){
	return "{\"id\":\""+id+"\",\"documentId\":\""+documentId+"\",\"title\":\""+title+"\"}";
    }
    
    public String getSourceId() {
        return sourceId;
    }
    
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
    
    public String getSourceName() {
        return sourceName;
    }
    
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}