/**
 * Author: Prem kumar Murugesan
 * 
 * 
 * Problem Statement: 
 * ==================
 * You are going on a long trip. You start on the road at mile post 0. Along the way
 * there are n hotels, numbered as 1 ≤ i ≤ n, at mile posts a 1 < a 2 < . . . < a n , where each
 * a i is measured from the starting point. The only places you are allowed to stop are at
 * these hotels, but you can choose which of the hotels you stop at. You must stop at the
 * final hotel (at distance a n ), which is your destination.
 * You would ideally like to travel 200 miles a day, but this may not be possible (de-
 * pending on the spacing of the hotels). If you travel x miles during a day, the penalty for
 * that day is (200 − x) 2 . You want to plan your trip so as to minimize the total penalty,
 * the sum, over all travel days, of the daily penalties.
 * 
 * Type:
 * =====
 * Dynamic Programming
 * 
 * Algorithm:
 * ==========
 * If x is a marker number, ax is the mileage to that marker, and px is the minimum penalty to 
 * get to that marker, you can calculate pn for marker n if you know pm for all markers m before n.
 * To calculate pn, find the minimum of pm + (200 - (an - am))^2 for all markers m where am < an 
 * and (200 - (an - am))^2 is less than your current best for pn (last part is optimization).
 * 
 * 
 * find : minpath(from 0,1,2,..i, to k) and store it as optimal path of k from 0.
 * 
 * Running Time:
 * =============
 * 
 * Hotel	No of Comparison
 * ------+--------------------
 * 0		0
 * 1		1 (penalty directly from start, and penalty if comes through 0)
 * 2		2 (penalty from start, penalty through 0 and 1)
 * .		.
 * .		.
 * n		n
 * 
 * Note: 0 is the 1st hotel(convenience for array representation)
 * 
 * Total running time : 0+1+2+3+..+n = n(n-1)/2 => O(n^2)
 * 
 * Reference : 
 * ===========
 * http://stackoverflow.com/questions/4950956/how-would-you-look-at-developing-an-algorithm-for-this-hotel-problem
 */
import java.util.Arrays;

public class Hotel {

	/**
	 * Gives the optimal stops a driver should make in the trip to MINIMIZE the
	 * penalty, before reaching the destination.
	 */
	public static void optimalStops(int[] input) {

		int[] hotel = input;
		int[] bestpath = new int[hotel.length];
		int[] stop = new int[hotel.length];

		for (int i = 0; i < hotel.length; i++) {
			bestpath[i] = (int) (Math.pow((200 - hotel[i]), 2));
			stop[i] = 0;
			for (int j = 0; j < i; j++) {
				if (bestpath[j] + Math.pow((200 - (hotel[i] - hotel[j])), 2) < bestpath[i]) {
					bestpath[i] = (int) (bestpath[j] + Math.pow(
							(200 - (hotel[i] - hotel[j])), 2));
					stop[i] = j + 1;
				}
			}
		}

		// Print the output
		System.out.println("Minimal Penalty :"+bestpath[hotel.length - 1]);
		
		String finalPath = "";
		int index = stop.length-1;
		while(index>=0){
			finalPath = (index+1)+" "+finalPath;
			index = stop[index]-1;
		}
		System.out.println(Arrays.toString(stop));
		System.out.println("Stop at: "+finalPath);
	}

	/**
	 * Give the input hotel distances in the trip
	 */
	public static void main(String[] args) {

		int[] input = {190, 420, 550, 660, 670 };
		Hotel.optimalStops(input);

	}

}
