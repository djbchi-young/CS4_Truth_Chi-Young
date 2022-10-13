/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author TRUTH
 */
public class Store {
  private String name;
  private double earnings;
  private ArrayList<Item> itemList;
  private static ArrayList<Store> storeList = new ArrayList();

  public Store(String name){
    this.name = name;
    itemList = new ArrayList();
    storeList.add(this);
  }

  public String getName(){
    return name;
  }
  public double getEarnings(){
    return earnings;
  }
  public void sellItem(int index){
    if(index < itemList.size()){
        Item item = itemList.get(index);
        earnings += item.getCost();
        System.out.printf("%s has sold %s.\n", this.name, item.getName());
	}
    else{System.out.printf("There are only %d items in %s.\n", itemList.size(), name);}
  }
  public void sellItem(String name){
      boolean hasItem = false;
      for (Item item : itemList){
          if(item.getName().equals(name)){
            hasItem = true;
            earnings += item.getCost();
            System.out.printf("%s has sold %s.\n", this.name, name);
          }
      }
      if(!hasItem){
          System.out.printf("%s does not sell %s.\n", this.name, name);
      }
  }
  public void sellItem(Item i){
    // check if Item i exists in the store (there is a method that can help with this) (if not, print statement that the store doesn't sell it)
    // get Item i from itemList and add its cost to earnings
    // print statement indicating the sale
    if(itemList.contains(i)){
        earnings += i.getCost();
        System.out.println(i.getName() + " has been sold.");
    }
    else{
        System.out.printf("%s does not sell %s.\n", name, i.getName());
    }
    
  }
  public void addItem(Item i){
      itemList.add(i);
  }
  public void filterType(String type){
    for(Item item : itemList){
          if(item.getName().equals(type)){
              System.out.println(item.getName());
          }
      }
  }
  public void filterCheap(double maxCost){
      for(Item item : itemList){
          if(item.getCost() <= maxCost){
              System.out.println(item.getName());
          }
      }
  }
  public void filterExpensive(double minCost){
      for(Item item : itemList){
          if(item.getCost() >= minCost){
              System.out.println(item.getName());
          }
      }
  }
  public static void printStats(){
    // loop over storeList and print the name and the earnings
    for(Store store : storeList){
        System.out.printf("%s has earned %.2f.\n", store.getName(), store.getEarnings());
    }
  }
}
