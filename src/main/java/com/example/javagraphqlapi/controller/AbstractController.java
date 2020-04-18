package com.example.javagraphqlapi.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.language.Document;
import graphql.language.SDLDefinition;
import graphql.language.TypeDefinition;
import graphql.parser.Parser;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.spring.web.servlet.components.GraphQLController;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.FileNameMap;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public abstract class AbstractController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private Set<String> CUSTOMER_GRAPHQL_FILE = new HashSet<>();
    private static final String RESOURCE_PACKAGE = "graphqls/";
    private static final String RESOURCE_SUFFIX = ".graphql";

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void addPath() {
        getSchemaResourceName();
        init();
    }

    private void init() {
        GraphQLSchema graphQLSchema = buildSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema() {
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        TypeDefinitionRegistry typeDefinitionRegistry = typeDefinitionRegistry();
        RuntimeWiring runtimeWiring = buildWiring();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private TypeDefinitionRegistry typeDefinitionRegistry() {
        if (CollectionUtils.isEmpty(CUSTOMER_GRAPHQL_FILE)) {
            throw new IllegalArgumentException("自定义的type文件不能为空");
        }

        TypeDefinitionRegistry typeDefinitionRegistry = new TypeDefinitionRegistry();
        CUSTOMER_GRAPHQL_FILE.forEach(fileName -> {
            URL schemaResourceName = Resources.getResource(fileName);
            String stringUrl;
            try {
                stringUrl = Resources.toString(schemaResourceName, Charset.defaultCharset());
            } catch (IOException e) {
                LOGGER.error("加载 Resource 的 schema 的资源文件出现异常", e);
                return;
            }

            StringReader stringReader = new StringReader(stringUrl);
            Parser parser = new Parser();
            Document document = parser.parseDocument(stringReader);
            document.getDefinitions().forEach(definition -> {
                if (definition instanceof SDLDefinition) {
                    typeDefinitionRegistry.add((SDLDefinition) definition);
                }
            });
        });

        return typeDefinitionRegistry;
    }


    private void getSchemaResourceName() {
        String resourcePath = "classpath*:" + RESOURCE_PACKAGE + File.separator + "*" + RESOURCE_SUFFIX;
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = new Resource[0];
        try {
            resources = resourcePatternResolver.getResources(resourcePath);
        } catch (IOException e) {
            LOGGER.error("加载资源出现异常:", e);
        }

        Arrays.stream(resources).forEach(resource -> {
            try {
                String name = resource.getFile().getName();
                String graphqlFileName = RESOURCE_PACKAGE + name;
                CUSTOMER_GRAPHQL_FILE.add(graphqlFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    protected abstract RuntimeWiring buildWiring();
}
