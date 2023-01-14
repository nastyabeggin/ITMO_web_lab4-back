package com.nastyabeggin.lab4back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nastyabeggin.lab4back.beans.PointBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PointDataRepository extends JpaRepository<PointBean, Long> {

    List<PointBean> findAllByUsername(String username);

    @Transactional
    @Modifying
    @Query("delete from PointBean p where p.username = ?1")
    void clearHitsByUsername(String username);

}
