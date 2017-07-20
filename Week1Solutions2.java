//Largest Number
public class Solution {
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
    
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0; i<a.size(); i++){
            arr.add(String.valueOf(a.get(i)));
        }
     
        Collections.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
     
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }
     
        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);
     
        return sb.toString();
/*
		final String sortString = "0123456789";

		StringBuffer result = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < a.size(); i++) {
			String element = String.valueOf(a.get(i));
			for (int j = 1; j <= element.length(); j++) {
				list.add(element.substring(j - 1, j));
			}
		}

		Collections.sort(list, new Comparator<String>() {
			public int compare(String a, String b) {
				// return sortString.indexOf(s2) - sortString.indexOf(s1);
				return (b+a).compareTo(a+b);
			}
		});


		for (String element : list) {
			result = result.append(element);
		}
		return result.toString();
*/
	}
	

    
}



// Pascal Triangle
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int a) {
	    
	    ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
	    
	    ArrayList<Integer> lastRow = new ArrayList<Integer>();
	    
	    for (int i = 0; i < a; i++) {
	        ArrayList<Integer> newRow = getNextRow(lastRow);
	        retList.add(newRow);
	        lastRow = newRow;
	    }
	    
	    return retList;
	}
	
	
	public ArrayList<Integer> getNextRow(ArrayList<Integer> lastRow) {
	   // System.out.println("lastRow: "+lastRow);
	    ArrayList<Integer> nextRow = new ArrayList<Integer>();
	    
	    if (lastRow.size() == 0) {
	        nextRow.add(1);
	    } else {
            nextRow.add(lastRow.get(0));
	        for (int i = 1; i < lastRow.size(); i++) {
                nextRow.add(lastRow.get(i-1) + lastRow.get(i));
	        }
	        nextRow.add(lastRow.get(lastRow.size()-1));
	    }
	    
	    
        return nextRow;

	}
}
