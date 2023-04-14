package com.test.sicredi.votingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VotingServiceApplication

fun main(args: Array<String>) {
	runApplication<MonolithicServiceApplication>(*args)
}
