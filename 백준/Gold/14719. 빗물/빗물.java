import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());//한 라인을 읽어와 공백을 기준으로 잘라서 입력받는다
		int H=Integer.parseInt(st.nextToken());//(1 ≤ H)
		int W=Integer.parseInt(st.nextToken());//(W ≤ 500)
		int arr[][]=new int[H][W];
		st=new StringTokenizer(br.readLine());
		/*
		 * 입력 예 
		 * 4 4 
		 * 3 0 1 4
		 * 출력 예
		 * 5
		 * -------------
		 * arr[][]의 표현
		 * □ □ □ ■
		 * ■ □ □ ■
		 * ■ □ □ ■
		 * ■ □ ■ ■
		 * -------------
		 * */
		for(int i=0;i<W;i++) 
		{
			int height=Integer.parseInt(st.nextToken());
			for(int j=height;j>0;j--)
			{
				arr[H-j][i]=1;
			}
		}//입력값 입력 종료
		/*for debug
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<W;j++)
			{
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}System.out.println();
		*/
		int ans=0;
		Queue<int[]>q=new LinkedList<>();
		boolean visited[][]=new boolean[H][W];
		for(int i=0;i<H;i++)
		{
			boolean flag=false;
			for(int j=0;j<W;j++)
			{	
				if(visited[i][j]==true)
				{
					continue;
				}
				if(arr[i][j]==1&&flag==false)
				{
					flag=true;
				}
				else if(j==(W-1)&&arr[i][j]!=1)
				{
					//System.out.println(i+" "+j+" 큐 클리어");
					q.clear();
				}
				else if(flag==true)
				{
					if(arr[i][j]==0)
					{
						//System.out.println(i+" "+j+" 큐 삽입");
						q.offer(new int[] {i,j});
					}
					if(arr[i][j]==1)
					{
						//System.out.println("물 채우기 시작");
						while(!q.isEmpty())
						{
							int[] tmp=q.poll();
							visited[tmp[0]][tmp[1]]=true;
							arr[tmp[0]][tmp[1]]=2;
							ans++;
							if(tmp[0]+1<H&&arr[tmp[0]+1][tmp[1]]==0)
							{
								//System.out.println("아래 추가 물채우기 "+(tmp[0]+1)+" "+tmp[1]);
								q.offer(new int[] {tmp[0]+1,tmp[1]});
							}
						}
					}
				}
				/*//for debug
				for(int k=0;k<H;k++)
				{
					for(int p=0;p<W;p++)
					{
						System.out.print(arr[k][p]+" ");
					}System.out.println();
				}System.out.println();
				*/
			}
		}
		System.out.println(ans);
	}
}