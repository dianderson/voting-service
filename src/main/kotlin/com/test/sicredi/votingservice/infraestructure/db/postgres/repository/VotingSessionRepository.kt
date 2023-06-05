package com.test.sicredi.votingservice.infraestructure.db.postgres.repository

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.VotingSessionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface VotingSessionRepository : JpaRepository<VotingSessionEntity, String> {
    fun findByAgendaIdAndStartTime(agendaId: String, startTime: LocalDateTime): VotingSessionEntity?
    fun findAllByNotifiedFalseAndEndTimeBefore(now: LocalDateTime): List<VotingSessionEntity>

    @Modifying
    @Query(
        value = """
            UPDATE 	voting_sessions
            SET notified = true
            WHERE id_voting_session = :code
        """,
        nativeQuery = true
    )
    fun updateToNotified(code: String)
}