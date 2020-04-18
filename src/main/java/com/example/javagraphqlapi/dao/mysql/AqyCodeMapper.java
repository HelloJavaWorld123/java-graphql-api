package com.example.javagraphqlapi.dao.mysql;

import com.example.javagraphqlapi.model.mysql.AqyCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
@Repository
public interface AqyCodeMapper {
    List<AqyCode> listByOrderNo(@Param("orderNo") String orderNo);

    AqyCode findByCodeId(@Param("id") Long id);

    List<AqyCode> findByParams(@Param("orderNo") String orderNo, @Param("code") String code, @Param("codeStatus") Integer codeStatus);

    List<AqyCode> listCodeByPage(@Param("code") String code, @Param("start") Integer start, @Param("offset") Integer offset);
}
