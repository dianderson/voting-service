package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.models.DbUserModel

interface DbFindUserByUserName {
    fun execute(userName: String): DbUserModel?
}