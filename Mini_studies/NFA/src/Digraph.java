import java.util.LinkedList;
import java.util.List;

public class Digraph
{
	
	private final int V;
	private List<Integer>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public Digraph(int V) 
	{
		this.V = V;
		this.adjacencyList = (List<Integer>[]) new List[V];
		for (int i = 0; i < adjacencyList.length; i++)
		{
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) 
	{
		adjacencyList[v].add(w);
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adjacencyList[v];
	}
	
	public int V()
	{
		return V;
	}
	
}
