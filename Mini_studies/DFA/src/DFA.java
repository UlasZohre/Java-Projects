import java.util.HashMap;
import java.util.Map;

public class DFA {

	private int[][] dfa;
	private String[] alphabet;
	private String[] pat;
	private Map<String, Integer> alphabetMap; 
	
	public DFA(String[] pat, String[] alphabet) // pat: pattern
	{
		this.pat = pat;
		this.alphabet = alphabet;
		
		dfa = new int[alphabet.length][pat.length + 1];
		alphabetMap = new HashMap<String, Integer>();
		
		constructAlphabetMap();
		this.construct();
	}
	
	private void constructAlphabetMap() 
	{
		for (int i = 0; i < alphabet.length; i++)
		{
			alphabetMap.put(alphabet[i], i);
		}
	}
	
	private void construct() 
	{
		int x = 0, M = pat.length, N = alphabet.length;
		
		// match transition
		for (int j = 0; j < M; j++)
		{
			String symbol = getSymbol(j);
			
			int symbolIndexInAlphabet = alphabetMap.get(symbol);
			dfa[symbolIndexInAlphabet][j] = j + 1;
		}
		

		for (int i = 0; i < alphabet.length; i++)
		{
			String symbol = getSymbol(0);
			int symbolIndexInAlphabet = alphabetMap.get(symbol);
			if (i == symbolIndexInAlphabet) continue;
			dfa[i][0] = 0;
		}
		
		
		// mismatch transition
		for (int stateIndex = 1; stateIndex < dfa[0].length - 1; stateIndex++)
		{	
			String symbol = getSymbol(stateIndex);
			int symbolIndexInAlphabet = alphabetMap.get(symbol);
			
			for (int j = 0; j < N; j++)
			{
				
				if (symbolIndexInAlphabet == j) continue; // match transition -> already set above
				dfa[j][stateIndex] = dfa[j][x];
			}

			x = dfa[alphabetMap.get(getSymbol(stateIndex))][x];
			
		}
		
	}
	
	private String getSymbol(int j)
	{
		String symbol = pat[j];
		if (!alphabetMap.containsKey(symbol))
		{
			throw new RuntimeException("Alphabet and symbols are not compliant!");
		}
		
		return symbol;
	}
	
	public void print()
	{
		for (int i = 0; i < dfa.length; i++)
		{
			for (int j = 0; j < dfa[0].length; j++)
			{
				System.out.print(dfa[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int search(String[] txt)
	{
		int i, j, N = txt.length;
		for (i = 0, j = 0; i < N && j < pat.length; i++)
			j = dfa[alphabetMap.get(txt[i])][j];
		if (j == pat.length) return i - pat.length;
		else return N;
	}
	
}
