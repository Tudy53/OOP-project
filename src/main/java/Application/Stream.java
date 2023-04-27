package Application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stream implements Comparable<Stream> {
    private Integer streamType;
    private Integer id;
    private Integer streamGenre;
    private Long noOfStreams;
    private Integer streamerId;
    private Long length;
    private Long dateAdded;
    private String name;

    public Stream(Integer streamType, Integer id, Integer streamGenre, Long noOfStreams, Integer streamerId, Long lenght, Long dateadded, String name) {
        this.streamType = streamType;
        this.id = id;
        this.streamGenre = streamGenre;
        this.noOfStreams = noOfStreams;
        this.streamerId = streamerId;
        this.length = lenght;
        this.dateAdded = dateadded;
        this.name = name;
    }

    public Integer getStreamType() {
        return streamType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStreamerId() {
        return streamerId;
    }

    private String getDuration() {
        long HH = length / 3600;
        long MM = (length % 3600) / 60;
        long SS = length % 60;

        String res = "";
        if (HH != 0L) {
            res += HH + ":";
        }

        if (MM < 10) {
            res += "0";
        }

        res += MM + ":";

        if (SS < 10) {
            res += "0";
        }
        res += SS;

        return res;
    }

    public Long getNoOfStreams() {
        return noOfStreams;
    }

    public void increaseNoOfListenings() {
        noOfStreams++;
    }

    public String list() {
        String streamerName = Database.getInstance().getStreamer(streamerId).getName();
        String duration = getDuration();
        Date date = new Date(dateAdded * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        String dataString = simpleDateFormat.format(date);
        return "{" +
                "\"id\":\"" + id +
                "\",\"name\":\"" + name +
                "\",\"streamerName\":\"" + streamerName +
                "\",\"noOfListenings\":\"" + noOfStreams +
                "\",\"length\":\"" + duration +
                "\",\"dateAdded\":\"" + dataString +
                "\"}";
    }

    @Override
    public int compareTo(Stream o) {
        return (int) (o.getNoOfStreams() - this.noOfStreams);
    }
}
