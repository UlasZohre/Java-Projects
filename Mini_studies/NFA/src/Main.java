
public class Main 
{
	
	public static void main(String[] args)
	{
		//NFA nfa = new NFA("((A*B|AC)D)");
		//System.out.println(nfa.recognizes("AABD"));
		
		NFA nfa = new NFA("(((AB)*A)*C.*)");
		System.out.println(nfa.recognizes("ACB"));
		nfa.printEpsilonTransitions();
	}

}
