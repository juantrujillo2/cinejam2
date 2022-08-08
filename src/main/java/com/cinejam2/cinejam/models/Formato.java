package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "formato")
@ToString
@EqualsAndHashCode
public class Formato {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "for_id")
    private Integer for_id;

    @Getter @Setter @Column(name = "for_nombre")
    private String for_nombre;

}
