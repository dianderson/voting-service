package com.test.sicredi.votingservice.infraestructure.postgres.repository

import com.test.sicredi.votingservice.infraestructure.postgres.entities.VotingSessionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VotingSessionRepository : JpaRepository<VotingSessionEntity, String>