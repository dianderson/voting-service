package com.test.sicredi.votingservice.infraestructure.clients.resources

interface ValidateUserByUserName {
    fun execute(userName: String): Boolean
}