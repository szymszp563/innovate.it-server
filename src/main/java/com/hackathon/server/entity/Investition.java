package com.hackathon.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Investition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Lob
    private String description;

    @OneToMany(mappedBy = "investition", cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "creator_id")
    private Users creator;

    @OneToMany(mappedBy = "investition", cascade = CascadeType.ALL)
    private List<Place> places;

}
