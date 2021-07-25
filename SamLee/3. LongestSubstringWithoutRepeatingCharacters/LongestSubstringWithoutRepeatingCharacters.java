import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters
{
   public static int lengthOfLongestSubstring(String s) {
      int i=0,j=0;
      int max=0;
        //hash set declaring
      HashSet<Character> hash = new HashSet();
      while(j<s.length()){
            //if a character not presents in hash set
         if(!hash.contains(s.charAt(j))){
                //add to hashset
            hash.add(s.charAt(j));
            j++;
                //finding maximum
            max = Math.max(hash.size(),max);
         }
            //if element is already present in hash
         else
         {
                //we remove the element at i
            hash.remove(s.charAt(i));
            i++;
         }
      }
      return max;
   }
   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(""));
   }
}