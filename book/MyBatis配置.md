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
