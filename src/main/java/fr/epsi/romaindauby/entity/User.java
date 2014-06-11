package fr.epsi.romaindauby.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	/**
	 * Unique identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", unique = true, nullable = false)
	private Long id;

	/**
	 * Email of the user
	 */
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	/**
	 * Password of the user
	 */
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * Name of the user
	 */
	@Column(name = "name", nullable = false)
	private String name;

	/**
	 * Surname of the user
	 */
	@Column(name = "surname", nullable = false)
	private String surname;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}