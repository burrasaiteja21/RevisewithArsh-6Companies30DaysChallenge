//leetcode link:https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/?envType=daily-question&envId=2024-01-10
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start)
    {

        HashMap<TreeNode,TreeNode> hm=new HashMap<>();
        TreeNode startpr=bfstmap(root,start,hm);
        return findmintimetoburn(startpr,hm);

    }
    public TreeNode bfstmap(TreeNode root, int start,HashMap<TreeNode,TreeNode> hm)
    {
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        TreeNode startnode=null;
        while(!qu.isEmpty())
        {
            TreeNode curr=qu.poll();
            if(curr.val==start)
            {
                startnode=curr;
            }
            if(curr.left!=null)
            {
                qu.add(curr.left);
                hm.put(curr.left,curr);
            }
            if(curr.right!=null){
                hm.put(curr.right,curr);
                qu.add(curr.right);
            }
        }
        return startnode;
    }
    public int findmintimetoburn(TreeNode startptr,HashMap<TreeNode,TreeNode> hm)
    {
        Set<TreeNode> vis=new HashSet<>();
        Queue<TreeNode> qu=new LinkedList<>();
        vis.add(startptr);
        qu.add(startptr);
        int count=0;
        while(!qu.isEmpty())
        {
            int si=qu.size();
            boolean flag=false;
            for(int i=0;i<si;i++)
            {
                TreeNode curr=qu.poll();
                if(curr.left!=null && !vis.contains(curr.left))
                {
                    qu.add(curr.left);
                    vis.add(curr.left);
                    flag=true;
                }
                if(curr.right!=null && !vis.contains(curr.right))
                {
                    qu.add(curr.right);
                    vis.add(curr.right);
                    flag=true;
                }
                if(hm.containsKey(curr) && !vis.contains(hm.get(curr)))
                {
                    qu.add(hm.get(curr));
                    vis.add(hm.get(curr));
                    flag=true;
                }
            }
            if(flag==true)
            {
                count++;
            }

        }

        return count;

    }
}