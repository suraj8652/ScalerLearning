package addSubtractUsingSynchronisedMethod;

public class Count {
    int value;

    public synchronized void addValue(int i){
        value += i;

    }

    public int getValue(){
        return value;
    }

}
