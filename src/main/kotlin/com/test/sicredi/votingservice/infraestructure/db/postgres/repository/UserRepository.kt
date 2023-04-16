package com.test.sicredi.votingservice.infraestructure.db.postgres.repository

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByEmail(email: String): UserEntity?
}