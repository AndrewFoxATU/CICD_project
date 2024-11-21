package ie.atu.cicd_project_andrew_fox.controller;

import ie.atu.cicd_project_andrew_fox.model.Player;
import ie.atu.cicd_project_andrew_fox.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return service.getAllPlayers();
    }
}
