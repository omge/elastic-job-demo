/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.elastic;

import java.util.List;

import com.cheng.elastic.pojo.Foo;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chengchenrui
 * @version Id: MyThroughputDataflowElasticJob.java, v 0.1 2017.3.16 13:52 chengchenrui Exp $$
 */
@Slf4j
public class MyThroughputDataflowElasticJob implements DataflowJob<Foo> {

    public List<Foo> fetchData(ShardingContext shardingContext) {
        log.info("fetchData-->ShardingContext：{}", shardingContext.toString());
        switch (shardingContext.getShardingItem()) {
            case 0:
                List<Foo> data = null;// get data from database by sharding item 0
                return data;
            case 1:
                List<Foo> data2 = null;// get data from database by sharding item 1
                return data2;
            case 2:
                List<Foo> data3 = null;// get data from database by sharding item 2
                return data3;
            // case n: ...
        }
        return null;
    }

    public void processData(ShardingContext shardingContext, List<Foo> list) {
        log.info("processData-->ShardingContext：{}", shardingContext.toString());
    }
}
