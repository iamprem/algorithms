import java.util.Arrays;


public class ContigousSubsequence {

	public static void maxSumSequence(int[] input){

		int currentMax = input[0];
		int currentSum = 0;
		int prevSum = input[0];
		int startIndex = 0;
		int tempStartIndex = 0;
		int endIndex = 0;
		
		for (int i = 1; i < input.length; i++) {
		
			currentSum = Math.max(prevSum+input[i], input[i]);
			if (currentSum == prevSum+input[i]) {
				if (currentSum > currentMax) {
					startIndex = tempStartIndex;
					endIndex = i;
					currentMax = currentSum;
					
				}
			} else{
				tempStartIndex = i;
			}
			prevSum = currentSum;
		}
		
		System.out.println("Maximum Sum value : " + currentMax);
		System.out.println("Sequence : "+Arrays.toString(Arrays.copyOfRange(input, startIndex, endIndex+1)));
		
	}
	
	
	public static void main(String[] args) {
		
		int[] input = {5, 15, -30, 10, -5, 40, 10};
		ContigousSubsequence.maxSumSequence(input);
		
	}

}
