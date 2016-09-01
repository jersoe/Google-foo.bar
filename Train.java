package professorBoolean;

public class Train {

	public static void main(String[] args) {
		int[] x = {1,4,7};
		int[] x2 = {1,2};
		
		System.out.println(answer(x));
	}
	
	public static int answer(int[] x) {
		
		int trainLength = x.length;
		int rabbits = 0;
		
		for (int i=0; i<x.length; i++) {
			rabbits+=x[i];
		}
		
		int rabbitsPerCarInt = rabbits/trainLength;
		double rabbitsPerCarDouble=(double)rabbits/trainLength;
		
		if ((double)rabbitsPerCarInt == rabbitsPerCarDouble) {
			return trainLength;
		} else {
			return trainLength-1;
		}
	}
}
