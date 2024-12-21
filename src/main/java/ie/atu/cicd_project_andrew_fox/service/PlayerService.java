package ie.atu.cicd_project_andrew_fox.service;

import ie.atu.cicd_project_andrew_fox.model.Player;
import ie.atu.cicd_project_andrew_fox.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    public List<Player> getPlayersByClub(String clubName) {
        return repository.findByTeam(clubName);
    }

    public Player savePlayer(Player player) {
        return repository.save(player);
    }
}
