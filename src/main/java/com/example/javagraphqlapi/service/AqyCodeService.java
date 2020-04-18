package com.example.javagraphqlapi.service;

import com.example.javagraphqlapi.model.mysql.AqyCode;
import graphql.schema.DataFetcher;

import java.util.List;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public interface AqyCodeService {
    DataFetcher<List<AqyCode>> listByOrderNo();

    DataFetcher<AqyCode> getCodeById();

    DataFetcher<List<AqyCode>> findByParams();

    DataFetcher<List<AqyCode>> ListCodePage();
}
