//leetcode link:https://leetcode.com/problems/repeated-dna-sequences/description/
//187. Repeated DNA Sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s)
    {
        class Solution {
            public List<String> findRepeatedDnaSequences(String s) {
                Set seen = new HashSet(), repeated = new HashSet();
                for (int i = 0; i + 9 < s.length(); i++) {
                    String ten = s.substring(i, i + 10);
                    if (!seen.add(ten))
                        repeated.add(ten);
                }
                return new ArrayList(repeated);
            }
        }
//Complexity
i)Time complexity:O(N)




//class Solution
//{
//public List<String> findRepeatedDnaSequences(String s)
//{
//        int n = s.length();
//     HashMap<String, Integer> ma = new HashMap<>();

//     for (int i = 0; i <= n - 10; i++) {
//         StringBuilder str = new StringBuilder();
//         for (int j = i; j < i + 10; j++) {
//             str.append(s.charAt(j));
//         }
//         ma.put(str.toString(), ma.getOrDefault(str.toString(), 0) + 1);
//     }

//     List<String> li = new ArrayList<>();
//     for (Map.Entry<String, Integer> entry : ma.entrySet()) {
//         if (entry.getValue() > 1) {
//             li.add(entry.getKey());
//         }
//     }

//     return li;
// }
// }

//explanation
        1) Intuition
        The goal of this problem is to find repeated DNA sequences of length 10 in the given string s. A straightforward approach is to iterate through all possible 10-character substrings in the string, count their occurrences, and then identify the ones that are repeated.

        2)Approach
        i) Create a HashMap<String, Integer> (ma) to store the counts of each 10-character substring encountered.
        ii) Iterate through the string s, considering substrings of length 10.
        iii) Use a nested loop to construct each 10-character substring and update its count in the ma HashMap.
        iv) After processing the entire string, iterate through the entries of the ma HashMap.
        v) If the count of a substring is greater than 1, add it to the result list li.
        vi) Return the list li containing the repeated DNA sequences.

        3)Complexity
        i)Time complexity:
        O(n⋅10)=O(n), where n is the length of the input string. The outer loop runs n−10+1 times, and the inner loop has a constant length of 10.

        ii)Space complexity:
        O(m), where m is the number of distinct 10-character substrings in the input string. In the worst case,can be n−10+1 which leads to
        O(n) space complexity. The space is used to store the counts of each substring in the HashMap.