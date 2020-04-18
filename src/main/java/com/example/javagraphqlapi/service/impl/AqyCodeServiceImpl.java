package com.example.javagraphqlapi.service.impl;

import com.example.javagraphqlapi.dao.mysql.AqyCodeMapper;
import com.example.javagraphqlapi.model.mysql.AqyCode;
import com.example.javagraphqlapi.service.AqyCodeService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
@Service
public class AqyCodeServiceImpl implements AqyCodeService {

    @Autowired
    private AqyCodeMapper aqyCodeMapper;

    @Override
    public DataFetcher<List<AqyCode>> listByOrderNo() {
        return dataFetchingEnvironment -> {
            String orderNo = dataFetchingEnvironment.getArgument("orderNo");
            return aqyCodeMapper.listByOrderNo(orderNo);
        };
    }

    @Override
    public DataFetcher<AqyCode> getCodeById() {
        return environment -> {
            Long id = environment.getArgument("id");
            return aqyCodeMapper.findByCodeId(id);
        };
    }
}
