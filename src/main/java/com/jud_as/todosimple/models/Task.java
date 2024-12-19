package com.jud_as.todosimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task {

    public static final String TABLE_NAME = "task";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "description", length = 255, nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;

    public Task() {

    }

    public Task(Long id, User user, String description) {
        this.id = id;
        this.user = user;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object taskObj) {
        if (taskObj == this) return true;
        if (taskObj == null) return false;
        if (!(taskObj instanceof Task otherTask)) return false;

        if (this.id == null) {
            if (otherTask.id != null) {
                return false;
            }
        } else if (!this.id.equals(otherTask.id)) {
            return false;
        }

        return     Objects.equals(this.description, otherTask.description)
                && Objects.equals(this.user, otherTask.user);
    }

    @Override
    public int hashCode() {
        final int prime = 31; // Random prime number
        int result = 1; // Generate HashCode
        result = prime * result + ((this.id == null ? 0 : this.id.hashCode())); // HashCode for unique id
        return result; // Return HashCode
    }
}
