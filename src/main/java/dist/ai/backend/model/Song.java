package dist.ai.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
public class Song {
    //TODO: edit
    private String title;
    private String band;

    public Song(String title, String band) {
        this.title = title;
        this.band = band;
    }
//    private int id;
//    private String song_name;
//    private int artist_id;
//    private int album_id;
//    private int genre_id;
//    private Time length;
}
