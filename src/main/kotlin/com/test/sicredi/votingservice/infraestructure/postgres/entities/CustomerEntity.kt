package com.test.sicredi.votingservice.infraestructure.postgres.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener::class)
data class CustomerEntity(
    @field:Id
    @field:Column(name = "id")
    val id: String,
    @field:Column(name = "id_user", nullable = false)
    val idUser: Long,
    @field:Column(name = "name", nullable = false)
    val name: String,
    @field:Column(name = "document", nullable = false)
    val document: String,
    @field:Column(name = "phone", nullable = false)
    val phone: String,
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
