package com.autentication.autentication.model;

import jakarta.persistence.*;

import java.util.UUID;

public class Role {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Roles roles;

    public String getAuthority() {
        return this.roles.toString();
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public Roles getRoleName() {
        return roles;
    }

    public void setRoleName(Roles roleName) {
        this.roles = roleName;
    }
}
