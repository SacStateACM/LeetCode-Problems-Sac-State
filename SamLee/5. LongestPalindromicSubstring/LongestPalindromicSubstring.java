public class LongestPalindromicSubstring
{
    /**
     * main method which call the longestPalindrome method
     */
   public static void main(String[] args) {
      try{
                /**
                 * you can call this method multiple time in the main method and other class
                 */ 
         System.out.println(longestPalindrome("babad"));
         System.out.println(longestPalindrome("cbbd"));
         System.out.println(longestPalindrome("a"));
         System.out.println(longestPalindrome("ac"));
      }
      catch(AssertionError e)
      {
         System.out.println("Error: " + e);
      }
   }
        
         
     /** 
         * find the mirror string in the given string
         * @param array it take string which length is not 0
         * @return String, length of mirror string, mirror means which reverse values also present in the original string
         * time complexity is approximate O(n^3) and space complexity is O(n), where n is the size of the array
         */
   public static String longestPalindrome(String array) 
   {
      if(array.length() < 1 || array.length() > 1000)
         throw new AssertionError("Assertion Error, invalid string");
      else
      {
         String localCount = "";
         String finalCount = "";
         for( int index = 0; index < array.length(); index++)
         {
                 
                 /**
                  * check values from the right side of the array, if values are equal then start updating local and final count according to the condition
                  */
            for(int innerIndex = array.length() - 1; innerIndex >= 0; innerIndex--)
            {
                     /**
                      * if left and right index character area same the then check the next characters
                      */
               if(array.charAt(index) == array.charAt(innerIndex))
               {
                  localCount = "";
                                 
                                 /**
                                  * run loop from starting to the last - index values, it means if index is 0 then loop 0 to length - 1 or if index 1 then then loop 0 to length-2 
                                  */
                  for(int kIndex = 0; kIndex <= array.length() - index; kIndex++)
                  {
                                         
                                         /**
                                          * first and second condition are boundary condition, they will help when all overall string is mirror string 
                                          * and 3rd condition for check value form mirror or not, its reverse of string is same with original, if follow all condition then 
                                          * Increment local count string
                                          */
                     if((index + kIndex < array.length()) && (innerIndex - kIndex >= 0) && (array.charAt(index + kIndex) == array.charAt(innerIndex - kIndex)))
                        localCount += array.charAt(index + kIndex);
                     else
                        break;
                  }
                                 
                                 // if local count is greater then final count then update
                  if(localCount.length() > finalCount.length())
                     finalCount = localCount;
               }
            }
         }
         return finalCount;
      }
   }
}