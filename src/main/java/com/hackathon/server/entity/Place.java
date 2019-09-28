package com.hackathon.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;

    private String longitude;

    private String latitude;

    @ManyToOne
    @JoinColumn(name = "investition_id")
    private Investition investition;
}
