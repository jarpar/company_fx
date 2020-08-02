package tests;

public class Camel implements Rideable {
    int weight = 2;
    @Override
    public String getGait() {
        return " mph, lope";
    }
    //    String getGait() { return " mph, lope"; }
    void go(int speed) {
        ++speed;
        weight++;
        int walkrate = speed * weight;
        System.out.print(walkrate + getGait());
    }
    public static void main(String[] args) {
        new Camel().go(8);
    }
}