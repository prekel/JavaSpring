import entities.Computer;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello world");

        var a = new ArrayList<Computer>();

        for (var i : a) {
            System.out.println(i);
        }
    }
}
