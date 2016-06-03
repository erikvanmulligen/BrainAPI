# ExternalconceptcontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllKnowledgeBasesUsingGET1**](ExternalconceptcontrollerApi.md#getAllKnowledgeBasesUsingGET1) | **GET** /external/knowledge-bases | / Returns list of \&quot;knowledgebases\&quot; values.
[**getAllSourcesUsingGET**](ExternalconceptcontrollerApi.md#getAllSourcesUsingGET) | **GET** /external/sources | / Returns list of \&quot;sources\&quot; values.
[**getConceptAdditionalFieldsUsingGET**](ExternalconceptcontrollerApi.md#getConceptAdditionalFieldsUsingGET) | **GET** /external/concepts/additional-fields | / Returns list of available concept \&quot;additionalfield\&quot; values.
[**getConceptByIdUsingGET**](ExternalconceptcontrollerApi.md#getConceptByIdUsingGET) | **GET** /external/concepts/{id} | / Returns concept details for the given id, \&quot;additionalFields\&quot; (list) can be included to enrich the response.
[**getConceptByIdUsingPOST**](ExternalconceptcontrollerApi.md#getConceptByIdUsingPOST) | **POST** /external/concepts/{id} | / Returns concept details for the given id, \&quot;additionalFields\&quot; (list) can be included to enrich the response.
[**getConceptSearchKeysUsingGET1**](ExternalconceptcontrollerApi.md#getConceptSearchKeysUsingGET1) | **GET** /external/concepts/search-keys | / Returns list of available (/concepts/search) \&quot;queryString\&quot; key names which can be used within the concept search call.
[**getConceptsFromSolrUsingPOST1**](ExternalconceptcontrollerApi.md#getConceptsFromSolrUsingPOST1) | **POST** /external/concepts/search | / Returns list of concepts which match the search criteria, \&quot;additionalFields\&quot; (list) can be included to enrich the response.
[**getMultipleConceptsByIdsUsingPOST**](ExternalconceptcontrollerApi.md#getMultipleConceptsByIdsUsingPOST) | **POST** /external/concepts | / Returns concept details for the given id list, \&quot;additionalFields\&quot; (list) can be included to enrich the response.
[**getSuperNodesUsingPOST**](ExternalconceptcontrollerApi.md#getSuperNodesUsingPOST) | **POST** /external/super-nodes | / Returns list of concepts which are part of the super node list, \&quot;additionalFields\&quot; (list) can be included to enrich the response.


<a name="getAllKnowledgeBasesUsingGET1"></a>
# **getAllKnowledgeBasesUsingGET1**
> List&lt;String&gt; getAllKnowledgeBasesUsingGET1()

/ Returns list of \&quot;knowledgebases\&quot; values.

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;knowledgebases\&quot; can be retrieved using the    * /external/knowledge-bases call.    *    * @return \&quot;knowledgebases\&quot; values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
try {
    List<String> result = apiInstance.getAllKnowledgeBasesUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getAllKnowledgeBasesUsingGET1");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getAllSourcesUsingGET"></a>
# **getAllSourcesUsingGET**
> List&lt;String&gt; getAllSourcesUsingGET()

/ Returns list of \&quot;sources\&quot; values.

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;sources\&quot; can be retrieved using the    * /external/sources call.    *    * @return \&quot;sources\&quot; values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
try {
    List<String> result = apiInstance.getAllSourcesUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getAllSourcesUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getConceptAdditionalFieldsUsingGET"></a>
# **getConceptAdditionalFieldsUsingGET**
> List&lt;String&gt; getConceptAdditionalFieldsUsingGET()

/ Returns list of available concept \&quot;additionalfield\&quot; values.

     *     * @param no parameters required    *     * Info; For most concept related commands \&quot;additionalFields\&quot; can be specified to enrich    * the response. Using this call (/concepts/additional-fields) allows you to understand    * which additionalFields can be used.    *    * @return concept \&quot;additionalfield\&quot; values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
try {
    List<String> result = apiInstance.getConceptAdditionalFieldsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getConceptAdditionalFieldsUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getConceptByIdUsingGET"></a>
# **getConceptByIdUsingGET**
> ExternalConceptDto getConceptByIdUsingGET(id, requestDto)

/ Returns concept details for the given id, \&quot;additionalFields\&quot; (list) can be included to enrich the response.

     * @param id (M) string based concept id&#39;s.    *     * @param additionalFields (O), see /external/concepts/additional-fields API call.    *     * Info; Most results will return the concept id. This call allows translation to human    * understandable information. The \&quot;additionalFields\&quot; allow further response enrichment of    * the concept details.    *     * Example \&quot;additionalFields\&quot;; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;.    *     * Example query; { \&quot;id\&quot;:\&quot;2790858\&quot; } .    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;id\&quot;: \&quot;2790858\&quot; } .    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;synonyms\&quot;, \&quot;source\&quot; ], \&quot;id\&quot;: \&quot;2790858\&quot;} .    *     * Optional dependency response; /external/concepts/additional-fields API call.    *     * @return default concept; preferred term, id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
Long id = 789L; // Long | id
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    ExternalConceptDto result = apiInstance.getConceptByIdUsingGET(id, requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getConceptByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**ExternalConceptDto**](ExternalConceptDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getConceptByIdUsingPOST"></a>
# **getConceptByIdUsingPOST**
> ExternalConceptDto getConceptByIdUsingPOST(id, requestDto)

/ Returns concept details for the given id, \&quot;additionalFields\&quot; (list) can be included to enrich the response.

     * @param id (M) string based concept id&#39;s.    *     * @param additionalFields (O), see /external/concepts/additional-fields API call.    *     * Info; Most results will return the concept id. This call allows translation to human    * understandable information. The \&quot;additionalFields\&quot; allow further response enrichment of    * the concept details.    *     * Example \&quot;additionalFields\&quot;; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;.    *     * Example query; { \&quot;id\&quot;:\&quot;2790858\&quot; } .    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;id\&quot;: \&quot;2790858\&quot; } .    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;synonyms\&quot;, \&quot;source\&quot; ], \&quot;id\&quot;: \&quot;2790858\&quot;} .    *     * Optional dependency response; /external/concepts/additional-fields API call.    *     * @return default concept; preferred term, id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
Long id = 789L; // Long | id
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    ExternalConceptDto result = apiInstance.getConceptByIdUsingPOST(id, requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getConceptByIdUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**ExternalConceptDto**](ExternalConceptDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getConceptSearchKeysUsingGET1"></a>
# **getConceptSearchKeysUsingGET1**
> List&lt;String&gt; getConceptSearchKeysUsingGET1()

/ Returns list of available (/concepts/search) \&quot;queryString\&quot; key names which can be used within the concept search call.

     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /concepts/search-keys response will provide a list of available    * search keys which can be used within the queryString. Please note that the logical    * conditions AND, OR, NOT and grouping ( ) are not included in this response.    *     * The values which can be used to make the (/concepts/search) queryString key,value pair    * complete can be retrieved using the following API calls; /external/semantic-categories,    * /external/semantic-types, /external/taxonomies, /external/knowledge-bases,    * /external/sources.    *     * Example query search keys; \&quot;term\&quot;, \&quot;semantictype\&quot;, \&quot;semanticcategory\&quot;, \&quot;knowledgebase\&quot;,    * \&quot;source\&quot;, \&quot;gi\&quot;, \&quot;preferred\&quot;.    *     * Example source query values; \&quot;umls\&quot;, \&quot;uniprot\&quot;, \&quot;entrezgene\&quot;.    *     * Example knowledgebase query values; \&quot;mim\&quot;, \&quot;chebi\&quot;, \&quot;umls\&quot;.    *     * Example semantictypes query values; \&quot;T116\&quot;, \&quot;T028\&quot;.    *     * Example semanticcategory query values; \&quot;\&quot;Disorders\&quot;, \&quot;Occupations\&quot;.    *     * Example preferred query values; \&quot;true\&quot;, \&quot;false\&quot;.    *     * Example queryString as used with /concept/search API call; { \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND source:&#39;umls&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * Associated API calls; /external/semantic-categories, /external/semantic-types,    * /external/taxonomies, /external/knowledge-bases, /external/sources    *     * @return concept search \&quot;queryString\&quot; key names     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
try {
    List<String> result = apiInstance.getConceptSearchKeysUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getConceptSearchKeysUsingGET1");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getConceptsFromSolrUsingPOST1"></a>
# **getConceptsFromSolrUsingPOST1**
> List&lt;ExternalConceptDto&gt; getConceptsFromSolrUsingPOST1(externalConceptSearchRequestDto)

/ Returns list of concepts which match the search criteria, \&quot;additionalFields\&quot; (list) can be included to enrich the response.

     * @param queryString (M), Key,value pair based search criteria. Value need to be enclosed using    * single quotes &#39;...&#39;. Supported keys are available using /external/concept-search-keys.    * Associated values can be retrieved through various enum calls, such as /external/sources    * or /external/knowledge-bases. Logical conditions AND, OR, NOT can be used within the    * query with lead/tail space. Logical grouping ( ) can be used within query with lead /    * tail space. The \&quot;term:\&quot; key is required for the API call to succeed.    *     * @param searchType (M) STRING or TOKEN, STRING will consider the term field as one complete    * word. TOKEN will consider the term field as multiple words where each word is part of    * search criteria.    *     * @param additionalFields (O) see /external/concepts/additional-fields API call.    *     * Info; This api call is the starting point for the knowledge network. Here a literal term    * will be linked to an internal concept identifier. The key \&quot;term\&quot; is mandatory for the    * search to succeed. The term will be used to search through the thesaurus and match both    * preferred and synonyms by default. When specifying \&quot;preferred:&#39;true&#39;\&quot; within the query,    * only preferred terms will be matched. Please note that the internal concept identifier    * is not guaranteed persistent with new data releases. When documenting a resolved    * concept, please ensure documenting the concept details such as name, synonyms, source,    * knowledgebase etc. This will allow resolving the concept in future datasets.    *     * Example \&quot;additionalFields\&quot;; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;.    *     * Example query search keys; \&quot;term\&quot;, \&quot;semantictype\&quot;, \&quot;semanticcategory\&quot;, \&quot;knowledgebase\&quot;,    * \&quot;source\&quot;, \&quot;gi\&quot;, \&quot;preferred\&quot;.    *     * Example \&quot;source\&quot; query values; \&quot;umls\&quot;, \&quot;uniprot\&quot;, \&quot;entrezgene\&quot;.    *     * Example \&quot;knowledgebase\&quot; query values; \&quot;mim\&quot;, \&quot;chebi\&quot;, \&quot;umls\&quot;.    *     * Example \&quot;semantictype\&quot; query values; \&quot;T116\&quot;, \&quot;T028\&quot;.    *     * Example \&quot;semanticcategory\&quot; query values; \&quot;\&quot;Disorders\&quot;, \&quot;Occupations\&quot;.    *     * Example \&quot;preferred\&quot; query values; \&quot;true\&quot;, \&quot;false\&quot;.    *     * Example queryString; { \&quot;queryString\&quot;: \&quot;term:&#39;egfr&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * Example queryString; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;queryString\&quot;: \&quot;term:&#39;egfr&#39;\&quot;,    * \&quot;searchType\&quot;: \&quot;TOKEN\&quot; } .    *     * Example queryString; { \&quot;additionalFields\&quot;: [ \&quot;synonyms\&quot;, \&quot;source\&quot; ], \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39;\&quot;, \&quot;searchType\&quot;: \&quot;TOKEN\&quot; } .    *     * Example queryString; { \&quot;additionalFields\&quot;: [ \&quot;synonyms\&quot;, \&quot;source\&quot; ], \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND (source:&#39;umls&#39; OR source:&#39;uniprot&#39;)\&quot;, \&quot;searchType\&quot;: \&quot;TOKEN\&quot; } .    *     * Dependencies query; /external/concept-search-keys, /external/semantic-categories,    * /external/semantic-types, /external/taxonomies, /external/knowledge-bases,    * /external/sources    *     * Optional dependency response; /external/concepts/additional-fields    *     * @return default concept; preferred term and id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
ExternalConceptSearchRequestDto externalConceptSearchRequestDto = new ExternalConceptSearchRequestDto(); // ExternalConceptSearchRequestDto | externalConceptSearchRequestDto
try {
    List<ExternalConceptDto> result = apiInstance.getConceptsFromSolrUsingPOST1(externalConceptSearchRequestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getConceptsFromSolrUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **externalConceptSearchRequestDto** | [**ExternalConceptSearchRequestDto**](ExternalConceptSearchRequestDto.md)| externalConceptSearchRequestDto |

### Return type

[**List&lt;ExternalConceptDto&gt;**](ExternalConceptDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getMultipleConceptsByIdsUsingPOST"></a>
# **getMultipleConceptsByIdsUsingPOST**
> List&lt;ExternalConceptDto&gt; getMultipleConceptsByIdsUsingPOST(requestDto)

/ Returns concept details for the given id list, \&quot;additionalFields\&quot; (list) can be included to enrich the response.

     * @param ids (M) list with string based concept id&#39;s.    *     * @param additionalFields (O), see /external/concepts/additional-fields API call.    *     * Info; Most results will return the concept id. This call allows translation to human    * understandable information. The \&quot;additionalFields\&quot; allow further response enrichment of    * the concept details.    *     * Example \&quot;additionalfields\&quot;; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;.    *     * Example query; { \&quot;ids\&quot;: [ \&quot;2790858\&quot;, \&quot;2790859\&quot; ] } .    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;ids\&quot;: [ \&quot;2790858\&quot;, \&quot;2790859\&quot; ] } .    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;synonyms\&quot;, \&quot;source\&quot; ], \&quot;ids\&quot;: [ \&quot;2790858\&quot;,    * \&quot;2790859\&quot; ] } .    *     * Optional dependency response; /external/concepts/additional-fields API call.    *     *     * @return default concept; preferred term, id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
MultipleEntitiesRequestDto requestDto = new MultipleEntitiesRequestDto(); // MultipleEntitiesRequestDto | requestDto
try {
    List<ExternalConceptDto> result = apiInstance.getMultipleConceptsByIdsUsingPOST(requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getMultipleConceptsByIdsUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**MultipleEntitiesRequestDto**](MultipleEntitiesRequestDto.md)| requestDto |

### Return type

[**List&lt;ExternalConceptDto&gt;**](ExternalConceptDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getSuperNodesUsingPOST"></a>
# **getSuperNodesUsingPOST**
> List&lt;ExternalConceptDto&gt; getSuperNodesUsingPOST(requestDto)

/ Returns list of concepts which are part of the super node list, \&quot;additionalFields\&quot; (list) can be included to enrich the response.

     * @param additionalFields (O), see /external/concepts/additional-fields API call.    *     * Info; It is possible in several api calls to include or exclude so called super-nodes.    * Super nodes are considered \&quot;large\&quot; based on a manual curated list. This api call    * (/super-nodes) can be used to understand which nodes (read concepts) are part of the    * super node list.The \&quot;additionalFields\&quot; allow further response enrichment of the concept    * details.    *     * Example \&quot;additionalFields\&quot;; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;.    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;source\&quot; ] } .    *     * Optional dependency response; /external/concepts/additional-fields API call.    *     * @return default concept; preferred term, id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalconceptcontrollerApi;


ExternalconceptcontrollerApi apiInstance = new ExternalconceptcontrollerApi();
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    List<ExternalConceptDto> result = apiInstance.getSuperNodesUsingPOST(requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalconceptcontrollerApi#getSuperNodesUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**List&lt;ExternalConceptDto&gt;**](ExternalConceptDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

