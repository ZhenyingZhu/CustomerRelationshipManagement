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
	     String s="abcabcbb";
	     int result=lengthOfLongestSubstring(s);
		  System.out.println(result);
       return;
	}
	public static int lengthOfLongestSubstring(String s) {
        int rst=1;
        if(s==null||s.equals(""))
          return 0;
        int start=0;
        for(int i=1;i<s.length();i++){
            int tmp=s.substring(start,i).indexOf(s.charAt(i));
            if(tmp==-1)
               rst=Math.max(rst,i+1-start);
            else {
                start=tmp+1+start;
            }
        //    System.out.println(rst);
        }
        return rst;
    }
}



