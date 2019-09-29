package com.hackathon.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Investition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Lob
    private String description;

    private String shortDescription;

    @Enumerated(value = EnumType.STRING)
    private InvestitionCategory category;

    @OneToMany(mappedBy = "investition", cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Users creator;

    @OneToOne(mappedBy = "investition", cascade = CascadeType.ALL)
    private Place place;

    @OneToMany(mappedBy = "investition", cascade = CascadeType.ALL)
    private List<Grade> grades;

    public void addImage(Image image) {
        this.images.add(image);
        image.setInvestition(this);
    }

    public void addPlace(Place place) {
        this.place = place;
        place.setInvestition(this);
    }

    public void addGrade(Grade grade){
        this.grades.add(grade);
        grade.setInvestition(this);
    }

}
