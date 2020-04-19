package com.example.javagraphqlapi.service.impl;

import com.example.javagraphqlapi.dao.mysql.AqyProductMapper;
import com.example.javagraphqlapi.model.mysql.AqyCode;
import com.example.javagraphqlapi.model.mysql.AqyProduct;
import com.example.javagraphqlapi.service.AqyProductService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public DataFetcher<AqyProduct> productInfo() {
        return dataFetchingEnvironment->{
            boolean present = Optional.ofNullable(dataFetchingEnvironment.getArgument("id")).isPresent();
            if(present){
                long id = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
                return aqyProductMapper.productById(id);
            }
            return new AqyProduct();
        };
    }
}
