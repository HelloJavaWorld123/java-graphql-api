package com.example.javagraphqlapi.service.impl;

import com.example.javagraphqlapi.dao.mysql.AqyCodeMapper;
import com.example.javagraphqlapi.model.mysql.AqyCode;
import com.example.javagraphqlapi.service.AqyCodeService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
           Long id = Long.valueOf(environment.getArgument("id"));
           return aqyCodeMapper.findByCodeId(id);
       };
    }

    @Override
    public DataFetcher<List<AqyCode>> findByParams() {
        return dataFetchingEnvironment->{
            String orderNo = dataFetchingEnvironment.getArgument("orderNo");
            String code = dataFetchingEnvironment.getArgument("code");
            String strCodeStatus = dataFetchingEnvironment.getArgument("codeStatus");
            Integer codeStatus = null;
            if (StringUtils.isNoneEmpty(strCodeStatus)){
                codeStatus = Integer.parseInt(strCodeStatus);
            }
            return aqyCodeMapper.findByParams(orderNo,code,codeStatus);
        };
    }

    @Override
    public DataFetcher<List<AqyCode>> ListCodePage() {
        return dataFetchingEnvironment->{
            String code = dataFetchingEnvironment.getArgument("orderNo");
            Integer pageSize = dataFetchingEnvironment.getArgument("pageSize");
            Integer pageNum = dataFetchingEnvironment.getArgument("pageNum");
            pageNum = pageNum * pageSize;
           return aqyCodeMapper.listCodeByPage(code,pageNum,pageSize);
        };
    }
}
