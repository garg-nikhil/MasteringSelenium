package utils;

public class a {
    public static void main(String[] args) {
        reve();
    }

    public static void reverseString(){
        String input = "I am an Automation Engineer";
        System.out.println("");
      String[] words = input.split(" ");
      StringBuffer ab = new StringBuffer();
      for(String a: words){
          ab.append(new StringBuffer(a).reverse()).append(" ");
      }
        System.out.println(ab);
    }

    public static void reve(){
        String input = "I am an Automation Engineer";
        String[] words = input.split(" ");
        String result = "";
        for(String a: words){
            result += reverses(a)+ " ";
        }
        System.out.println(result);
    }

    private static String reverses(String abb){
        String input = "";
        //char[] abc = input.toCharArray();
        for(int i = abb.length() -1 ;i>=0;i--){
            input += abb.charAt(i);
        }
        return input;
    }

    public static void abc(){

    }
}
