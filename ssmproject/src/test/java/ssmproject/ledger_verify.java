package ssmproject;

public class ledger_verify {

	public static void main(String[] args) {
		double amountPaid=2000.00;
		double totalMonthly=115.00;
		//int prepayPeriod=0;
		double rentAmount=100.00;
		double prorateRent=36.67;
		double prorateIns=5.50;
		double insAmount=15.00;		
		double noOfMonthsPaid = Math.floor(amountPaid/totalMonthly);
		
		double diffAmount=0.00;
		double remCredits=0.00;

		double prepayrent=rentAmount*noOfMonthsPaid;
		prepayrent=prepayrent+prorateRent;//1740
		double prepayins=insAmount*noOfMonthsPaid;
		prepayins=prepayins+prorateIns;//261
		double totalprepay=0;
		totalprepay=prepayrent+prepayins;//2001
		if(totalprepay>amountPaid) {//2001>2000
			while(totalprepay>amountPaid) {
				diffAmount=totalprepay-amountPaid;//2001-2000=1
				if(diffAmount>rentAmount) {//1>100
					diffAmount=diffAmount-rentAmount;
					prepayrent=prepayrent-diffAmount;
					totalprepay=prepayrent+prepayins;
					
					if(diffAmount>insAmount) {//1>15
						diffAmount=diffAmount-insAmount;
						prepayins=prepayins-diffAmount;
						totalprepay=prepayrent+prepayins;
					}
					else {
						prepayrent=prepayrent-diffAmount;//1740-0=1740
						totalprepay=prepayrent+prepayins;//2000

					}
					
				}
				else {
					prepayins=prepayins-diffAmount;//261-1=260
					totalprepay=prepayrent+prepayins;//1740+260=2000
				}
				
			
			}
			
		}
		else {//1999<2000
			remCredits=amountPaid-totalprepay;//2000-1999=1
			if(remCredits>rentAmount) {//1>100
				prepayrent=prepayrent+rentAmount;
				remCredits=remCredits-rentAmount;
				totalprepay=prepayrent+prepayins;
				remCredits=totalprepay-remCredits;

				if(remCredits>insAmount) {//1>15
					prepayins=prepayins+insAmount;
					remCredits=remCredits-insAmount;
					totalprepay=prepayrent+prepayins;
					remCredits=totalprepay-remCredits;
				}
				else {
					prepayins=prepayins+remCredits;
					totalprepay=prepayrent+prepayins;
					remCredits=totalprepay-remCredits;
				}
				
			}
			else {
				prepayrent=prepayrent+remCredits;
				totalprepay=prepayrent+prepayins;
				remCredits=totalprepay-remCredits;
			}
			
		}
		
		System.out.printf("prepayrent:%2f\n",prepayrent);
		System.out.printf("prepayins:%2f\n",prepayins);
		System.out.printf("remCredits:%2f\n", remCredits);
		System.out.printf("totalprepay:%2f\n", totalprepay);
		System.out.printf("diffAmount:%2f\n", diffAmount);
		
	}
	
	

}
