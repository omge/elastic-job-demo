package com.cheng.elastic;

import java.util.ArrayList;
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
        Foo foo = new Foo();
        switch (shardingContext.getShardingItem()) {
            case 0:
                List<Foo> data = new ArrayList<Foo>();// get data from database by sharding item 0
                foo.setId("1");
                data.add(foo);
                return data;
            case 1:
                List<Foo> data2 = new ArrayList<Foo>();// get data from database by sharding item 1
                foo.setId("2");
                data2.add(foo);
                return data2;
            case 2:
                List<Foo> data3 = new ArrayList<Foo>();// get data from database by sharding item 2
                foo.setId("3");
                data3.add(foo);
                return data3;
            // case n: ...
        }
        return null;
    }

    public void processData(ShardingContext shardingContext, List<Foo> list) {
        log.info("processData-->ShardingContext：{}", shardingContext.toString());
        log.info("List<Foo> list = {}", list.get(0));
    }
}
