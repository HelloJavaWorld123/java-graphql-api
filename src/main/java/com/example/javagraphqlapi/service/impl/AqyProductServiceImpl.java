package com.example.javagraphqlapi.service.impl;

import com.example.javagraphqlapi.dao.mysql.AqyProductMapper;
import com.example.javagraphqlapi.model.mysql.AqyCode;
import com.example.javagraphqlapi.model.mysql.AqyProduct;
import com.example.javagraphqlapi.service.AqyProductService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
@Service
public class AqyProductServiceImpl implements AqyProductService {

    @Autowired
    private AqyProductMapper aqyProductMapper;

    @Override
    public DataFetcher<AqyProduct> listByProductNo() {
        return dataFetchingEnvironment->{
            AqyCode aqyCode = dataFetchingEnvironment.getSource();
            return aqyProductMapper.ProductByProductNo(aqyCode.getProductNo());
        };
    }
}
