package com.test.sicredi.votingservice.infraestructure.postgres.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "agenda")
@EntityListeners(AuditingEntityListener::class)
data class AgendaEntity(
    @field:Id
    @field:Column(name = "id")
    val id: String,
    @field:Column(name = "name", nullable = false)
    val name: String,
    @field:Column(name = "subject", nullable = false)
    val subject: String,
    @field:Column(name = "comments", nullable = false)
    val comments: String,
    @field:Column(name = "start_date", nullable = false)
    val startDate: LocalDateTime,
    @field:Column(name = "duration_in_hours", nullable = false)
    val durationInHours: Long,
    @field:CreatedDate
    @field:Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime? = null,
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    var createdBy: String? = null,
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null,
    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    var updatedBy: String? = null
)
