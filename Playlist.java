package com.example.playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Playlist implements Iterable<Song> {
    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public boolean removeSongByTitle(String title) {
        return songs.removeIf(s -> s.getTitle().equalsIgnoreCase(title));
    }

    public void shuffle() {
        Collections.shuffle(songs);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    @Override
    public Iterator<Song> iterator() {
        return songs.iterator();
    }
}
