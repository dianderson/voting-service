package com.test.sicredi.votingservice.infraestructure.clients.resources

import com.test.sicredi.votingservice.infraestructure.clients.integrations.ClientIntegration
import feign.FeignException.FeignClientException
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component

@Component
class ValidateUserByUserNameImpl(
    private val clientIntegration: ClientIntegration
) : ValidateUserByUserName {
    private val logger = LogManager.getLogger(ValidateUserByUserNameImpl::class.java)
    override fun execute(userName: String): Boolean =
        try {
            clientIntegration.validateUser(userName)
        } catch (ex: FeignClientException) {
            logger.error("Error code: ${ex.status()}")
            true
        }
}