/*
Zombit monitoring
=================

The first successfully created zombit specimen, Dolly the Zombit, needs constant monitoring, and Professor Boolean has tasked the minions with it. Any minion who monitors the zombit records the start and end times of their shifts. However, those minions, they are a bit disorganized: there may be times when multiple minions are monitoring the zombit, and times when there are none!

That's fine, Professor Boolean thinks, one can always hire more minions... Besides, Professor Boolean can at least figure out the total amount of time that Dolly the Zombit was monitored. He has entrusted you, another one of his trusty minions, to do just that. Are you up to the task?

Write a function answer(intervals) that takes a list of pairs [start, end] and returns the total amount of time that Dolly the Zombit was monitored by at least one minion. Each [start, end] pair represents the times when a minion started and finished monitoring the zombit. All values will be positive integers no greater than 2^30 - 1. You will always have end > start for each interval.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (int) intervals = [[1, 3], [3, 6]]
Output:
    (int) 5

Inputs:
    (int) intervals = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]
Output:
    (int) 16
*/

package professorBoolean;

import java.util.Arrays;

public class ZombitMonitoring {

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
