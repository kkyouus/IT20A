
package Prelim;

import java.util.ArrayList;
import java.util.Collections;

public class FruitList {
    public static void main(String[] args) {
        
        ArrayList <String> fruits = new ArrayList<>();
        
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Guava");
        fruits.add("Coconut");
        fruits.add("Santol");
        
        Collections.sort(fruits);
        
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.print(fruits);
        
    }
}