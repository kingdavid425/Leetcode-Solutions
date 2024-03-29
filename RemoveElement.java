/*
Leetcode instructions: 
   Given an array nums and a value val, remove all instances of that value in-place and return the new length.
   Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
https://leetcode.com/problems/remove-element/
*/
import java.util.Arrays;

public class RemoveElement {
	public static void main(String[] args) {
      int a[] = {33, 3, 4, 5};
      System.out.println(removeElement(a, 3));
      System.out.println(Arrays.toString(a)); 
   }
   
   public static int removeElement(int[] nums, int val) {
      int size = nums.length;
      int j = 0;
        
      for(int i = 0; i < nums.length; i++) {
         if(nums[i] != val) {
             nums[j] = nums[i];
             j++;
         } else {
             size--;
         }   
      } 
      return size;
   }
}