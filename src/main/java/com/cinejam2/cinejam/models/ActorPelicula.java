package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "actor_pelicula")
@ToString
@EqualsAndHashCode
public class ActorPelicula {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "apl_id")
    private Integer apl_id;

    @Column(name = "act_id")
    private Integer act_id;

    @Column(name = "pel_id")
    private Integer pel_id;

    @Getter @Setter @Column(name = "apl_papel")
    private String apl_papel;
}
