//Week 1 solutions

//Add One To Number
//https://www.interviewbit.com/problems/add-one-to-number/

public class Solution {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    
        if (a.size() == 0) {
            return a;
        } else {
            a = removeLeadingZeroes(a);
            
            int curDigitIndex = a.size()-1;
            int newDigit = 0;
            while (curDigitIndex >= 0) {
                int curDigit = a.get(curDigitIndex);
                newDigit = addOneToDigit(curDigit);
                a.set(curDigitIndex, newDigit);

                if (newDigit == 0) {
                    curDigitIndex--;
                } else {
                    return a;
                }
            }
            if (newDigit == 0) { 
                a.add(0, 1);
            }
            return a;
        }
        
	}

    public ArrayList<Integer> removeLeadingZeroes(ArrayList<Integer> a) {
        while (a.size() > 0 && a.get(0) == 0) {
            a.remove(0);
        }
        return a;
    }
	
	public int addOneToDigit(int digit) {
        if (digit < 9) {
	        return digit+1;
        } else {
            return 0;
        }
	}
}

//Find Duplicate In Array
//https://www.interviewbit.com/problems/find-duplicate-in-array/

public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    HashMap<Integer, Integer> viewed = new HashMap<Integer, Integer>();
	    for (int i= 0; i < a.size(); i++) {
	        if (viewed.containsKey(a.get(i))) {
	            return a.get(i);
	        } else {
	            viewed.put(a.get(i), 1);
	        }
	    }
	    return -1;
	}
}

//Longest Common Prefix
//https://www.interviewbit.com/problems/longest-common-prefix/
public class Solution {
	public String longestCommonPrefix(ArrayList<String> a) {
	    
	    String curLongestPrefix = "";
	    
	    if (a.size() == 0) {
	        return curLongestPrefix;
	    } else if (a.size() == 1) {
	        return a.get(0);
	    }
	    
	    curLongestPrefix = a.get(0);
	    for (int i = 1; i < a.size(); i++) {
	        String curPrefix = getCommonPrefix(a.get(i), curLongestPrefix);
	        if (curPrefix.length() < curLongestPrefix.length()) {
	            curLongestPrefix = curPrefix;
	        }
	    }
	    
	    return curLongestPrefix;
	}
	
	public String getCommonPrefix(String a1, String a2) {
	    String prefix = "";
	    int i = 0;
	    while (i < a1.length() && i < a2.length() && a1.charAt(i)==a2.charAt(i)) {
            prefix += a1.charAt(i);
            i++;
	    }
	    return prefix;
	}
}

//Length Of Last Word
//https://www.interviewbit.com/problems/length-of-last-word/
public class Solution {
	public int lengthOfLastWord(final String a) {
	    String[] subStr = a.split(" ");
	    if (subStr.length == 0) { return 0; };
	    String lastWord = subStr[subStr.length-1];
	    return lastWord.length();
	}
}



