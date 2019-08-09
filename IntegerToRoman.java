/*
Leetcode instructions: Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
https://leetcode.com/problems/integer-to-roman/
*/

public class IntegerToRoman {

	public static void main(String[] args) {
      System.out.println(intToRoman(100));
   }
   
   public static String intToRoman(int num) {
      String answer = "";
      int divider = 1000;
      int x; // = num / divider;
      
      if(num == 0) {
         return "";
      }
      
      while(num != 0) {
         x = num / divider;
         //x *= divider;
         
         if(divider == 1000) {
            while(x != 0) {
               answer += "M";
               x--;
            }
         } else if(divider == 100) {
            if(x >= 9) {
               while(x >= 9) {
                  answer += "C";
                  x--;
               }
               answer += "M";
            } else if(x >= 5) {
               answer += "D";
               while(x > 5) {
                  answer += "C";
                  x--;
               }
            } else if(x >= 4) {
               while(x >= 4) {
                  answer += "C";
                  x--;
               }
               answer += "D";
            } else {
               while(x > 0) {
                  answer += "C";
                  x--;
               }
            }        
         } else if(divider == 10) {
            if(x >= 9) {
               while(x >= 9) {
                  answer += "X";
                  x--;
               }
               answer += "C";
            } else if(x >= 5) {
               answer += "L";
               while(x > 5) {
                  answer += "X";
                  x--;
               }
            } else if(x >= 4) {
               while(x >= 4) {
                  answer += "X";
                  x--;
               }
               answer += "L";
            } else {
               while(x > 0) {
                  answer += "X";
                  x--;
               }
            }              
         } else {
            if(x >= 9) {
               while(x >= 9) {
                  answer += "I";
                  x--;
               }
               answer += "X";
            } else if(x >= 5) {
               answer += "V";
               while(x > 5) {
                  answer += "I";
                  x--;
               }
            } else if(x >= 4) {
               while(x >= 4) {
                  answer += "I";
                  x--;
               }
               answer += "V";
            } else {
               while(x > 0) {
                  answer += "I";
                  x--;
               }
            } 
            
         }
         
         num = num % divider;
         divider /= 10; 
      }
      
      return answer;
   }  
}