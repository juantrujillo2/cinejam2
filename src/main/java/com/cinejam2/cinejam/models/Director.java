package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "director")
@ToString
@EqualsAndHashCode
public class Director {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "dir_id")
    private Integer dir_id;

    @Getter @Setter @Column(name = "dir_nombre")
    private String dir_nombre;
}
