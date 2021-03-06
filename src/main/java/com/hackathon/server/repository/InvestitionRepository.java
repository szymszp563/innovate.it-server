package com.hackathon.server.repository;

import com.hackathon.server.entity.Investition;
import com.hackathon.server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestitionRepository extends JpaRepository<Investition, Integer> {
    Investition findByTitle(String title);

    @Query("from Investition inv, Place p where inv.id = p.investition.id and p.name = ?1")
    List<Investition> findByCity(String city);

    List<Investition> findByCreator(Users creator);

    @Query("SELECT i FROM Grade g, Investition i, Users u WHERE g.user.username=u.username AND g.investition.id=i.id and u.username=?1")
    List<Investition> findInvestitionWithGradeOfUser(String user);

    @Query("SELECT i FROM Investition i WHERE NOT EXISTS (SELECT g FROM i.grades g WHERE g.user.username=?1)")
    List<Investition> findAllInvestitionsNotLikedByUser(String username);

    @Query("SELECT i FROM Grade g, Investition i, Users u WHERE g.user.username=u.username AND g.investition.id=i.id and u.username=?1 AND g.doLike=true ")
    List<Investition> findInvestitionLikedByUser(String user);

}
//WHERE NOT EXISTS (SELECT o FROM i.grades WHERE o.user.username=?1)
