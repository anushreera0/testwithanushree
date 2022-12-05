package ssmproject;

public class smartstop_ledger {
	public static void main(String[] args) {
		double amountPaid=2000.00;
		double totalMonthly=115.00;
		//int prepayPeriod=0;
		double rentAmount=100.00;
		double prorateRent=36.67;
		double prorateIns=4.03;
		double prorateFees=1.47;
		double insAmount=11.00;	
		double feesAmount=4.00;
		double noOfMonthsPaid = Math.floor(amountPaid/totalMonthly);
		double diffAmount=0.00;
		double remCredits=0.00;
		double prepayFees=feesAmount*noOfMonthsPaid;
		prepayFees=prepayFees+prorateFees;
		double prepayrent=rentAmount*noOfMonthsPaid;
		prepayrent=prepayrent+prorateRent;//1740
		double prepayins=insAmount*noOfMonthsPaid;
		prepayins=prepayins+prorateIns;//261
		double totalprepay=0;
		totalprepay=prepayrent+prepayins+prepayFees;//2001
		if(totalprepay>amountPaid) {//2001>2000
			while(totalprepay>amountPaid) {
				diffAmount=totalprepay-amountPaid;//2001-2000=1
				if(diffAmount>feesAmount) {
					diffAmount=diffAmount-feesAmount;
					prepayFees=prepayFees-diffAmount;
					totalprepay=prepayrent+prepayins+prepayFees;//2001

					if(diffAmount>rentAmount) {//1>100
						diffAmount=diffAmount-rentAmount;
						prepayrent=prepayrent-diffAmount;
						totalprepay=prepayrent+prepayins+prepayFees;//2001

						if(diffAmount>insAmount) {//1>15
							diffAmount=diffAmount-insAmount;
							prepayins=prepayins-diffAmount;
							totalprepay=prepayrent+prepayins+prepayFees;//2001
						}
						else {
							prepayFees=prepayFees-diffAmount;//1740-0=1740
							totalprepay=prepayrent+prepayins+prepayFees;//2001

						}

					}
					else {
						prepayrent=prepayrent-diffAmount;//1740-0=1740
						totalprepay=prepayrent+prepayins+prepayFees;//2001
					}
				}

				else {
					prepayins=prepayins-diffAmount;
					totalprepay=prepayrent+prepayins+prepayFees;
				}
			}
		}

			else {//1999<2000
				remCredits=amountPaid-totalprepay;//2000-1999=1
				if(remCredits>feesAmount) {
					prepayFees=prepayFees+feesAmount;
					remCredits=remCredits-feesAmount;
					totalprepay=prepayrent+prepayins+prepayFees;
					remCredits=totalprepay-remCredits;
				
				if(remCredits>rentAmount) {//1>100
					prepayrent=prepayrent+rentAmount;
					remCredits=remCredits-rentAmount;
					totalprepay=prepayrent+prepayins+prepayFees;
					remCredits=totalprepay-remCredits;

					if(remCredits>insAmount) {//1>15
						prepayins=prepayins+insAmount;
						remCredits=remCredits-insAmount;
						totalprepay=prepayrent+prepayins+prepayFees;
						remCredits=totalprepay-remCredits;
					}
					else {
						prepayins=prepayins+remCredits;
						totalprepay=prepayrent+prepayins+prepayFees;
						remCredits=totalprepay-remCredits;
					}

				}
				else {
					prepayrent=prepayrent+remCredits;
					totalprepay=prepayrent+prepayins+prepayFees;
					remCredits=totalprepay-remCredits;
				}

			}
				else {
					prepayFees=prepayFees+remCredits;
					totalprepay=prepayrent+prepayins+prepayFees;
					remCredits=totalprepay-remCredits;

				}
			}

			System.out.printf("prepayrent:%2f\n",prepayrent);
			System.out.printf("prepayins:%2f\n",prepayins);
			System.out.printf("prepayFees:%2f\n",prepayFees);
			System.out.printf("remCredits:%2f\n", remCredits);
			System.out.printf("totalprepay:%2f\n", totalprepay);
			System.out.printf("diffAmount:%2f\n", diffAmount);

		}

	}

