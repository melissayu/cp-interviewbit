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
