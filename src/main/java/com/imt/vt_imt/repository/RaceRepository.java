package com.imt.vt_imt.repository;

import com.imt.vt_imt.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {
    List<Race> findByDateAfterOrderByDateAsc(LocalDate after);
}
