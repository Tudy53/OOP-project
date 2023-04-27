package Application;

import Application.GetInfo.ParseStreamersFile;
import Application.GetInfo.ParseStreamsFile;
import Application.GetInfo.ParseUsersFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database database;
    private Map<Integer, UserOnline> users;
    private Map<Integer, StreamerOnline> streamers;
    private Map<String, List<Integer>> streamsCategories;
    private Map<Integer, Stream> streams;

    private Database() {
        ParseUsersFile parserUsers = new ParseUsersFile();
        users = parserUsers.parseInput();
        ParseStreamersFile parserStreamers = new ParseStreamersFile();
        streamers = parserStreamers.parseInput();
        ParseStreamsFile parserStreams = new ParseStreamsFile();
        streams = parserStreams.parseInput(streamers);
        for (UserOnline userOnline : users.values()) {
            userOnline.actualizeListenedStreamers(streams, streamers);
        }
    }

    private void organizeStreams() {
        List<Integer> audioBookStreams = new ArrayList<>();
        List<Integer> podcastStreams = new ArrayList<>();
        List<Integer> musicStreams = new ArrayList<>();

        streamsCategories = new HashMap<>();
        for (Stream stream : streams.values()) {
            putStream(stream.getStreamType(), stream.getId(), audioBookStreams, podcastStreams, musicStreams);
        }
    }

    private void putStream(Integer streamType, Integer streamID, List<Integer> audioBookStreams, List<Integer> podcastStreams, List<Integer> musicStreams) {
        switch (streamType) {
            case 1:
                musicStreams.add(streamID);
                break;
            case 2:
                podcastStreams.add(streamID);
                break;
            case 3:
                audioBookStreams.add(streamID);
                break;
            default:
                System.out.println("Unknown stream type!\n");
        }
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public StreamerOnline getStreamer(Integer streamerID) {
        return streamers.get(streamerID);
    }

    public UserOnline getUser(Integer userID) {
        return users.get(userID);
    }

    public boolean isUser(Integer ID) {
        return users.containsKey(ID);
    }

    public boolean isStreamer(Integer ID) {
        return streamers.containsKey(ID);
    }

    public void addStream(Stream stream) {
        streams.put(stream.getId(), stream);
        StreamerOnline streamer = streamers.get(stream.getStreamerId());
        streamer.addStream(stream.getId());
    }

    public Stream getStream(Integer id) {
        return streams.get(id);
    }

    public static void clear() {
        database = null;
    }
}
