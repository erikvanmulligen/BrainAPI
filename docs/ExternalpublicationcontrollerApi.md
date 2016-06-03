# ExternalpublicationcontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMultiplePublicationsByIdsUsingPOST**](ExternalpublicationcontrollerApi.md#getMultiplePublicationsByIdsUsingPOST) | **POST** /external/publications | / Returns publication details for the given id list, additionalFields (list) can be included to enrich the response.
[**getPublicationAdditionalFieldsUsingGET1**](ExternalpublicationcontrollerApi.md#getPublicationAdditionalFieldsUsingGET1) | **GET** /external/publications/additional-fields | /
[**getPublicationsByIdUsingGET1**](ExternalpublicationcontrollerApi.md#getPublicationsByIdUsingGET1) | **GET** /external/publications/{id} | / Returns publication details for the given id, additionalFields (list) can be included to enrich the response.
[**getPublicationsByIdUsingPOST1**](ExternalpublicationcontrollerApi.md#getPublicationsByIdUsingPOST1) | **POST** /external/publications/{id} | / Returns publication details for the given id, additionalFields (list) can be included to enrich the response.


<a name="getMultiplePublicationsByIdsUsingPOST"></a>
# **getMultiplePublicationsByIdsUsingPOST**
> List&lt;ExternalPublicationDto&gt; getMultiplePublicationsByIdsUsingPOST(requestDto)

/ Returns publication details for the given id list, additionalFields (list) can be included to enrich the response.

     * @param ids (M) list with string based publication id&#39;s.    *     * @param additionalFields (O), see /external/publications/additional-fields API call.    *     * Info; when working with triples and/or paths often the publication id can be included in    * the response. Based on score you can decide which publications are required to make the    * result complete.    *     * Example additional fields; \&quot;url\&quot;, \&quot;abstract\&quot;, \&quot;sourceId\&quot;, \&quot;sourceName\&quot;, \&quot;authors\&quot;,    * \&quot;keywords\&quot;, \&quot;geneSymList\&quot;, \&quot;chemSubList\&quot;, \&quot;meshHeadList\&quot;,    * \&quot;publicationDateAsEpochMillisecondsUTC\&quot;, \&quot;publicationDateHumanReadableUTC\&quot;,    * \&quot;lastUpdatedDateAsEpochMillisecondsUTC\&quot;, \&quot;LastUpdatedDateHumanReadableUTC\&quot;, \&quot;measures\&quot;,    * \&quot;accessMappings\&quot;    *     * Example; { \&quot;ids\&quot;: [ \&quot;678126\&quot; ] } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;ids\&quot;: [ \&quot;678126\&quot;,\&quot;12345\&quot; ] } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;url\&quot;,\&quot;keywords\&quot; ], \&quot;ids\&quot;: [ \&quot;678126\&quot;,\&quot;12345\&quot; ] } .    *     * Optional dependency response; /external/publications/additional-fields API call.    *     * @return default publication details; publication id, document id, title     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpublicationcontrollerApi;


ExternalpublicationcontrollerApi apiInstance = new ExternalpublicationcontrollerApi();
MultipleEntitiesRequestDto requestDto = new MultipleEntitiesRequestDto(); // MultipleEntitiesRequestDto | requestDto
try {
    List<ExternalPublicationDto> result = apiInstance.getMultiplePublicationsByIdsUsingPOST(requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpublicationcontrollerApi#getMultiplePublicationsByIdsUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**MultipleEntitiesRequestDto**](MultipleEntitiesRequestDto.md)| requestDto |

### Return type

[**List&lt;ExternalPublicationDto&gt;**](ExternalPublicationDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getPublicationAdditionalFieldsUsingGET1"></a>
# **getPublicationAdditionalFieldsUsingGET1**
> List&lt;String&gt; getPublicationAdditionalFieldsUsingGET1()

/

     *     * Returns list of available additional field names which can be used within the publication    * calls.    *     * @param no parameters required    *     * Info; For most publication related commands additionalFields can be specified to enrich    * the response. Using this call (/external/publications/additional-fields) allows you to    * understand which additionalFields can be used.    *     * Example additional fields; \&quot;url\&quot;, \&quot;abstract\&quot;, \&quot;sourceId\&quot;, \&quot;sourceName\&quot;, \&quot;authors\&quot;,    * \&quot;keywords\&quot;, \&quot;geneSymList\&quot;, \&quot;chemSubList\&quot;, \&quot;meshHeadList\&quot;,    * \&quot;publicationDateAsEpochMillisecondsUTC\&quot;, \&quot;publicationDateHumanReadableUTC\&quot;,    * \&quot;lastUpdatedDateAsEpochMillisecondsUTC\&quot;, \&quot;LastUpdatedDateHumanReadableUTC\&quot;, \&quot;measures\&quot;,    * \&quot;accessMappings\&quot;    *     * @return publication additional field names    *      

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpublicationcontrollerApi;


ExternalpublicationcontrollerApi apiInstance = new ExternalpublicationcontrollerApi();
try {
    List<String> result = apiInstance.getPublicationAdditionalFieldsUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpublicationcontrollerApi#getPublicationAdditionalFieldsUsingGET1");
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

<a name="getPublicationsByIdUsingGET1"></a>
# **getPublicationsByIdUsingGET1**
> ExternalPublicationDto getPublicationsByIdUsingGET1(id, requestDto)

/ Returns publication details for the given id, additionalFields (list) can be included to enrich the response.

     * @param id (M) string based publication id.    *     * @param additionalFields (O), see /external/publications/additional-fields API call.    *     * Example additional fields; \&quot;url\&quot;, \&quot;abstract\&quot;, \&quot;sourceId\&quot;, \&quot;sourceName\&quot;, \&quot;authors\&quot;,    * \&quot;keywords\&quot;, \&quot;geneSymList\&quot;, \&quot;chemSubList\&quot;, \&quot;meshHeadList\&quot;,    * \&quot;publicationDateAsEpochMillisecondsUTC\&quot;, \&quot;publicationDateHumanReadableUTC\&quot;,    * \&quot;lastUpdatedDateAsEpochMillisecondsUTC\&quot;, \&quot;LastUpdatedDateHumanReadableUTC\&quot;, \&quot;measures\&quot;,    * \&quot;accessMappings\&quot;    *     * Info; when working with triples and/or paths often the publication id can be included in    * the response. Based on score you can decide which publications are required to make the    * result complete.    *     * Example; { \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;url\&quot;,\&quot;keywords\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Optional dependency response; /external/publications/additional-fields API call.    *     * @return default publication details; publication id, document id, title     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpublicationcontrollerApi;


ExternalpublicationcontrollerApi apiInstance = new ExternalpublicationcontrollerApi();
Long id = 789L; // Long | id
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    ExternalPublicationDto result = apiInstance.getPublicationsByIdUsingGET1(id, requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpublicationcontrollerApi#getPublicationsByIdUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**ExternalPublicationDto**](ExternalPublicationDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getPublicationsByIdUsingPOST1"></a>
# **getPublicationsByIdUsingPOST1**
> ExternalPublicationDto getPublicationsByIdUsingPOST1(id, requestDto)

/ Returns publication details for the given id, additionalFields (list) can be included to enrich the response.

     * @param id (M) string based publication id.    *     * @param additionalFields (O), see /external/publications/additional-fields API call.    *     * Example additional fields; \&quot;url\&quot;, \&quot;abstract\&quot;, \&quot;sourceId\&quot;, \&quot;sourceName\&quot;, \&quot;authors\&quot;,    * \&quot;keywords\&quot;, \&quot;geneSymList\&quot;, \&quot;chemSubList\&quot;, \&quot;meshHeadList\&quot;,    * \&quot;publicationDateAsEpochMillisecondsUTC\&quot;, \&quot;publicationDateHumanReadableUTC\&quot;,    * \&quot;lastUpdatedDateAsEpochMillisecondsUTC\&quot;, \&quot;LastUpdatedDateHumanReadableUTC\&quot;, \&quot;measures\&quot;,    * \&quot;accessMappings\&quot;    *     * Info; when working with triples and/or paths often the publication id can be included in    * the response. Based on score you can decide which publications are required to make the    * result complete.    *     * Example; { \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;url\&quot;,\&quot;keywords\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Optional dependency response; /external/publications/additional-fields API call.    *     * @return default publication details; publication id, document id, title     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpublicationcontrollerApi;


ExternalpublicationcontrollerApi apiInstance = new ExternalpublicationcontrollerApi();
Long id = 789L; // Long | id
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    ExternalPublicationDto result = apiInstance.getPublicationsByIdUsingPOST1(id, requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpublicationcontrollerApi#getPublicationsByIdUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**ExternalPublicationDto**](ExternalPublicationDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

