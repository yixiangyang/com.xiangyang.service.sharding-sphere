package com.xiangyang.service.application;


import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.core.strategy.route.ShardingStrategy;

import java.util.Collection;

public class MyShardingStrategyConfiguration implements PreciseShardingAlgorithm {


    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        System.out.println("这个是"+collection);
        System.out.println("这个是值"+preciseShardingValue);
        if(Integer.valueOf(String.valueOf(preciseShardingValue.getValue()))>50000){
            return "xiangyang2";
        }else {
            return "xiangyang1";
        }
    }
}
