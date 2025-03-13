package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class collections {
    public static void main(String[] args){
        collections abc = new collections();
        abc.removeElementFromUserInput();
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

        public void remove(){
            List<Integer> list1 = new ArrayList<>();
            list1.add(10);
            list1.add(20);
            list1.add(30);
            list1.add(1);
            list1.add(2);

            System.out.println("Before removing elements: "+list1);
            list1.remove(1);
            System.out.println("After removing elements: "+list1);
        }

        public void removeElementFromUserInput(){
            List<Integer> list1 = new ArrayList<>();
            list1.add(10);
            list1.add(20);
            list1.add(30);
            list1.add(1);
            list1.add(2);

            System.out.println("Before removing elements: "+list1);

            Scanner sc = new Scanner(System.in);
            int inp = sc.nextInt();

            list1.remove(inp);
            System.out.println("After removing elements: "+list1);
        }
    }

