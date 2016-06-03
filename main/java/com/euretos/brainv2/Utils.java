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

package com.euretos.brainv2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 *  
 */
public class Utils {

    public static String getContentElementAsString(JsonElement jsonElement) {
	return (jsonElement == null || jsonElement.isJsonNull()) ? null : jsonElement.getAsString();
    }

    public static Boolean getContentElementAsBoolean(JsonElement jsonElement) {
	return (jsonElement == null || jsonElement.isJsonNull()) ? null : jsonElement.getAsBoolean();
    }

    public static Integer getContentElementAsInteger(JsonElement jsonElement) {
	return (jsonElement == null || jsonElement.isJsonNull()) ? null : jsonElement.getAsInt();
    }

    public static Float getContentElementAsFloat(JsonElement jsonElement) {
	return (jsonElement == null || jsonElement.isJsonNull()) ? null : jsonElement.getAsFloat();
    }

    public static Long getContentElementAsDate(JsonElement jsonElement) {
	return (jsonElement == null || jsonElement.isJsonNull()) ? null : jsonElement.getAsLong();
    }

    public static List<String> getContentElementAsList(JsonElement jsonElement) {
	List<String> result = null;

	if ( jsonElement != null && !jsonElement.isJsonNull() ){
	    result = new ArrayList<String>();
	    JsonArray array = jsonElement.getAsJsonArray();
	    for ( int i = 0 ; i < array.size() ; i++ ){
		result.add( array.get(i).getAsString() );
	    }
	}
	return result;
    }
    
    public static String toQuoteString(String arg, String str) {
	return "\""+arg+"\":"+(str!=null?"\""+str+"\"":"null");
    }

    public static String toQuoteString(String arg, Integer count) {
	return "\""+arg+"\":"+(count!=null?count:"null");
    }

    public static PostResponse postUrl( String url, String data, String token ){
	try {
	    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	    HttpPost request = new HttpPost(url);
	    request.addHeader("content-type", "application/json");
	    request.addHeader("X-Token", token);
	    if ( data != null ){
		StringEntity params = new StringEntity(data);
		request.setEntity(params);
	    }
	    HttpResponse result = httpClient.execute(request);
	    PostResponse response = new PostResponse( result.getStatusLine().getStatusCode(), EntityUtils.toString(result.getEntity(), "UTF-8") );
	    return response;
	} catch (IOException ex) {
	}
	return null;
    }

    public static PostResponse postUrl( String url, String data ){
	try {
	    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	    HttpPost request = new HttpPost(url);
	    request.addHeader("content-type", "application/json");
	    if ( data != null ){
		StringEntity params = new StringEntity(data);
		request.setEntity(params);
	    }
	    HttpResponse result = httpClient.execute(request);
	    PostResponse response = new PostResponse( result.getStatusLine().getStatusCode(), EntityUtils.toString(result.getEntity(), "UTF-8") );
	    return response;
	} catch (IOException ex) {
	}
	return null;
    }

    public static PostResponse getUrl( String url, String token ){
	try {
	    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	    HttpGet request = new HttpGet(url);
	    request.addHeader("content-type", "application/json");
	    request.addHeader("X-Token", token);
	    HttpResponse result = httpClient.execute(request);
	    return new PostResponse( result.getStatusLine().getStatusCode(), EntityUtils.toString(result.getEntity(), "UTF-8") );
	} catch (IOException ex) {
	}
	return null;
    }

    public static PostResponse getUrl( String url ){
	try {
	    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	    HttpGet request = new HttpGet(url);
	    request.addHeader("content-type", "application/json");
	    HttpResponse result = httpClient.execute(request);
	    return new PostResponse( result.getStatusLine().getStatusCode(), EntityUtils.toString( result.getEntity(), "UTF-8") );
	} catch (IOException ex) {
	}
	return null;
    }

    public static Set<String> getConceptIds(Set<Concept> concepts) {
	Set<String> result = new HashSet<String>();
	for (Concept concept : concepts){
	    result.add(concept.getId());
	}
	return result;
    }

    public static List<Integer> getPath(List<PathElement> path) {
	List<Integer> result = new ArrayList<Integer>(); 
	for (int i=0 ; i<path.size() ; i++){
	    if (i==0){
		result.add(path.get(i).getSource());
	    }
	    result.add(path.get(i).getTarget());
	}
	return result;
    }

    public static Set<String> getTriples(List<PathElement> path) {
	Set<String> result = new HashSet<String>(); 
	for (int i=0 ; i<path.size() ; i++){
	    Iterator<String> iterator = path.get(i).getTripleIds().iterator();
	    while (iterator.hasNext()){
		result.add(iterator.next());
	    }
	}
	return result;
    }

    public static Set<String> getPublicationIds(List<PathElement> path) {
	Set<String> result = new HashSet<String>(); 
	for (int i=0 ; i<path.size() ; i++){
	    Iterator<String> iterator = path.get(i).getPublicationIds().iterator();
	    while (iterator.hasNext()){
		result.add(iterator.next());
	    }
	}
	return result;
    }

}
