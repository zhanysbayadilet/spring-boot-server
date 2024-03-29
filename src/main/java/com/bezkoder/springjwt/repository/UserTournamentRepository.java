package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.UserTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserTournamentRepository extends JpaRepository<UserTournament, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM user_tournament " +
            "WHERE user_id = :userId AND tournament_id = :tournamentId")
    UserTournament findByUserIdAndTournamentId(Long userId, Long tournamentId);

    @Transactional
    Integer deleteUserTournamentByUserIdAndTournamentId(Long userId, Long tournamentId);
}
