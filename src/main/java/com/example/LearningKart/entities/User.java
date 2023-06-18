package com.example.LearningKart.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@Table(name = "student")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@NotNull(message = "Email is Mandatory.")
	@Email(message = "Email should be valid")
	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private String role = "user";

	@NotNull(message = "Password cannot be Empty.")
	@Column(name = "password")
	private String password;


}