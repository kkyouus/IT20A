
package Prelim;


public class TwoDimentionalArray {
    public static void main(String[] args) {
        int marks[][]= {
            {77, 85, 68, 99, 67},
            {98, 56, 79, 90, 92},
            {78, 68, 56, 70, 99}      
        };
        
        marks[1][2] = 84;
        
        for (int i = 0; i < marks.length; i++){
            for (int j = 0; j < marks[i].length; j++){
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        } 
    }   
}
