//leetcode link:https://leetcode.com/problems/sort-characters-by-frequency/description/

class Solution
{
    public String frequencySort(String s) {
        // Count the occurence on each character
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c: s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        // Build heap
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> (cnt.get(b) - cnt.get(a)));
        heap.addAll(cnt.keySet());

        // Build string
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int i = 0; i < cnt.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// class Solution
// {
//     public String frequencySort(String s)
//     {
//         Map<Character,Integer> ma=new TreeMap<>();
//         for(int i=0;i<s.length();i++)
//         {
//             ma.put(s.charAt(i),ma.getOrDefault(s.charAt(i),0)+1);
//         }
//         StringBuilder sb=new StringBuilder();
//         for(Map.Entry<Character,Integer> m: ma.entrySet())
//         {
//           // int d=
//            int i=m.getValue();
//            while(i!=0)
//            {
//                sb.append(m.getKey());
//                i--;
//            }
//        }

//     return sb.toString();
//     }
// }

//Explanation:
//
//        Counting Occurrences: The first loop iterates over each character in the string 's' and counts the occurrences of each character using a HashMap. This step takes O(n) time, where n is the length of the string.
//
//        Building Heap: The code then builds a max heap (PriorityQueue) based on the character frequencies. The size of the heap is at most the number of unique characters in the string, which is denoted by 'k'. The heap operations (insertions and removals) take O(log k) time, and there can be at most 'k' unique characters.
//
//        Building String: The code constructs the final sorted string by repeatedly polling the characters from the heap and appending them to a StringBuilder. In the worst case, each character is appended 'cnt.get(c)' times, where 'cnt.get(c)' is the frequency of the character 'c'. This step takes O(n log k) time, where n is the length of the string.
//
//        Therefore, the overall time complexity is dominated by the building of the heap, and it is O(n log k), where k is the number of unique characters in the input string.