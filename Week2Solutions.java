//Anagrams: return group of strings that are anagrams
//Input : cat dog god tca
//Output : [[1, 4], [2, 3]]

public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

        //List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < a.size(); i++){
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if (map.containsKey(s)){
                map.get(s).add(i+1);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i+1);
                map.put(s,l);
            }
        }     

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;


	}
}

//Reverse Linked List
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    if (a.next == null || m == n) {
	        return a;
	    }
	    int i = 1;
	    ListNode curNode = a;
	    ListNode beforeRev = null;
	    ListNode revNode = a;
	    while (curNode != null) {
            if (i == m-1) {
                beforeRev = curNode;
            } else if (i == m) {
                revNode = curNode;
            } else if (i > m && i <= n) {
                ListNode insertNode = new ListNode(curNode.val);
                
                if (beforeRev != null) {
                    insertNode.next = beforeRev.next;
                    beforeRev.next = insertNode;
                } else {
                    insertNode.next = a;
                    a = insertNode;
                }

                revNode.next = curNode.next;

            }   
            curNode = curNode.next;
            i++;
        }
        return a;
	}
}

//Partition List
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode partition(ListNode a, int b) {
	    
	    //keep track of first&last node of less than (curLessNode)
	    ListNode curLessHead=null;
	    ListNode curLessNode=null;

	    //keep track of first&last node of equals (curEqualNode)
        // ListNode curEqualHead=null;
        // ListNode curEqualNode=null;
	    
	    //keep track of first&last node of greater (curGreaterNode)
	    ListNode curGreaterHead=null;
	    ListNode curGreaterNode=null;

	    //loop through each element of a
	    while(a != null) {
	        //if element is less than b, add it as next of curLess
	        if (a.val < b) {
	            ListNode newNode = new ListNode(a.val);
	            if (curLessHead == null) {
	                curLessHead = newNode;
	                curLessNode = curLessHead;
	            } else {
    	            curLessNode.next = newNode;
	                curLessNode = newNode;
	            }
	        }
	        
	        //if element is equal to b, add it as next of curEqual
	       // else if (a.val == b) {
	       //     ListNode newNode = new ListNode(a.val);
	       //     if (curEqualHead == null) {
	       //         curEqualHead = newNode;
	       //         curEqualNode = curEqualHead;
	       //     } else {
    	   //         curEqualNode.next = newNode;
	       //         curEqualNode = newNode;
	       //     }
	       // }
	        //if element is greater than b, add it as next of curGreater
	        else if (a.val >= b) {
	            ListNode newNode = new ListNode(a.val);
	            if (curGreaterHead == null) {
	                curGreaterHead = newNode;
	                curGreaterNode = curGreaterHead;
	            } else {
    	            curGreaterNode.next = newNode;
	                curGreaterNode = newNode;
	            }
	        }
	        a = a.next;
	    }
	        
	        
	        
	   if (curLessHead==null) {
	       //if (curEqualHead ==null) {
	           return curGreaterHead;
	       //} else {
	       //    curEqualNode.next = curGreaterHead;
	       //}
	       //return curEqualHead;
	   }

        // if (curEqualHead==null) {
        //     curLessNode.next = curGreaterHead;
        //     return curLessHead;
        // } 
        
        curLessNode.next = curGreaterHead;
        return curLessHead;
	    
	}
}
