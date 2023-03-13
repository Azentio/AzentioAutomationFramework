package resources;

import java.time.LocalDate;
import java.time.Month;

public class DateIncrementDecrement {
	
	public String dateIncrementor(int year,int month,int day)
	{
		String Strmonth="";
		String finalDate="";		
		LocalDate localDate=LocalDate.of(year, month, day);
		LocalDate plusDays = localDate.plusDays(1);
		String plusDayStr = plusDays.toString();
		String[] splitDay = plusDayStr.split("-");
		
		String splitMonth=splitDay[1];
		String splitDays=splitDay[2];
		for(int i=0;i<splitMonth.length()-1;i++)
		{
			if(splitMonth.charAt(i)=='0')
			{
				splitMonth=splitMonth.substring(i+1);
				
			}
		}
		
		for(int i=0;i<splitDays.length()-1;i++)
		{
			if(splitDays.charAt(i)=='0')
			{
				splitDays=splitDays.substring(i+1);
				
			}
		}
				switch(splitMonth)
				{
				case "1":
					Strmonth=Month.JANUARY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "2":
					Strmonth=Month.FEBRUARY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "3":
					Strmonth=Month.MARCH.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "4":
					Strmonth=Month.APRIL.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "5":
					Strmonth=Month.MAY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "6":
					Strmonth=Month.JUNE.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "7":
					Strmonth=Month.JULY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "8":
					Strmonth=Month.AUGUST.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "9":
					Strmonth=Month.SEPTEMBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "10":
					Strmonth=Month.OCTOBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "11":
					Strmonth=Month.NOVEMBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "12":
					Strmonth=Month.DECEMBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
					
				}
				finalDate=String.valueOf(year)+"-"+Strmonth+"-"+splitDays;
		return finalDate;
	}
	public String dateDecrementor(int year,int month,int day)
	{
		String Strmonth="";
		String finalDate="";
		
		LocalDate localDate=LocalDate.of(year, month, day);
		LocalDate plusDays = localDate.minusDays(1);
		
		
		String plusDayStr = plusDays.toString();
		String[] splitDay = plusDayStr.split("-");
		
		String splitMonth=splitDay[1];		
		String splitDays=splitDay[2];
		
		for(int i=0;i<splitMonth.length()-1;i++)
		{
			if(splitMonth.charAt(i)=='0')
			{
				
				splitMonth=splitMonth.substring(i+1);	
				
			}
		}
		for(int i=0;i<splitDays.length()-1;i++)
		{
			if(splitDays.charAt(i)=='0')
			{
				splitDays=splitDays.substring(i+1);
				
			}
		}
		
				switch(splitMonth)
				{
				case "1":
					Strmonth=Month.JANUARY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "2":
					Strmonth=Month.FEBRUARY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "3":
					Strmonth=Month.MARCH.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "4":
					Strmonth=Month.APRIL.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "5":
					Strmonth=Month.MAY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "6":
					Strmonth=Month.JUNE.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "7":
					Strmonth=Month.JULY.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "8":
					Strmonth=Month.AUGUST.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "9":
					Strmonth=Month.SEPTEMBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "10":
					Strmonth=Month.OCTOBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "11":
					Strmonth=Month.NOVEMBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
				case "12":
					Strmonth=Month.DECEMBER.toString();
					Strmonth=Strmonth.substring(0,1)+Strmonth.substring(1).toLowerCase();	
					break;
					
				}
				finalDate=String.valueOf(year)+"-"+Strmonth+"-"+splitDays;
		return finalDate;
	}
	/*public static void main(String args[])
	{
		DateIncrementDecrement test= new DateIncrementDecrement();

		String dateIncrementor = test.dateIncrementor(2000, 8, 9);	
		System.out.println(dateIncrementor);
		String dateDecrementor = test.dateDecrementor(2024, 3, 30);
		System.out.println(dateDecrementor);
		
	}*/

}
