package com.test.sicredi.votingservice.infraestructure.db.postgres.repository

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.AgendaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface AgendaRepository : CrudRepository<AgendaEntity, String> {
    fun findByNameAndStartTime(name: String, startTime: LocalDateTime): AgendaEntity?
}