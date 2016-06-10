package com.euretos.brainv2;

import java.util.HashSet;
import java.util.Set;

public class PathSearchPathsInfoSpecification {
    private Set<Path> paths = null;
    private Set<String> additionalFields = null;

    public Set<Path> getPaths() {
	return paths;
    }

    public void setPaths(Set<Path> paths) {
	this.paths = paths;
    }
    
    public void addPath(Path path){
	if (this.paths == null){
	    this.paths = new HashSet<Path>();
	}
	this.paths.add(path);
    }
    
    public void setPathIds(Set<Integer> ids) {
	Path path = new Path();
	path.setIds(ids);
	addPath(path);
    }

    public Set<String> getAdditionalFields() {
	return additionalFields;
    }

    public void setAdditionalFields(Set<String> additionalFields) {
	this.additionalFields = additionalFields;
    }
}
