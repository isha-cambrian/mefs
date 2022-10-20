package com.capvig4.mefs.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer userId;

    @Column
    private String body;

    @Column
    private CommunicationType communicationType;

    @Column
    @CreationTimestamp
    private Timestamp CreatedAt;

}
