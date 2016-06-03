package com.euretos.brainv2;

import java.util.Set;

public class DirectConnections {

    private Set<Neighbour> content = null;
    private Boolean last = null;
    private Integer totalElements = null;
    private Integer totalPages = null;
    private Integer numberOfElements = null;
    private Boolean first = null;
    private String sort = null;
    private Integer size = null;
    private Integer number = null;
    
    public Set<Neighbour> getContent() {
        return content;
    }
    
    public void setContent(Set<Neighbour> content) {
        this.content = content;
    }
    
    public Boolean getLast() {
        return last;
    }
    
    public void setLast(Boolean last) {
        this.last = last;
    }
    
    public Integer getTotalElements() {
        return totalElements;
    }
    
    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }
    
    public Integer getTotalPages() {
        return totalPages;
    }
    
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    
    public Integer getNumberOfElements() {
        return numberOfElements;
    }
    
    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }
    
    public Boolean getFirst() {
        return first;
    }
    
    public void setFirst(Boolean first) {
        this.first = first;
    }
    
    public String getSort() {
        return sort;
    }
    
    public void setSort(String sort) {
        this.sort = sort;
    }
    
    public Integer getSize() {
        return size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
}
