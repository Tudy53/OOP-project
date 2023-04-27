package Application.GetInfo;

import Application.Application;
import Application.Commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseCommandsFile {
    public ParseCommandsFile() {
    }

    public List<Command> parseInput() {
        BufferedReader reader;
        List<Command> commands = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + Application.COMMANDS_FILE));
            String line = reader.readLine();

            while (line != null) {
                String[] tokens = line.split(" ");
                Command command = CommandFactory.getCommand(tokens);
                if (command != null) {
                    commands.add(command);
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return commands;
    }
}
