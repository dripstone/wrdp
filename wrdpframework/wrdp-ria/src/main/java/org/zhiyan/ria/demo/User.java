/**
 * 
 */
package org.zhiyan.ria.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title:用户实体
 * @Description:
 * @Author:zzy
 * @Since:2015年8月13日
 * @Version:1.1.0
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
    private static final long serialVersionUID = -1641679482429576307L;
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private Date dob;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }

    public User(String id, String name, String email, String password,
            Date dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email
                + ", dob=" + dob + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
