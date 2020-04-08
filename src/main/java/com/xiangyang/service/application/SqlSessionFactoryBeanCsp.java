package com.xiangyang.service.application;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration

@MapperScan(basePackages= {"com.yixiangyang.mapper"},sqlSessionFactoryRef="sqlSessionFactoryCsp")
public class SqlSessionFactoryBeanCsp {

	@Bean(name = "dataSourceCsp")
	@Primary
	public DataSource createDataSource() {
		DruidDataSource dataSource1 = new DruidDataSource();
		dataSource1.setUsername("root");
		dataSource1.setPassword("xiangyang123");
		dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource1.setUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
//        dataSource1.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
		System.out.println("gggggggggggggggggggggg");
		dataSource1.setUseUnfairLock(true);
		dataSource1.setInitialSize(2);
		dataSource1.setMaxActive(2);
		dataSource1.setMinIdle(2);
		dataSource1.setMaxWait(15000L);
		dataSource1.setTestOnBorrow(false);
		dataSource1.setTestOnReturn(false);
		dataSource1.setTestWhileIdle(true);
		dataSource1.setValidationQuery("SELECT 1");
		dataSource1.setMinEvictableIdleTimeMillis(300000L);
		dataSource1.setTimeBetweenEvictionRunsMillis(60000L);
		String url="jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
		String  username = "root";
		String  password = "xiangyang123";
		DataSource ds = new ProxyDataSource(url, username, password, null);
		return  ds;
	}
	
	@Bean("sqlSessionFactoryCsp")
	@Primary
	public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("dataSourceCsp") DataSource dataSource){
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		return sessionFactoryBean;
	}
	
	@Bean(name = "platformTransactionManagerCsp")
	@Primary
	public PlatformTransactionManager createPlatformTransactionManager(@Qualifier("dataSourceCsp") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
