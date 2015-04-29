import java.io.*;
public class C 
{ 

public static String[] input=new String[]{"Bharti", "Bharat", "Akash", "Bhaviye", "Chand", "Brijesh","Chetak", "Arvind", "Bhavna"};

public static StringBuilder output = new StringBuilder();
public static String inputstring;
public static String str="";

    public static void main(String[] args){
	//BBABCBCAB
      int hello=sequences(input);
      System.out.println(hello);
      }
    
    public static void combine() { combine( 0 ); }

    private static void combine(int start ){
 	int n=inputstring.length();
        for( int i = start; i < n; ++i ){
            output.append( inputstring.charAt(i) );
	    if(output.length()>2 && ! str.contains(output))
            	str=str+output+",";
            if ( i < inputstring.length() )
            	combine( i + 1);
            output.setLength( output.length() - 1 );
        }
    }

    public static int sequences(String[] input1)
    {
        int total_length=input1.length;
	char[] ch1=new char[total_length];
	
	for(int i=0; i<total_length; i++)
	{
		ch1[i]=input1[i].charAt(0);
		//System.out.println(""+ch[i]);
	}
	inputstring=String.valueOf(ch1);
	combine();
	str=str+inputstring;
	
	int back_pointer;
	int big=0;

	String[] str_array=str.split(",");
	
	//System.out.println(str);
	int n=str_array.length;
	
	for(int k=0; k<n;k++)
	{
	int ln=str_array[k].length();
	back_pointer=ln-1;
	char[] ch=str_array[k].toCharArray();

	while(back_pointer>0)
	{
	 //System.out.println(back_pointer);
	 for(int i=0; i<ln;i++)
	 {
		if(i==back_pointer)
		{
			
			break;
		}
		
		else
		 {
			if(ch[i]==ch[back_pointer])
			{
			 //System.out.println(ch[i]);
			 String st="";
			 for(int j=i; j<back_pointer+1;j++)
			  st+=ch[j];
			 boolean flag=check(st);
			 if(flag)
  			 {
			  //System.out.println(st);
			  if(big<st.length())
			    big=st.length();
			 }
			}
		}
	 }
	 back_pointer--;
	}
	}

	return big;

    }
    public static boolean check(String s){
	int n = s.length();
	 for (int i=0;i<(n / 2) + 1;++i) {
	     if (s.charAt(i) != s.charAt(n - i - 1)) {
		 return false;
	     }
	  }
	return true;
	}
}
