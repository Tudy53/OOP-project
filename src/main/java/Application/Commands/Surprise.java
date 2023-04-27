package Application.Commands;

import Application.User;

public class Surprise extends UserCommand {
    private String category;

    public Surprise(Integer userID, String category) {
        super(userID);
        this.category = category;
    }

    @Override
    public void execute() {

    }
}
