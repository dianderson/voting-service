package com.test.sicredi.votingservice.infraestructure.db.models

import com.test.sicredi.votingservice.common.enums.Roles

data class DbUserModel(
    val id: Long,
    val email: String,
    val password: String,
    val roles: List<Roles>
)
