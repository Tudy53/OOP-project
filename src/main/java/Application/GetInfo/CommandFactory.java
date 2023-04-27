package Application.GetInfo;

import Application.Commands.*;
import Application.Database;

public class CommandFactory {
    static Command getCommand(String[] tokens) {
        Integer ID = Integer.parseInt(tokens[0]);
        String commandString = tokens[1];
        switch (commandString) {
            case "ADD":
                return getAddStreamCommand(tokens);
            case "LIST":
                return getListCommand(tokens);
            case "DELETE":
                return new DeleteStream(ID, Integer.parseInt(tokens[2]));
            case "LISTEN":
                return new ListenStream(ID, Integer.parseInt(tokens[2]));
            case "RECOMMEND":
                return new Recommend(ID, tokens[2]);
            case "SURPRISE":
                return new Surprise(ID, tokens[2]);
            default:
                System.out.println("Command " + commandString + " does not exist!\n");
                return null;
        }
    }

    private static Command getAddStreamCommand(String[] tokens) {
        Integer ID = Integer.parseInt(tokens[0]);
        Integer streamType = Integer.parseInt(tokens[2]);
        Integer streamID = Integer.parseInt(tokens[3]);
        Integer streamGenre = Integer.parseInt(tokens[4]);
        Long length = Long.parseLong(tokens[5]);
        String name = tokens[6];
        return new AddStream(ID, streamType, streamID, streamGenre, length, name);
    }

    private static Command getListCommand(String[] tokens) {
        Integer ID = Integer.parseInt(tokens[0]);
        Database db = Database.getInstance();
        if (db.isUser(ID)) {
            return new ListStreamsUser(ID);
        }

        if (db.isStreamer(ID)) {
            return new ListStreams(ID);
        }

        System.out.println("This ID does not exist!\n");
        return null;
    }
}
