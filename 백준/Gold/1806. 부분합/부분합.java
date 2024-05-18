import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_골드4_1806_부분합"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int[]arr=new int[N];
		 st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int ans=Integer.MAX_VALUE;
		int sum=arr[0];
		int pt1=0;
		int pt2=0;
	
		while(true)
		{			
			if(sum>=S)
			{
				//System.out.println(pt1+" "+pt2);
				ans=Math.min(ans,pt2-pt1+1);
				sum-=arr[pt1];
				pt1++;
			}
			else
			{
				pt2++;
				if(pt2>=N)
				{
					break;
				}
				sum+=arr[pt2];
			}
			
		}
		if(ans>S)
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(ans);
		}
	}
}
