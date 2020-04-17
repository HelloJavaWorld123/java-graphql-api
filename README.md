# java-graphql-api
Spring Boot GraphQL API


# Q&A
- graphql.schema.idl.errors.SchemaProblem: errors=[The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1]]
  -- 标量类型错误；标量类型包括：String Int Float Boolean ID

- "Validation error of type FieldUndefined: Field 'codesByOrderNo' in type 'Query' is undefined @ 'codesByOrderNo'"
  - 接口查询的字段与定义的Query类型对应不上