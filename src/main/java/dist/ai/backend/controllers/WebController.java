package dist.ai.backend.controllers;

import dist.ai.backend.models.Song;
import dist.ai.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Somers
 * @version 1.0 1/10/2020 15:18
 */

@RestController
@RequestMapping("/web")
public class WebController {
    //Initialiseren databank repositories
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private PlayedSongRepository playedSongRepo;
    @Autowired
    private ProcessedVotesRepository processedVotesRepo;
    @Autowired
    private SongRepository songRepo;
    @Autowired
    private UserRepository userRepo;

    private List<Song> songs;
    private Song currentPlaying;


    @Autowired
    public WebController() {
        currentPlaying = null;
        songs = new ArrayList<>();
    }

    @GetMapping("/get/songs")
    public ResponseEntity<List<Song>> getSongs() {
        this.songs = songRepo.findAll();
        return new ResponseEntity<>(this.songs, HttpStatus.OK);
    }

    @GetMapping("/get/current")
    public ResponseEntity<Song> getCurrent() {
        return new ResponseEntity<>(this.currentPlaying, HttpStatus.OK);
    }

    @PutMapping("/set/current/{songID}")
    public ResponseEntity<Song> setCurrentPlaying(@RequestBody int songID) {
        //TODO: vragen hoe PutMapping en RequestBody werkt

        currentPlaying = songRepo.findByIdEquals(songID);

        return new ResponseEntity<>(this.currentPlaying, HttpStatus.OK);
    }

}