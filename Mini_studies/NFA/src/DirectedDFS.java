
public class DirectedDFS 
{
	
	private int[] edgeTo;
	private boolean[] marked;
	private Digraph G;
	
	private DirectedDFS(Digraph G)
	{
		this.G = G;
		this.edgeTo = new int[G.V()];
		this.marked = new boolean[G.V()];
	}
	
	public DirectedDFS(Digraph G, int s)
	{
		this(G);
		dfs(s);
		
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> sources)
	{
		this(G);
		for(int i: sources) 
		{
			dfs(i);
		}
	}
	
	private void dfs(int v)
	{
		marked[v] = true;
		
		for (int w: G.adj(v))
		{
			if (!marked[w])
			{
				dfs(w);
				edgeTo[w] = v;
			}
		}

	}
	
	public boolean marked(int v)
	{
		return marked[v];
	}

}
