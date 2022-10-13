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
        earnings += itemList.get(index).getCost();
        System.out.println(itemList.get(index).getName() + " has been sold.");
	}
    else{System.out.println("There are only " + itemList.size() + " items in the store.");}
  }
  public void sellItem(String name){
      boolean hasItem = false;
      for (Item item : itemList){
          if(item.getName().equals(name)){
            hasItem = true;
            earnings += item.getCost();
            System.out.println(item.getName() + " has been sold.");
          }
      }
      if(!hasItem){
          System.out.printf("The store does not sell %s.\n", name);
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
        System.out.println("That store does not sell that item");
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
    // loop over storeList and print the name and the earnings'Store.java'
    for(Store store : storeList){
        System.out.println(store.getName() + " has earned " + store.getEarnings());
    }
  }
}
