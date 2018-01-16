package song;

public class Song implements Comparable<Song>{

    private String title;
    private String artist;
    private String rating;
    private String bpm;

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    @Override
    public int compareTo(Song s) {
        return this.title.compareTo(s.getTitle());
    }
}
