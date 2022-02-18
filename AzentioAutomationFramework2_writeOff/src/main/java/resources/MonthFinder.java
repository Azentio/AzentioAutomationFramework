package resources;

import java.time.Month;

public class MonthFinder {
	public Month capitalizationMonth;

public Month monthFinder(String month)
{
	switch(month){
	case "Jan":
		capitalizationMonth=capitalizationMonth.JANUARY;
		break;
	case "Feb":
		capitalizationMonth=capitalizationMonth.FEBRUARY;
		break;
	case "Mar":
		capitalizationMonth=capitalizationMonth.MARCH;
		break;
	case "Apr":
		capitalizationMonth=capitalizationMonth.APRIL;
		break;
	case "May":
		capitalizationMonth=capitalizationMonth.MAY;
		break;
	case "Jun":
		capitalizationMonth=capitalizationMonth.JUNE;
		break;
	case "Jul":
		capitalizationMonth=capitalizationMonth.JULY;
		break;
	case "Aug":
		capitalizationMonth=capitalizationMonth.AUGUST;
		break;
	case "Sep":
		capitalizationMonth=capitalizationMonth.SEPTEMBER;
		break;
	case "Oct":
		capitalizationMonth=capitalizationMonth.OCTOBER;
		break;
	case "Nov":
		capitalizationMonth=capitalizationMonth.NOVEMBER;
		break;
	case "Dec":
		capitalizationMonth=capitalizationMonth.DECEMBER;
		break;
		
		
		
	}
	return capitalizationMonth;
	}

}
