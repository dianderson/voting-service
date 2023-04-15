package com.test.sicredi.votingservice.infraestructure.postgres.repository

import com.test.sicredi.votingservice.infraestructure.postgres.entities.RefreshTokenEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : JpaRepository<RefreshTokenEntity, String>