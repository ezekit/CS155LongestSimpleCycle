import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*	Ezekiel Calubaquib
 *  SJSU CS 155
 *  Using a BFS and DFS
 */

public class CycleTest {

	static Queue<Vertex> bfsq = new LinkedList<Vertex>();
	static Stack<Vertex> dfss = new Stack<Vertex>();
	static LinkedList<Vertex> list = new LinkedList<Vertex>();
	static HashMap<ArrayList<Vertex>, Integer> cycles = new HashMap<>();
	
	public static void main(String[] args) {
		Graph lsc = new Graph();
		list = lsc.getList();
		BFS(lsc);
		System.out.println();

	}

	public static void BFS(Graph orgList) {
		//enqueue
		bfsq.add(list.get(0));
		
		while(!bfsq.isEmpty())
		{
			//dequeue
			Vertex v = bfsq.remove();
			ArrayList<Vertex> adj_list = v.getAdjacentList();

			System.out.print(v.getName() +":");
			DFS(v, orgList);
			
			v.setBFSVisited();
			
			Iterator<Vertex> itr = adj_list.iterator();
			while(itr.hasNext())
			{
				Vertex adj_v = itr.next();
				if(!adj_v.isBFSVisited())
				{
					adj_v.setBFSVisited();
					bfsq.add(adj_v);
				//	System.out.print(adj_v.getName());
				}				
			}

		}
	}
	
	//find vertex cycle using DFS
	public static void DFS(Vertex v, Graph list){
			
		//push initial stack v
		dfss.add(v);
		boolean firstEnt = true;
		
		System.out.println();
		while(!dfss.isEmpty())
		{
			//pop
			Vertex adj_v = dfss.pop();			

			//if not visited 
			if(!adj_v.isDFSVisited())
			{
				//set visited
				adj_v.setDFSVisited();
				System.out.println(adj_v.getName()+"<svis ");

				
				//for each unvisited neighbor push unvisited
				ArrayList<Vertex> vl = adj_v.getAdjacentList();
				Iterator<Vertex> itr = vl.iterator();
				
				
				int i=0; 
				while(itr.hasNext() && i<1)
				{
					Vertex e = itr.next();
					
					//System.out.println(e.getName()+"<dd " + dfss.size());

					if(!e.isDFSVisited())
					{
						dfss.push(e);
						//System.out.println(e.getName()+"<p ");
						i++;
					}
					else if(e.getName().equals(v.getName())) {
						System.out.println("Cycle");
						break;
					}
					else if(e.hasUnvisited())
					{
						dfss.push(e);
						//System.out.println(e.getName()+"<ee " + dfss.size());
					}
					else if(e.containStartV(v))
					{
						System.out.println(e.getName() + ": Contains a vertex pointing to a cycle: " + v.getName());
						dfss.push(e);
					}
				}	
			
			}else if(adj_v.containStartV(v)){
				System.out.println("Cycle"); 
				break;
			}else if(adj_v.hasUnvisited()) {
				dfss.push(adj_v.getUnivisited());
				System.out.println("Contains unvisited");
			}

		}
		
		System.out.println("\n");
		list.reset();
	
	}
	
}
