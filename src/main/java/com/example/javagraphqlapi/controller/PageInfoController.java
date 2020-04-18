package com.example.javagraphqlapi.controller;

import graphql.relay.PageInfo;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.stereotype.Controller;

/**
 * @author : RXK
 * Date : 2020/4/18 11:46
 * Code Less Think More
 * Desc:
 */
@Controller
public class PageInfoController extends AbstractController {
    @Override
    protected String getResourceName() {
        return "pageInfo";
    }

    @Override
    protected RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring().build();
    }
}
