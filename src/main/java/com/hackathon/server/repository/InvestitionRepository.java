package com.hackathon.server.repository;

import com.hackathon.server.entity.Investition;
import com.hackathon.server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestitionRepository extends JpaRepository<Investition, Integer> {
    Investition findByTitle(String title);

    @Query("from Investition inv, Place p where inv.id = p.investition.id and p.name = ?1")
    List<Investition> findByCity (String city);

    List<Investition> findByCreator(Users creator);
}
