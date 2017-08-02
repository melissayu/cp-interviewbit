//Number of 1 bits
public class Solution {
	public int numSetBits(long a) {
	    int bits = 0;
	    
	    while (a > 0) {
            if (a%2 ==1) {
                bits++;
            }
    	    a = a >> 1;
	    }
	    
	    
	    return bits;
	}
}

//All combinations
public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    return combHelper(1,n,k);
	    
	}

	public ArrayList<ArrayList<Integer>> combHelper(int s, int n, int k) {
	    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
	   // HashSet<ArrayList<Integer>> retSet = new HashSet<ArrayList<Integer>>();
	    if (k == 1) {
            for (int i = s; i <= n; i++) {
    	        ArrayList<Integer> retVal = new ArrayList<Integer>();
                retVal.add(i);
                retList.add(retVal);
            }
	    }
	    else {
            for (int i = s; i <= n; i++) {
               ArrayList<ArrayList<Integer>> subCombs = combHelper(i+1, n, k-1);
               for(ArrayList<Integer> subComb : subCombs) {
                   ArrayList<Integer> newVal = new ArrayList<Integer>();
                   newVal.add(i);
                   newVal.addAll(subComb);
                //   retSet.add(newVal);
                    retList.add(newVal);
               }
            }
	    }
	    
	    
        // retList.addAll(retSet);	    

	    return retList;
	}
	
}

//All Permutations
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	   // System.out.println("permute: "+a);
	    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> permSet = new HashSet<ArrayList<Integer>>();

	    if (a.size() == 1) {
	        retList.add(a);
	    } else {
	        for (int i = 0; i < a.size(); i++) {

	            Integer ai = a.get(i);
                // System.out.println("ai: "+ai);

	            ArrayList<Integer> b = new ArrayList<Integer>();
	            b.addAll(a);
	            b.remove(i);

                // System.out.println("b: "+b);

	            ArrayList<ArrayList<Integer>> subPerms = permute(b);
                //letter a[i]+permute(a.remove(i))
                for (ArrayList<Integer> subPerm : subPerms) {
                    // System.out.println("subPerm: "+subPerm);
                    ArrayList<Integer> newPerm = new ArrayList<Integer> ();
                    newPerm.add(ai);
                    newPerm.addAll(subPerm);
                    permSet.add(newPerm);
                }
	        }
	    }
	    
	    retList.addAll(permSet);
        // System.out.println("retList: "+retList);

	    return retList;
	}
}

