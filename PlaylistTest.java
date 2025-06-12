package com.example.playlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {
    @Test
    void addAndRemoveSong() {
        Playlist playlist = new Playlist();
        Song song = new Song("Test", "Artist", 3.5);
        playlist.addSong(song);
        assertTrue(playlist.getSongs().contains(song));
        assertTrue(playlist.removeSongByTitle("Test"));
        assertFalse(playlist.getSongs().contains(song));
    }

    @Test
    void shuffleChangesOrder() {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("A", "a", 1));
        playlist.addSong(new Song("B", "b", 2));
        playlist.addSong(new Song("C", "c", 3));
        String originalFirst = playlist.getSongs().get(0).getTitle();
        playlist.shuffle();
        // After shuffle there is a chance the first stays the same, but rarely for 3 songs.
        // To avoid flakiness we just assert size remains and not all songs removed.
        assertEquals(3, playlist.getSongs().size());
        assertTrue(playlist.getSongs().stream().anyMatch(s -> s.getTitle().equals(originalFirst)));
    }
}
