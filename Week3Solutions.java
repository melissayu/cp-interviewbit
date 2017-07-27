//Max depth of tree
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int maxDepth(TreeNode a) {
	    
	    if (a==null) {
	        return 0;
	    } else {
            int lDepth = maxDepth(a.left);
            int rDepth = maxDepth(a.right);
	        return Math.max(lDepth, rDepth) +1;
	    }
	    
	}
}


//Square root of integer
public class Solution {
	public int sqrt(int a) {
	    
	    if (a == 0 || a==1 ) {
	        return a;
	    }
	    
	    long start = 0;
	    long end = a/2;
	    int ans = 0;
	    
	    while (start <= end) {
	        long mid = (start+end)/2;
	        if (mid*mid == a) {
	            return Math.toIntExact(mid);
	        } else if (mid*mid < a) {
	            start = mid+1;
	            ans = Math.toIntExact(mid);
	        } else {
	            end = mid-1;
	        }
	    }
	    return ans;
	}
}
