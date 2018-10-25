package com.chm.toodles.substitution.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySimpleJob implements SimpleJob {

  @Override
  public void execute(ShardingContext shardingContext) {
    String shardingParameter = shardingContext.getShardingParameter();
    int shardingTotalCount = shardingContext.getShardingTotalCount();
    log.info("分片参数:{}", shardingParameter);
    int value = Integer.parseInt(shardingParameter);
    for (int i = 0; i < 100; i++) {
      if (i % shardingTotalCount == value) {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        log.info("count={},parameter={},time={},开始执行简单任务:{}", shardingTotalCount, shardingParameter,
            time, i);
      }
    }
  }
}
