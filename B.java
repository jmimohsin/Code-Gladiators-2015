/*Expert Level
   2    1   3   4
     -1   2   1
        3   -1 
	  -4
*/

import java.io.*;
public class B 
{ 

    public static void main(String[] args){
	
      String hello=sequences("2,1,3,4");
      System.out.println(hello);

}	
    public static String sequences(String input1)
    {
        String[] strArray =  input1.split(",");

	int total_length=strArray.length;
	
	while(total_length>1)
	{
	  for(int i=0; i<total_length-1;i++)
	  { 
	   strArray[i]=""+(Integer.parseInt(strArray[i+1])-Integer.parseInt(strArray[i]));
	  }
	 total_length--;
	}
	return strArray[0];
    }
}
