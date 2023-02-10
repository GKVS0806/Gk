package javaapract;

public class RemovingDuplicatesfromArray 
{
public static void main(String[] args) 
{
int arr[]= {1,2,3,4,5,3,6,7,8};
for (int i = 0; i < arr.length; i++) 
{
	int count=0;
for (int j = i+1; j < arr.length; j++)
{
if(arr[i]==arr[j])
{
count++;	
}
}
if(count<=0)
{
	System.out.println(arr[i]);
}
}


}
}
