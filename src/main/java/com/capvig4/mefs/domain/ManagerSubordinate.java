package com.capvig4.mefs.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ManagerSubordinate {
    @Column
    private Integer managerId;

    @Column
    private Integer subordinateId;
}
