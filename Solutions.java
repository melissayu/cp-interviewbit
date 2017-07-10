// ---------------- Level 2 checkpoint --------------------
//2: PRETTYPRINT
public class Solution {
    
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> rect = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2*a-1; i++) {
            ArrayList<Integer> row = buildRow(a, i);
            rect.add(row);
        }
        return rect;
	} 
	
	public ArrayList<Integer> buildRow(int a, int rowNum) {
	    ArrayList<Integer> row = new ArrayList<Integer>();
	    if (rowNum == 0 || rowNum == 2*a-2) {
	        for (int i = 0; i < 2*a-1; i++) {
	            row.add(a);
	        }
	    } else {
	        row.add(a);
	        row.addAll(buildRow(a-1, rowNum-1));
	        row.add(a);
	    }
	    return row;
	}
}

// ---------------- Level 3 checkpoint --------------------
//3-1: Kth Smallest Element In The Array
public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
	    
	    // Build a heap of first k elements: O(k) time
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
     
		for(int i=0; i < a.size(); i++){
			pq.offer(a.get(i));
		}
		int n = -1;
		while( k > 0 ){
			n = pq.poll();
			k--;
		}
		return n;
	}	
}

//3-2: Numrange
public class Solution {
	public int numRange(ArrayList<Integer> a, int b, int c) {
	    int count = 0;
	    
	    //For each element in array, start testing subsequences of size 0 thru a.size()-i
	    for (int i = 0; i < a.size(); i++) {
	       // System.out.println("i: "+i);
	       // System.out.println("a[i]: "+a.get(i));
	        //If number is greater than high end of range, go to next number in array
	        if (a.get(i) <= c) {
                
                for (int subSeqSize = 1; subSeqSize < a.size()-i+1; subSeqSize++) {
                    int subSeqSum = sumSubSeq(a, i, subSeqSize);
                    if (subSeqSum >= b && subSeqSum <=c) {
                        count++;
                    } else if (subSeqSum > c) {
                        break;
                    }
                }
                
            }
	    }
	    return count;
	}
	
	public int sumSubSeq(ArrayList<Integer> a, int startIndex, int subSeqSize) {
	    int sum = 0;
	    for (int i = startIndex; i < startIndex+subSeqSize; i++) {
	        sum += a.get(i);
	    }
	    return sum;
	}
}

// ---------------- Level 4 checkpoint --------------------
//4-1: Subtract
public class Solution {
	public ListNode subtract(ListNode a) {
	    
	    HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
	    
	    ListNode curNode = a;
	    int size = 0;
	    while (curNode != null) {
	        m.put(size, curNode.val);
	        size++;
	        curNode = curNode.next;
	    } 
	    
	   // System.out.println("size: "+size);
	    int halfIndex = size/2;
	   // System.out.println("halfIndex: "+halfIndex);

	    
	    int j = 0;
	    curNode = a;
        while (j < halfIndex) {
            curNode.val = m.get(size-j-1) - m.get(j);
            curNode = curNode.next;
            j++;
        }
        
        return a;
	    
	}
}

//4-2: Nextgreater
public class Solution {
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    
	    //For each element k in list, find smallest element > k in remainder of list
	    for (int i = 0; i < a.size(); i++) {
	        int k = a.get(i);
	        int small = getNextGreater(a, i, k);
	        a.set(i, small);
	    }
	    
	    return a;
	}
	
	public int getNextGreater(ArrayList<Integer> a, int startIndex, int greaterThan) {
	   // int nextGreater = -1;
	    
	    for (int i = startIndex; i < a.size(); i++) {
	        if (a.get(i) > greaterThan) {
                return a.get(i);
	        }
	    }
	    return -1;
	}
}

// ---------------- Level 5 checkpoint --------------------

//5-1: All Unique Permutations
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	   // System.out.println("permute --- a: "+a);
	    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
	    
	    //If size is 1, that is the only permutation
	    if (a.size() == 1) {
	        retList.add(a);
	        return retList;
	    } 
	    //Otherwise keep first element and permute rest of elements recursively
	    else {
	        for (int i = 0; i < a.size(); i++) {
	            ArrayList<Integer> newA = new ArrayList<Integer>();
	            newA.addAll(a);
	            
	           // System.out.println("newA: "+newA);

	            
	            Integer curElement = a.get(i);
	           // System.out.println("curElement: "+curElement);

                
                newA.remove(i);
                
                ArrayList<ArrayList<Integer>> subPermutes = permute(newA);
                
                                // System.out.println("subPermutes: "+subPermutes);
                for (int j = 0; j < subPermutes.size(); j++) {
                    ArrayList<Integer> newPermutation = new ArrayList<Integer>();
    	            newPermutation.add(curElement);
                    newPermutation.addAll(subPermutes.get(j));
                    retList.add(newPermutation);
                }
	        }
	    }
	    
	    
        Set<ArrayList<Integer>> subPermuteSet = new HashSet<ArrayList<Integer>>();
        subPermuteSet.addAll(retList);
        // System.out.println("subPermuteSet: "+subPermuteSet);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(subPermuteSet);

	    return list;
	    
	}
	
}

//5-2: Longest Consecutive Sequence

public class Solution {
	public int longestConsecutive(final List<Integer> a) {
	        int res = 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int n : a) {
                if (!map.containsKey(n)) {
                    int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                    int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                    int sum = left + right + 1;
                    map.put(n, sum);
                    res = Math.max(res, sum);
                    map.put(n - left, sum);
                    map.put(n + right, sum);
                }
                else {
                    continue;
                }
            }
            return res;

	    /*
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    int longest = 0;
	    for (int i = 0; i < a.size(); i++) {
	        //if key doesn't exist in hash
	        int curNum = a.get(i);
	       // System.out.println("curNum: "+curNum);
	        if (!hm.containsKey(curNum)) {
	            int lowerCount = 0;
	            int higherCount = 0;
	            int newCount = 1;
	            if (hm.containsKey(curNum-1) && hm.containsKey(curNum+1)) {
        	       // System.out.println("curNum: "+curNum);

	                lowerCount = hm.get(curNum-1);
        	       // System.out.println("lowerCount: "+lowerCount);
	                higherCount = hm.get(curNum+1);
        	       // System.out.println("higherCount: "+higherCount);
	                newCount += lowerCount+higherCount;
	               // System.out.println("contains -1 & +1: "+newCount);

	                hm.put(curNum, newCount);
                    hm.put(curNum-lowerCount, newCount);
                    hm.put(curNum+higherCount, newCount);
                    // int lower = curNum-1;
                    // while(hm.containsKey(lower)) {
                    //     hm.put(lower, newCount);
                    //     lower--;
                    // }

                    // int higher = curNum+1;
                    // while(hm.containsKey(higher)) {
	                   // hm.put(higher, newCount);
	                   // higher++;
                    // }

	            }
	            else if (hm.containsKey(curNum-1)) {
	                lowerCount = hm.get(curNum-1);
    	            newCount += lowerCount;
	               // System.out.println("contains -1: "+newCount);
	               // hm.put(curNum-1, newCount);
    	            hm.put(curNum, newCount);
                    hm.put(curNum-lowerCount, newCount);
                    // int lower = curNum-1;
                    // while(hm.containsKey(lower)) {
                    //     hm.put(lower, newCount);
                    //     lower--;
                    // }
	            }
	            else if (hm.containsKey(curNum+1)) {
	                higherCount = hm.get(curNum+1);
    	            newCount += higherCount;
	               // System.out.println("contains +1: "+newCount);
	               // hm.put(curNum+1, newCount);
    	            hm.put(curNum, newCount);
                    hm.put(curNum+higherCount, newCount);
                    // int higher = curNum+1;
                    // while(hm.containsKey(higher)) {
	                   // hm.put(higher, newCount);
	                   // higher++;
                    // }
	            } else {
	                hm.put(curNum, newCount);
	            }
	            if (newCount > longest) {
	                longest = newCount;
	            }
                // System.out.println("longest: "+longest);
	        }
	    }
	    return longest;
	    */
	}
}


