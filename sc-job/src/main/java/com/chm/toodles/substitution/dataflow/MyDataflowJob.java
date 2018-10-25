package com.chm.toodles.substitution.dataflow;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyDataflowJob implements DataflowJob<String> {

  @Override
  public List<String> fetchData(ShardingContext shardingContext) {
    return Arrays.asList("1", "2", "3");
  }

  @Override
  public void processData(ShardingContext shardingContext, List<String> data) {
    log.info("处理数据:{}", data.toString());
  }
}
