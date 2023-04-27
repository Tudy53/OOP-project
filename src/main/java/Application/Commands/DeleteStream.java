package Application.Commands;

public class DeleteStream extends StreamerCommand {
    private Integer streamID;

    public DeleteStream(Integer streamerID, Integer streamID) {
        super(streamerID);
        this.streamID = streamID;
    }


    @Override
    public void execute() {

    }
}
