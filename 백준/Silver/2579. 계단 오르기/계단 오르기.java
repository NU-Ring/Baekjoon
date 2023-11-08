import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N+2];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		int dp[][]=new int[N+2][2];
		
		dp[0][0]=arr[0];
		dp[1][0]=arr[0]+arr[1];
		dp[1][1]=arr[1];
		for(int i=2;i<N;i++)
		{
			dp[i][0]=dp[i-1][1]+arr[i]; //한칸으로 이번계단에 오기(한칸이전계단, 두칸으로 올라온것만)
			dp[i][1]=Math.max(dp[i-2][0],dp[i-2][1])+arr[i]; //두칸으로 이번계단에 오기(두칸이전계단, 한칸으로 올라온 것, 두칸으로 올라온 것 둘 다 가능)
		}
		System.out.println(Math.max(dp[N-1][0],dp[N-1][1]));
	}
}