# ExternaltriplecontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMultipleTriplesByIdsUsingPOST**](ExternaltriplecontrollerApi.md#getMultipleTriplesByIdsUsingPOST) | **POST** /external/triples | / Returns triple details for the given id list, additionalFields (list) can be included to enrich the response.
[**getTripleAdditionalFieldsUsingGET1**](ExternaltriplecontrollerApi.md#getTripleAdditionalFieldsUsingGET1) | **GET** /external/triples/additional-fields | / Returns list of available additional field names which can be used within the triple calls.
[**getTripleByIdUsingGET**](ExternaltriplecontrollerApi.md#getTripleByIdUsingGET) | **GET** /external/triples/{id} | / Returns triple details for the given id, additionalFields (list) can be included to enrich the response
[**getTripleByIdUsingPOST**](ExternaltriplecontrollerApi.md#getTripleByIdUsingPOST) | **POST** /external/triples/{id} | / Returns triple details for the given id, additionalFields (list) can be included to enrich the response


<a name="getMultipleTriplesByIdsUsingPOST"></a>
# **getMultipleTriplesByIdsUsingPOST**
> List&lt;ExternalTripleDto&gt; getMultipleTriplesByIdsUsingPOST(requestDto)

/ Returns triple details for the given id list, additionalFields (list) can be included to enrich the response.

     * @param ids (M) list with string based triple id&#39;s    *     * @param additionalFields (O) , see /external/triples/additional-fields API call.    *     * Info; For most triple related commands additionalFields can be specified to enrich the    * response. Using this call (/external/triples/additional-fields) allows you to understand    * which additionalFields can be used.    *     * Example additional fields; \&quot;subjectName\&quot;, \&quot;objectName\&quot;, \&quot;predicateName\&quot;,    * \&quot;subjectSemanticCategory\&quot;, \&quot;objectSemanticCategory\&quot;, \&quot;accessMappings\&quot;, \&quot;measures\&quot;    *     * Example; { \&quot;ids\&quot;: [ \&quot;678126\&quot; ] } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;ids\&quot;: [ \&quot;678126\&quot;, \&quot;1234\&quot; ] } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;subjectName\&quot;,\&quot;objectName\&quot; ], \&quot;ids\&quot;: [ \&quot;678126\&quot;,\&quot;1234\&quot;    * ] } .    *     * Optional dependency response; /external/triples/additional-fields API call.    *     * @return default triple details; subject id, predicate id, object id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternaltriplecontrollerApi;


ExternaltriplecontrollerApi apiInstance = new ExternaltriplecontrollerApi();
MultipleEntitiesRequestDto requestDto = new MultipleEntitiesRequestDto(); // MultipleEntitiesRequestDto | requestDto
try {
    List<ExternalTripleDto> result = apiInstance.getMultipleTriplesByIdsUsingPOST(requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternaltriplecontrollerApi#getMultipleTriplesByIdsUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**MultipleEntitiesRequestDto**](MultipleEntitiesRequestDto.md)| requestDto |

### Return type

[**List&lt;ExternalTripleDto&gt;**](ExternalTripleDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getTripleAdditionalFieldsUsingGET1"></a>
# **getTripleAdditionalFieldsUsingGET1**
> List&lt;String&gt; getTripleAdditionalFieldsUsingGET1()

/ Returns list of available additional field names which can be used within the triple calls.

     *     * Info; For most triple related commands additionalFields can be specified to enrich the    * response. Using this call (/external/triples/additional-fields) allows you to understand which    * additionalFields can be used.    *     * Example fields; \&quot;subjectName\&quot;, \&quot;objectName\&quot;, \&quot;predicateName\&quot;, \&quot;subjectSemanticCategory\&quot;,    * \&quot;objectSemanticCategory\&quot;, \&quot;accessMappings\&quot;, \&quot;measures\&quot;.    *     * @return triple additional field names     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternaltriplecontrollerApi;


ExternaltriplecontrollerApi apiInstance = new ExternaltriplecontrollerApi();
try {
    List<String> result = apiInstance.getTripleAdditionalFieldsUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternaltriplecontrollerApi#getTripleAdditionalFieldsUsingGET1");
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

<a name="getTripleByIdUsingGET"></a>
# **getTripleByIdUsingGET**
> ExternalTripleDto getTripleByIdUsingGET(id, requestDto)

/ Returns triple details for the given id, additionalFields (list) can be included to enrich the response

     * @param id (M) string based triple id    *     * @param additionalFields (O) , see /external/triples/additional-fields    *     * Info; For most triple related commands additionalFields can be specified to enrich the    * response. Using this call (/external/triples/additional-fields) allows you to understand    * which additionalFields can be used.    *     * Example additional fields; \&quot;subjectName\&quot;, \&quot;objectName\&quot;, \&quot;predicateName\&quot;,    * \&quot;subjectSemanticCategory\&quot;, \&quot;objectSemanticCategory\&quot;, \&quot;accessMappings\&quot;, \&quot;measures\&quot;    *     * Example; { \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;subjectName\&quot;,\&quot;objectName\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Optional dependency response; /external/triples/additional-fields API call.    *     * @return default triple details; subject id, predicate id, object id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternaltriplecontrollerApi;


ExternaltriplecontrollerApi apiInstance = new ExternaltriplecontrollerApi();
Long id = 789L; // Long | id
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    ExternalTripleDto result = apiInstance.getTripleByIdUsingGET(id, requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternaltriplecontrollerApi#getTripleByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**ExternalTripleDto**](ExternalTripleDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getTripleByIdUsingPOST"></a>
# **getTripleByIdUsingPOST**
> ExternalTripleDto getTripleByIdUsingPOST(id, requestDto)

/ Returns triple details for the given id, additionalFields (list) can be included to enrich the response

     * @param id (M) string based triple id    *     * @param additionalFields (O) , see /external/triples/additional-fields    *     * Info; For most triple related commands additionalFields can be specified to enrich the    * response. Using this call (/external/triples/additional-fields) allows you to understand    * which additionalFields can be used.    *     * Example additional fields; \&quot;subjectName\&quot;, \&quot;objectName\&quot;, \&quot;predicateName\&quot;,    * \&quot;subjectSemanticCategory\&quot;, \&quot;objectSemanticCategory\&quot;, \&quot;accessMappings\&quot;, \&quot;measures\&quot;    *     * Example; { \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Example; { \&quot;additionalFields\&quot;: [ \&quot;subjectName\&quot;,\&quot;objectName\&quot; ], \&quot;id\&quot;: \&quot;678126\&quot; } .    *     * Optional dependency response; /external/triples/additional-fields API call.    *     * @return default triple details; subject id, predicate id, object id     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternaltriplecontrollerApi;


ExternaltriplecontrollerApi apiInstance = new ExternaltriplecontrollerApi();
Long id = 789L; // Long | id
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
try {
    ExternalTripleDto result = apiInstance.getTripleByIdUsingPOST(id, requestDto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternaltriplecontrollerApi#getTripleByIdUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]

### Return type

[**ExternalTripleDto**](ExternalTripleDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

