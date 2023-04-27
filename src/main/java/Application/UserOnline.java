package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOnline {
    private User user;
    private HashMap<Integer, StreamerOnline> streamers;

    public UserOnline(User user) {
        this.user = user;
        this.streamers = new HashMap<>();
    }

    public String listStreams() {
        return user.listStreams();
    }

    public void listen(Integer streamID, StreamerOnline streamer) {
        user.listen(streamID);
        streamers.put(streamer.getID(), streamer);
    }

    public HashMap<Integer, StreamerOnline> getStreamers() {
        return streamers;
    }

    public void actualizeListenedStreamers(Map<Integer, Stream> streams, Map<Integer, StreamerOnline> streamers) {
        Stream stream;
        StreamerOnline streamer;
        for (Integer id : user.getStreams()) {
            stream = streams.get(id);
            if (!this.streamers.containsKey(stream.getStreamerId())) {
                this.streamers.put(stream.getStreamerId(), streamers.get(stream.getStreamerId()));
            }
        }
    }

    public List<Integer> listenedStreams() {
        return user.getStreams();
    }
}
