# ExternalcontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getSemanticCategoriesUsingGET1**](ExternalcontrollerApi.md#getSemanticCategoriesUsingGET1) | **GET** /external/semantic-categories | / Returns list of semantic category values
[**getSemanticCategoriesUsingPOST1**](ExternalcontrollerApi.md#getSemanticCategoriesUsingPOST1) | **POST** /external/semantic-categories | / Returns list of semantic category values
[**getSemanticTypesUsingGET**](ExternalcontrollerApi.md#getSemanticTypesUsingGET) | **GET** /external/semantic-types | / Returns list of semantic type values
[**getSemanticTypesUsingPOST**](ExternalcontrollerApi.md#getSemanticTypesUsingPOST) | **POST** /external/semantic-types | / Returns list of semantic type values
[**getTaxonomiesUsingPOST**](ExternalcontrollerApi.md#getTaxonomiesUsingPOST) | **POST** /external/taxonomies | / Returns list of taxonomy values


<a name="getSemanticCategoriesUsingGET1"></a>
# **getSemanticCategoriesUsingGET1**
> PageExternalSemanticCategoryDto getSemanticCategoriesUsingGET1(requestDto, pageable)

/ Returns list of semantic category values

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;semanticcategory\&quot; can be retrieved using the    * /external/semantic-categories call.    *     * Example queryString as used with /concept/search API call; { \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND semanticcategory:&#39;Disorders&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * @return semantic category values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalcontrollerApi;


ExternalcontrollerApi apiInstance = new ExternalcontrollerApi();
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PageExternalSemanticCategoryDto result = apiInstance.getSemanticCategoriesUsingGET1(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalcontrollerApi#getSemanticCategoriesUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PageExternalSemanticCategoryDto**](PageExternalSemanticCategoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getSemanticCategoriesUsingPOST1"></a>
# **getSemanticCategoriesUsingPOST1**
> PageExternalSemanticCategoryDto getSemanticCategoriesUsingPOST1(requestDto, pageable)

/ Returns list of semantic category values

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;semanticcategory\&quot; can be retrieved using the    * /external/semantic-categories call.    *     * Example queryString as used with /concept/search API call; { \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND semanticcategory:&#39;Disorders&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * @return semantic category values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalcontrollerApi;


ExternalcontrollerApi apiInstance = new ExternalcontrollerApi();
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PageExternalSemanticCategoryDto result = apiInstance.getSemanticCategoriesUsingPOST1(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalcontrollerApi#getSemanticCategoriesUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PageExternalSemanticCategoryDto**](PageExternalSemanticCategoryDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getSemanticTypesUsingGET"></a>
# **getSemanticTypesUsingGET**
> PageExternalSemanticTypeDto getSemanticTypesUsingGET(requestDto, pageable)

/ Returns list of semantic type values

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;semantictypes\&quot; can be retrieved using the    * /external/semantic-types call.    *     * Example queryString as used with /concept/search API call; { \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND semantictypes:&#39;T116&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * @return semantic type values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalcontrollerApi;


ExternalcontrollerApi apiInstance = new ExternalcontrollerApi();
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PageExternalSemanticTypeDto result = apiInstance.getSemanticTypesUsingGET(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalcontrollerApi#getSemanticTypesUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PageExternalSemanticTypeDto**](PageExternalSemanticTypeDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getSemanticTypesUsingPOST"></a>
# **getSemanticTypesUsingPOST**
> PageExternalSemanticTypeDto getSemanticTypesUsingPOST(requestDto, pageable)

/ Returns list of semantic type values

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;semantictypes\&quot; can be retrieved using the    * /external/semantic-types call.    *     * Example queryString as used with /concept/search API call; { \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND semantictypes:&#39;T116&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * @return semantic type values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalcontrollerApi;


ExternalcontrollerApi apiInstance = new ExternalcontrollerApi();
ExternalRequestDto requestDto = new ExternalRequestDto(); // ExternalRequestDto | requestDto
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PageExternalSemanticTypeDto result = apiInstance.getSemanticTypesUsingPOST(requestDto, pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalcontrollerApi#getSemanticTypesUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestDto** | [**ExternalRequestDto**](ExternalRequestDto.md)| requestDto | [optional]
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PageExternalSemanticTypeDto**](PageExternalSemanticTypeDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getTaxonomiesUsingPOST"></a>
# **getTaxonomiesUsingPOST**
> PageExternalTaxonomyDto getTaxonomiesUsingPOST(pageable)

/ Returns list of taxonomy values

     *     * @param no parameters required    *     * Info; The concept search API call (/concepts/search) requires a query to be based on a    * key, value pair. The /search-keys response will provide a list of available search keys    * which can be used within the queryString. Please note that the logical conditions AND,    * OR, NOT and grouping ( ) are not included in this response.    *     * The values as available for the key \&quot;taxonomies\&quot; can be retrieved using the    * /external/taxonomies call.    *     * Example queryString as used with /concept/search API call; { \&quot;queryString\&quot;:    * \&quot;term:&#39;egfr&#39; AND taxonomies:&#39;Homo Sapiens&#39;\&quot;, \&quot;searchType\&quot;: \&quot;STRING\&quot; } .    *     * @return taxonomy values     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalcontrollerApi;


ExternalcontrollerApi apiInstance = new ExternalcontrollerApi();
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PageExternalTaxonomyDto result = apiInstance.getTaxonomiesUsingPOST(pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalcontrollerApi#getTaxonomiesUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PageExternalTaxonomyDto**](PageExternalTaxonomyDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

