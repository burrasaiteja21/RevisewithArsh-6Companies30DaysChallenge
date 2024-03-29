//leetcode link:https://leetcode.com/problems/query-kth-smallest-trimmed-number/
class Solution {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries)
    {
        int n = queries.length;
        int[] fin = new int[n];

        for (int i = 0; i < n; i++)
        {
            int queryindx=query(nums,queries[i][1],queries[i][0]);
            fin[i]=queryindx;
        }
        return fin;
    }
    public int query(String[] nums,int trim,int k)
    {
        PriorityQueue<Pair> heap = new PriorityQueue();
        int len = nums.length;
        for(int idx =0;idx<len;idx++){
            StringBuilder sb = new StringBuilder();
            int numsLen = nums[idx].length();

            for(int strIdx=numsLen-trim;strIdx<numsLen;strIdx++){
                sb.append(nums[idx].charAt(strIdx));
            }

            String str = sb.toString();
            heap.add(new Pair(str,idx));
            if(heap.size()>k) heap.remove();
        }
        Pair ans = heap.remove();
        int minIdx = ans.idx;
        return minIdx;
    }
    class Pair implements Comparable<Pair>{
        String num;
        int idx;
        Pair(String num,int idx){
            this.num = num;
            this.idx = idx;
        }
        public int compareTo(Pair other){
            if(this.num.equals(other.num)) return other.idx-this.idx;
            else return other.num.compareTo(this.num);
        }
    }
}