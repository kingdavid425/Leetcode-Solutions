/*
Leetcode instructions: Given a string containing just the characters '(', ')', '{', '}', '[' and
   ']', determine if the input string is valid.
https://leetcode.com/problems/valid-parentheses/
*/

import java.util.Stack;

public class ValidParenthesis {
   public static void main(String[] args) {
      System.out.println(isValid("()[]{})"));
   }
    
   public static boolean isValid(String s) {
      Stack<Character> stack = new Stack<Character>();
      
      try {
         while(!s.isEmpty()) {
            if(s.charAt(0) == '(' || s.charAt(0) == '{' || s.charAt(0) == '[') {
               stack.push(s.charAt(0));
            } else if(s.charAt(0) == ')') {
               if(stack.pop() != '(') {
                  return false;
               }
            } else if(s.charAt(0) == '}') {
               if(stack.pop() != '{') {
                  return false;
               }
            } else if(s.charAt(0) == ']') {
               if(stack.pop() != '[') {
                  return false;
               }
            }
            
            s = s.substring(1);
         }
         if(!stack.isEmpty()) {
            return false;  
         }
         return true;
      } catch(Exception e) {
         return false;
      }
   }  
}