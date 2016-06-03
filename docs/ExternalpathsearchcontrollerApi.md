# ExternalpathsearchcontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**directConnectionsCountForSemTypesUsingPOST1**](ExternalpathsearchcontrollerApi.md#directConnectionsCountForSemTypesUsingPOST1) | **POST** /external/direct-connections-count/semantic-types | / Returns list of semantic type count to direct neighbors within given semantic category list.
[**directConnectionsCountUsingPOST**](ExternalpathsearchcontrollerApi.md#directConnectionsCountUsingPOST) | **POST** /external/direct-connections-count | / Returns list of category, predicate, taxonomy count to directly connected concepts.
[**directConnectionsWithScoresUsingPOST**](ExternalpathsearchcontrollerApi.md#directConnectionsWithScoresUsingPOST) | **POST** /external/direct-connections-with-scores | / Returns list of direct neighbors with scores based on filterGroups.
[**findDirectConceptToConceptPathsUsingPOST**](ExternalpathsearchcontrollerApi.md#findDirectConceptToConceptPathsUsingPOST) | **POST** /external/concept-to-concept/direct | / Returns direct path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; concepts id&#39;s.
[**findDirectConceptToSemanticPathsUsingPOST1**](ExternalpathsearchcontrollerApi.md#findDirectConceptToSemanticPathsUsingPOST1) | **POST** /external/concept-to-semantic/direct | / Returns direct path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; semantic field(s).
[**findIndirectConceptToConceptPathsUsingPOST**](ExternalpathsearchcontrollerApi.md#findIndirectConceptToConceptPathsUsingPOST) | **POST** /external/concept-to-concept/indirect | / Returns indirect path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; concepts id&#39;s.
[**findIndirectConceptToSemanticPathsUsingPOST1**](ExternalpathsearchcontrollerApi.md#findIndirectConceptToSemanticPathsUsingPOST1) | **POST** /external/concept-to-semantic/indirect | / Returns indirect path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; semantic field(s).
[**getAllAvailableScoringAlgorithmsUsingGET**](ExternalpathsearchcontrollerApi.md#getAllAvailableScoringAlgorithmsUsingGET) | **GET** /external/scoring-algorithms | / Returns list of \&quot;relationshipWeightAlgorithm\&quot; values
[**getDirectConnectionCountAdditionalFieldsUsingGET**](ExternalpathsearchcontrollerApi.md#getDirectConnectionCountAdditionalFieldsUsingGET) | **GET** /external/direct-connections-count/additional-fields | / Returns list of available \&quot;additionalField\&quot; names which can be used within the direct connection count API.
[**getFiltersUsingGET1**](ExternalpathsearchcontrollerApi.md#getFiltersUsingGET1) | **GET** /external/path-search/filters | / Returns list of path \&quot;negativeFilters\&quot;, \&quot;positiveFilters\&quot; or \&quot;rightInputs\&quot; semantic field prefixes
[**getPathAdditionalFieldsUsingGET1**](ExternalpathsearchcontrollerApi.md#getPathAdditionalFieldsUsingGET1) | **GET** /external/path-search/additional-fields | / Returns list of path-search \&quot;additionalField\&quot; names.
[**getPathsInfoUsingPOST1**](ExternalpathsearchcontrollerApi.md#getPathsInfoUsingPOST1) | **POST** /external/path-search/paths-info | / Finds the publications containing all the concepts from a received path


<a name="directConnectionsCountForSemTypesUsingPOST1"></a>
# **directConnectionsCountForSemTypesUsingPOST1**
> List&lt;ExternalNameCountDto&gt; directConnectionsCountForSemTypesUsingPOST1(requestDto)

/ Returns list of semantic type count to direct neighbors within given semantic category list.

     * @param ids (M) list with string based concept id&#39;s    *     * @param semanticCategories (M) list with string based semantic categories, see    * external/semantic-categories    *     * @param additionalFields (M) see /direct-connections-count/additional-fields    *     * Example \&quot;additionalFields\&quot;; \&quot;totalCount\&quot;, \&quot;categories\&quot;, \&quot;taxonomies\&quot;, \&quot;predicates\&quot;.    *     * Info; Returns list of semantic type count to direct neighbors within given semantic    * category list, \&quot;additionalFields\&quot; (list) can be included to enrich the response.    *     * @return semantic type list (name,id, count)     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
SemanticCategoriesRequestDto requestDto = new SemanticCategoriesRequestDto(); // SemanticCategoriesRequestDto | requestDto
try {
    List<ExternalNameCountDto> result = apiInstance.directConnectionsCountForSemTypesUsingPOST1(requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#directConnectionsCountForSemTypesUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**SemanticCategoriesRequestDto**](SemanticCategoriesRequestDto.md)| requestDto |

### Return type

[**List&lt;ExternalNameCountDto&gt;**](ExternalNameCountDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="directConnectionsCountUsingPOST"></a>
# **directConnectionsCountUsingPOST**
> NeighboursCountResultDto directConnectionsCountUsingPOST(requestDto)

/ Returns list of category, predicate, taxonomy count to directly connected concepts.

     * @param ids (M) list with string based concept id&#39;s.    *     * @param additionalFields (M) see /direct-connections-count/additional-fields.    *     * Additional fields; \&quot;totalCount\&quot;, \&quot;categories\&quot;, \&quot;taxonomies\&quot;, \&quot;predicates\&quot;.    *     * Info; Returns list of category, predicate and/or taxonomy count to direct neighbors,    * additionalFields (list) can be included to enrich the response.    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;categories\&quot; ], \&quot;ids\&quot;: [ \&quot;4047995\&quot; ] }.    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;categories\&quot;, \&quot;predicates\&quot; ], \&quot;ids\&quot;: [ \&quot;4047995\&quot;    * ] }.    *     * @return category list (name, count), predicate list(name, count), taxonomy list(name, count)     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
MultipleEntitiesRequestDto requestDto = new MultipleEntitiesRequestDto(); // MultipleEntitiesRequestDto | requestDto
try {
    NeighboursCountResultDto result = apiInstance.directConnectionsCountUsingPOST(requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#directConnectionsCountUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**MultipleEntitiesRequestDto**](MultipleEntitiesRequestDto.md)| requestDto |

### Return type

[**NeighboursCountResultDto**](NeighboursCountResultDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="directConnectionsWithScoresUsingPOST"></a>
# **directConnectionsWithScoresUsingPOST**
> PageNeighboursResultDto directConnectionsWithScoresUsingPOST(requestDto, pageable)

/ Returns list of direct neighbors with scores based on filterGroups.

     *     * @param ids (M) list of concept ids.    *     * @param additionalFields (O) see /direct-connections-count/additional-fields.    *     * @param filterGroups (M) filter groups to define the search criteria.    *     * @param groupExternalCombinationType (O), currently fixed to INTERSECT.    *     * @param groupInternalCombinationType (O), currently fixed to UNION.    *     * @param relationshipWeightAlgorithm (M) string based parameter from /external/scoring-algorithms    *    * Info; Returns concept ids (list) to direct neighbors using filterGroups.    *     * \&quot;filterGroups\&quot; represents a list of \&quot;filters\&quot;. The amount of \&quot;filters\&quot; is not    * restricted. Each filter contains one or multiple prefix,value pairs.    *    * A single filter is based on a prefix,value pair. To make a filter for a concept id    * 12345, the filter construct would look like \&quot;concept:12345\&quot;. For semantic type the    * filter construct would look like \&quot;st:T116\&quot;. When providing multiple filter prefix,value    * pairs within a \&quot;filters\&quot; construct, keep in mind that the inner logic is based on union.    *     * Example of a single \&quot;filters\&quot; with single filter;    * {\&quot;filterGroups\&quot;:[{\&quot;filters\&quot;:[\&quot;sc:Disorders\&quot;]}]}    *     * Example of a single \&quot;filters\&quot; with multiple filters. Within the \&quot;filters\&quot; construct this    * condition will match \&quot;sc:Disorders\&quot; OR \&quot;st:T116\&quot;;    * {\&quot;filterGroups\&quot;:[{\&quot;filters\&quot;:[\&quot;sc:Disorders\&quot;, \&quot;st:T116\&quot;]}]}    *     * Example of a multiple \&quot;filters\&quot;, each with single filter. Within the \&quot;filterGroup\&quot;    * construct each \&quot;filters\&quot; construct logic is based on intersect. This means that this    * condition will match \&quot;sc:Disorders\&quot; AND \&quot;st:T116\&quot;;    * {\&quot;filterGroups\&quot;:[{\&quot;filters\&quot;:[\&quot;sc:Disorders\&quot;]},{\&quot;filters\&quot;:[\&quot;st:T116\&quot;]}]}    *     * Example of a multiple \&quot;filters\&quot;, one with multiple filter. Within the \&quot;filterGroup\&quot;    * construct each \&quot;filters\&quot; construct logic is based on intersect. This means that this    * condition will match \&quot;sc:Disorders\&quot; AND (\&quot;st:T116\&quot; OR \&quot;st:028\&quot;);    * {\&quot;filterGroups\&quot;:[{\&quot;filters\&quot;:[\&quot;sc:Disorders\&quot;]},{\&quot;filters\&quot;:[\&quot;st:T116\&quot;, \&quot;st:028\&quot;]}]}    *     * Relationship weight algorithm must be included to rank the paths based on    * /external/scoring-algorithms. Sorting is mandatory and could be ASC or DESC.    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;filterGroups\&quot;: [ { \&quot;filters\&quot;: [    * \&quot;sc:Disorders\&quot; ] } ], \&quot;ids\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;pws\&quot; }    *     * Example query;{ \&quot;additionalFields\&quot;: [ \&quot;categories\&quot; ], \&quot;filterGroups\&quot;: [ { \&quot;filters\&quot;: [    * \&quot;sc:Disorders\&quot; ] } ], \&quot;groupExternalCombinationType\&quot;: \&quot;INTERSECTION\&quot;,    * \&quot;groupInternalCombinationType\&quot;: \&quot;INTERSECTION\&quot;, \&quot;ids\&quot;: [ \&quot;4047995\&quot; ],    * \&quot;relationshipWeightAlgorithm\&quot;: \&quot;pws\&quot; }    *     * Example \&quot;additionalFields\&quot;; \&quot;totalCount\&quot;, \&quot;categories\&quot;, \&quot;taxonomies\&quot;, \&quot;predicates\&quot;.    *     * Example \&quot;relationshipWeightAlgorithm\&quot;; \&quot;lws\&quot;, \&quot;jis\&quot;, \&quot;pws\&quot;, \&quot;plws\&quot;.    *    *    * Mandatory dependency request: /external/scoring-algorithms,    * /external/path-search/filter,/external/semantic-categories, /external/semantic-types,    * /external/taxonomies, /external/predicates.    *     * Optional dependencies response: /direct-connections-count/additional-fields,    *     * @return {content: [ { neighbour: { id,name}, score:, sourceNodes: [ { id,name,score} ] }}     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
FindNeighbourFilteredRequestDto requestDto = new FindNeighbourFilteredRequestDto(); // FindNeighbourFilteredRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PageNeighboursResultDto result = apiInstance.directConnectionsWithScoresUsingPOST(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#directConnectionsWithScoresUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**FindNeighbourFilteredRequestDto**](FindNeighbourFilteredRequestDto.md)| requestDto |
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PageNeighboursResultDto**](PageNeighboursResultDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="findDirectConceptToConceptPathsUsingPOST"></a>
# **findDirectConceptToConceptPathsUsingPOST**
> PagePathDto findDirectConceptToConceptPathsUsingPOST(requestDto, pageable)

/ Returns direct path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; concepts id&#39;s.

     *     * @param leftInputs (M) list with string based concept id&#39;s.    *     * @param rightInputs (M) list with string based concept id&#39;s.    *    * @param additionalFields (O) list with string based additional fields from    * /external/path-search/additional-fields.    *     * @param negativeFilters (Obsolete, please remove) list with filter parameters from    * /external/path-search/filters.    *    * @param positiveFilters (Obsolete, please remove) list with filter parameters from    * /external/path-search/filters.    *    * @param relationshipWeightAlgorithm (M) string based parameter from    * /external/scoring-algorithms.    *    * @param sort (M) string based value using ASC or DESC.    *     * Notes; Returns direct path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; concepts    * id&#39;s. AdditionalFields (list) can be included to enrich the response based on    * /external/path-search/additional-fields.    *     * Relationship weight algorithm must be included to rank the paths based on    * /external/scoring-algorithms. Sorting is mandatory and could be ASC or DESC.    *     * Negative and positive filters are obsolete. Please remove from the query.    *    * Example query; { \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;,    * \&quot;rightInputs\&quot;: [ \&quot;3062402\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;\&quot;], \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ],    * \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [ \&quot;3062402\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;publicationIds\&quot;, \&quot;tripleIds\&quot;, \&quot;predicateIds\&quot;],    * \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [    * \&quot;3062402\&quot;, \&quot;12345\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *     * Example additional Fields; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;, \&quot;concepts\&quot;, \&quot;publicationsCount\&quot;, \&quot;publicationIds\&quot;.    *     * Example relation weight algorithms; \&quot;lws\&quot;, \&quot;jis\&quot;, \&quot;pws\&quot;, \&quot;plws\&quot;.    *     * Mandatory dependency request: /external/scoring-algorithms, \&quot;sort\&quot;:\&quot;ASC\&quot; or \&quot;DESC\&quot;.    *     * Optional dependency response: /external/path-search/additional-fields API call.    *    * @return content:[{concepts:[{id, name},{id,name}], relationships:[{concept0Id, concept1Id}],    * score}]     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
PathSearchRequestDto requestDto = new PathSearchRequestDto(); // PathSearchRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PagePathDto result = apiInstance.findDirectConceptToConceptPathsUsingPOST(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#findDirectConceptToConceptPathsUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**PathSearchRequestDto**](PathSearchRequestDto.md)| requestDto |
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PagePathDto**](PagePathDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="findDirectConceptToSemanticPathsUsingPOST1"></a>
# **findDirectConceptToSemanticPathsUsingPOST1**
> PagePathDto findDirectConceptToSemanticPathsUsingPOST1(requestDto, pageable)

/ Returns direct path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; semantic field(s).

     *     * @param leftInputs (M) list with string based concept id&#39;s    *     * @param rightInputs (M) list with string based semantic field prefix, value pairs    *     * @param negativeFilters (Obsolete, please remove) list with filter parameters from    * /external/path-search/filters.    *    * @param positiveFilters (Obsolete, please remove) list with filter parameters from    * /external/path-search/filters.    *    * @param relationshipWeightAlgorithm (M) string based parameter from    * /external/scoring-algorithms.    *    * @param sort (M) string based value using ASC or DESC.    *    * Info; Returns direct path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; semantic    * field(s). AdditionalFields (list) can be included to enrich the response based on    * /external/path-search/additional-fields.    *     * The semantic field(s) are based on a prefix,value pair. To make a semantic field for a    * concept id 12345, the filter construct would look like &#39;concept:12345&#39;. For semantic    * type the semantic field construct would look like &#39;st:T116&#39;. When providing multiple    * semantic fields keep in mind that the combination is based on intersect.    *     * Relationship weight algorithm must be included to rank the paths based on    * /external/scoring-algorithms. Sorting is mandatory and could be ASC or DESC.    *     * Example query; { \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;,    * \&quot;rightInputs\&quot;: [ \&quot;sc:Disorders\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;\&quot;], \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ],    * \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [ \&quot;st:T116\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;publicationIds\&quot;, \&quot;tripleIds\&quot;, \&quot;predicateIds\&quot;],    * \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [    * \&quot;sc:Disorders\&quot;, \&quot;st:T116\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *     * Example additional Fields; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;, \&quot;concepts\&quot;, \&quot;publicationsCount\&quot;, \&quot;publicationIds\&quot;.    *     * Example relation weight algorithms; \&quot;lws\&quot;, \&quot;jis\&quot;, \&quot;pws\&quot;, \&quot;plws\&quot;.    *     * Example search filter prefixes; \&quot;concept:\&quot;, \&quot;tax:\&quot;, \&quot;st:\&quot;, \&quot;sc:\&quot;, \&quot;supernodes\&quot;,    * \&quot;predicate:\&quot;.    *     * prefix concept: is associated with a node in the network    *     * prefix tax: is associated with a taxonomy value (/external/taxonomies)    *     * prefix st: is associated with a semantic type value (/external/semantic-types)    *     * prefix sc: is associated with a semantic category value (/external/semantic-categories)    *     * prefix predicate: is associated with a predicate value (/external/predicates)    *     * Negative and positive filters are obsolete. Please remove from the query.    *     * Mandatory dependency request: /external/scoring-algorithms, \&quot;sort\&quot;:\&quot;ASC\&quot; or \&quot;DESC\&quot;,    * /external/path-search/filter,/external/semantic-categories, /external/semantic-types,    * /external/taxonomies, /external/predicates.    *     * Optional dependency response: /external/path-search/additional-fields API call.    *     * @return content:[{concepts:[{id, name},{id,name}], relationships:[{concept0Id, concept1Id}],    * score}]     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
PathSearchRequestDto requestDto = new PathSearchRequestDto(); // PathSearchRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PagePathDto result = apiInstance.findDirectConceptToSemanticPathsUsingPOST1(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#findDirectConceptToSemanticPathsUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**PathSearchRequestDto**](PathSearchRequestDto.md)| requestDto |
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PagePathDto**](PagePathDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="findIndirectConceptToConceptPathsUsingPOST"></a>
# **findIndirectConceptToConceptPathsUsingPOST**
> PagePathDto findIndirectConceptToConceptPathsUsingPOST(requestDto, pageable)

/ Returns indirect path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; concepts id&#39;s.

     *     * @param leftInputs (M) list with string based concept id&#39;s    *     * @param rightInputs (M) list with string based concept id&#39;s    *     * @param additionalFields (O) list with string based additional fields from    * /external/path-search/additional-fields    *     * @param negativeFilters (O) list with filter parameters from /path-search/filters    *    * @param positiveFilters (O) list with filter parameters from /path-search/filters    *    * @param relationshipWeightAlgorithm (M) string based parameter from /external/scoring-algorithms    *    * @param sort (M) string based value using ASC or DESC    *    * Info; Returns indirect path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; concepts    * id&#39;s. AdditionalFields (list) can be included to enrich the response based on    * /external/path-search/additional-fields.    *     * Negative and positive filters (lists) are based on a prefix,value pair. To make a filter    * for a concept id 12345, the filter construct would look like &#39;concept:12345&#39;. For    * semantic type the filter construct would look like &#39;st:T116&#39;. When providing multiple    * filter prefix,value pairs keep in mind that the filter is based on intersect.    *     * Relationship weight algorithm must be included to rank the paths based on    * /external/scoring-algorithms. Sorting is mandatory and could be ASC or DESC.    *     * Example query; { \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;,    * \&quot;rightInputs\&quot;: [ \&quot;3062402\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;\&quot;], \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ],    * \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [ \&quot;3062402\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;publicationIds\&quot;, \&quot;tripleIds\&quot;, \&quot;predicateIds\&quot;],    * \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [    * \&quot;3062402\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *     * Example query; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ],    * \&quot;positiveFilters\&quot;: [ \&quot;sc:Disorders\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;pws\&quot;,    * \&quot;rightInputs\&quot;: [ \&quot;sc:Disorders\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *     * Example additional Fields; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;, \&quot;concepts\&quot;, \&quot;publicationsCount\&quot;, \&quot;publicationIds\&quot;.    *     * Example relation weight algorithms; \&quot;lws\&quot;, \&quot;jis\&quot;, \&quot;pws\&quot;, \&quot;plws\&quot;.    *     * Example search filter prefixes; \&quot;concept:\&quot;, \&quot;tax:\&quot;, \&quot;st:\&quot;, \&quot;sc:\&quot;, \&quot;supernodes\&quot;,    * \&quot;predicate:\&quot;.    *     * prefix concept: is associated with a node in the network    *     * prefix tax: is associated with a taxonomy value (/external/taxonomies)    *     * prefix st: is associated with a semantic type value (/external/semantic-types)    *     * prefix sc: is associated with a semantic category value (/external/semantic-categories)    *     * prefix predicate: is associated with a predicate value (/external/predicates)    *     * Relationship weight algorithm must be included to rank the paths based on    * /external/scoring-algorithms. Sorting is mandatory and could be ASC or DESC.    *    * Mandatory dependency request: /external/scoring-algorithms, \&quot;sort\&quot;:\&quot;ASC\&quot; or \&quot;DESC\&quot;.    *     * Optional dependency request: /external/path-search/filter,/external/semantic-categories,    * /external/semantic-types, /external/taxonomies, /external/predicates.    *     * Optional dependency response: /external/path-search/additional-fields API call.    *     * @return content:[{concepts:[{id, name},{id, name},{id, name}] , relationships:[{concept0Id,    * concept1Id},{concept0Id, concept1Id}] , score}]     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
PathSearchRequestDto requestDto = new PathSearchRequestDto(); // PathSearchRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PagePathDto result = apiInstance.findIndirectConceptToConceptPathsUsingPOST(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#findIndirectConceptToConceptPathsUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**PathSearchRequestDto**](PathSearchRequestDto.md)| requestDto |
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PagePathDto**](PagePathDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="findIndirectConceptToSemanticPathsUsingPOST1"></a>
# **findIndirectConceptToSemanticPathsUsingPOST1**
> PagePathDto findIndirectConceptToSemanticPathsUsingPOST1(requestDto, pageable)

/ Returns indirect path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; semantic field(s).

     *     * @param leftInputs (M) list with string based concept id&#39;s    *     * @param rightInputs (M) list with string based semantic field prefix, value pairs    *     * @param additionalFields (O) list with string based additional fields from    * /external/path-search/additional-fields    *     * @param negativeFilters (O)list with string based prefixes from /path-search/filters combined    * with value    *    * @param positiveFilters (O)list with string based prefixes from /path-search/filters combined    * with value    *    * @param relationshipWeightAlgorithm (M) string based parameter from /external/scoring-algorithms    *    * @param sort (M) string based value using ASC or DESC    *    * Info; Returns indirect path between \&quot;left hand\&quot; concept id&#39;s and \&quot;right hand\&quot; semantic    * field(s). AdditionalFields (list) can be included to enrich the response based on    * /external/path-search/additional-fields.    *     * The semantic field(s) are based on a prefix,value pair. To make a semantic field for a    * concept id 12345, the semantic field construct would look like &#39;concept:12345&#39;. For    * semantic type the semantic field construct would look like &#39;st:T116&#39;. When providing    * multiple semantic fields keep in mind that the combination is based on intersect.    *    * Negative and positive filters (lists) are based on a prefix,value pair. To make a filter    * for a concept id 12345, the filter construct would look like &#39;concept:12345&#39;. For    * semantic type the filter construct would look like &#39;st:T116&#39;. When providing multiple    * filter prefix,value pairs keep in mind that the filter is based on intersect.    *     * Relationship weight algorithm must be included to rank the paths based on    * /external/scoring-algorithms. Sorting is mandatory and could be ASC or DESC.    *     * Example query; { \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;,    * \&quot;rightInputs\&quot;: [ \&quot;sc:Disorders\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;\&quot;], \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ],    * \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [ \&quot;st:T116\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *    * Example query; { \&quot;additionalFields\&quot;:[\&quot;publicationIds\&quot;, \&quot;tripleIds\&quot;, \&quot;predicateIds\&quot;],    * \&quot;leftInputs\&quot;: [ \&quot;4047995\&quot; ], \&quot;relationshipWeightAlgorithm\&quot;: \&quot;PWS\&quot;, \&quot;rightInputs\&quot;: [    * \&quot;sc:Disorders\&quot;, \&quot;st:T116\&quot; ], \&quot;sort\&quot;: \&quot;ASC\&quot; }.    *     * Example additional Fields; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;, \&quot;concepts\&quot;, \&quot;publicationsCount\&quot;, \&quot;publicationIds\&quot;.    *     * Example relation weight algorithms; \&quot;lws\&quot;, \&quot;jis\&quot;, \&quot;pws\&quot;, \&quot;plws\&quot;.    *     * Example search filter prefixes; \&quot;concept:\&quot;, \&quot;tax:\&quot;, \&quot;st:\&quot;, \&quot;sc:\&quot;, \&quot;supernodes\&quot;,    * \&quot;predicate:\&quot;.    *     * prefix concept: is associated with a node in the network    *     * prefix tax: is associated with a taxonomy value (/external/taxonomies)    *     * prefix st: is associated with a semantic type value (/external/semantic-types)    *     * prefix sc: is associated with a semantic category value (/external/semantic-categories)    *     * prefix predicate: is associated with a predicate value (/external/predicates)    *     * Mandatory dependency request: /external/scoring-algorithms, \&quot;sort\&quot;:\&quot;ASC\&quot; or \&quot;DESC\&quot;,    * /external/path-search/filter,/external/semantic-categories, /external/semantic-types,    * /external/taxonomies, /external/predicates.    *     * Optional dependency response: /external/path-search/additional-fields API call.    *    *     * @return content:[{concepts:[{id, name},{id, name},{id, name}] , relationships:[{concept0Id,    * concept1Id},{concept0Id, concept1Id}] , score}]     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
PathSearchRequestDto requestDto = new PathSearchRequestDto(); // PathSearchRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PagePathDto result = apiInstance.findIndirectConceptToSemanticPathsUsingPOST1(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#findIndirectConceptToSemanticPathsUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**PathSearchRequestDto**](PathSearchRequestDto.md)| requestDto |
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PagePathDto**](PagePathDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getAllAvailableScoringAlgorithmsUsingGET"></a>
# **getAllAvailableScoringAlgorithmsUsingGET**
> List&lt;String&gt; getAllAvailableScoringAlgorithmsUsingGET()

/ Returns list of \&quot;relationshipWeightAlgorithm\&quot; values

     * @param no parameters required    *     * Info; For most path API calls such as concept to concept, concept to semantics and path    * search the query requires a relation weight algorithm.    *     * Example relation weight algorithms; \&quot;lws\&quot;, \&quot;jis\&quot;, \&quot;pws\&quot;, \&quot;plws\&quot;.    *     * @return \&quot;relationshipWeightAlgorithm\&quot; values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
try {
    List<String> result = apiInstance.getAllAvailableScoringAlgorithmsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#getAllAvailableScoringAlgorithmsUsingGET");
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

<a name="getDirectConnectionCountAdditionalFieldsUsingGET"></a>
# **getDirectConnectionCountAdditionalFieldsUsingGET**
> List&lt;String&gt; getDirectConnectionCountAdditionalFieldsUsingGET()

/ Returns list of available \&quot;additionalField\&quot; names which can be used within the direct connection count API.

     * @param no parameters required    *     * Info; provides available \&quot;additionalField\&quot; names for direct connection count API calls.    *     * Example \&quot;additionalFields\&quot;; \&quot;totalCount\&quot;, \&quot;categories\&quot;, \&quot;taxonomies\&quot;, \&quot;predicates\&quot;.    *     *    * @return field names     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
try {
    List<String> result = apiInstance.getDirectConnectionCountAdditionalFieldsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#getDirectConnectionCountAdditionalFieldsUsingGET");
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

<a name="getFiltersUsingGET1"></a>
# **getFiltersUsingGET1**
> List&lt;String&gt; getFiltersUsingGET1()

/ Returns list of path \&quot;negativeFilters\&quot;, \&quot;positiveFilters\&quot; or \&quot;rightInputs\&quot; semantic field prefixes

     *     * @param no parameters required    *     * Info; For \&quot;negativeFilters\&quot; or \&quot;positiveFilters\&quot; each prefix is part of a prefix, value    * pair. To make a filter for a concept id 12345, the filter construct would look like    * &#39;concept:12345&#39;. For semantic type the filter construct would look like &#39;st:T116&#39;.    *     * The \&quot;rightInputs\&quot; semantic field(s) are based on a prefix,value pair. To make a semantic    * field for a concept id 12345, the semantic field construct would look like    * &#39;concept:12345&#39;. For semantic type the semantic field construct would look like    * &#39;st:T116&#39;. When providing multiple semantic fields keep in mind that the combination is    * based on intersect.    *     * Filter prefixes; \&quot;concept:\&quot;, \&quot;tax:\&quot;, \&quot;st:\&quot;, \&quot;sc:\&quot;, \&quot;supernodes\&quot;, \&quot;predicate:\&quot;.    *     * prefix concept: is associated with a node in the network    *     * prefix tax: is associated with a taxonomy value (/external/taxonomies)    *     * prefix st: is associated with a semantic type value (/external/semantic-types)    *     * prefix sc: is associated with a semantic category value (/external/semantic-categories)    *     * prefix predicate: is associated with a predicate value (/external/predicates)    *     * One exception is the key supernodes which is a fixed key without further parameters.    *     * @return path filter prefixes     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
try {
    List<String> result = apiInstance.getFiltersUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#getFiltersUsingGET1");
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

<a name="getPathAdditionalFieldsUsingGET1"></a>
# **getPathAdditionalFieldsUsingGET1**
> List&lt;String&gt; getPathAdditionalFieldsUsingGET1()

/ Returns list of path-search \&quot;additionalField\&quot; names.

     *     * @param no parameters required    *     * Example \&quot;additionalFields\&quot;; \&quot;description\&quot;, \&quot;semanticCategory\&quot;, \&quot;semanticTypes\&quot;,    * \&quot;taxonomies\&quot;, \&quot;measures\&quot;, \&quot;accessMappings\&quot;, \&quot;hasTriples\&quot;, \&quot;synonyms\&quot;, \&quot;source\&quot;,    * \&quot;knowledgebase\&quot;, \&quot;concepts\&quot;, \&quot;publicationsCount\&quot;, \&quot;publicationIds\&quot;.    *    * @return path-search \&quot;additionalField\&quot;     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
try {
    List<String> result = apiInstance.getPathAdditionalFieldsUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#getPathAdditionalFieldsUsingGET1");
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

<a name="getPathsInfoUsingPOST1"></a>
# **getPathsInfoUsingPOST1**
> List&lt;PathPublicationsDto&gt; getPathsInfoUsingPOST1(paths)

/ Finds the publications containing all the concepts from a received path

     *     * @param paths list of paths. Path is an array of ids of concepts in that path    *     * Info; After building a \&quot;path\&quot; step by step and storing them as a List [node1, node2,    * node3, node4] representing a path between node1,2,3 and 4 this API call can be used to    * collect the associated publication ids. When multiple paths are available the query    * needs to be repeated for each list.    *     * @return for each path returns publications count and publication ids     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpathsearchcontrollerApi;


ExternalpathsearchcontrollerApi apiInstance = new ExternalpathsearchcontrollerApi();
PathsListRequestDto paths = new PathsListRequestDto(); // PathsListRequestDto | paths
try {
    List<PathPublicationsDto> result = apiInstance.getPathsInfoUsingPOST1(paths);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpathsearchcontrollerApi#getPathsInfoUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paths** | [**PathsListRequestDto**](PathsListRequestDto.md)| paths |

### Return type

[**List&lt;PathPublicationsDto&gt;**](PathPublicationsDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

