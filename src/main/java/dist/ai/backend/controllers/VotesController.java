package dist.ai.backend.controllers;

import dist.ai.backend.database.VoteContext;
import dist.ai.backend.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotesController {
    @Autowired
    VoteContext voteContext;

    @PostMapping("/vote")
    public void Vote() {
        Vote vote = new Vote((byte)-1, 123456, "2020-10-01 17:12:10", 456);
        voteContext.saveVote(vote);
    }
}
