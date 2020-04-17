package com.example.javagraphqlapi.dao.mysql;

import com.example.javagraphqlapi.model.mysql.AqyProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
@Repository
public interface AqyProductMapper {
    AqyProduct ProductByProductNo(@Param("productNo") String productNo);
}
