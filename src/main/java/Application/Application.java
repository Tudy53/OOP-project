package Application;

import Application.Commands.Command;
import Application.GetInfo.ParseCommandsFile;

import java.util.List;


public class Application {
    public static String STREAMERS_FILE;
    public static String STREAMS_FILE;
    public static String USERS_FILE;
    public static String COMMANDS_FILE;
    private List<Command> commands;

    public Application() {
        Database.clear();
    }
    public void start(String StreamersCSV, String StreamsCSV, String UsersCSV, String CommandsTXT) {
        STREAMERS_FILE = StreamersCSV;
        STREAMS_FILE = StreamsCSV;
        USERS_FILE = UsersCSV;
        COMMANDS_FILE = CommandsTXT;

        Database db = Database.getInstance();
        ParseCommandsFile parserCommands = new ParseCommandsFile();
        commands = parserCommands.parseInput();

        for (Command command : commands) {
            command.execute();
        }
    }
}
