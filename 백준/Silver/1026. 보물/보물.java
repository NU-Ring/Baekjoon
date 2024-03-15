import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ans=0;
		
		int n=Integer.parseInt(br.readLine());
		int[]A=new int[n];
		int[]B=new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			A[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			B[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		for(int i=0;i<n;i++)
		{
			ans+=A[i]*B[n-1-i];
		}
		System.out.println(ans);
	}
}
