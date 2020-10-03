package dist.ai.backend.services;

import dist.ai.backend.models.PlayedSong;
import dist.ai.backend.models.Song;
import dist.ai.backend.models.User;
import dist.ai.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DataService {

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

    private Song currentlyPlaying = null;

    public List<Song> getSongs() {
        return songRepo.findAll();
    }

    public Map<Song, Integer> getSongsWithScore() {
        List<Song> playedSongs = getAllPlayedSongs();
        HashMap<Song, Integer> songsWithScore = new HashMap<>();
        for (Song playedSong : playedSongs) {
            songsWithScore.put(playedSong, getScore(playedSong));
        }
        return songsWithScore;
    }

    public Song getSong(Integer id) {
        return songRepo.findByIdEquals(id);
    }

    public Integer getScore(Integer songId) {
        return processedVotesRepo.findScoreById(songId);
    }

    public Integer getScore(Song song) {
        return processedVotesRepo.findScoreById(song.getId());
    }

    public Integer getNumberOfVotes(Integer songId) {
        return processedVotesRepo.findVotesById(songId);
    }

    public Integer getNumberOfVotes(Song song) {
        return processedVotesRepo.findVotesById(song.getId());
    }

    public double getApprovalRate(Integer songId) {
        return ((double) getScore(songId)) / ((double) getNumberOfVotes(songId));
    }

    public double getApprovalRate(Song song) {
        return ((double) getScore(song)) / ((double) getNumberOfVotes(song));
    }

    public List<Song> getAllPlayedSongs() {
        List<PlayedSong> playedSongs = playedSongRepo.findAll();
        List<Song> returnList = new ArrayList<>();
        for (PlayedSong ps : playedSongs) {
            returnList.add(getSong(ps.getSong_id()));
        }
        return returnList;
    }

    public void setPlaying(Song song) {
        currentlyPlaying = song;
    }

    public Song getCurrentlyPlaying() {
        return currentlyPlaying;
    }

    public User getMostActiveUser() {
        return userRepo.findHighestVoter();
    }


}
