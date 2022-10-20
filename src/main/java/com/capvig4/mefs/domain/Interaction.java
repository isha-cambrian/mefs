package com.capvig4.mefs.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer managerId;

    @Column
    private Integer subordinateId;

    @Column
    @CreationTimestamp
    private Timestamp CreatedAt;

    @Column
    @UpdateTimestamp
    private Timestamp UpdatedAt;

    @Column
    private Timestamp ScheduledAt;
}
