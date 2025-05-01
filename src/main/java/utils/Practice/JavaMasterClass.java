package utils.Practice;

public class JavaMasterClass {
    public static void main(String[] args) {
        displayHighScorePosition("Tim",calculateHighScorePosition(1500));
        displayHighScorePosition("Tim",calculateHighScorePosition(1000));
        displayHighScorePosition("Tim",calculateHighScorePosition(500));
        displayHighScorePosition("Tim",calculateHighScorePosition(100));
        displayHighScorePosition("Tim",calculateHighScorePosition(25));
    }



    public static void challenge() {
        double a = 20.00d;
        double b = 80.00d;
        double sum = (100 * (a + b));
        System.out.println(sum);
        double remainder = a - b;
        boolean ab = remainder == 0 ? true : false;
        System.out.println(ab);
    }

    public static void displayHighScorePosition(String name, int position){
        System.out.println(name+" managed to get into position " +position+ " on the high score list");
    }

    public static int calculateHighScorePosition(int score){
        if(score >= 1000){
            return 1;
        }else if(score >=500 && score < 1000){
            return 2;
        } else if(score >= 100 && score < 500){
            return 3;
        } else{
            return 4;
        }
    }
}
