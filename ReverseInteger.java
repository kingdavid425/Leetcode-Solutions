/*
Leetcode instructions: Given a 32-bit signed integer, reverse digits of an integer.
https://leetcode.com/problems/reverse-integer/
*/

public class ReverseInteger {

	public static void main(String[] args) {
      int input = 123456789;
   
      System.out.println(reverse(input));
   }
   
   public static int reverse(int x) {
      int reverseX;
        
      reverseX = x % 10;
      x /= 10;
        
      while(x != 0) {
         if(reverseX > Integer.MAX_VALUE / 10) {
            return 0;
         }
         if(reverseX < Integer.MIN_VALUE / 10) {
            return 0;
         }
         reverseX *= 10;               
         reverseX += x % 10;
         x /= 10;
      }
        
      return reverseX;
    }
}  