# springDemo
springboot + mybatis

### 17/09/18 更新
新增自定义权限验证注解
将@Authenticate注解加在controller的方法上
将会验证请求时参数是否带有token
例如直接访问/callAll会提示无token
/callAll?token=123456将会得到正确结果

后续将会加入
- /login 生成token存进redis
- token验证连接redis
- redis存储用户的token与id映射
### 18/02/28 更新
增加了token相关的操作，因为成本问题还是用数据库代替redis
反正也没人用不用担心性能问题，数据库和redis的实现思路是一样的


TODO:
- 全局异常处理
- 信息加密处理
- 用户登录系统
