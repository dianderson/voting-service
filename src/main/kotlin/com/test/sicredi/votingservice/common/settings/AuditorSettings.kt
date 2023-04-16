package com.test.sicredi.votingservice.common.settings

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AuditorSettings {
    @Bean
    fun auditorAware(): CustomAuditAware = CustomAuditAware()
}