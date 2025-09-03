package com.imt.vt_imt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "results")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ResultEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Race race;

    @ManyToOne(optional = false)
    private User user;

    private Integer rankPosition;
    private Integer timeSeconds;
}
