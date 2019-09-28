package com.hackathon.server.repository;

import com.hackathon.server.entity.Authorities;
import com.hackathon.server.entity.privatekeys.AuthoritiesPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesPK> {
}
