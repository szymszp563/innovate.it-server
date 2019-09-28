package com.hackathon.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id
    private String username;

    private String password;

    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authoritiesPK.username")
    private List<Authorities> authorities;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Investition> investition;

    public void addInvestition(Investition investition) {
        this.investition.add(investition);
        investition.setCreator(this);
    }
}
