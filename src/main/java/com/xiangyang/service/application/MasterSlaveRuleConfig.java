//package com.xiangyang.service.application;
//
//import org.apache.shardingsphere.api.config.RuleConfiguration;
//import org.apache.shardingsphere.api.config.masterslave.LoadBalanceStrategyConfiguration;
//import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
//
//import com.google.common.base.Preconditions;
//import com.google.common.base.Strings;
//
//import java.util.Collection;
//
//public class MasterSlaveRuleConfig implements RuleConfiguration{
////	 private  String name;
////	    
////	    private  String masterDataSourceName;
////	    
////	    private  Collection<String> slaveDataSourceNames;
////	    
////	    private  LoadBalanceStrategyConfiguration loadBalanceStrategyConfiguration;
////	    
////	    public MasterSlaveRuleConfiguration(final String name, final String masterDataSourceName, final Collection<String> slaveDataSourceNames) {
////	        this(name, masterDataSourceName, slaveDataSourceNames, null);
////	    }
////	    
////	    public MasterSlaveRuleConfiguration(final String name, 
////	                                        final String masterDataSourceName, final Collection<String> slaveDataSourceNames, final LoadBalanceStrategyConfiguration loadBalanceStrategyConfiguration) {
////	        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "Name is required.");
////	        Preconditions.checkArgument(!Strings.isNullOrEmpty(masterDataSourceName), "MasterDataSourceName is required.");
////	        Preconditions.checkArgument(null != slaveDataSourceNames && !slaveDataSourceNames.isEmpty(), "SlaveDataSourceNames is required.");
////	        this.name = name;
////	        this.masterDataSourceName = masterDataSourceName;
////	        this.slaveDataSourceNames = slaveDataSourceNames;
////	        this.loadBalanceStrategyConfiguration = loadBalanceStrategyConfiguration;
////	    } 
//}
