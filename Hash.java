package professorBoolean;


public class Hash {

	public static void main(String[] args) {
		
		
		int[] digest = {0, 129, 3, 129, 7, 129, 3, 129, 15, 129, 3, 129, 7, 129, 3, 129};
		//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		int[] digest2 = {0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165};
		//[0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225]
		int[] result = new int[16];
		
		result = answer(digest2);
		
		for (int x=0; x<result.length; x++){
			System.out.println(result[x]);
		}
	
	}
	
	public static int[] answer(int[] digest){
		
		//Array for response
		int[] response = new int[16];
		
		//Create digestTable 
		int[][] digestTable = new int[256][256];

		//Populate digestTable
		for (int y=0; y<256; y++){
			for (int x=0; x<256; x++){
				{
					digestTable[x][y] = ( (129 * x) ^ y) % 256;
				}
			}
		}
		
		int previousMessage=0;
		int tempPreviousMessage=0;

		for (int z=0; z<digest.length; z++){
			// find x where y = previous message and x,y=digest[z]
			for (int y=0; y<256; y++){
				for (int x=0; x<256; x++){
					if (y==previousMessage && digestTable[x][y]==digest[z]){
						//System.out.println("Previous msg: "+y+" current msg: "+x+" Digest: " + digestTable[x][y]);
						response[z]=x;
						tempPreviousMessage=x;
					}
				}
			}
			previousMessage=tempPreviousMessage;
		}	
		return response;
	}
}
