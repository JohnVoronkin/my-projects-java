package ru.simple.java.test.List;

import song.Song;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Jukebox {

    private ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args) {
        new Jukebox().go();
    }

    class ArtistCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public void go() {
        getSongs();
        System.out.println("Без сортировки: " + songList);

        Collections.sort(songList);
        System.out.println("Сортировка title: " + songList);

        ArtistCompare artistCompare = new ArtistCompare();

        Collections.sort(songList, artistCompare);
        System.out.println("Сортировка artist: " + songList);
    }

    void getSongs() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(Objects.requireNonNull(getClass()
                            .getClassLoader().getResource("SongList.txt")).getFile()));
            String line;
            while ((line = reader.readLine()) != null) addSong(line);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(new Song(tokens[0], tokens[1], tokens[2], tokens[3]));
    }


}
