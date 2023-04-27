package Application.Commands;

import Application.Database;
import Application.User;
import Application.UserOnline;

public abstract class UserCommand implements Command {
    protected Integer userID;
    protected UserOnline user;

    public UserCommand(Integer userID) {
        this.userID = userID;
        user = Database.getInstance().getUser(userID);
    }
}
