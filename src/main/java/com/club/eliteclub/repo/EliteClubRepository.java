package com.club.eliteclub.repo;

import com.club.eliteclub.entity.EliteClub;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EliteClubRepository extends JpaRepository<EliteClub, Long> {
    @Query("select x from EliteClub x where lower(x.clubName) like :searchTerm order by x.clubName asc")
    List<EliteClub> findClubs(@Param("searchTerm") String searchTerm, Pageable pageable);

}
