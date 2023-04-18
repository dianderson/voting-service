package com.test.sicredi.votingservice.infraestructure.kafka.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "configs.kafka")
data class ConsumerKafkaProperties(
    var serverUrl: String = "",
    var schemaRegistryUrl: String = "",
    var groupId: String = "",
    var concurrency: Int = 1
)
