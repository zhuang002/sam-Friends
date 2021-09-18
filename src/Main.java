import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static HashMap<Integer,Integer> graph = new HashMap<>();
	public static void main(String[] argv) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
			int id = sc.nextInt();
			int assignedTo = sc.nextInt();
			
			graph.put(id, assignedTo);
			
		}
		
		int id1=sc.nextInt();
		int id2=sc.nextInt();
		while (id1!=0 || id2!=0) {
			int step=getRing(id1, id2);
			if (step==-1) {
				System.out.println("No");
			} else {
				System.out.println("Yes "+step);
			}
			id1 = sc.nextInt();
			id2 = sc.nextInt();
		}
		
	}
	private static int getRing(int id1,int id2) {
		// TODO Auto-generated method stub
		
		int step = 0;
		
		int nextId = graph.get(id1);
		boolean found = false;
		while (nextId!=0) {
			if (nextId == id2) {
				found = true;
			} else if (!found) {
				step++;
			} 
			
			if (nextId == id1) {
				if (found) return step;
				else return -1;
			}
			
			if (graph.containsKey(nextId))
				nextId = graph.get(nextId);
			else 
				break;
		}
		return -1;
	}
	

}

