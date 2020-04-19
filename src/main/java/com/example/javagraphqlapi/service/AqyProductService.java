package com.example.javagraphqlapi.service;

import com.example.javagraphqlapi.model.mysql.AqyProduct;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public interface AqyProductService {
    DataFetcher<AqyProduct> listByProductNo();

    DataFetcher<AqyProduct> productInfo();
}
