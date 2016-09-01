package professorBoolean;

public class MinionHierarchy {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(answer(2));
	}
	
	public static int answer(int x) {
		double y=0.0;
		x++;
		
		for (int i=0; i<x; i++) {
			y += Math.pow(7, i); 			
		}
	return (int) y;	
	}

}
