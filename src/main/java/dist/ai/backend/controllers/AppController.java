package dist.ai.backend.controllers;

import dist.ai.backend.database.VoteContext;
import dist.ai.backend.model.SongInfo;
import dist.ai.backend.model.Vote;
import dist.ai.backend.services.MQTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Autowired
    VoteContext voteContext;

    @Autowired
    MQTTService mqttService;

    @PostMapping("/vote")
    public ResponseEntity<Object> Vote() {
        mqttService.publishNewSong(new SongInfo("testSong", "testArtist", 1));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> New() {
        return new ResponseEntity<>("{\"uid\":12}",HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<String> Status() {
        return new ResponseEntity<>("status OK", HttpStatus.OK);
    }
}
