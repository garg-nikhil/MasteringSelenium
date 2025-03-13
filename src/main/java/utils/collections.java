package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class collections {
    public static void main(String[] args){
        collections abc = new collections();
        abc.temp();
    }

    public void listing(){
        List<String> list = new ArrayList<>();
        list.add("Linkedlist");
        list.add("ArrayList");
        list.add("Vector");

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        for(String str:list){
            System.out.println(str);
        }
    }

    //list - arraylist, linkedlist, vector
    //set - hashset, linkedhashset, treeset
    //queue - priorityqueue, linkedlist
    //map - hashmap, linkedhashmap, treemap

    public void temp(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(18);
        list.add(4);
        list.add(6);

        for(Integer i:list){
            System.out.println(i);
        }

        int minimum = Collections.min(list);
        int maximum = Collections.max(list);

        if(minimum == maximum) {
            System.out.println("Minimum and Maximum are same");
        }else
            {
                System.out.println("Minimum element: "+minimum);
                System.out.println("Maximum element: "+maximum);
            }
        }
    }

