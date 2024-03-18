import java.util.*;
import java.io.*;

public class Main {
	public static StringBuilder sb;
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC=Integer.parseInt(br.readLine());
		for(int tc=0;tc<TC;tc++)
		{
			N=Integer.parseInt(br.readLine());
			//dfs 로직
			//index(n-1회의 기호를 넣으면서 반복, 현재의 계산값, 현재의 계산식, 이전계산기호, 현재 숫자)
			sb=new StringBuilder();
			dfs(1,0,"1",1,1); 
			
			System.out.println(sb);
		}

	}
	public static void dfs(int index, int sum, String his,int op, int num)
	{
		if(index==N)//n-1번의 기호를 모두 넣었다면
		{
			sum+=(num*op);
			if(sum==0) //합산이 0이 되었다면 출력리스트에 추가
			{
				sb.append(his+"\n");
			}
			return;
		}

		
		//공백 넣기
		dfs(index+1,sum,his+" "+Integer.toString(index+1),op,(num*10+(index+1)));
		
		
		//기호결정+숫자확정+계산
		
		//덧셈 계산하기
		dfs(index+1, sum+(num*op), his+"+"+Integer.toString(index+1),1,index+1);
		
		//뺄셈 계산하기
		dfs(index+1, sum+(num*op), his+"-"+Integer.toString(index+1),-1,index+1);
	}
}