
package Prelim;


public class Array {
    public static void main(String[] args) {
        
        int numbers[] = {1, 2, 3, 4, 5};
        
        numbers[4] = 6;
        
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
            
        }
        
        System.out.println("Array length: " + numbers.length);
    }
    
}
