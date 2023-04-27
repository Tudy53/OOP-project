package Application;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private List<Integer> streams;

    public User(Integer id, String name, List<Integer> streams) {
        this.id = id;
        this.name = name;
        this.streams = streams;
    }

    public String listStreams() {
        StringBuilder res = new StringBuilder("[");
        Stream stream;
        Database db = Database.getInstance();
        for (Integer id : streams) {
            stream = db.getStream(id);
            res.append(stream.list()).append(",");
        }

        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public List<Integer> getStreams() {
        return streams;
    }

    public void listen(Integer streamID) {
        streams.add(streamID);
    }
}
