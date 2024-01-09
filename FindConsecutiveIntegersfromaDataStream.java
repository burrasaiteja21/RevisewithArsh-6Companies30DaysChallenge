//2526. Find Consecutive Integers from a Data Stream
//Medium
//leetcode link: https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/


class DataStream {
    private int val, k, count;
    public DataStream(int value, int k) {
        this.val = value;
        this.k = k;
        this.count = 0;
    }

    public boolean consec(int num) {
        // if num == val, increment the streak else set it to 0
        count = (num == val)? count + 1 : 0;
        return count >= k;

    }
}
