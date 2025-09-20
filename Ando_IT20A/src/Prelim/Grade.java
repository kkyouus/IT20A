
package Prelim;

import java.util.Stack;

public class Grade {
    public static void main(String[] args) {
        Stack <Integer> grade = new Stack<>();
        
        grade.push(75);
        grade.push(89);
        grade.push(90);
        
        System.out.println(grade);
        
        System.out.println(grade.pop());
        
        System.out.println(grade);
        
        System.out.println(grade.peek());
        
        System.out.println(grade);
        
        System.out.println(grade.search(75));
        
        System.out.println(grade.size());
        
        grade.clear();
        System.out.println(grade);
        
    }
    
}
