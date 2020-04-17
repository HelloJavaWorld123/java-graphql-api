package com.example.javagraphqlapi.controller;

import com.google.common.base.Strings;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.spring.web.servlet.components.GraphQLController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public abstract class AbstractController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static final String RESOURCE_PACKAGE = "graphqls";
    private static final String RESOURCE_SUFFIX = ".graphqls";

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }


    @PostConstruct
    private void init() {
        URL schemaResourceName = Resources.getResource(getSchemaResourceName());
        String stringUrl;
        try {
            stringUrl = Resources.toString(schemaResourceName, Charset.defaultCharset());
        } catch (IOException e) {
            LOGGER.error("加载 Resource 的 schema 的资源文件出现异常", e);
            return;
        }
        GraphQLSchema graphQLSchema = buildSchema(stringUrl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String stringUrl) {
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        TypeDefinitionRegistry registry = new SchemaParser().parse(stringUrl);
        RuntimeWiring runtimeWiring = buildWiring();
        return schemaGenerator.makeExecutableSchema(registry,runtimeWiring);
    }


    private String getSchemaResourceName() {
        String resourceName = getResourceName();
        if (Strings.isNullOrEmpty(resourceName)) {
            throw new IllegalArgumentException("schema 的配置文件不能为空 ");
        }
        return RESOURCE_PACKAGE+ File.separator+resourceName + RESOURCE_SUFFIX;
    }

    protected abstract String getResourceName();
    protected abstract RuntimeWiring buildWiring();
}
