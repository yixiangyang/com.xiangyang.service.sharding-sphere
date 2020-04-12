//package com.xiangyang.service.application;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
//import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
//import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
//import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
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
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
////@Configuration
//@MapperScan(basePackages= {"com.yixiangyang.mapper"},sqlSessionFactoryRef="sqlSessionFactoryCsp")
//public class DataSourceConfig   {
//
//
//    @Bean("shardingDataSource")
//    public DataSource configDataSource() {
//        DruidDataSource dataSource1 = new DruidDataSource();
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("xiangyang123");
//        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource1.setUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
////        dataSource1.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
//System.out.println("ggggggggggggggggggggggddddddddddd");
//        HikariDataSource dataSource2 = new HikariDataSource();
//        dataSource2.setUsername("root");
//        dataSource2.setPassword("xiangyang123");
//        dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource2.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang2?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
//
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",
//                new MyShardingStrategyConfiguration()));
//        shardingRuleConfig.setDefaultDataSourceName("xiangyang1");
//        Map<String,DataSource> dataSourceMap = new HashMap<>();
//        dataSourceMap.put("xiangyang1",dataSource1);
//        dataSourceMap.put("xiangyang2",dataSource2);
//
//        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",new OrderShardingAlgorithm()));
//        // 获取数据源对象
//        Properties properties = new Properties();
//        properties.setProperty("sql.show", "true");
//        DataSource dataSource= null;
//        try {
//           dataSource  = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
//        }catch (Exception e){
//            System.out.println("这个是错误"+e);
//        }
//
//      System.out.println(dataSource);
//        return  dataSource;
//    }
//    @Bean("sqlSessionFactoryCsp")
//    @Primary
//    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("shardingDataSource") DataSource dataSource){
//        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        return sessionFactoryBean;
//    }
//
//    @Bean(name = "platformTransactionManagerCsp")
//    @Primary
//    public PlatformTransactionManager createPlatformTransactionManager(@Qualifier("shardingDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
