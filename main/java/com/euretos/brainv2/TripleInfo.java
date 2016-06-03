package com.euretos.brainv2;

public class TripleInfo {
    private String id = null;
    private String subjectId = null;
    private String objectId = null;
    private String predicateId = null;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
    public String getObjectId() {
        return objectId;
    }
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
    public String getPredicateId() {
        return predicateId;
    }
    public void setPredicateId(String predicateId) {
        this.predicateId = predicateId;
    }
    @Override
    public String toString(){
	return "{\"id\":\""+id+"\",\"subjectId\":\""+subjectId+"\",\"objectId\":\""+objectId+"\",\"predicateId\":\""+predicateId+"\"}";
    }
}
