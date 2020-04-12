//package com.xiangyang.service.application;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
//import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;
//import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
//import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
////@Configuration
////@MapperScan(basePackages= {"com.yixiangyang.mapper"},sqlSessionFactoryRef="sqlSessionFactoryCsp")
//public class ShardingDataSourceConfig {
//
////    @Bean
//    Map<String, DataSource> createDataSourceMap(){
//        DruidDataSource dataSource1 = new DruidDataSource();
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("xiangyang123");
//        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource1.setUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
//        Map<String,DataSource> map = new HashMap<>();
//        map.put("xiangyang1",dataSource1);
//        return map;
//    }
//
//    private static KeyGeneratorConfiguration getKeyGentr(){
//        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE","id");
//        return result;
//    }
//
//    TableRuleConfiguration getUserTableRuleConfig(){
//        TableRuleConfiguration result = new TableRuleConfiguration("user","xiangyang1.user0,xiangyang1.user1");
//        result.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",new OrderShardingAlgorithm()));
//        return result;
//    }
//
//    @Bean("shardingDataSource")
//    DataSource getShardingDataSource() throws SQLException {
//        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
//        shardingRuleConfiguration.getTableRuleConfigs().add(getUserTableRuleConfig());
//        Properties properties = new Properties();
//        properties.setProperty("sql.show", "true");
//        System.out.println("这个是");
//        shardingRuleConfiguration.setDefaultDataSourceName("xiangyang1");
//
//        return  ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfiguration, properties);
//
//    }
//
////    @Bean("sqlSessionFactoryCsp")
////    @Primary
////    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("shardingDataSource") DataSource dataSource){
////        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
////        System.out.println("这个是11111111"+dataSource.toString());
////        sessionFactoryBean.setDataSource(dataSource);
////        return sessionFactoryBean;
////    }
////
////    @Bean(name = "platformTransactionManagerCsp")
////    @Primary
////    public PlatformTransactionManager createPlatformTransactionManager(@Qualifier("shardingDataSource") DataSource dataSource) {
////        System.out.println("这个是222222222222"+dataSource.toString());
////        return new DataSourceTransactionManager(dataSource);
////    }
//}
