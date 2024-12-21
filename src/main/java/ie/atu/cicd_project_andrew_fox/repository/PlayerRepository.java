package ie.atu.cicd_project_andrew_fox.repository;

import ie.atu.cicd_project_andrew_fox.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeam(String team);
}
