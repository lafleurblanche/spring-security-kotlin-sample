package net.konohana.sakuya.sample.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User2 {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @Column(name = "username")
    var username: String = ""

    @Column(name = "password")
    var password: String = ""

    @Column(name = "rolename")
    var rolename: String = ""

    constructor(){}
    constructor(
        username: String,
        password: String,
        rolename: String,
    ) : super() {
        this.username = username
        this.password = password
        this.rolename = rolename
    }
}
