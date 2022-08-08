package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alquiler")
@ToString
@EqualsAndHashCode
public class Alquiler {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "alq_id")
    private Integer alq_id;

    @Column(name = "soc_id")
    private Integer soc_id;

    @Column(name = "pel_id")
    private Integer pel_id;

    @Getter @Setter @Column(name = "alq_fecha_desde")
    private Date alq_fecha_desde;

    @Getter @Setter @Column(name = "alq_fecha_hasta")
    private Date alq_fecha_hasta;

    @Getter @Setter @Column(name = "alq_valor")
    private Float alq_valor;

    @Getter @Setter @Column(name = "alq_fecha_entrega")
    private Date alq_fecha_entrega;
}
