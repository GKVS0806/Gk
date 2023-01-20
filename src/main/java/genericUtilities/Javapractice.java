package genericUtilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Javapractice
{
public static void main(String[] args) 
{
	HashSet hs = new HashSet();
	hs.add("blue");
	hs.add("green");
	hs.add("red");
	hs.add("yellow");
	
	System.out.println(hs);
	
	ArrayList a1 = new ArrayList(hs);
	System.out.println(a1.get(0));
	
	
	
	
	
}
}
