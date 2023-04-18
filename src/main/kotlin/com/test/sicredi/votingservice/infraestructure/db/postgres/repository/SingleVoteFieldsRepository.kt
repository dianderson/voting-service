package com.test.sicredi.votingservice.infraestructure.db.postgres.repository

import com.test.sicredi.votingservice.infraestructure.db.postgres.entities.SingleVoteFieldsEntity
import com.test.sicredi.votingservice.infraestructure.db.postgres.pk.SingleVoteFieldsPK
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SingleVoteFieldsRepository : JpaRepository<SingleVoteFieldsEntity, SingleVoteFieldsPK>