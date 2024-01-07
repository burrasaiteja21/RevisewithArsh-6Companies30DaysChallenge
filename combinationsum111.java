//leetcode link:https://leetcode.com/problems/combination-sum-iii/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> arr=new ArrayList<>();
        generateSubset(1,9,k,n,new ArrayList<>(),arr);
        return arr;
    }
    public static void generateSubset(int start,int end,int k,int target,List<Integer> cur,List<List<Integer>> subset)
    {
        if(target == 0 && cur.size() == k){
            subset.add(new ArrayList(cur));
        }
        for(int i = start; i <= end; i++){
            cur.add(i);
            generateSubset(i+1, end,k,target-i, cur,subset);

            cur.remove(cur.size() - 1);
        }
    }
}