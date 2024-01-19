//leetcode link:https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
class Solution {
     public int numberOfWays(int startPos, int endPos, int k)
    {

        return numways(startPos,endPos,k);

    }
    public int numways(int start,int end,int k)
    {
        if(start==end && k==0)
        {
            return 1;
        }
        if(k== 0 && start!=end)
        {
            return 0;
        }

         int take=numways(start-1,end,k-1);
        int notake=numways(start+1,end,k-1);
        return (take+notake)%1000000007;

    }
}

//Here's an explanation of the code:
//
//1) Method numberOfWays:
//
//This is the public method that is initially called with the provided starting position (startPos), ending position (endPos), and the number of steps (k).
//It calls the private recursive method numways with the same parameters and returns its result.
//2) Method numways:
//
//This is the recursive method responsible for calculating the number of ways to reach the ending position from the current position with the remaining steps.
//The base cases are:
//If the current position (start) is equal to the ending position (end) and there are no remaining steps (k is 0), there is exactly one way to reach the end, so it returns 1.
//If there are no remaining steps (k is 0) and the current position is not equal to the ending position, there is no way to reach the end, so it returns 0.
//The method then recursively calls itself twice:
//take: Moves one step to the left (start - 1) with one fewer remaining step (k - 1).
//notake: Moves one step to the right (start + 1) with one fewer remaining step (k - 1).
//The result is the sum of take and notake (the total number of ways to reach the end from the current position), and it returns this sum modulo 1000000007.
//Explanation:
//
//The recursive approach explores all possible combinations of moves to find the total number of ways to reach the end from the given starting position with the specified number of steps.
//The modulo operation is used to prevent integer overflow and keep the result within a manageable range.
//Note:
//
//While this recursive approach is valid, it may be inefficient for larger values of k or a large difference between startPos and endPos due to repeated computations. Memoization or dynamic programming techniques can be applied to optimize the solution and avoid redundant calculations.