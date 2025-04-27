package model;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class UAV {

    @Id  // This is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID
    private int id;

    private String rfidTag;

    private String ownerName;

    private String model;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    // Getters and Setters

    public enum Status {
        AUTHORIZED, UNAUTHORIZED
    }

}

