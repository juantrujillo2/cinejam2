package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@ToString
@EqualsAndHashCode
public class Genero {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "gen_id")
    private Integer gen_id;

    @Getter @Setter @Column(name = "gen_nombre")
    private String gen_nombre;
}
