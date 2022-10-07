/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author crisbisnar
 */
public class Singer {
    private String name;
    private int noOfPerformances;
    private double earnings;
    private Song favoriteSong;
    private static int totalPerformances; 
    
    public Singer(String name, int noOfPerformances, double earnings, Song favoriteSong){
        this.name = name;
        this.noOfPerformances = noOfPerformances;
        this.earnings = earnings;
        this.favoriteSong = favoriteSong;
        
        totalPerformances += noOfPerformances;
    }
    
    
    public void performForAudience(int people, Song song){  //sets earnings and performances
        noOfPerformances += 1;
        earnings += people*100;
        System.out.println(" performed " + song.name + " by " + song.artist + " for " + people + " people and earned " + earnings);
        totalPerformances++;
    }
    
    public void performForAudience(int people, Song song, Singer[] partnerList){  //sets earnings and performances
        noOfPerformances += 1;
        totalPerformances++;
        earnings += people*100/(partnerList.length+1);
        System.out.print(name + " and ");
        for(int i = partnerList.length-1; i>=0; i--){
            partnerList[i].noOfPerformances++;
            partnerList[i].earnings += people*100/(partnerList.length+1);
            System.out.print(partnerList[i].getName());
            if(!(i==0)){
                System.out.print(" and ");
            }
        }
        System.out.print(" performed " + song.getName() + " by " + song.getArtist() + " for " + people + " people and earned " +  people*100/(partnerList.length+1) + " each!");
        totalPerformances++;
    }
    public void changeFavSong(Song favSong){
        favoriteSong = favSong;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public int getNoOfPerformances() {
        return noOfPerformances;
    }

    public double getEarnings() {
        return earnings;
    }

    public Song getFavoriteSong() {
        return favoriteSong;
    }
    
    public void printFavoriteSong(){
        System.out.println(name + "'s favorite song is " + favoriteSong.getName() + " by " + favoriteSong.getArtist());
    }
}
