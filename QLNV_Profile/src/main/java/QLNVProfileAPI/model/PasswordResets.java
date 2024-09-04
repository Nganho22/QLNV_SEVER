package QLNVProfileAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_resets")
public class PasswordResets {

    @Id
    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "email", insertable = false, updatable = false)
    private Profile profile;

    // Constructors
    public PasswordResets() {
        super();
    }

    public PasswordResets(String email, String code, LocalDateTime createdAt, Profile profile) {
        super();
        this.email = email;
        this.code = code;
        this.createdAt = createdAt;
        this.profile = profile;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
