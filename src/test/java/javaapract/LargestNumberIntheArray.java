package javaapract;

public class LargestNumberIntheArray 
{
public static void main(String[] args) 
{
int arr[]= {2,8,4,10,1};
int max=arr[2];// or int max=0;
for(int i=0;i<arr.length;i++)
{
if(arr[i]>max)	
{
max=arr[i];	
}
}
System.out.println(max);
}
}
