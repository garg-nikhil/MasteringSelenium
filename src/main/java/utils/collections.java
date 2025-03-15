package utils;

import java.util.*;

public class collections {
    public static void main(String[] args){
        collections abc = new collections();
        abc.toList();
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

        public void replaceElementFromUserInput(){
         List<Integer> a = new ArrayList<>();
            a.add(10);
            a.add(20);
            a.add(100);
            a.add(1);

            System.out.println("Before replacing elements: "+a);
            a.set(1,30);
            System.out.println("after replacing elements: "+a);
            Scanner sc = new Scanner(System.in);
            //sc.nextInt();
            //sc.nextInt();
            //sc.close();
            a.set(sc.nextInt(),sc.nextInt());
            System.out.println("after replacing elements: "+a);
        }

        public void toList(){
        String[] arr = {"abc","def","ghi","jkl"};
        System.out.println("before converting it to list: "+ Arrays.toString(arr));

        List<String> list = Arrays.asList(arr);
        System.out.println("After converting it to list: "+list);
        List<String> list2 = new ArrayList<>(Arrays.asList(arr));

        list2.add("mno");
        System.out.println("After converting it to list: "+list2);
        }
    }

