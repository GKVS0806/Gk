package javaapract;

public class StringExtractionHello 
{
	public static void main(String[] args) 
	{
	String s="01H23E45L67L89O";	
	    String[] ch =s.split("");
	for (int i = 2; i < ch.length; i=i+3) 
	{
		System.out.println(ch[i]);
	}
	
	}       
}
