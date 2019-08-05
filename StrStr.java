/*
Leetcode instructions: Return the index of the first occurrence of needle in haystack, or -1 if
   needle is not part of haystack.
https://leetcode.com/problems/implement-strstr/
*/

public class StrStr {
   
   public static void main(String[] args){
      System.out.println(strStr("Mississippi", "pi"));   
   }
   
   public static int strStr(String haystack, String needle) {
      if(haystack.equals(needle)) {
          return 0;
      }
      
      String substring;
      int needleLength = needle.length();
        
      for(int i = 0; i <= haystack.length() - needleLength; i++) {
          substring = haystack.substring(i, i + needleLength);
            
          if(substring.equals(needle)) {
              return i;
          }
      }
        
      return -1;
   }
}