package com.example.javagraphqlapi.controller;

import com.example.javagraphqlapi.service.AqyCodeService;
import com.example.javagraphqlapi.service.AqyProductService;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
@Controller
public class AqyController extends AbstractController{

    @Autowired
    private AqyCodeService aqyCodeService;

    @Autowired
    private AqyProductService aqyProductService;

    @Override
    protected String getResourceName() {
        return "aqyOrder";
    }

    @Override
    protected RuntimeWiring buildWiring() {
        return RuntimeWiring
                .newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                              .dataFetcher("codesByOrderNo",aqyCodeService.listByOrderNo()))
                .type(TypeRuntimeWiring.newTypeWiring("OrderCode").dataFetcher("product",aqyProductService.listByProductNo()))
                .build();
    }
}
