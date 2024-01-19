//leetcode link:https://leetcode.com/problems/find-the-winner-of-the-circular-game/
class Solution {
    public int findTheWinner(int n, int k)
    {
        Queue<Integer> qu = new LinkedList<>();

        // Fill the queue with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }

        // Simulate the elimination process
        while (qu.size() > 1) {
            for (int i = 1; i < k; i++) {
                // Rotate the queue by skipping the first element
                qu.add(qu.poll());
            }

            // Remove the k-th person from the queue
            qu.poll();
        }

        // Return the remaining person, who is the winner
        return qu.peek();
    }
}