package com.example.uavdockingmanagementsystem.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UAV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rfidTag;
    private String ownerName;
    private String model;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getRfidTag() {
        return rfidTag;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getModel() {
        return model;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRfidTag(String rfidTag) {
        this.rfidTag = rfidTag;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public enum Status {
        AUTHORIZED, UNAUTHORIZED
    }
}