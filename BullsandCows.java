/*
Intuition
The problem seems to involve finding the number of bulls and cows in a guessing game, where bulls represent correct digits in the correct positions, and cows represent correct digits in incorrect positions. The solution likely requires iterating through the strings and keeping track of counts.

Approach
Initialization: Initialize variables for the length of the strings (n and m) and a counter for bulls (bull). Check if the lengths of the strings are equal; if not, return an empty string.
Bulls: Iterate through the strings, find and count the number of bulls (matching digits in the same positions). Update a dictionary (dict) to keep track of the counts of digits not in the correct positions.
Remove Bulls: Create new StringBuilders (modifiedSec and modifiedGu) to store the modified strings without the bulls. Iterate through the strings, adding characters not associated with bulls to the new StringBuilders.
Cows: Iterate through the modified string for the guess (modifiedGu) and count cows (matching digits in incorrect positions) by checking against the dictionary. Update the dictionary accordingly.
Build Result String: Construct a result string by appending the count of bulls, 'A', the count of cows, and 'B' to a StringBuilder (finanswer).
Return Result: Return the result as a string.
Complexity
Time complexity: O(n), where 'n' is the length of the input strings. The algorithm iterates through the strings once.
Space complexity: O(n), where 'n' is the length of the input strings. The space is used for StringBuilders and the dictionary.
 */

class Solution {
    public String getHint(String secret, String guess)
    {
        int n = secret.length();
        int m = guess.length();
        int bull = 0;

        if (n != m) {
            return new String();
        }

        StringBuilder sec = new StringBuilder(secret);
        StringBuilder gu = new StringBuilder(guess);

        HashMap<Character, Integer> dict = new HashMap<>();

        // Find bulls
        for (int i = 0; i < n; i++) {
            if (sec.charAt(i) == gu.charAt(i)) {
                bull++;
            } else {
                dict.put(secret.charAt(i), dict.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        // Create new StringBuilders for modified strings
        StringBuilder modifiedSec = new StringBuilder();
        StringBuilder modifiedGu = new StringBuilder();

        // Remove characters associated with bulls
        for (int i = 0; i < n; i++) {
            if (sec.charAt(i) != gu.charAt(i)) {
                modifiedSec.append(sec.charAt(i));
                modifiedGu.append(gu.charAt(i));
            }
        }

        int cow = 0;

        // Count cows
        for (int i = 0; i < modifiedGu.length(); i++) {
            if (dict.containsKey(modifiedGu.charAt(i)) && dict.get(modifiedGu.charAt(i)) > 0) {
                cow++;
                dict.put(modifiedGu.charAt(i), dict.get(modifiedGu.charAt(i)) - 1);
            }
        }

        StringBuilder finanswer = new StringBuilder();
        finanswer.append(bull);
        finanswer.append('A');
        finanswer.append(cow);
        finanswer.append('B');

        return finanswer.toString();
    }
}