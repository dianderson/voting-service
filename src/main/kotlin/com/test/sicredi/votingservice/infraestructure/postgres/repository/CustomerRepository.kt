package com.test.sicredi.votingservice.infraestructure.postgres.repository

import com.test.sicredi.votingservice.infraestructure.postgres.entities.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerEntity, String>