package com.fuji.inventory.fujiInv.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Logs")
@AllArgsConstructor
@NoArgsConstructor
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Long id;
    @Column(name = "log_date_time")
    private LocalDateTime logTime;
    @Column(name = "log text", length = 1000)
    private String logText;

    @ManyToOne
    private InvItem item;

    @PrePersist
    private void init() {
        logTime = LocalDateTime.now();
    }
}
