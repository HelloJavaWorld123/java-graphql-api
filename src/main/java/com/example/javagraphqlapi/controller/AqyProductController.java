package com.example.javagraphqlapi.controller;

import com.example.javagraphqlapi.service.AqyProductService;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author : RXK
 * Date : 2020/4/18 11:48
 * Code Less Think More
 * Desc:
 */
@Controller
public class AqyProductController extends AbstractController {

    private final AqyProductService aqyProductService;

    public AqyProductController(AqyProductService aqyProductService) {
        this.aqyProductService = aqyProductService;
    }


    @Override
    protected RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("productInfoApi")
                        .dataFetcher("productInfo", aqyProductService.productInfo()))
                .build();
    }
}
