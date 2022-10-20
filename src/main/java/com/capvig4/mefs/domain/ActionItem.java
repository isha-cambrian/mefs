package com.capvig4.mefs.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class ActionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer feedbackId;

    @Column
    private String body;

    @Column
    private Status status;

    @Column
    @CreationTimestamp
    private Timestamp CreatedAt;

    @Column
    @UpdateTimestamp
    private Timestamp UpdatedAt;

    @Column
    private Date DueDate;
}
