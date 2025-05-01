package utils.Practice;

public class MySingleton {

    private static MySingleton instance;
    private MySingleton(){};

    public static MySingleton getInstance(){
        if(instance == null){
            instance =  new MySingleton();
        }
        return instance;
    }

}

enum browserType{
    CHROME,
    EDGE,
    FIREFOX,
    SAFARI
}