import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int[]arr = new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int pt1=0;
		int pt2=0;
		int sum=arr[pt1];
		
		
		int ans=Integer.MAX_VALUE;
		while(true)
		{
			if(s<=sum)
			{
				ans=Math.min(ans,pt2-pt1);
			}
			if(s>sum||pt1==pt2)
			{
				pt2++;
				if(pt2==n)
				{
					break;
				}
				sum+=arr[pt2];
			}
			else
			{
				sum-=arr[pt1];
				pt1++;
			}
		}
		
		if(ans!=Integer.MAX_VALUE)
		{
			System.out.println(ans+1);
		}
		else
		{
			System.out.println(0);
		}
	}
}