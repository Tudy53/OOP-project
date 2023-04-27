package Application.Commands;

import Application.Database;
import Application.Stream;

public class AddStream extends StreamerCommand {
    private Integer streamType;
    private Integer streamID;
    private Integer streamGenre;
    private Long length;
    private String name;

    public AddStream(Integer streamerID, Integer streamType, Integer streamID, Integer streamGenre, Long length, String name) {
        super(streamerID);
        this.streamType = streamType;
        this.streamID = streamID;
        this.streamGenre = streamGenre;
        this.length = length;
        this.name = name;
    }

    @Override
    public void execute() {
        Stream stream = new Stream(streamType, streamID, streamGenre, 0L, streamerID, length, System.currentTimeMillis(), name);
        Database db = Database.getInstance();
        db.addStream(stream);
    }
}
