package com.cinejam2.cinejam.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "actor")
@ToString @EqualsAndHashCode

public class Actor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "act_id")
    private Long act_id;

    @Getter @Setter @Column(name = "sex_id")
    private Long sex_id;

    @Getter @Setter @Column(name = "act_nombre")
    private String act_nombre;

}
