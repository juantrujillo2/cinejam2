package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "sexo")
@ToString
@EqualsAndHashCode
public class Sexo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "sex_id")
    private Integer sex_id;

    @Getter @Setter @Column(name = "sex_nombre")
    private String sex_nombre;

}
