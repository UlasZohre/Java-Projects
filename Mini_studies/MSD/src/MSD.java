import java.util.Arrays;

public class MSD {
	
	private static String[] aux;
	private static int R = 256;
	private static int loopCounter = 0;
	
	public static void sort(String[] a)
	{
		loopCounter = 0;
		aux = new String[a.length];
		sort(a, aux, 0, a.length - 1, 0);
	}
	
	private static void sort(String[] a, String[] aux, int lo, int hi, int d)
	{
		if (hi <= lo) return;
		int[] count = new int[R + 2];
		for (int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;
		
		for (int r = 0; r < R + 1; r++)
			count[r + 1] += count[r];
		
		for (int i = lo; i <= hi; i++)
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		
		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];
		
		loopCounter++;
		System.out.println(String.format("After performing key-indexed counting for the %d. time: %s", 
				loopCounter, Arrays.toString(a)));
		
		for (int r = 0; r < R; r++)
			sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
	}
	
	private static int charAt(String str ,int d)
	{
		if (d < str.length()) return str.charAt(d);
		else return -1;
	}

}
