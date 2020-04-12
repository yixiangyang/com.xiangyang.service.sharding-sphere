package com.xiangyang.service.application;

import com.xiangyang.service.application.*;
import com.yixiangyang.mapper.UserMapper;
import com.yixiangyang.model.Employee;
import com.yixiangyang.model.User;
import com.yixiangyang.service.UserService;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.http.client.utils.DateUtils;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

@SpringBootTest(classes = Application.class)

@RunWith(SpringRunner.class)
public class ApplicationTests {
	@Resource
	private UserService userService;
	@Resource
	private UserMapper userMapper;

	@Test
	public void mm() {
		for(int i=50003;i<50020;i++){
			System.out.println(i);
			Date createTime = new Date(System.currentTimeMillis());
			userService.addUser(new User(i,"test"+i,createTime));
		}
	}

	@Test
	public void addEmployee (){
		for(int i=5000;i<5100;i++){
			Date createTime = new Date(System.currentTimeMillis());
			userService.addEmployee(new Employee(i,"test"+i,createTime));
		}
	}
	@Test
	public void addEmployee1 (){
		for(int i=50020;i<50025;i++){
			System.out.println(i);
			Date createTime = new Date(System.currentTimeMillis());
			userService.addUser(new User(i,"test"+i,createTime));
		}
	}
	@Test
	public  void test() throws SQLException {
//		userService.addUser();
//
//		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//		shardingRuleConfig.set
//		shardingRuleConfig.setDefaultTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("userId",
//				MyRangeShardingAlgorithm));
//		TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration("user");
//
//
//		StandardShardingStrategyConfiguration strategyConfiguration = new StandardShardingStrategyConfiguration("id",
//				new MyShardingStrategyConfiguration());
//		tableRuleConfiguration.setDatabaseShardingStrategyConfig(strategyConfiguration);
//		tableRuleConfiguration.setDatabaseShardingStrategyConfig(s);
		HikariDataSource dataSource1 = new HikariDataSource();
		dataSource1.setUsername("root");
		dataSource1.setPassword("xiangyang123");
		dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource1.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");

		HikariDataSource dataSource2 = new HikariDataSource();
		dataSource2.setUsername("root");
		dataSource2.setPassword("xiangyang123");
		dataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource2.setJdbcUrl("jdbc:mysql://121.41.56.97:3317/xiangyang2?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");

		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",
				new MyShardingStrategyConfiguration()));
		Map<String,DataSource> dataSourceMap = new HashMap<>();
		dataSourceMap.put("xiangyang1",dataSource1);
		dataSourceMap.put("xiangyang2",dataSource2);

		shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("id",new OrderShardingAlgorithm()));
		// 获取数据源对象
		Properties properties = new Properties();
		properties.setProperty("sql.show", "true");

		DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
		System.out.println(dataSource.getConnection());

		Date createTime = new Date(System.currentTimeMillis());
		userMapper.inserUser(new User(1,"测试1",createTime));

	}

	@Test
	public void aaa(){
		Date createTime = new Date(System.currentTimeMillis());
		System.out.println(DateUtils.formatDate(createTime,"yyyy-mm-dd HH:mm:ss"));
		userMapper.inserUser(new User(20,"测试1",createTime));
	}

	public static void main(String[] args) {
		System.out.println(5000%2);
	}

//	public static void main(String[] args) throws SQLException {
//		DruidDataSource dataSource1 = new DruidDataSource();
//		dataSource1.setUsername("root");
//		dataSource1.setPassword("xiangyang123");
//		dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource1.setUrl("jdbc:mysql://121.41.56.97:3317/xiangyang1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
//		System.out.println("aaaaaaaaaaaaaaaaaaa:"+dataSource1.getConnection());
//	}
}
