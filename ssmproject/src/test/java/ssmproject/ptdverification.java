package ssmproject;

import java.sql.Date;

public class ptdverification {
	public static void main(String[] arg) {
		
		    String date = "12/15/2022";
		    double prepayPeriod = 0;
		    String lastDateOfMonth = LastDateOfCurrentMonth(date, prepayPeriod);
		    double rentValue = 58.02; 
		    //String rentValue = rent.replace("$","");
		    double amountPaidDuringMoveInValue = 0.00;
		    //String amountPaidDuringMoveInValue = amountPaidDuringMoveIn.replace("$", "");
		    double Balance = 0.00;
		    double TotalMonthly = 108.20;
		    double noOfMonthsPaid1 = 1;
		    //var Balance=amountPaidDuringMoveInValue-rentValue;
		    double noOfMonthsPaid2 = (amountPaidDuringMoveInValue/TotalMonthly);
		    double noOfMonthsPaid = noOfMonthsPaid1+noOfMonthsPaid2;
		    //var noOfMonthsPaid = (amountPaidDuringMoveInValue / rentValue);
		    if (amountPaidDuringMoveInValue > rentValue) {
		         noOfMonthsPaid1 = 1;
		        //var Balance=amountPaidDuringMoveInValue-rentValue;
		         noOfMonthsPaid2 = (Balance/TotalMonthly);
		         noOfMonthsPaid = noOfMonthsPaid1+noOfMonthsPaid2;
		    } else {
		         noOfMonthsPaid = (amountPaidDuringMoveInValue / rentValue);
		    }




		    if (noOfMonthsPaid !== 1) {
		        var paidTroughDateYear = new Date(date.setMonth(date.getMonth() + noOfMonthsPaid));
		        var lastDate = new Date(paidTroughDateYear.getFullYear(), paidTroughDateYear.getMonth(), 0);
		        var paidTroughDate = ("0" + (lastDate.getMonth() + 1)).slice(-2) + "/" + lastDate.getDate() + "/" + lastDate.getFullYear();
		        return paidTroughDate;



		    } else {
		        var paidTroughDate = lastDateOfMonth;
		        return paidTroughDate;



		    }



		
		 public static String LastDateOfCurrentMonth(String date, String prepayPeriod) {
		    Date date = new Date(date);
		    Date lastDay;
		    Date lastDay = "";
		    if (prepayPeriod > 0) {
		        lastDay = new Date(date.getYear(), date.getMonth() + 1 + prepayPeriod, 0);



		    } else {
		        lastDay = new Date(date.getYear(), date.getMonth() + 1, 0);



		    }
		    return ("0" + (lastDay.getMonth() + 1)).slice(-2) + "/" + lastDay.getDate() + "/" + lastDay.getYear();



		}
	

}
