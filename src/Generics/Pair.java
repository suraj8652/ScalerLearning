package Generics;

public class Pair<T, U> {
    T first;
    U second;

    public Pair(T t, U u){
        this.first = t;
        this.second = u;
    }

    T getFirst(){
        return this.first;
    }
    void setFirst(T first){
        this.first = first;
    }

    U getSecond(){
        return this.second;
    }
    void setSecond(U second){
        this.second = second;
    }
}
