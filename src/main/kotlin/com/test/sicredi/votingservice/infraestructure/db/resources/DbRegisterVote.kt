package com.test.sicredi.votingservice.infraestructure.db.resources

import com.test.sicredi.votingservice.infraestructure.db.models.DbVotingSessionPreviewModel

interface DbRegisterVote {
    fun execute(votingSessionCode: String, votingField: String): DbVotingSessionPreviewModel
}