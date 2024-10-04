public class Solution {

  public boolean isPalindrome(String s) {
    for (int low = 0, high = s.length() - 1;; low++, high--) {
      char cLow = 0, cHigh = 0;

      // Find the next acceptable character for the increasing index.
      while (low < high && !Character.isLetterOrDigit(cLow = s.charAt(low))) {
        low++;
      }

      // Find the previous acceptable character for the decreasing index.
      while (low < high && !Character.isLetterOrDigit(cHigh = s.charAt(high))) {
        high--;
      }

      if (low >= high) {
        // All previous character comparisons succeeded and we have a palindrome.
        return true;
      }

      if (Character.toUpperCase(cLow) != Character.toUpperCase(cHigh)) {
        // This is not a palindrome.
        return false;
      }
    }
  }
}
