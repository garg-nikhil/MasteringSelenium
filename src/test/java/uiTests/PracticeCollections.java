package uiTests;

import java.util.*;

public class PracticeCollections {
    public static void main(String[] args) {
        collectPractice();
    }


    public static void collectPractice(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Automation",1);
        map.put("SDET",2);
        map.put("Security",2);

        for(Map.Entry<String,Integer> a: map.entrySet()){
            //System.out.println(a.getKey()+","+a.getValue());
        }

        List<String> mapKeys = new ArrayList<>();
        for(String s:map.keySet()){
            mapKeys.add(s);
        }

        Iterator<String> it = mapKeys.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }


}
