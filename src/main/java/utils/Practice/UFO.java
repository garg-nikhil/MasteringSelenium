package utils.Practice;

public class UFO implements Spaceship{

    static int speed =0;


    public void takeOff() {
        speed = 1;
        System.out.println("UFO is taking off!");
    }

    public void dock() {
        System.out.println("UFO is docking!");
    }
}
