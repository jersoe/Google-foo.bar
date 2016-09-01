package professorBoolean;

import java.util.Arrays;

public class Zombit {

	public static void main(String[] args) {
		int[][] intervals = {{3, 6},{4, 5}, {3, 3},{3, 6},{1, 3}, {3, 3},{3, 6},{1, 3}, {3, 3}};
		int[][] intervals2 = {{10, 14}, {4, 18}, {19, 20}, {19, 20}, {13, 20}};
		int[][] intervals3 = {{23,26},{10, 14}, {4, 18}, {19, 20}, {19, 20}, {13, 20},{48,52},{51,53},{52,100 }};
		
		
		System.out.println(answer(intervals));
	}
	
	public static int answer(int[][] intervals) {
		int totalHours=0;

		//Sort the array based on the first element
		java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
			  public int compare(int[] a, int[] b) {
			    //return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
			    
			    if (a[0] < b[0]) {
			    	return -1;
			    } else if (a[0] == b[0]) {
			    	//return 0;
			    	//First elements are the same, so look at second elements
			    	if (a[1] < b[1]) {
			    		return -1;
			    	} else if (a[1] == b[1]) {
			    		return 0;
			    	} else {
			    		return 1;
			    	}		    	
			    } else 
			    	return 1;
			    
			  }
			});		
		
		//Loop through array and remove overlap
		for (int i=0; i<intervals.length-1; i++) { //-1 because we should stop with the second last element
			if (intervals[i][1] > intervals[i+1][0]) { // overlap
				int j=intervals[i][1];
				intervals[i][1] = intervals[i+1][0];
				if (intervals[i+1][1] < j) {
					intervals[i+1][1] = j;
				}
			}
		}
		
		//loop through array and calculate hours for each element
		for (int i=0; i<intervals.length; i++) {
			totalHours+=intervals[i][1]-intervals[i][0];
		}
		
		return totalHours;

	}
}
