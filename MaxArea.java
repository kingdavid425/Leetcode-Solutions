/*
Leetcode Instructions: Given n non-negative integers a1, a2, ..., an , where each represents a
   point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line 
   i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
   such that the container contains the most water.
https://leetcode.com/problems/container-with-most-water/
*/


public class MaxArea {
   public static void main(String[] args) {
      int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
      
      System.out.println(maxArea(intArray));
   }
   
   public static int maxArea(int[] height) {
      int max = 0;
      int x;
        
      for(int i = 0; i < height.length - 1; i++) {
         for(int j = i + 1; j < height.length; j++) {
            if(height[i] < height[j]) {
               x = height[i] * (j - i);
               if(x > max) {
                  max = x;
               }
            } else {
               x = height[j] * (j - i);
               if(x > max) {
                  max = x;
               }            
            }
         }
      }
      
      return max;
   }
}