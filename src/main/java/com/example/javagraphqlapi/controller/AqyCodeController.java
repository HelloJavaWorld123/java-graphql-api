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
public class AqyCodeController extends AbstractController{

    private final AqyCodeService aqyCodeService;

    private final AqyProductService aqyProductService;

    public AqyCodeController(AqyCodeService aqyCodeService, AqyProductService aqyProductService) {
        this.aqyCodeService = aqyCodeService;
        this.aqyProductService = aqyProductService;
    }

    @Override
    protected RuntimeWiring buildWiring() {
        return RuntimeWiring
                .newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                              .dataFetcher("codesByOrderNo",aqyCodeService.listByOrderNo())
                        .dataFetcher("codeById", aqyCodeService.getCodeById())
                        .dataFetcher("listCode",aqyCodeService.findByParams())
                        .dataFetcher("listCodePage", aqyCodeService.ListCodePage())
                ).type(TypeRuntimeWiring.newTypeWiring("OrderCode")
                        .dataFetcher("product",aqyProductService.listByProductNo()))
                .build();
    }
}
