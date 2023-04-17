package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.models.DbUserModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.UserRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbFindUserByUserName
import org.springframework.stereotype.Component

@Component
class DbFindUserByUserNameImpl(
    private val userRepository: UserRepository
) : DbFindUserByUserName {
    override fun execute(email: String): DbUserModel? =
        userRepository.findByEmail(email)?.toModel()
}