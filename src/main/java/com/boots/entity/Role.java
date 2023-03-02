package com.boots.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="t_role")
public class Role  implements GrantedAuthority {
    @Id
    private long id;
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles");
    private Set<User> user;
    public Role(){

    }
    public Role(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
