import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static int[][] graph = new int[10000][10000]; // exceed memory, give up.
	public static void main(String[] argv) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
			int id = sc.nextInt();
			int assignedTo = sc.nextInt();
			
			graph[id][assignedTo]=assignedTo;
			
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
		
		int nextId = findAssignedTo(id1);
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
			
			nextId = findAssignedTo(nextId);
		}
		return -1;
	}
	
	private static int findAssignedTo(int id) {
		// TODO Auto-generated method stub
		for (int i=0;i<10000;i++) {
			if (graph[id][i]!=0) {
				return graph[id][i];
			}
		}
		return 0;
	}

}

