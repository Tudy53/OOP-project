package Application.GetInfo;

import Application.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ParseUsersFile {

    public ParseUsersFile() {
    }

    public Map<Integer, UserOnline> parseInput() {
        BufferedReader reader;
        Map<Integer, UserOnline> users = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + Application.USERS_FILE));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                String[] tokens = line.replace("\"", "").split(",", 3);
                Integer IDUser = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                String[] streamsStringsIDs = tokens[2].split(" ");
                List<Integer> streamsIds = new ArrayList<>();
                for (String stringID : streamsStringsIDs) {
                    streamsIds.add(Integer.parseInt(stringID));
                }

                UserOnline user = new UserOnline(new User(IDUser, name, streamsIds));
                users.put(IDUser, user);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
