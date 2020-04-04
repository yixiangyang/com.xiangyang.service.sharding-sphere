package com.xiangyang.service.application;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
@Configuration
public class MyRangeShardingAlgorithm implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        System.out.println("这个是"+collection);
        System.out.println("这个是值"+preciseShardingValue);
        if(Integer.valueOf(String.valueOf(preciseShardingValue.getValue()))>50000){
            return "xiangyang2";
        }
        System.out.println("这个是"+collection);
        System.out.println("这个是值"+preciseShardingValue);
        return null;
    }
}
