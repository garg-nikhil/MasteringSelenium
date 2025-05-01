package utils.Practice;

import java.util.HashMap;
import java.util.Map;

public class StingOperations {
    public static void main(String[] args) {
        aweStrings();
    }

    public static void aweStrings(){
        String a = "aabbcdefffff";
        HashMap<Character, Integer> ab = new HashMap<>();
        for(char abc:a.toCharArray()){
            ab.put(abc,ab.getOrDefault(abc,0)+1);
        }

        for(Map.Entry<Character, Integer> abcd: ab.entrySet()){
            System.out.println(abcd.getKey()+":"+abcd.getValue());
        }
    }
}
