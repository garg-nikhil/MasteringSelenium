package utils;

public class SampleJavaCode {
    public static void main(String[] args){
        SampleJavaCode abc = new SampleJavaCode();
        abc.sum();
    }

    public void sum(){
        int a = 10;
        int b = 20;
        System.out.println(a+b);
    }

    public void printStarsInReverse(){
        for(int i=5;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printStars(){
        for(int i=0;i<=5;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
