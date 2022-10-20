package com.capvig4.mefs.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer InterationId;

    @Column
    private String body;

    @Column
    @CreationTimestamp
    private Timestamp CreatedAt;

    @Column
    @UpdateTimestamp
    private Timestamp UpdatedAt;

    @Column
    private Date DueDate;
}
