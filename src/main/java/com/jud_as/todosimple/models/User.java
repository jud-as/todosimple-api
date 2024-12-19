package com.jud_as.todosimple.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}

    public static final String TABLE_NAME = "user";

    @Id // Primary key
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(name = "username", length = 100, nullable = false, unique = false)
    @NotNull(groups = CreateUser.class)
    @NotEmpty(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 4, max = 100)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Hide password in JSON response
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Hide tasks in JSON response
    private List<Task> tasks = new ArrayList<Task>();

    public User() {

    } // Empty constructor for Spring Boot

    public User(Long id, String username, String password) {
        this.username = username;
        this.password = password;

    } // Constructor for user creation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 4, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(groups = CreateUser.class) @NotEmpty(groups = CreateUser.class) @Size(groups = CreateUser.class, min = 4, max = 100) String username) {
        this.username = username;
    }

    public @NotNull(groups = {CreateUser.class, UpdateUser.class}) @NotEmpty(groups = {CreateUser.class, UpdateUser.class}) @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(groups = {CreateUser.class, UpdateUser.class}) @NotEmpty(groups = {CreateUser.class, UpdateUser.class}) @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 100) String password) {
        this.password = password;
    }

    @JsonIgnore
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object userObj) {
        if (userObj == this) return true;
        if (userObj == null) return false;
        if (!(userObj instanceof User otherUser)) return false;

        if (this.id == null) {
            if (otherUser.id != null) {
                return false;
            }
        } else if (!this.id.equals(otherUser.id))
            return false;

        return     Objects.equals(this.username, otherUser.username)
                && Objects.equals(this.password, otherUser.password);
    }

    @Override
    public int hashCode() {
        final int prime = 31; // Random prime number
        int result = 1; // Generate HashCode
        result = prime * result + ((this.id == null ? 0 : this.id.hashCode())); // HashCode for unique id
        return result; // Return HashCode
    }
}
