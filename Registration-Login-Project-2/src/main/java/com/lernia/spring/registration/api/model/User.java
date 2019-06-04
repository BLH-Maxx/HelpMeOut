package com.lernia.spring.registration.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "registereduser")
@DynamicUpdate
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@NotNull
	@Column(name = "personal_number", unique = true)
	private long personalNumber;

	@NotNull
	@Column(name = "user_name", unique = true)
	private String userName;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "address")
	private String address;

	@NotNull
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@Min(value = 100000000)
	@NotNull
	@Column(name = "phone")
	private Long phone;

	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private Boolean active;
	
	@NotNull
	@Column(name = "balance")
	private int balance;

	@Column(name = "rating")
	private int rating;

	@Column(name = "roles")
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@Override
	public String toString() {
		return "User [id=" + user_id + ", personalNumber=" + personalNumber + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", password=" + password + ", active=" + active + ", rating=" + rating + ", roles=" + roles
				+ "]";
	}

	public User(@NotNull long personalNumber,
			@NotNull String userName, @NotNull String firstName, @NotNull String lastName, @NotNull String address,
			@NotNull @Email String email, @Min(1000000000) @NotNull Long phone, @NotNull String password) {
		super();
		this.personalNumber = personalNumber;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {
		
	}
	
	

}
