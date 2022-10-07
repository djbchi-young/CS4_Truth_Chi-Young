/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author crisbisnar
 */
public class Song {
    public String name, album, artist, genre;
    private int yearReleased;
    
    public Song(String name, String artist, String album, String genre, int yearReleased){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.yearReleased = yearReleased;
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }
    
    
}
