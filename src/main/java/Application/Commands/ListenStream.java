package Application.Commands;

import Application.*;

public class ListenStream extends UserCommand {
    private Integer streamID;

    public ListenStream(Integer userID, Integer streamID) {
        super(userID);
        this.streamID = streamID;
    }

    @Override
    public void execute() {
        UserOnline user = super.user;
        Stream stream = Database.getInstance().getStream(streamID);
        stream.increaseNoOfListenings();
        StreamerOnline streamer = Database.getInstance().getStreamer(stream.getStreamerId());
        user.listen(streamID, streamer);
    }
}
