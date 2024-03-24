package com.loser.utils;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 重试工具
 *
 * @author loser
 */
@Component
public class RetryUtil {

    /**
     * 重试调用方法-有返回值
     *
     * @param callable  业务方法
     * @param excRetry  异常是否重试
     * @param sleepTime 每次重试休眠时间
     * @param retryTime 重试次数
     * @param <T>       判断值类型
     * @return 返回值
     */
    public static <T> T retry(Callable<T> callable, boolean excRetry, long sleepTime, int retryTime) {

        RetryerBuilder<T> builder = RetryerBuilder.<T>newBuilder()
                // 每次循环休眠时间
                .withWaitStrategy(WaitStrategies.fixedWait(sleepTime, TimeUnit.MILLISECONDS))
                // 设置最大执行次数N次
                .withStopStrategy(StopStrategies.stopAfterAttempt(retryTime));
        if (excRetry) {
            builder.retryIfRuntimeException();
        }
        Retryer<T> retry = builder.build();
        try {
            return retry.call(callable);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}



