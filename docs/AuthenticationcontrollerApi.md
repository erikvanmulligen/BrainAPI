# AuthenticationcontrollerApi

All URIs are relative to *https://euretos-brain.com/spine-ws*

Method | HTTP request | Description
------------- | ------------- | -------------
[**documentationCacheUsingGET**](AuthenticationcontrollerApi.md#documentationCacheUsingGET) | **GET** /login/documentationCache | Authorization point. Generates token that is used in secured APIs to authenticate user in system
[**getAuthenticateUsingPOST1**](AuthenticationcontrollerApi.md#getAuthenticateUsingPOST1) | **POST** /login/authenticate | Authorization point. Generates token that is used in secured APIs to authenticate user in system
[**getExpiredUsingGET**](AuthenticationcontrollerApi.md#getExpiredUsingGET) | **GET** /login/expired | Fires on authorization failure if user expired and needs to pay for account prolongation
[**getFailedUsingGET**](AuthenticationcontrollerApi.md#getFailedUsingGET) | **GET** /login/failed | Fires on authorization failure


<a name="documentationCacheUsingGET"></a>
# **documentationCacheUsingGET**
> DocumentationCache documentationCacheUsingGET()

Authorization point. Generates token that is used in secured APIs to authenticate user in system

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthenticationcontrollerApi;


AuthenticationcontrollerApi apiInstance = new AuthenticationcontrollerApi();
try {
    DocumentationCache result = apiInstance.documentationCacheUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationcontrollerApi#documentationCacheUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**DocumentationCache**](DocumentationCache.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getAuthenticateUsingPOST1"></a>
# **getAuthenticateUsingPOST1**
> TokenHolder getAuthenticateUsingPOST1(loginInfo)

Authorization point. Generates token that is used in secured APIs to authenticate user in system

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthenticationcontrollerApi;


AuthenticationcontrollerApi apiInstance = new AuthenticationcontrollerApi();
LoginInfo loginInfo = new LoginInfo(); // LoginInfo | user credentials
try {
    TokenHolder result = apiInstance.getAuthenticateUsingPOST1(loginInfo);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationcontrollerApi#getAuthenticateUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **loginInfo** | [**LoginInfo**](LoginInfo.md)| user credentials | [optional]

### Return type

[**TokenHolder**](TokenHolder.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getExpiredUsingGET"></a>
# **getExpiredUsingGET**
> getExpiredUsingGET()

Fires on authorization failure if user expired and needs to pay for account prolongation

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthenticationcontrollerApi;


AuthenticationcontrollerApi apiInstance = new AuthenticationcontrollerApi();
try {
    apiInstance.getExpiredUsingGET();
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationcontrollerApi#getExpiredUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getFailedUsingGET"></a>
# **getFailedUsingGET**
> getFailedUsingGET()

Fires on authorization failure

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthenticationcontrollerApi;


AuthenticationcontrollerApi apiInstance = new AuthenticationcontrollerApi();
try {
    apiInstance.getFailedUsingGET();
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationcontrollerApi#getFailedUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

