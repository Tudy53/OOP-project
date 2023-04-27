package Application.GetInfo;

import Application.Application;
import Application.Stream;
import Application.StreamerOnline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParseStreamsFile {

    public ParseStreamsFile() {
    }

    public Map<Integer, Stream> parseInput(Map<Integer, StreamerOnline> streamers) {
        BufferedReader reader;
        Map<Integer, Stream> streams = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + Application.STREAMS_FILE));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                String[] tokens = line.replace("\"", "").split(",", 8);
                Integer streamType = Integer.parseInt(tokens[0]);
                Integer streamID = Integer.parseInt(tokens[1]);
                Integer streamGenre = Integer.parseInt(tokens[2]);
                Long noOfStreams = Long.parseLong(tokens[3]);
                Integer streamerID = Integer.parseInt(tokens[4]);
                Long length = Long.parseLong(tokens[5]);
                Long dateAdded = Long.parseLong(tokens[6]);
                String name = tokens[7];
                Stream stream = new Stream(streamType, streamID, streamGenre, noOfStreams, streamerID, length, dateAdded, name);
                streams.put(streamID, stream);
                StreamerOnline streamer = streamers.get(streamerID);
                streamer.addStream(streamID);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return streams;
    }
}
