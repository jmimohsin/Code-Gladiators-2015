import java.io.*;
import java.util.*; 

public class Medium 
{ 
public static int node_covered;
public static int big=0;
public static boolean[] visited;
public static int matrix_length;
public static boolean[][] matrix;

public static String[] input=new String[]
//{"1#2", "2#3", "1#11", "3#11", "4#11", "4#5","5#6", "6#7", "4#12", "8#12","9#12","8#10","9#10","8#9"};
//{"1#2", "2#3","3#4","3#5","5#6","5#7","6#7","7#8"};
{"1#10","2#10","8#10","2#5","2#6","3#5","3#7","6#7","7#9","4#6","4#8","4#9"};

	public static void main(String[] args){
	      int hello=maxno_city(input);
	      System.out.println(hello);
      }

    public static int maxno_city(String[] input1)
    {
	int ln=input1.length;
	HashSet hs = new HashSet();

	for(int i=0; i<ln;i++)
	{
		String[] temp=input1[i].split("#");		
		hs.add(temp[0]);		
		hs.add(temp[1]);	
	}
	
	matrix_length=hs.size();
	//System.out.println(matrix_length);
	hs.clear();

	matrix=new boolean[matrix_length][matrix_length];
	//System.out.println(Arrays.deepToString(matrix));
	
	for(int i=0;i<ln;i++)
	{
		
		String[] temp=input1[i].split("#");
		int first=Integer.parseInt(temp[0])-1;
		int second=Integer.parseInt(temp[1])-1;
		//System.out.println((first+1)+" -> "+(second+1));
		matrix[first][second]=true;
		matrix[second][first]=true;
		
	}
	//System.out.println(Arrays.deepToString(matrix));
	//initialized
	//now start work on matrix
	for(int i=0;i<matrix_length;i++)
	{
		for(int j=0; j<matrix_length;j++)
		{
			visited=new boolean[matrix_length];
			if(matrix[i][j])
			{
				node_covered=1;
				//System.out.print("node from "+(i+1)+"->");
				visited[i]=true;
				getNextPath(j);
				
			}	
		}
	}
        return big;
    }
	
	//recursive method
	public static void getNextPath(int path)
	{
		node_covered++;
		for(int i=0;i<matrix_length;i++)
		{
			if(matrix[path][i] && !visited[i])
			{
				//System.out.print((path+1)+"->");
				//node_covered++;
				visited[path]=true;
				getNextPath(i);
			}
		}
		
		//System.out.print(path+1);
		//System.out.println("");

		if(big<node_covered)
		{
			big=node_covered;
		//	System.out.println("BIG: "+big);
		}
		//System.out.println("Node covered: "+node_covered);
		node_covered--;
		visited[path]=false;
	}
}
