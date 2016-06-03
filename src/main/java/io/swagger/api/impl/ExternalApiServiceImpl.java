package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.ExternalNameCountDto;
import io.swagger.model.SemanticCategoriesRequestDto;
import io.swagger.model.MultipleEntitiesRequestDto;
import io.swagger.model.NeighboursCountResultDto;
import io.swagger.model.FindNeighbourFilteredRequestDto;
import io.swagger.model.Pageable;
import io.swagger.model.PageNeighboursResultDto;
import io.swagger.model.PagePathDto;
import io.swagger.model.PathSearchRequestDto;
import io.swagger.model.PagePredicateDto;
import io.swagger.model.ExternalRequestDto;
import io.swagger.model.ExternalConceptDto;
import io.swagger.model.ExternalConceptSearchRequestDto;
import io.swagger.model.ExternalPublicationDto;
import io.swagger.model.ExternalTripleDto;
import io.swagger.model.PathsListRequestDto;
import io.swagger.model.PathPublicationsDto;
import io.swagger.model.PageExternalSemanticCategoryDto;
import io.swagger.model.PageExternalSemanticTypeDto;
import io.swagger.model.PageExternalTaxonomyDto;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-05-22T14:24:41.728+02:00")
public class ExternalApiServiceImpl extends ExternalApiService {
    
    @Override
    public Response directConnectionsCountForSemTypesUsingPOST1(SemanticCategoriesRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response directConnectionsCountUsingPOST(MultipleEntitiesRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response directConnectionsWithScoresUsingPOST(FindNeighbourFilteredRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response findDirectConceptToConceptPathsUsingPOST(PathSearchRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response findDirectConceptToSemanticPathsUsingPOST1(PathSearchRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response findIndirectConceptToConceptPathsUsingPOST(PathSearchRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response findIndirectConceptToSemanticPathsUsingPOST1(PathSearchRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getAllAvailableScoringAlgorithmsUsingGET(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getAllKnowledgeBasesUsingGET1(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getAllPredicatesUsingGET1(Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getAllPredicatesUsingPOST1(Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getAllSourcesUsingGET(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getConceptAdditionalFieldsUsingGET(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getConceptByIdUsingGET(Long id, ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getConceptByIdUsingPOST(Long id, ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getConceptSearchKeysUsingGET1(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getConceptsFromSolrUsingPOST1(ExternalConceptSearchRequestDto externalConceptSearchRequestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getDirectConnectionCountAdditionalFieldsUsingGET(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getFiltersUsingGET1(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getMultipleConceptsByIdsUsingPOST(MultipleEntitiesRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getMultiplePublicationsByIdsUsingPOST(MultipleEntitiesRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getMultipleTriplesByIdsUsingPOST(MultipleEntitiesRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getPathAdditionalFieldsUsingGET1(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getPathsInfoUsingPOST1(PathsListRequestDto paths, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getPublicationAdditionalFieldsUsingGET1(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getPublicationsByIdUsingGET1(Long id, ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getPublicationsByIdUsingPOST1(Long id, ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getSemanticCategoriesUsingGET1(ExternalRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getSemanticCategoriesUsingPOST1(ExternalRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getSemanticTypesUsingGET(ExternalRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getSemanticTypesUsingPOST(ExternalRequestDto requestDto, Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getSuperNodesUsingPOST(ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getTaxonomiesUsingPOST(Pageable pageable, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getTripleAdditionalFieldsUsingGET1(SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getTripleByIdUsingGET(Long id, ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
    @Override
    public Response getTripleByIdUsingPOST(Long id, ExternalRequestDto requestDto, SecurityContext securityContext)
    throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    
}
