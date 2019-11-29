# com.xiangyang.service.sharding-sphere
sharding-sphere 使用以下配置做读写分离

```java
#所有的数据库名字多个逗号分隔
spring.shardingsphere.datasource.names=xiangyang,xiangyangslave,xiangyangslave2
spring.shardingsphere.datasource.xiangyang.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.xiangyang.driver-class-name=com.mysql.jdbc.Driver
spring.shardingsphere.datasource.xiangyang.jdbc-url=jdbc:mysql://121.41.56.97:3306/xiangyang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false
spring.shardingsphere.datasource.xiangyang.username=root
spring.shardingsphere.datasource.xiangyang.password=123456
#从数据库1配置
spring.shardingsphere.datasource.xiangyangslave.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.xiangyangslave.driver-class-name=com.mysql.jdbc.Driver
spring.shardingsphere.datasource.xiangyangslave.jdbc-url=jdbc:mysql://121.41.56.97:3306/xiangyangslave?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false
spring.shardingsphere.datasource.xiangyangslave.username=root
spring.shardingsphere.datasource.xiangyangslave.password=123456
#从数据库2配置
spring.shardingsphere.datasource.xiangyangslave2.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.xiangyangslave2.driver-class-name=com.mysql.jdbc.Driver
spring.shardingsphere.datasource.xiangyangslave2.jdbc-url=jdbc:mysql://121.41.56.97:3306/xiangyangslave2?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false
spring.shardingsphere.datasource.xiangyangslave2.username=root
spring.shardingsphere.datasource.xiangyangslave2.password=123456
#从数据库读取配置 使用轮询算法
spring.shardingsphere.masterslave.load-balance-algorithm-type=round_robin
spring.shardingsphere.masterslave.name=ds_ms
#主数据库
spring.shardingsphere.masterslave.master-data-source-name=xiangyang
#从数据库 多个逗号分隔
spring.shardingsphere.masterslave.slave-data-source-names=xiangyangslave,xiangyangslave2
```

使用以下配置做单库分片处理

```java
#数据库配置省略 取上面的主数据配置就可以
#以下是分片 配置，单个数据库分多个表
spring.shardingsphere.datasource.names=xiangyang
#表的名字
spring.shardingsphere.sharding.tables.user.actual-data-nodes=xiangyang.user$->{0..1}
spring.shardingsphere.sharding.tables.user.table-strategy.inline.sharding-column=id
#单库下分表使用的规则
spring.shardingsphere.sharding.tables.user.table-strategy.inline.algorithm-expression=user$->{id % 2}
#分表使用的列
spring.shardingsphere.sharding.tables.user.key-generator.column=id
#使用雪花算法
spring.shardingsphere.sharding.tables.user.key-generator.type=SNOWFLAKE
```

使用自定义算法实现

```java
#ceshi自定义分片
spring.shardingsphere.datasource.names=xiangyang
spring.shardingsphere.datasource.xiangyang.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.xiangyang.driver-class-name=com.mysql.jdbc.Driver
spring.shardingsphere.datasource.xiangyang.jdbc-url=jdbc:mysql://121.41.56.97:3306/xiangyang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false
spring.shardingsphere.datasource.xiangyang.username=root
spring.shardingsphere.datasource.xiangyang.password=123456
#使用自定义分表策略 实现了PreciseShardingAlgorithm 精确算法分片
spring.shardingsphere.sharding.tables.user.actual-data-nodes=xiangyang.user,xiangyang.user0,xiangyang.user1
spring.shardingsphere.sharding.tables.user.table-strategy.standard.sharding-column=id
spring.shardingsphere.sharding.tables.user.table-strategy.standard.precise-algorithm-class-name=com.xiangyang.service.application.OrderShardingAlgorithm
#开启sharding的日志打印
spring.shardingsphere.props.sql.show=true
```

