package com.xiangyang.service.application;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.core.strategy.route.ShardingStrategy;
import org.apache.shardingsphere.core.strategy.route.value.RouteValue;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.HashSet;
@Configuration
public class MyComplexKeysShardingAlgorithm implements RangeShardingAlgorithm {


    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        collection.getClass();
        System.out.println(rangeShardingValue.getLogicTableName());
        System.out.println("aaa"+rangeShardingValue);
        return null;
    }
}
