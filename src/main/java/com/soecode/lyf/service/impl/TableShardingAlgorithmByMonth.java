package com.soecode.lyf.service.impl;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * 支付平台中大表按月分表，新表名为：原表名+"_"+yyyyMM，例如pay_log_201904
 * @author lzc
 */
public final class TableShardingAlgorithmByMonth implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<String> shardingValue) {
    	try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
	        System.out.println("shardingValue.getValue()"+String.valueOf(shardingValue.getValue()));
	        System.out.println(">>>>>>"+shardingValue.getLogicTableName()+"_"+dateFormat.format(shardingValue.getValue()));
	        return shardingValue.getLogicTableName()+"_"+dateFormat.format(shardingValue.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
    }
    
}
