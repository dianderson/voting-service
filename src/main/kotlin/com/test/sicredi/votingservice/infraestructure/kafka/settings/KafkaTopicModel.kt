package com.test.sicredi.votingservice.infraestructure.kafka.settings

data class KafkaTopicModel(
    val name: String,
    val partitions: Int,
    val replicationFactory: Int
)
