
package Prelim;


public class TwoDimentionalArrayWithSum {
    public static void main(String[] args) {
        
        int sum = 0;
        
        int marks[][]={
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < marks.length; i++){
            for (int j = 0; j< marks[i].length; j++){
                System.out.print(marks[i][j] + " ");
                sum += marks[i][j];
            }
            System.out.println();
        }
        System.out.println("The sum of all elements: " + sum);      
    }
}
