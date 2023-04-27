package Application.GetInfo;

import Application.Application;
import Application.StreamerOnline;
import Application.Streamer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParseStreamersFile {
    public ParseStreamersFile() {
    }

    public Map<Integer, StreamerOnline> parseInput() {
        BufferedReader reader;
        Map<Integer, StreamerOnline> streamers = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + Application.STREAMERS_FILE));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                String[] tokens = line.replace("\"", "").split(",", 3);
                Integer streamerType = Integer.parseInt(tokens[0]);
                Integer streamerID = Integer.parseInt(tokens[1]);
                String name = tokens[2];
                StreamerOnline streamer = new StreamerOnline(new Streamer(streamerType, streamerID, name));
                streamers.put(streamerID, streamer);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return streamers;
    }
}
