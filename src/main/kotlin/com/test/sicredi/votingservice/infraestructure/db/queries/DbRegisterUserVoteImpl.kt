package com.test.sicredi.votingservice.infraestructure.db.queries

import com.test.sicredi.votingservice.infraestructure.db.inputs.DbRegisterUserVoteInput
import com.test.sicredi.votingservice.infraestructure.db.postgres.repository.SingleVoteFieldsRepository
import com.test.sicredi.votingservice.infraestructure.db.resources.DbRegisterUserVote
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import javax.management.BadAttributeValueExpException

@Component
class DbRegisterUserVoteImpl(
    private val singleVoteFieldsRepository: SingleVoteFieldsRepository
) : DbRegisterUserVote {
    override fun execute(input: DbRegisterUserVoteInput) {
        input.buildPk()
            .let { it to singleVoteFieldsRepository.findByIdOrNull(it) }
            .takeIf { it.second == null }
            ?.let { singleVoteFieldsRepository.save(input.toEntity(it.first)) }
            ?: throw BadAttributeValueExpException("User vote already registered")
    }
}