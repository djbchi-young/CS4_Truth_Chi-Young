/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex3_truth_chiyoung;

/**
 *
 * @author crisbisnar
 */
public class Ex3_Truth_ChiYoung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Legend bodvar = new Legend("Bödvar", "Hammer", "Sword", 6, 6, 5, 5);
        Legend ada = new Legend("Ada", "Blasters", "Spear", 6, 7, 3, 6);
        Legend teros = new Legend("Teros", "Axe", "Hammer", 8, 3, 6, 5);
        
        Song jovenero = new Song("Jovenero", "AnteX", "Jovenero", "R&B", 2022);
        Song ignition = new Song("Ignition", "R. Kelly", "Ignition", "R&B", 2002);
        
        Singer martin = new Singer("GejorgE", 0, 0, ignition);
        System.out.print(martin.name);
        martin.performForAudience(12, jovenero);
        martin.changeFavSong(jovenero);
        System.out.println(martin.name + "'s favorite song is " + martin.favoriteSong.name + " by " + martin.favoriteSong.artist);
    }
    
}
