import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int arr[]=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(N<=2)
		{
			System.out.println(0);
			return ;
		}
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		
		int cnt=0;
		Arrays.sort(arr);
		
		for(int i=0;i<N;i++)
		{
			
			int pt1=0;
			if(i==0)
			{
				pt1=1;
			} // 반례
			//4
			//0 0 0 0
			int pt2=N-1;
			if(i==N-1)
			{
				pt2=N-2;
			}
			if(pt2<0||pt2<=pt1)
			{
				continue;
			}
			int s=arr[i];
			while(true)
			{
				if(s==arr[pt1]+arr[pt2])
				{
					cnt++;
					break;
				}
				else
				{
					if(s<arr[pt1]+arr[pt2])
					{
						pt2--;
						if(pt2==i)
						{
							pt2--;
						}
						if(pt1>=pt2)
						{
							break;
						}
					}
					else // s>arr[pt1]+arr[pt2]
					{
						pt1++;
						if(pt1==i)
						{
							pt1++;
						}
						if(pt2==pt1)
						{
							break;
						}
					}
				}
			}
		}
		System.out.println(cnt);

	}
}