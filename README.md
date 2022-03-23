## 简介
HSBC

## 相关框架
* [Spring boot](http://projects.spring.io/spring-boot/)
使用Spring boot可以快速搭建一个java web应用，提高开发效率。


## 启动

直接Run`HsbcApplication`启动后访问：http://localhost:8080/swagger-ui.html




## HSBC接口文档


**简介**：<p>HSBC接口文档</p>


# 角色管理

## 添加角色


**接口描述**:


**接口地址**:`/role`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"code": "",
	"id": 0,
	"name": "",
	"remark": "",
	"seq": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|role| role  | body | true |Role  | Role   |

**schema属性说明**



**Role**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|code|   | body | true |string  |    |
|id|   | body | false |integer(int64)  |    |
|name|   | body | true |string  |    |
|remark|   | body | false |string  |    |
|seq|   | body | false |integer(int32)  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 删除角色


**接口描述**:


**接口地址**:`/role/delete`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"code": "",
	"id": 0,
	"name": "",
	"remark": "",
	"seq": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|role| role  | body | true |Role  | Role   |

**schema属性说明**



**Role**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|code|   | body | true |string  |    |
|id|   | body | false |integer(int64)  |    |
|name|   | body | false |string  |    |
|remark|   | body | false |string  |    |
|seq|   | body | false |integer(int32)  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 用户管理

## 添加用户


**接口描述**:


**接口地址**:`/user`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"createTime": "",
	"id": 0,
	"modifyTime": "",
	"name": "",
	"password": "",
	"roleIds": [],
	"roleNames": [],
	"username": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|user| user  | body | true |User  | User   |

**schema属性说明**



**User**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|createTime|   | body | false |string(date-time)  |    |
|id|   | body | false |integer(int64)  |    |
|modifyTime|   | body | false |string(date-time)  |    |
|name|   | body | true |string  |    |
|password|   | body | true |string  |    |
|roleIds|   | body | false |array  |    |
|roleNames|   | body | false |array  |    |
|username|   | body | true |string  |    |

**响应示例**:

```json
{
	"createTime": "",
	"id": 0,
	"modifyTime": "",
	"name": "",
	"password": "",
	"roleIds": [],
	"roleNames": [],
	"username": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|createTime|   |string(date-time)  | string(date-time)   |
|id|   |integer(int64)  | integer(int64)   |
|modifyTime|   |string(date-time)  | string(date-time)   |
|name|   |string  |    |
|password|   |string  |    |
|roleIds|   |array  |    |
|roleNames|   |array  |    |
|username|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |User|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询用户角色


**接口描述**:


**接口地址**:`/user/allRoles`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|token| token  | query | true |string  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 校验是否存在角色


**接口描述**:


**接口地址**:`/user/checkRole`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"roleCode": 0,
	"token": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|checkRoleVO| checkRoleVO  | body | true |CheckRoleVO  | CheckRoleVO   |

**schema属性说明**



**CheckRoleVO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|roleCode|   | body | true |integer(int64)  |    |
|token|   | body | true |string  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 删除用户


**接口描述**:


**接口地址**:`/user/delete`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"createTime": "",
	"id": 0,
	"modifyTime": "",
	"name": "",
	"password": "",
	"roleIds": [],
	"roleNames": [],
	"username": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|user| user  | body | true |User  | User   |

**schema属性说明**



**User**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|createTime|   | body | false |string(date-time)  |    |
|id|   | body | true |integer(int64)  |    |
|modifyTime|   | body | false |string(date-time)  |    |
|name|   | body | false |string  |    |
|password|   | body | false |string  |    |
|roleIds|   | body | false |array  |    |
|roleNames|   | body | false |array  |    |
|username|   | body | true |string  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 用户授权


**接口描述**:


**接口地址**:`/user/grant`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"roleCode": "",
	"userId": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|userRoleVO| userRoleVO  | body | true |UserRoleVO  | UserRoleVO   |

**schema属性说明**



**UserRoleVO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|roleCode|   | body | true |string  |    |
|userId|   | body | true |integer(int64)  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 注销


**接口描述**:


**接口地址**:`/user/invalidate`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|token| token  | query | true |string  |    |

**响应示例**:

```json
null
```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RestResp|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 用户登录


**接口描述**:


**接口地址**:`/user/login`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"createTime": "",
	"id": 0,
	"modifyTime": "",
	"name": "",
	"password": "",
	"roleIds": [],
	"roleNames": [],
	"username": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|u| u  | body | true |User  | User   |

**schema属性说明**



**User**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|createTime|   | body | false |string(date-time)  |    |
|id|   | body | false |integer(int64)  |    |
|modifyTime|   | body | false |string(date-time)  |    |
|name|   | body | false |string  |    |
|password|   | body | true |string  |    |
|roleIds|   | body | false |array  |    |
|roleNames|   | body | false |array  |    |
|username|   | body | true |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||