package com.test.sicredi.votingservice.infraestructure.clients.integrations

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    value = "client",
    url = "\${configs.clients.clientUrl}"
)
interface ClientIntegration {
    @GetMapping("/{user-name}")
    fun validateUser(@PathVariable("user-name") userName: String): Boolean
}