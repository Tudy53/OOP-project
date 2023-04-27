package Application.Commands;

import Application.Database;
import Application.Stream;
import Application.StreamerOnline;
import Application.UserOnline;

import java.util.*;

public class Recommend extends UserCommand {
    private Integer category;

    public Recommend(Integer userID, String category) {
        super(userID);
        if ("SONG".equals(category)) {
            this.category = 1;
        }
        if ("PODCAST".equals(category)) {
            this.category = 2;
        }
        if ("AUDIOBOOK".equals(category)) {
            this.category = 3;
        }
    }


    @Override
    public void execute() {
        UserOnline user = super.user;
        Database db = Database.getInstance();
        SortedSet<Stream> allStreamsFromListenedStreamers = new TreeSet<>();
        Stream stream;
        for (StreamerOnline streamer : user.getStreamers().values()) {
            if (streamer.getCategory().compareTo(category) == 0) {
                for (Integer idStream : streamer.getStreams()) {
                    stream = db.getStream(idStream);
                    allStreamsFromListenedStreamers.add(stream);
                }
            }
        }

        int nr = 0;
        List<Stream> recommendStreams = new ArrayList<>();
        Iterator<Stream> iterator = allStreamsFromListenedStreamers.iterator();
        while (nr < 5 && iterator.hasNext()) {
            stream = iterator.next();
            if (!user.listenedStreams().contains(stream.getId())) {
                recommendStreams.add(stream);
                nr++;
            }
        }

        System.out.println(showRecommended(recommendStreams));
    }

    private String showRecommended(List<Stream> recommendStreams) {
        StringBuilder res = new StringBuilder("[");
        for (Stream stream : recommendStreams) {
            res.append(stream.list()).append(",");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");

        return res.toString();
    }
}
