package com.example.playlist;

public class Song {
    private final String title;
    private final String artist;
    private final double duration;

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + duration + ")";
    }
}
