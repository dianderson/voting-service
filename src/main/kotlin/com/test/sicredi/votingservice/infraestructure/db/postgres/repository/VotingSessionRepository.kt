package com.test.sicredi.votingservice.infraestructure.db.postgres.repository

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.VotingSessionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface VotingSessionRepository : JpaRepository<VotingSessionEntity, String> {
    fun findByAgendaIdAndStartTime(agendaId: String, startTime: LocalDateTime): VotingSessionEntity?
    fun findAllByEndTimeBefore(now: LocalDateTime): List<VotingSessionEntity>
}