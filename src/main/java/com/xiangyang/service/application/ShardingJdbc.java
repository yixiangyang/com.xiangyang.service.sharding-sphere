package com.xiangyang.service.application;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@MapperScan(basePackages= {"com.yixiangyang.mapper"},sqlSessionFactoryRef="sqlSessionFactoryCsp")
public class ShardingJdbc {
    public static void main(String[] args) {
        System.out.println(50001 %2 );
    }
    @Bean("shardingDataSource")
    DataSource getShardingDataSource() throws SQLException {

        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // 配置第一个数据源
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setUsername("root");
        dataSource1.setPassword("xiangyang123");
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
        dataSourceMap.put("xiangyang1", dataSource1);

        // 配置第二个数据源
        HikariDataSource dataSource2 = new HikariDataSource();
        dataSource2.setUsername("root");
        dataSource2.setPassword("xiangyang123");
        dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource2.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang2?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
        dataSourceMap.put("xiangyang2", dataSource2);

        HikariDataSource dataSource0= new HikariDataSource();
        dataSource0.setUsername("root");
        dataSource0.setPassword("xiangyang123");
        dataSource0.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource0.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang0?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
        dataSourceMap.put("xiangyang0", dataSource0);
    System.out.println("aaaaaaaaa"+dataSourceMap.toString());
        // 配置Order表规则
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("user","xiangyang${0..2}.user${0..2}");

        // 配置分库 + 分表策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "xiangyang${id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user${id % 2}"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        // 省略配置order_item表规则...
        // ...

        // 获取数据源对象
        Properties properties = new Properties();
        properties.setProperty("sql.show", "true");
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
        return dataSource;
    }

    @Bean("sqlSessionFactoryCsp")
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("shardingDataSource") DataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        System.out.println("这个是11111111"+dataSource.toString());
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    @Bean(name = "platformTransactionManagerCsp")
    public PlatformTransactionManager createPlatformTransactionManager(@Qualifier("shardingDataSource") DataSource dataSource) {
        System.out.println("这个是222222222222"+dataSource.toString());
        return new DataSourceTransactionManager(dataSource);
    }
}
