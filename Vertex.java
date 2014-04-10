import java.util.ArrayList;
import java.util.Iterator;


/*	Ezekiel Calubaquib
 *  SJSU CS 155
 *  Vertex class contains vertex data
 */

public class Vertex {
	
	private String vname;
	private boolean bfsVisited = false;
	private boolean dfsVisited = false;	
	private ArrayList<Vertex> adjacentVertex;

	public Vertex(String name)
	{
		vname = name;
		adjacentVertex = new ArrayList<Vertex>();
	}
	
	
	public String getName()
	{
		return vname;
	}
	
	public void setBFSVisited(){
		this.bfsVisited = true;
	}
	
	public boolean isBFSVisited(){
		return this.bfsVisited;
	}
	
	public void setDFSVisited(){
		this.dfsVisited = true;
	}
	
	public void resetDFSVisited(){
		this.dfsVisited = false;
	}
	
	public boolean isDFSVisited(){
		return this.dfsVisited;
	}
	
	
	public ArrayList<Vertex> getAdjacentList(){
		return this.adjacentVertex;
	}
	
	public void addAdjacent(Vertex v, Double dist){
		adjacentVertex.add(v);
	}
	
	public void reset(){
		
		for(Vertex v: this.adjacentVertex)
			v.resetDFSVisited();
	}
	
	public boolean hasUnvisited()
	{
		for(Vertex e: this.adjacentVertex)
			if(!e.dfsVisited)
				return true;
		return false;
		
	}
	
	public Vertex getUnivisited()
	{
		for(Vertex e: this.adjacentVertex)
			if(!e.dfsVisited)
				return e;
		return null;
	}
	
	public boolean containStartV(Vertex v)
	{
		for(Vertex e: this.adjacentVertex)
			if(e.getName().equals(v.getName()))
				return true;
		return false;
	}
	
	public String toSring()
	{
		System.out.print("V: " + vname + " Adj: ");

		Iterator<Vertex> itr = this.adjacentVertex.iterator();
		while(itr.hasNext())
		{
			Vertex vert = itr.next();
			System.out.print(vert.getName()+ " ");			
		}
		
		System.out.println();
		return "";
	}
	
	
	
}
