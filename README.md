# java-graphql-api
Spring Boot GraphQL API


# Q&A
- graphql.schema.idl.errors.SchemaProblem: errors=[The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1]]
  -- 标量类型错误；标量类型包括：String Int Float Boolean ID

- "Validation error of type FieldUndefined: Field 'codesByOrderNo' in type 'Query' is undefined @ 'codesByOrderNo'"
  - 接口查询的字段与定义的Schema的Query类型中字段对应不上
- 查询成功并且能够返回,但返回的字段的值都会null
  - 数据结构对应不上
    - 比如 逻辑中实际返回的是一个集合类型,但是Schema中定义的确不是一个集合类型,导致返回的都为null