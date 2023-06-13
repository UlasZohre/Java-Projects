import java.util.Arrays;

// LSD: Least-Significant-Digit-First String Sort
public class LSD 
{
	
	public static void sort(String[] a, int W)
	{
		int R = 256;
		int N = a.length;
		String[] aux = new String[N];
		int loopCounter = 0;
		for (int d = W - 1; d >= 0; d--)
		{
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++)
				count[a[i].charAt(d) + 1]++;
			
			for (int r = 0; r < R; r++)
				count[r+1] += count[r];
			
			for (int i = 0; i < N; i++)
				aux[count[a[i].charAt(d)]++] = a[i];
			
			for (int i = 0; i < N; i++)
				a[i] = aux[i];
			
			loopCounter++;
			System.out.println("The array at the end of loop " + loopCounter + ": " + Arrays.toString(a));
			
		}
	}

}
