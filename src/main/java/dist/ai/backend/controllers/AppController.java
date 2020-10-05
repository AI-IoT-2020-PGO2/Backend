package dist.ai.backend.controllers;

import dist.ai.backend.database.DataContext;
import dist.ai.backend.database.VoteContext;
import dist.ai.backend.models.User;
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
    private DataContext data;

    @PostMapping("/new")
    public ResponseEntity<String> New() {
        User user = data.adduser();
        return new ResponseEntity<>(String.format("{\"uid\":%d}", user.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<String> Status() {
        return new ResponseEntity<>("status OK", HttpStatus.OK);
    }
}
