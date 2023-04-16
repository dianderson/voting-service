package com.test.sicredi.votingservice.common.settings

import com.test.sicredi.votingservice.api.auth.models.UserSecurity
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomAuditAware : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> =
        SecurityContextHolder.getContext().authentication
            .takeIf { it.isAuthenticated }
            .let { Optional.of((it?.principal as UserSecurity).userName) }
}