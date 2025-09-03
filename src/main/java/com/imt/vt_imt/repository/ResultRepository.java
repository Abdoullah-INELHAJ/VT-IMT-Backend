package com.imt.vt_imt.repository;

import com.imt.vt_imt.entity.ResultEntry;
import com.imt.vt_imt.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResultRepository extends JpaRepository<ResultEntry, Long> {
    List<ResultEntry> findByRaceOrderByRankPositionAsc(Race race);
}
