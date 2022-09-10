/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex3_truth_chiyoung;

/**
 *
 * @author crisbisnar
 */
public class Singer {
    public String name;
    public int noOfPerformances;
    public double earnings;
    public Song favoriteSong;
    
    public void performForAudience(int people, Song song){
        noOfPerformances += 1;
        earnings += people*100;
        System.out.println(" performed " + song.name + " by " + song.artist + " for " + people + " people and earned " + earnings);
    }
    public void changeFavSong(Song favSong){
        favoriteSong = favSong;
    }
    
    public Singer(String n, int no, double e, Song favSong){
        name = n;
        noOfPerformances = no;
        earnings = e;
        favoriteSong = favSong;
    }
}
