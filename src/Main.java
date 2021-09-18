import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static HashMap<Integer, Node> nodes = new HashMap<>();
	public static void main(String[] argv) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
			int id = sc.nextInt();
			int assignedTo = sc.nextInt();
			Node node1,node2;
			if(nodes.containsKey(id)) {
				node1 = nodes.get(id);
			} else {
				node1=new Node(id);
				nodes.put(id, node1);
			}
			if(nodes.containsKey(assignedTo)) {
				node2 = nodes.get(assignedTo);
			} else {
				node2=new Node(assignedTo);
				nodes.put(assignedTo, node2);
			}
			
			node1.assignedTo(node2);
			
		}
		
		int id1=sc.nextInt();
		int id2=sc.nextInt();
		while (id1!=0 || id2!=0) {
			int step=getRing(id1, id2);
			if (step==-1) {
				System.out.println("No");
			} else {
				System.out.println("Yes,"+step);
			}
			id1 = sc.nextInt();
			id2 = sc.nextInt();
		}
		
	}
	private static int getRing(int id1,int id2) {
		// TODO Auto-generated method stub
		
		int step = 0;
		Node current = nodes.get(id1);
		boolean found = false;
		
		Node next = current.assignedTo;
		while (next!=null) {
			if (next.id != id2 && !found ) {
				step++;
			} else {
				found = true;
			}
			
			if (next.id == id1) {
				if (found)
					return step;
				else 
					return -1;
			}
			next = next.assignedTo;
		}
		
		return -1;
	}

}

class Node {
	int id;
	Node assignedTo=null;
	
	public Node(int id) {
		this.id = id;
	}
	
	public void assignedTo(Node assignedTo) {
		this.assignedTo = assignedTo;
	}
}
