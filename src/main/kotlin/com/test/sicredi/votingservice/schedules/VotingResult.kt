package com.test.sicredi.votingservice.schedules

import com.test.sicredi.votingservice.domains.voting_session.resources.VotingResultProcessor
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class VotingResult(
    private val votingResultProcessor: VotingResultProcessor
) {
    @Scheduled(cron = "\${schedules.voting-result.cron}")
    fun execute() {
        votingResultProcessor.execute()
    }
}