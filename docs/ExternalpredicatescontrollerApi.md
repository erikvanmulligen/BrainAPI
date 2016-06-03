# ExternalpredicatescontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllPredicatesUsingGET1**](ExternalpredicatescontrollerApi.md#getAllPredicatesUsingGET1) | **GET** /external/predicates | / Returns list of predicate values
[**getAllPredicatesUsingPOST1**](ExternalpredicatescontrollerApi.md#getAllPredicatesUsingPOST1) | **POST** /external/predicates | / Returns list of predicate values


<a name="getAllPredicatesUsingGET1"></a>
# **getAllPredicatesUsingGET1**
> PagePredicateDto getAllPredicatesUsingGET1(pageable)

/ Returns list of predicate values

     *     * @param no parameters required    *     * Info; the predicate value can be used for the filters as available within the concept to    * concept, concept to semantics and direct connections with scores api calls. The api call    * /path-search/filters provides the options as available for those calls and predicate is    * one of them. Please note that a prefix is required to make the filter work. In this case    * the prefix will be \&quot;predicate:\&quot;.    *     * @return predicate values; predicate id, name, definition     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpredicatescontrollerApi;


ExternalpredicatescontrollerApi apiInstance = new ExternalpredicatescontrollerApi();
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PagePredicateDto result = apiInstance.getAllPredicatesUsingGET1(pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpredicatescontrollerApi#getAllPredicatesUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PagePredicateDto**](PagePredicateDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

<a name="getAllPredicatesUsingPOST1"></a>
# **getAllPredicatesUsingPOST1**
> PagePredicateDto getAllPredicatesUsingPOST1(pageable)

/ Returns list of predicate values

     *     * @param no parameters required    *     * Info; the predicate value can be used for the filters as available within the concept to    * concept, concept to semantics and direct connections with scores api calls. The api call    * /path-search/filters provides the options as available for those calls and predicate is    * one of them. Please note that a prefix is required to make the filter work. In this case    * the prefix will be \&quot;predicate:\&quot;.    *     * @return predicate values; predicate id, name, definition     

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExternalpredicatescontrollerApi;


ExternalpredicatescontrollerApi apiInstance = new ExternalpredicatescontrollerApi();
Pageable pageable = new Pageable(); // Pageable | pageable
try {
    PagePredicateDto result = apiInstance.getAllPredicatesUsingPOST1(pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExternalpredicatescontrollerApi#getAllPredicatesUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageable** | [**Pageable**](Pageable.md)| pageable | [optional]

### Return type

[**PagePredicateDto**](PagePredicateDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *

