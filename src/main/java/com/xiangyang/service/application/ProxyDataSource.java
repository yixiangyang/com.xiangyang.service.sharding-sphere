//package com.xiangyang.service.application;
//
//import com.alibaba.druid.filter.Filter;
//import com.alibaba.druid.pool.DruidDataSource;
//
//import java.util.List;
//
///**
// * @author chenjun
// *
// * 代理数据源
// */
//public final class ProxyDataSource extends DruidDataSource{
//	private static final long serialVersionUID = 7972580700229726401L;
//	/** 初始化连接数常量 */
//	private static final int INIT_SIZE = 30;
//	/** 最大连接数常量 */
//	private static final int MAX_ACTIVE = 50;
//	/** 最小空闲连接数 */
//	private static final int MIN_IDLE = 30;
//	/** 最大等待时间常量 */
//	private static final int MAX_WAIT = 15000;
//	/** 清除超时线程间隔时间常量 */
//	private static final int EVIC_BETWEEN_TIME = 60*1000;
//	/** 最大空闲时间常量 */
//	private static final int MAX_IDLE_TIME = 300000;
//	/** 非公平锁 */
//	private static final boolean UNFAIR_LOCK = true;
//	/** 最大清除长时间不 使用且没有关闭的连接*/
////	private static final int REMOVE_ABANDONED_TIMEOUT = 30*60;
//	private static final String VALID_SQL = "SELECT 1";
//	private static final boolean TEST_ON_BORROW = false;
//	private static final boolean TEST_ON_RETURN = false;
//	private static final boolean TEST_ON_WHILE = true;
//	/** 数据库驱动 */
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	/** 数据源名 */
//	private String name = String.valueOf("datasource_"+System.currentTimeMillis());
//
//	public ProxyDataSource() {}
//
//	public ProxyDataSource(String url, String username, String password, List<Filter> monitorFilterList) {
//		init(url, username, password, monitorFilterList);
//	}
//
//	private void init(String url, String username, String password, List<Filter> monitorFilterList)  {
//		this.setUrl(url);
//		this.setUsername(username);
//		this.setPassword(password);
//		this.setName(name);
//		this.setDriverClassName(DRIVER);
//		this.setUseUnfairLock(UNFAIR_LOCK);
//		this.setInitialSize(2);
//		this.setMaxActive(2);
//		this.setMinIdle(2);
//		this.setMaxWait(MAX_WAIT);
//		this.setTestOnBorrow(TEST_ON_BORROW);
//		this.setTestOnReturn(TEST_ON_RETURN);
//		this.setTestWhileIdle(TEST_ON_WHILE);
//		this.setValidationQuery(VALID_SQL);
//		this.setMinEvictableIdleTimeMillis(MAX_IDLE_TIME);
//		this.setTimeBetweenEvictionRunsMillis(EVIC_BETWEEN_TIME);
//		if (monitorFilterList != null) {
//			this.setProxyFilters(monitorFilterList);
//		}
//	}
//}
