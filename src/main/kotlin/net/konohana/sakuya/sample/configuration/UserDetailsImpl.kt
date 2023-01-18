package net.konohana.sakuya.sample.configuration

import net.konohana.sakuya.sample.entity.User2
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

data class UserDetailsImpl(
    val user2: User2
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return AuthorityUtils.createAuthorityList("ROLE_" + user2.rolename)
    }

    override fun getPassword(): String {
        return user2.password
    }

    override fun getUsername(): String {
        return user2.username
    }

    //アカウントの有効期限
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    //アカウントロック状態かどうか
    override fun isAccountNonLocked(): Boolean {
        return true
    }

    //権限に有効期限の設定があるかどうか
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    //有効なユーザーかどうか
    override fun isEnabled(): Boolean {
        return true
    }
}
