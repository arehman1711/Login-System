package com.example.Login_System.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "contactus")
public class ContactUs {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;

        @Column(name = "name")
        @Size(min = 1, max =20, message = "Name must be between 2 and 20 characters")
        private String name;
        @NotNull(message = "Email is Mandatory.")
        @Email(message = "Email should be valid")
        @Column(name = "email")
        private String email;

        @Column(name = "message")
        @Size(min = 1, max = 20, message = "Name must be between 2 and 20 characters")
        private String message;
}
