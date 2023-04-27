package Application.Commands;

import Application.Database;
import Application.StreamerOnline;

public abstract class StreamerCommand implements Command{
    protected Integer streamerID;
    protected StreamerOnline streamer;

    public StreamerCommand(Integer streamerID) {
        this.streamerID = streamerID;
        streamer = Database.getInstance().getStreamer(streamerID);
    }
}
