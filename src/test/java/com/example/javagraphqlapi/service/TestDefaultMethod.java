package com.example.javagraphqlapi.service;

import java.util.UUID;

/**
 * 接口中 只有一个方法的情况下 使用函数可以定义一个默认的实现
 */
public interface TestDefaultMethod {
    TestDefaultMethod TEST_DEFAULT_METHOD = (a,b) -> UUID.randomUUID().toString();
    String test(Integer age,Integer type);

}
