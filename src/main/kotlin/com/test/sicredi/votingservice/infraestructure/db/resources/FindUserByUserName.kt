package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.models.DbUserModel

interface FindUserByUserName {
    fun execute(userName: String): DbUserModel?
}