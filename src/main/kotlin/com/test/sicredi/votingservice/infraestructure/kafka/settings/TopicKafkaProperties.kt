package com.test.sicredi.votingservice.infraestructure.kafka.settings

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "configs.kafka")
data class TopicKafkaProperties(
    var topicProps: List<KafkaTopicModel> = listOf()
)
