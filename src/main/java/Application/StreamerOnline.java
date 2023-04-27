package Application;

import java.util.ArrayList;
import java.util.List;

public class StreamerOnline {
    private Streamer streamer;
    private List<Integer> streams;

    public StreamerOnline(Streamer streamer) {
        this.streamer = streamer;
        this.streams = new ArrayList<>();
    }

    public void addStream(Integer streamID) {
        streams.add(streamID);
    }

    public String listStreams() {
        StringBuilder res = new StringBuilder("[");
        Database db = Database.getInstance();
        Stream stream;
        for (Integer id : streams) {
            stream = db.getStream(id);
            res.append(stream.list() + ",");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public Integer getID() {
        return streamer.getId();
    }

    public Integer getCategory() {
        return streamer.getStreamerType();
    }

    public List<Integer> getStreams() {
        return streams;
    }

    public String getName() {
        return streamer.getName();
    }
}
