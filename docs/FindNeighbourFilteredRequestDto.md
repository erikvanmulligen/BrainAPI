
# FindNeighbourFilteredRequestDto

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalFields** | **List&lt;String&gt;** | Array of names of additional fields that should be returned by API |  [optional]
**filterGroups** | [**List&lt;FilterGroup&gt;**](FilterGroup.md) | List of filter groups that can be combined within a group (internally) and with other groups (externally) |  [optional]
**groupExternalCombinationType** | [**GroupExternalCombinationTypeEnum**](#GroupExternalCombinationTypeEnum) | Defines how to combine groups of filters |  [optional]
**groupInternalCombinationType** | [**GroupInternalCombinationTypeEnum**](#GroupInternalCombinationTypeEnum) | Defines how to combine filters inside a group |  [optional]
**ids** | **List&lt;String&gt;** | Array of entities ids | 
**relationshipWeightAlgorithm** | **String** | Defines the algorithm that should be used for path ordering |  [optional]


<a name="GroupExternalCombinationTypeEnum"></a>
## Enum: GroupExternalCombinationTypeEnum
Name | Value
---- | -----
INTERSECTION | &quot;INTERSECTION&quot;
UNION | &quot;UNION&quot;


<a name="GroupInternalCombinationTypeEnum"></a>
## Enum: GroupInternalCombinationTypeEnum
Name | Value
---- | -----
INTERSECTION | &quot;INTERSECTION&quot;
UNION | &quot;UNION&quot;



