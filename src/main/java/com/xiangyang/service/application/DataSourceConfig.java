package com.xiangyang.service.application;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {
    @Bean("shardingDataSource")
    public DataSource configDataSource() {
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setUsername("root");
        dataSource1.setPassword("xiangyang123");
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
System.out.println("gggggggggggggggggggggg");
        HikariDataSource dataSource2 = new HikariDataSource();
        dataSource2.setUsername("root");
        dataSource2.setPassword("xiangyang123");
        dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource2.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang2?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",
                new MyShardingStrategyConfiguration()));
        shardingRuleConfig.setDefaultDataSourceName("xiangyang1");
        Map<String,DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("xiangyang1",dataSource1);
        dataSourceMap.put("xiangyang2",dataSource2);

        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",new OrderShardingAlgorithm()));
        // 获取数据源对象
        Properties properties = new Properties();
        properties.setProperty("sql.show", "true");
        DataSource dataSource= null;
        try {
           dataSource  = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
        }catch (Exception e){
            System.out.println(e);
        }

      System.out.println(dataSource);
        return  dataSource;
    }
}
