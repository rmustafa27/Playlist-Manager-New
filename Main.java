package com.example.playlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        System.out.println("Welcome to the Playlist Manager!");
        while (true) {
            System.out.print("Type 'add', 'remove', or 'done': ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command.equals("add")) {
                System.out.print("Song title: ");
                String title = scanner.nextLine().trim();
                System.out.print("Artist: ");
                String artist = scanner.nextLine().trim();
                System.out.print("Duration (min.sec): ");
                double duration = Double.parseDouble(scanner.nextLine().trim());
                playlist.addSong(new Song(title, artist, duration));
            } else if (command.equals("remove")) {
                System.out.print("Song title to remove: ");
                String title = scanner.nextLine().trim();
                if (!playlist.removeSongByTitle(title)) {
                    System.out.println("Song not found.");
                }
            } else if (command.equals("done")) {
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }

        playlist.shuffle();
        System.out.println("\nHere is your playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }
}
