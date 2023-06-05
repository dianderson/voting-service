package com.test.sicredi.votingservice.common.settings

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor

@EnableAsync
@Configuration
@EnableScheduling
class ThreadsSettings(
    @Value("\${configs.threads.default}")
    private val defaultThreads: Int,
    @Value("\${configs.threads.max}")
    private val maxThreads: Int
) : AsyncConfigurer {
    @Bean
    fun taskExecutor(): Executor = ThreadPoolTaskExecutor()
        .apply { corePoolSize = defaultThreads }
        .apply { maxPoolSize = maxThreads }
        .apply { initialize() }
}