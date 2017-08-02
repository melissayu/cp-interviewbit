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

//Same Tree
public class Solution {
	public int isSameTree(TreeNode a, TreeNode b) {
	    
	    if (a==null && b==null) {
	        return 1;
	    } else if (a == null || b == null || a.val != b.val) {
	        return 0;
	    } else {
            int leftTree = isSameTree(a.left, b.left);
            int rightTree = isSameTree(a.right, b.right);
	        if (leftTree == 1 && rightTree == 1) {
	            return 1;
	        } else {
	            return 0;
	        }
	    }
	}
}


//Power Function with mod
public class Solution {
	public int pow(int x, int n, int d) {
        long result = 1L;
        long square = x;
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        while(n != 0){
            if(n % 2 != 0){
                result = result *  square;
                result = result % d;
                // System.out.println("result: "+result);
            }
            square = (square * square) % d;                
            // System.out.println("square: "+square);

            n = n/2;
        }
        result = (result+d) % d;
        return (int)result;

	}
}

