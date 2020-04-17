package com.example.javagraphqlapi.controller;

import com.example.javagraphqlapi.service.AqyCodeService;
import com.example.javagraphqlapi.service.AqyProductService;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
@Controller
@RequestMapping("/api/order")
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
    @RequestMapping("/code")
    protected RuntimeWiring buildWiring() {
        return RuntimeWiring
                .newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                              .dataFetcher("code",aqyCodeService.listByOrderNo()))
                .type(TypeRuntimeWiring.newTypeWiring("OrderCode").dataFetcher("product",aqyProductService.listByProductNo()))
                .build();
    }
}
