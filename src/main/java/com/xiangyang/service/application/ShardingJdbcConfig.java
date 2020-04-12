package com.xiangyang.service.application;

//import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//@Configuration
public class ShardingJdbcConfig {
    // 定义数据源
//    Map<String, DataSource> createDataSourceMap() {
//        DruidDataSource dataSource1 = new DruidDataSource();
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("xiangyang123");
//        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource1.setUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
//        Map<String, DataSource> result = new HashMap<>();
//        result.put("xiangyang1", dataSource1);
//        return result;
//    }
//    // 定义主键生成策略
//    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
//        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE","id");
//        return result;
//    }
//    // 定义t_order表的分片策略
//    TableRuleConfiguration getOrderTableRuleConfiguration() {
//        TableRuleConfiguration result = new TableRuleConfiguration("user","xiangyang1.user0,xiangyang1.user1");
//        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user${id % 2}"));
//        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
//        return result;
//    }
//    // 定义sharding‐Jdbc数据源
//    @Bean
//    DataSource getShardingDataSource() throws SQLException {
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
//        //spring.shardingsphere.props.sql.show = true
//        Properties properties = new Properties();
//        properties.put("sql.show","true");
//        System.out.println(createDataSourceMap());
//        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(),
//                shardingRuleConfig,properties);
//    }
}
