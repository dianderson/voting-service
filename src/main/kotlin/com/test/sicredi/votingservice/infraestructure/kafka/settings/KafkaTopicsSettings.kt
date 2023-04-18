package com.test.sicredi.votingservice.infraestructure.kafka.settings

import org.apache.kafka.clients.admin.AdminClient
import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.CreateTopicsResult
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicsSettings(
    @Value("\${configs.kafka.server-url}")
    private val serverUrl: String,
    private val application: TopicKafkaProperties
) {
    @Bean
    fun createTopics(): CreateTopicsResult =
        application.topicProps
            .buildNewTopics()
            .createTopics()

    private fun buildKafkaAdmin() = hashMapOf<String, Any>()
        .apply { this[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = serverUrl }
        .let { KafkaAdmin(it) }

    private fun List<KafkaTopicModel>.buildNewTopics(): List<NewTopic> = this
        .map { NewTopic(it.name, it.partitions, it.replicationFactory.toShort()) }

    private fun List<NewTopic>.createTopics() = AdminClient
        .create(buildKafkaAdmin().configurationProperties)
        .createTopics(this)
}