package com.example.javagraphqlapi.controller;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public abstract class AbstractController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final Set<File> CUSTOMER_SCHEMA_FILE = new HashSet<>();
    protected final Map<String, DataFetcher> CUSTOMER_DATAFETCHER = new HashMap<>();
    private static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
    private static final String RESOURCE_PACKAGE = "graphqls/";
    private static final String RESOURCE_SUFFIX = ".graphql";
    private final String ALL_RESOURCE_PATH = CLASSPATH_ALL_URL_PREFIX + RESOURCE_PACKAGE + File.separator + "*" + RESOURCE_SUFFIX;
    ;

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() {
        getSchemaResourceName();
        buildGraphql();
    }

    private void buildGraphql() {
        GraphQLSchema graphQLSchema = buildSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema() {
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        TypeDefinitionRegistry typeDefinitionRegistry = mergeDefinitionRegistry();
        RuntimeWiring runtimeWiring = buildWiring();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private TypeDefinitionRegistry mergeDefinitionRegistry() {
        if (CollectionUtils.isEmpty(CUSTOMER_SCHEMA_FILE)) {
            throw new IllegalArgumentException("自定义的type文件不能为空");
        }
        TypeDefinitionRegistry typeDefinitionRegistry = new TypeDefinitionRegistry();
        SchemaParser schemaParser = new SchemaParser();
        CUSTOMER_SCHEMA_FILE.forEach(file -> {
            typeDefinitionRegistry.merge(schemaParser.parse(file));
        });
        return typeDefinitionRegistry;
    }


    private void getSchemaResourceName() {
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = new Resource[0];
        try {
            resources = resourcePatternResolver.getResources(this.ALL_RESOURCE_PATH);
        } catch (IOException e) {
            LOGGER.error("加载资源出现异常:", e);
        }

        Arrays.stream(resources).forEach(resource -> {
            try {
                File schemaFile = resource.getFile();
                CUSTOMER_SCHEMA_FILE.add(schemaFile);
            } catch (IOException e) {
                LOGGER.error("加载Schema 文件资源时出现异常:", e);
            }
        });
    }

    protected abstract RuntimeWiring buildWiring();
}
