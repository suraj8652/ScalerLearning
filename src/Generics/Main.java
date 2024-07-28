package Generics;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> p = new Pair(6, 10);
        //p.setFirst(6);
        System.out.println(p.getFirst());
        //p.setSecond(10);
        System.out.println(p.getSecond());
    }

}

