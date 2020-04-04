package com.xiangyang.service.application;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.context.annotation.Configuration;

/**
 * 实现的是精确分片算法
 * @author 15138
 *
 */
@Configuration
public class OrderShardingAlgorithm implements PreciseShardingAlgorithm<Integer>{

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
//		int size = availableTargetNames.size();
//        for (String each : availableTargetNames) {
//            if (each.endsWith(shardingValue.getValue() % size + "")) {
//                return each;
//            }
//        }
//        throw new UnsupportedOperationException();
//        
				System.out.println(availableTargetNames);
		Integer a = 0;
		System.out.println(a);
		System.out.println(shardingValue.getValue());
		for (int i=0 ;i<50000;i=i+5000){
			System.out.println("这个是"+i+"这个是："+shardingValue.getValue());
			if(shardingValue.getValue()>=i && shardingValue.getValue()<i+5000){
				System.out.println("user"+String.valueOf(a));
				return "user"+String.valueOf(a);
			}
			a ++;
		}
		if(shardingValue.getValue()>50000){
			return "user0";
		}

//		Integer a =(Integer.valueOf(String.valueOf(shardingValue.getValue())) %2);
//		String targetTable = "user" + String.valueOf(a);
//		System.out.println(targetTable);
//	        if (availableTargetNames.contains(targetTable)){
//	            return targetTable;
//	        }
	        throw new UnsupportedOperationException("无法判定的值: " + String.valueOf(shardingValue.getValue()));
	}

//	@Override
//    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<Integer> shardingValue) {
//        int size = availableTargetNames.size();
//        for (String each : availableTargetNames) {
//           return "user0";
//        }
//        throw new UnsupportedOperationException();
//    }
}
