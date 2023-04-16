package com.test.sicredi.votingservice.api.auth.models

import com.test.sicredi.votingservice.common.enums.Roles
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class UserSecurity(
    val id: Long,
    val userName: String,
    val roles: List<GrantedAuthority>,
    private val pass: String? = null
) : UserDetails {
    constructor(id: Long, userName: String, roles: String) : this(
        id = id,
        userName = userName,
        roles = roles.split(",").map { SimpleGrantedAuthority(it) }
    )

    override fun getAuthorities() = roles
    override fun getPassword() = pass
    override fun getUsername() = userName
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}
