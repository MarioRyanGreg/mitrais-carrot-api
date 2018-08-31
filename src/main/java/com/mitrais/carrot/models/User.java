package com.mitrais.carrot.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_name" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User extends ModelAudit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_name")
	@Length(min = 5, message = "*Length min 5")
	private String userName;

	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotBlank(message = "*Please provide an email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotBlank(message = "*Please provide your password")
	@Transient
	private String password;

	@Column(name = "active")
	private Integer active;

	@OneToOne
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}