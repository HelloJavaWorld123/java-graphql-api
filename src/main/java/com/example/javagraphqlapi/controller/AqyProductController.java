package com.example.javagraphqlapi.controller;

import graphql.schema.idl.RuntimeWiring;
import org.springframework.stereotype.Controller;

/**
 * @author : RXK
 * Date : 2020/4/18 11:48
 * Code Less Think More
 * Desc:
 */
@Controller
public class AqyProductController extends AbstractController{

    @Override
    protected RuntimeWiring buildWiring() {
      return RuntimeWiring.newRuntimeWiring()
                .build();
    }
}
