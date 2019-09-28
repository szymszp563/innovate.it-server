package com.hackathon.server.entity;

import com.hackathon.server.entity.privatekey.AuthoritiesPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authorities {

    @EmbeddedId
    private AuthoritiesPK authoritiesPK;
}
