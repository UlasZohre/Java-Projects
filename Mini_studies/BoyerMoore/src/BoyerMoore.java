
public class BoyerMoore 
{
	
	private static int charComparisonsCount = 0;
	private static int executionOfOuterLoopCount = 0;
	
	public static int search(String txt, String pat)
	{
		int[] right = buildRightArray(txt, pat);
		
		int N = txt.length();
		int M = pat.length();
		int skip;
		
		charComparisonsCount = 0;
		executionOfOuterLoopCount = 0;
		
		for (int i = 0; i <= N-M; i += skip)
		{
			executionOfOuterLoopCount++;
			skip = 0;
			for (int j = M-1; j >= 0; j--)
			{
				charComparisonsCount++;
				if (pat.charAt(j) != txt.charAt(i+j))
				{
					skip = Math.max(1, j - right[txt.charAt(i+j)]);
					break;
				}
			}
			if (skip == 0) return i;
		}
		
		return N;
	}
	
	private static int[] buildRightArray(String txt, String pat)
	{
		int R = 256; // radix
		
		int[] right = new int[R];
		for (int i = 0; i < R; i++)
			right[i] = getRightmostIndex(pat, (char)i);
		
		return right;
		
	}
	
	private static int getRightmostIndex(String pat, char c)
	{
		if (!pat.contains(String.valueOf(c)))
			return -1;
		
		for (int j = pat.length() - 1; j >= 0; j--)
			if (pat.charAt(j) == c) return j;
		
		return -1;
	}
	
	public static void printReport()
	{
		System.out.println("[BOYER-MOORE]");
		System.out.println("Number of character comparisons: " + charComparisonsCount);
		System.out.println("The outer loop has been executed " + executionOfOuterLoopCount + " times");
	}
	
}
