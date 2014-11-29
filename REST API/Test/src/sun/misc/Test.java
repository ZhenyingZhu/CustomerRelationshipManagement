package sun.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Test {
	public static void main (String[] ags){
	     String str="-2147483647";
	  int result=atoi(str);
		  System.out.println(result);
       return;
	}
		public static int atoi(String str) {
			if(str==null||str.equals("")) return 0;
	        int rst=0;
	        int i=0;
	        int end=str.length()-1;
	        boolean negative=false;
	        while(i<=end&&Character.isWhitespace(str.charAt(i)))
	             i++;
	        if(i>end) return 0;
	        while(end>=i&&Character.isWhitespace(str.charAt(end)))
	             end--;
	        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
	            if(str.charAt(i)=='-') negative=true;
	            i++;
	        }
	        int gap=Integer.MAX_VALUE;
	       for(;i<=end;i++){
	    	     if(!Character.isDigit(str.charAt(i))) break;
	    	     if(rst>=(Integer.MAX_VALUE-10)/10){
	                  double tmp=214748364.7-(double)rst;
	              if(!negative){
	                  if(Character.getNumericValue(str.charAt(i))/(float)10>tmp)
	                    return Integer.MAX_VALUE;
	              }
	              else{
	                  if(Character.getNumericValue(str.charAt(i))/(float)10>tmp+0.1)
	                    return Integer.MIN_VALUE;
	              }
	           }
	              rst=rst*10+Character.getNumericValue(str.charAt(i));
	       }
	       if(negative) rst=(-1)*rst;
	       return rst;
    }
}



