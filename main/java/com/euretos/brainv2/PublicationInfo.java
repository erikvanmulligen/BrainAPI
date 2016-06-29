package com.euretos.brainv2;

public class PublicationInfo {
    private String id = null;
    private String documentId = null;
    private String title = null;
    private String url = null;
    private String sourceId = null;
    private String sourceName = null;
    private Long publicationDateAsEpochMillisecondsUTC = null;
    
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
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
    
    public Long getPublicationDateAsEpochMillisecondsUTC() {
	return publicationDateAsEpochMillisecondsUTC;
    }
    
    public void setPublicationDateAsEpochMillisecondsUTC(Long publicationDateAsEpochMillisecondsUTC) {
	this.publicationDateAsEpochMillisecondsUTC = publicationDateAsEpochMillisecondsUTC;
    }
}