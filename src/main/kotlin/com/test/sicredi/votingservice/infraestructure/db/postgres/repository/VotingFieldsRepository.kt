package com.test.sicredi.votingservice.infraestructure.db.postgres.repository

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.VotingFieldsEntity
import com.test.sicredi.votingservice.infraestructure.db.postgres.pk.VotingFieldsPK
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VotingFieldsRepository : JpaRepository<VotingFieldsEntity, VotingFieldsPK> {
    @Modifying
    @Query(
        value = """
            update voting_fields
            set quantity = quantity + 1
            where id_voting_session = :votingSessionCode
            and field_name = :votingField
        """, nativeQuery = true
    )
    fun registerVote(votingSessionCode: String, votingField: String)
}