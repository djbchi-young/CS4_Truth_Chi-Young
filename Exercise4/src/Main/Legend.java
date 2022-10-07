/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author crisbisnar
 */
public class Legend {
    private String name;
    private String weaponOne;
    private String weaponTwo;
    private int strength, dexterity, armor, speed;
    
    public Legend(String name, String weaponOne, String weaponTwo, int strength, int dexterity, int armor, int speed){
        this.name = name;
        this.weaponOne = weaponOne;
        this.weaponTwo = weaponTwo;
        this.strength = strength;
        this.dexterity = dexterity;
        this.armor = armor;
        this.speed = speed;
    }    
    public String getName() {
        return name;
    }

    public String getWeaponOne() {
        return weaponOne;
    }

    public String getWeaponTwo() {
        return weaponTwo;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getArmor() {
        return armor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponOne(String weaponOne) {
        this.weaponOne = weaponOne;
    }

    public void setWeaponTwo(String weaponTwo) {
        this.weaponTwo = weaponTwo;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
}
