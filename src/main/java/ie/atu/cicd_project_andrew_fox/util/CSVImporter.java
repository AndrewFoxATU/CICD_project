package ie.atu.cicd_project_andrew_fox.util;

import ie.atu.cicd_project_andrew_fox.model.Player;
import ie.atu.cicd_project_andrew_fox.repository.PlayerRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.Reader;

@Component
public class CSVImporter {
    private final PlayerRepository playerRepository;

    public CSVImporter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostConstruct
    public void importPlayers() {
        try {
            // Path to the CSV file
            Reader reader = new FileReader("src/main/resources/players.csv");
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (CSVRecord record : parser) {
                Player player = new Player();
                player.setId(Long.parseLong(record.get("id")));
                player.setWeb_name(record.get("name"));
                player.setPosition(record.get("position"));
                player.setTeam(record.get("team"));
                player.setNews(record.get("news"));

                if (!playerRepository.existsById(player.getId())) {
                    playerRepository.save(player);
                }
            }

            parser.close();
            System.out.println("Player data imported successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
