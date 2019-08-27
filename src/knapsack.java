

import java.util.ArrayList;
import java.util.*;


public class knapsack 
{
	
	public static void main(String args[])
	{

		Scanner scan = new Scanner(System.in);
		ArrayList<Items> items = new ArrayList<Items>();
		Items i0 = new Items(0,0);
		items.add(i0);
		System.out.print("Enter Number of Items You Wish to add: ");
		int n = scan.nextInt();
		
		for(int i=1; i<=n ; i++)
		{
			System.out.println("\nItem No: "+i);
			System.out.print("Enter Weight : ");
			int weight = scan.nextInt();
			System.out.print("Enter Value : ");
			int value = scan.nextInt();
			System.out.println();
			Items Items = new Items(weight,value);
			items.add(Items);
			
			
		}
		
		System.out.print("Enter Weight you can hold: ");
		int MaxWeight = scan.nextInt();
		int[][] matrix = new int[items.size()][MaxWeight+1];
		for(int w=0 ; w<=MaxWeight ; w++)
		{
			matrix[0][w] = 0;
		}
		for(int i=1 ; i<=items.size()-1 ; i++)
		{
			matrix[i][0] = 0;
			
		}
		for(int i=1 ; i<=items.size()-1 ; i++ )
		{
			for(int w=0 ; w<=MaxWeight ; w++)
			{
				Items WeightValue = items.get(i);
			int itemWeight = WeightValue.getWeight();
			int itemValue = WeightValue.getValue();
				if(itemWeight <= w)
				{
					
					if(itemValue + matrix[i-1][w-itemWeight]  > matrix[i-1][w] )
					
						matrix[i][w]=  itemValue + matrix[i-1][w-itemWeight] ;
				   else
					   matrix[i][w]= matrix[i-1][w];
				}
				else
				{
					matrix[i][w]= matrix[i-1][w];
					
				}
				
			}
			
		}

		int i=items.size()-1;
		int k=MaxWeight;
		
		while(i>0 && k>0)
		{
		
			if(matrix[i][k] != matrix[i-1][k])
			{
				Items it = items.get(i);
				int itemWeight = it.getWeight();
				
				System.out.println("(w,v) = ("+it.getWeight()+","+it.getValue()+")");
				i=i-1;
				k=k-itemWeight;
			}
			else
			{
				i=i-1;
				
			}
		}
				

	
	}
	


}

