
public class Main 
{
	
	public static void main(String[] args)
	{

		DFA dfa = new DFA(strToArr("BYEBYE"), strToArr("BYE"));
		dfa.print();

	}

	public static String[] strToArr(String s)
	{
		String[] r = new String[s.length()];
		for (int i = 0; i < s.length(); i++)
			r[i] = String.valueOf(s.charAt(i));
		return r;
	}
	
}
