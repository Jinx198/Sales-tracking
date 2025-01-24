/************************************
 * Program Name: SalesTracking.java
 * Programmer's Name: Jay Villanueva
 * Program Description:
 * This program will use arrays to store and process 
 * monthly sales as 
 * well as compute average yearly sales, total sales for the year,
 * and which month had the highest sales and which month 
 * had the lowest sales
 * 
 */
import java.text.NumberFormat;
import java.util.Scanner;
public class SalesTracking
{
	public static void main(String[] args)
	{
		//initialize variables
		double totalSales = 0;
		double averageSales = 0;
		double highestSales = 0;
		double lowestSales = 0;
		String highestSalesMonth = "";
		String lowestSalesMonth = "";
		
		//initialize arrays
		double[] monthlySales = new double[12];
		String[] monthArray = {"January" , "February", "March" , "April" ,
				"May", "June" , "July" , "August", "September" ,"October",
				"November", "December"};
		
		//Initialize Methods
		
		getSales(monthlySales, monthArray);
		totalSales= computeTotalSales(monthlySales);
		highestSales = computeHighestMonth(monthlySales);
		lowestSales = computeLowestMonth(monthlySales);
		highestSalesMonth= FindHighestMonth(monthlySales, monthArray);
		lowestSalesMonth= FindLowestMonth(monthlySales, monthArray);
		displayInfo(totalSales, averageSales, highestSales, lowestSales,
				highestSalesMonth, lowestSalesMonth);
		}
	public static void getSales(double monthlySales[], String monthArray[])
	{
		int i;
		Scanner input = new Scanner(System.in);
		try
		{
			for (i=0; i < monthlySales.length; i++)
			{
				System.out.print("Please enter total sales for "+ monthArray[i]+ ":");
				
				while (!input.hasNextBigDecimal())
				{
					System.out.print("Incorrect data for "+ monthArray[i]+ "! Try again: ");
					input.next();
				}
				monthlySales[i]= input.nextInt();
			}
		}
		finally
                {
                    input.close();
                }
	}
	
	public static double computeTotalSales(double monthlySales[])
	{
		int i;
		double total = 0;
		for (i=0; i< monthlySales.length; i++)
		{
			total = total + monthlySales[i];
		}
		return total;
	}
	
	public static double computeAverageSales(double monthlySales[])
	{
		int i;
		double total =0;
		double average;
		for(i =0; i < monthlySales.length; i++)
		{
			total= total+monthlySales[i];
		}
                average =total/monthlySales.length;
		return average;
	}
	
        public static double computeHighestMonth(double monthlySales[])
	{
		int i;
		double highest = monthlySales[0];
		for(i =0; i < monthlySales.length; i++)
		{
			if(monthlySales[i]> highest)
                        {
                            highest = monthlySales[i];
                        }
		}
		return highest;
	}
        public static String FindHighestMonth(double monthlySales[], String[] monthArray)
        {
            int i;
            double highest = monthlySales[0];
            String highestmonth = "January";
            for(i = 1; i< monthlySales.length; i++)
            {
                if(monthlySales[i]> highest)
                {
                    highest = monthlySales[i];
                    highestmonth=monthArray[i];
                }
            }
            return highestmonth;
        }
        
	public static String FindLowestMonth(double monthlySales[], String[] monthArray)
	{
		int i;
		double lowest = monthlySales[0];
		String lowestmonth = "January";
		
			for (i=1; i< monthlySales.length; i++)
			{
				if(monthlySales[i]< lowest)
				{
					lowest = monthlySales[i];
					lowestmonth = monthArray[i];
				}
			}
            return lowestmonth;
	}
        
        public static double computeLowestMonth(double monthlySales[])
        {
            int j;
            double lowest = monthlySales[0];
            for(j=0; j< monthlySales.length; j++)
            {
                if(monthlySales[j]< lowest)
                {
                    lowest = monthlySales[j];
                }
            }
            return lowest;
        }
	
	public static void displayInfo(double totalSales, double averageSales, double highestsales, double lowestsales, String highestSalesMonth, String lowestSalesMonth)
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		System.out.print("Total annual sales: "+ formatter.format(totalSales) + "\n");
		System.out.print("Average annual sales: " + formatter.format(averageSales)+ "\n");
		System.out.print("The first Month with the Highest annual sales was "+ highestSalesMonth+ " with "+formatter.format(highestsales)+ " in sales" + "\n");
		System.out.print("The first Month with the Lowest annual sales was "+ lowestSalesMonth+ " with "+formatter.format(lowestsales)+ " in sales" +" \n");
	}
	
	
}