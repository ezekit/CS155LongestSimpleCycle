import java.util.LinkedList;


/*	Ezekiel Calubaquib
 *  SJSU CS 155
 *  
 */

public class Graph
{
	
	//Initialize Graph with vertex
	
	LinkedList<Vertex> grapher;
	
	public Graph(){
		
		grapher = new LinkedList<Vertex>();
	
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		
		grapher.add(A);
		grapher.add(B);
		grapher.add(C);
		grapher.add(D);
		grapher.add(E);
		grapher.add(F);
		
		A.addAdjacent(B, 1.0);
		A.addAdjacent(E, 1.0);
		B.addAdjacent(C, 1.0);
		C.addAdjacent(D, 1.0);
		C.addAdjacent(E, 1.0);
		D.addAdjacent(A, 1.0);
		E.addAdjacent(F, 1.0);
		F.addAdjacent(C, 1.0);
		
	}
	
	
	public LinkedList<Vertex> getList()
	{
		return this.grapher;
	}
	
	public void reset()
	{
		for(Vertex v: grapher)
		{
			v.reset();
		}	
	}
	
	public void print()
	{
		for(Vertex v: grapher)
		{
			v.toSring();
		}
		
	}
	
	
}