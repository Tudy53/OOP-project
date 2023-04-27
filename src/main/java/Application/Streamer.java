package Application;

import java.util.List;

public class Streamer {
    private Integer streamerType;
    private Integer id;
    private String name;

    public Streamer(Integer streamerType, Integer id, String name) {
        this.streamerType = streamerType;
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStreamerType() {
        return streamerType;
    }

    public String getName() {
        return name;
    }

}
