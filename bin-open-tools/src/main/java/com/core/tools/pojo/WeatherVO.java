package com.core.tools.pojo;

import cn.hutool.core.date.StopWatch;
import lombok.Data;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author wb
 * @description:
 * @date 2022/11/29 15:41
 */
@Data
public class WeatherVO {
    public static BigDecimal add(BigDecimal count, boolean condition, BigDecimal amount){
        if (condition){
            count = count.add(amount);
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("autoExecuteSettleJob");
        stopWatch.start("01");
        long i = 1;
        for (int j = 0; j < 1000000000; j++) {
            i = i+1;
            i = i<<2;
            i = i^2;
        }
        Thread.sleep(100);
        stopWatch.stop();

        stopWatch.start("02");
        for (int j = 0; j < 1000000000; j++) {
            i = i+1;
        }
        stopWatch.stop();
        System.out.println(i);
        System.out.println(stopWatch.prettyPrint(TimeUnit.MILLISECONDS));
    }
}
