package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.models.DbUserModel
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.UserRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.FindUserByUserName
import org.springframework.stereotype.Component

@Component
class FindUserByUserNameImpl(
    private val userRepository: UserRepository
) : FindUserByUserName {
    override fun execute(email: String): DbUserModel? =
        userRepository.findByEmail(email)?.toModel()
}