# Settings 配置

## 自动映射 驼峰命名 级联规则 是否自动缓存 执行器类型等
## mybatis 配置大多默认就可以 
* 关于缓存的 cacheEnable
* 关于级联的 lazyLoadingEnable aggressiveLazyLoading
* 关于自动映射的 autoMappingBehavior mapUnderscoreTocameCase
* 关于执行器的 defaultExecutorType

# type Aliases 别名
## 由于Java 的对象包很长 不方便 所以搞了个别名
### 系统自定义别名 就是对Java 中比较常用的数据类型 和 其包装类起个简单的名字
### 代码在 org.apache.ibatis.type.TypeAliasRegistry
* 使用TypeAliasRegister 的 registerAlias 方法注册别名
* 通过Configuration 获取 TypeAliasRegister 见code-line 180
* this.typeAliasRegistry.registerAlias

# typeHander 类型转换器
### 就是将数据库中的数据映射成Java 数据类型
### jdbcType javaType
* 和别名一样 他也分为系统定义类型和自定义类型

# 级联 
1. one-to-one association
2. one-to-many collection
没有many-to-many 用两个one-to-many处理 

# 延迟加载 
1. lazyLoadingEnabled 是否开启全局延迟加载
2. aggressiveLazyLoading 调用方法后自动将对象完整加载
3. 在 collection association 上使用fetchType

# 缓存
### 一级存在在sqlSession上 二级在sqlSessionFactory
 一级自动开启 
 二级需要POJO实现 serializable接口 同时 mapper.xml 中
 配置 <cache /> 
 > 缓存配置项 blocking readOnly eviction
 > flushInterval type size
 
 + 自定义缓存可以实现org.apache.ibatis.cache.Cache接口
 + 在chache标签的type 上配置自己的实现类
 ```
 + <select flushCache="false" useCache="true">
 + <insert flushCache="true" >
 ```
 
# 存储过程 
```
-- 用javabean 作为参数
	<select id="countRole" parameterType="com.learn.ssm.chapter3.param.PdCountRoleParams"
		statementType="CALLABLE">
		{call count_role(
		#{roleName, mode=IN, jdbcType=VARCHAR},
		#{total, mode=OUT, jdbcType=INTEGER},
		#{execDate, mode=OUT, jdbcType=DATE}
		)}
	</select>
	
-- 返回游标用ResultSet处理 
<select id="findRole" parameterType="com.learn.ssm.chapter3.param.PdFindRoleParams"
    statementType="CALLABLE">
    {call find_role(
    #{roleName, mode=IN, jdbcType=VARCHAR},
    #{start, mode=IN,
    jdbcType=INTEGER},
    #{end, mode=IN, jdbcType=INTEGER},
    #{total, mode=OUT,
    jdbcType=INTEGER},
    #{roleList,mode=OUT,jdbcType=CURSOR,
    javaType=ResultSet,resultMap=roleMap2}
    )}
</select>

```

# 动态SQL


 
 