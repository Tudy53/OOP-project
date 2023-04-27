package Application.Commands;

import Application.Database;
import Application.StreamerOnline;

public class ListStreams extends StreamerCommand {

    public ListStreams(Integer streamerID) {
        super(streamerID);
    }

    @Override
    public void execute() {
        StreamerOnline streamer = super.streamer;
        System.out.println(streamer.listStreams());
    }
}
