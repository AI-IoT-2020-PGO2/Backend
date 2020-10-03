package dist.ai.backend.controllers;

import dist.ai.backend.model.Song;
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
    //Initialiseren databank

    //TODO: vervangen door initialisatie databank
    private List<Song> songs;
    private Song currentPlaying;

    @Autowired
    public WebController() {
        songs = new ArrayList<>();
        songs.add(new Song("10000 luchtballonnen", "K3"));
        songs.add(new Song("Oma's aan de top", "K3"));
        currentPlaying = new Song("Oya lélé", "K3");
    }

    @GetMapping("/get/songs")
    public ResponseEntity<List<Song>> getSongs() {
        //TODO: vervangen door: uitlezen songs uit databank
        return new ResponseEntity<>(this.songs, HttpStatus.OK);
    }

    @GetMapping("/get/current")
    public ResponseEntity<Song> getCurrent() {
        //TODO: vervangen door: uitlezen songs uit databank
        return new ResponseEntity<>(this.currentPlaying, HttpStatus.OK);
    }

    @PutMapping("/set/current/{songID}")
    public ResponseEntity<Song> setCurrentPlaying(@RequestBody int songID) {
        //TODO: song met id uitlezen uit databank en instellen als currentplaying
        this.currentPlaying = new Song("Alle kleuren", "K3");

        return new ResponseEntity<>(this.currentPlaying, HttpStatus.OK);
    }

}