package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "socio")
@ToString
@EqualsAndHashCode
public class Socio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "soc_id")
    private Integer soc_id;

    @Getter @Setter @Column(name = "soc_cedula")
    private String soc_cedula;

    @Getter @Setter @Column(name = "soc_nombre")
    private String soc_nombre;

    @Getter @Setter @Column(name = "soc_direccion")
    private String soc_direccion;

    @Getter @Setter @Column(name = "soc_telefono")
    private String soc_telefono;

    @Getter @Setter @Column(name = "soc_correo")
    private String soc_correo;

}