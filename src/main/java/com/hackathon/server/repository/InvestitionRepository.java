package com.hackathon.server.repository;

import com.hackathon.server.entity.Investition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestitionRepository extends JpaRepository<Investition, Integer> {
}
