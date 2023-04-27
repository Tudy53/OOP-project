package Application.Commands;

import Application.UserOnline;

public class ListStreamsUser extends UserCommand {

    public ListStreamsUser(Integer userID) {
        super(userID);
    }

    @Override
    public void execute() {
        UserOnline user = super.user;
        System.out.println(user.listStreams());
    }
}
