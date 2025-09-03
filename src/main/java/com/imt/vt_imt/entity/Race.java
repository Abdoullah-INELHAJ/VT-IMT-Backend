package com.imt.vt_imt.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "races")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;
    private LocalDate date;
    private String location;
    private Integer capacity;
    private String routeUrl;

    private LocalDateTime createdAt;
}
