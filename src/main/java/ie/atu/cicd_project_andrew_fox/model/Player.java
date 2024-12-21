package ie.atu.cicd_project_andrew_fox.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Player {
    @Id
    private Long id;

    private String web_name;
    private String position; // MID, FWD, DEF, GKP
    private String team;
    private String news;
}