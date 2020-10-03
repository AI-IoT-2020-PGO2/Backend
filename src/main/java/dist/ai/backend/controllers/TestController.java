package dist.ai.backend.controllers;

import dist.ai.backend.models.Song;
import dist.ai.backend.repositories.PlayedSongRepository;
import dist.ai.backend.repositories.ProcessedVotesRepository;
import dist.ai.backend.repositories.SongRepository;
import dist.ai.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private PlayedSongRepository playedSongs;
    @Autowired
    private ProcessedVotesRepository processedVotes;
    @Autowired
    private SongRepository songs;
    @Autowired
    private UserRepository users;

    @GetMapping("/listsongs")
    public Iterable<Song> getSongs(){
        return songs.findAll();
    }
}
