/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2017 All Rights Reserved.
 */
package com.cheng.elastic;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chengchenrui
 * @version Id: MySimpleElasticJob.java, v 0.1 2017.3.15 15:36 chengchenrui Exp $$
 */
@Slf4j
public class MySimpleElasticJob implements SimpleJob {

    public void execute(ShardingContext shardingContext) {
        log.info("SimpleJob 启动开始：{}", shardingContext.getShardingItem());
        switch (shardingContext.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                log.info("进入0");
                break;
            case 1:
                // do something by sharding item 1
                log.info("进入1");
                break;
            case 2:
                // do something by sharding item 2
                log.info("进入2");
                break;
            // case n: ...
        }
    }
}
