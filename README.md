# java-graphql-api
Spring Boot GraphQL API

#### 扩展
- ExecutionIdProvider 为每一个请求 产生一个唯一的id 默认的是 UUID；产生的规则可以根据请求以及请求参数扩展生成

- application/json 请求格式
```graphql endpoint doc
# No.1
{
	"query":"query{codeById(id:1){id code orderNo productName productNo}}"
}
```

- application/graphql 请求格式
```graphql endpoint doc
query{
    codeById(id: 1){
        id
        code
        codeStatus
        orderNo
    }
}
```

- 返回参数的形式:
```graphql endpoint doc
# 跟scheme 配置中必要的参数缺失返回的异常信息
{
    "errors": [
        {
            "message": "Validation error of type MissingFieldArgument: Missing field argument id @ 'codeById'",
            "locations": [
                {
                    "line": 2,
                    "column": 5
                }
            ],
            "extensions": {
                "classification": "ValidationError"
            }
        }
    ]
}

#正确数据的返回格式
{
    "data": {
        "codeById": {
            "id": "1",
            "code": "123456",
            "codeStatus": "2",
            "orderNo": "1911075874100961"
        }
    }
}
```
# Q&A
- graphql.schema.idl.errors.SchemaProblem: errors=[The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1], The field type 'int' is not present when resolving type 'Product' [@17:1]]
  -- 标量类型错误；标量类型包括：String Int Float Boolean ID

- "Validation error of type FieldUndefined: Field 'codesByOrderNo' in type 'Query' is undefined @ 'codesByOrderNo'"
  - 接口查询的字段与定义的Schema的Query类型中字段对应不上
- 查询成功并且能够返回,但返回的字段的值都会null
  - 数据结构对应不上
    - 比如 逻辑中实际返回的是一个集合类型,但是Schema中定义的确不是一个集合类型,导致返回的都为null
- Exception while fetching data (/codeById) : java.lang.String cannot be cast to java.lang.Long
  - 请求中参数的数据类型与Schema中查询参数定义的数据类型对应不上
- 在PostMan中使用变量时的错误:
```graphql endpoint doc
{
    "errors": [
        {
            "message": "Validation error of type VariableTypeMismatch: Variable type 'ID' doesn't match expected type 'ID!' @ 'codeById'",
            "locations": [
                {
                    "line": 2,
                    "column": 18
                }
            ],
            "extensions": {
                "classification": "ValidationError"
            }
        }
    ]
}
```
请求数据的格式 与 schema 定义的对应不上
```graphql endpoint doc
请求数据的格式是：(schema定义的id是必填的,但 下面定义不是必填的 所以报错)
query PostCodeById($id:ID) {
    codeById(id: $id){
        id
        code
        codeStatus
        orderNo
    }
}

变量是:(变量必须是json)
{
	"id":1
}

#正确的格式是:
query PostCodeById($id:ID!) {
    codeById(id: $id){
        id
        code
        codeStatus
        orderNo
    }
}
``` 

- nested exception is graphql.AssertException: you must provide a data fetcher
  - dataFetcher Chin中有没有初始化的方法,必须初始化但在初始化中可以返回空
- 查询的方法不存在异常
```graphql endpoint doc
{
    "errors": [
        {
            "message": "Validation error of type FieldUndefined: Field 'codesByOrderNo' in type 'Query' is undefined @ 'codesByOrderNo'",
            "locations": [
                {
                    "line": 2,
                    "column": 5
                }
            ],
            "extensions": {
                "classification": "ValidationError"
            }
        }
    ]
}
```