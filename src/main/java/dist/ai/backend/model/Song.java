package dist.ai.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
