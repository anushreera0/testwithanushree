package ssmproject;

public class transfer_allowance {
	public static void main(String[] args) {
		//double oldrentAmount=100.00;
		//double oldinsAmount=11.00;
		//double oldfeesAmount=4.00;
		double oldproraterent=70.97;
		double oldprorateins=7.81;
		double oldproratefees=0.00;
		double oldtotal=oldproraterent+oldprorateins+oldproratefees;//42.17
		double transferCredits=oldtotal;

		double newrentAmount=200.00;
		double newinsAmount=11.00;
		double newfeesAmount=0.00;
		double newproraterent=141.94;
		double newprorateins=7.81;
		double newproratefees=0.00;
		double newtotal=newproraterent+newprorateins+newproratefees;//40.7
		double total=0.00;
		double newRent=0.00;
		double diffAmount=0.00;
		double newIns=0.00;
		double newFees=0.00;
		double rentAllowance=0.00;
		double insAllowance=0.00;
		double feesAllowance=0.00;
		double dueatTransfer=newtotal;
		if(oldtotal>=newtotal) {
			diffAmount=oldtotal-newtotal;//42.17-40.7=1.47

			//42.17>40.7
			if(diffAmount>0.00) {//1.47<100

				newRent=newrentAmount+newproraterent;//100+36.67=136.67
				newIns=newinsAmount+newprorateins;//11+4.03=15.03
				newFees=newfeesAmount+newproratefees;//0.00
				newtotal=newRent+newIns+newFees;//136.67+15.03+0.00
				feesAllowance=newFees-oldproratefees;

			}

			else if(diffAmount==0) {
				newRent=newproraterent;
				newIns=newprorateins;
				newFees=newproratefees;
				newtotal=newRent+newIns+newFees;

			}
			else {
				newRent=newproraterent+oldproraterent;
				newIns=newprorateins+oldprorateins;
				newFees=newproratefees+oldproratefees;
				newtotal=newRent+newIns+newFees;

			}
			feesAllowance=newFees-oldproratefees;
			rentAllowance=newRent-oldproraterent;
			insAllowance=newIns-oldprorateins;
			if(feesAllowance>0.00) {
				if(rentAllowance<0.00) {
					feesAllowance=feesAllowance+rentAllowance;
					rentAllowance=0.00;
				}
				else {
					feesAllowance=feesAllowance+insAllowance;
					insAllowance=0.00;
				}
			}
			else if(rentAllowance>0.00) {
				if(feesAllowance<0) {
					rentAllowance=rentAllowance+feesAllowance;
					feesAllowance=0.00;	
				}
				else {
					rentAllowance=rentAllowance+insAllowance;
					insAllowance=0.00;					
				}
			}

			else if(insAllowance<0.00){
				if(rentAllowance<0.00) {
					insAllowance=insAllowance+rentAllowance;
					rentAllowance=0.00;
				}
				else {
					insAllowance=insAllowance+feesAllowance;
					feesAllowance=0.00;
				}

			}
		}
		else {
			if(transferCredits>newfeesAmount&&newfeesAmount>0.00) {
				feesAllowance=transferCredits-newproratefees;	
				total=feesAllowance+rentAllowance+insAllowance-transferCredits;
			}
			else if(transferCredits<newfeesAmount&&newfeesAmount>0.00) {
				feesAllowance=transferCredits-newproratefees;	
				total=feesAllowance+rentAllowance+insAllowance-transferCredits;
			}
			else {
				feesAllowance=0.00;
				total=transferCredits-feesAllowance+rentAllowance+insAllowance;

				//rentAllowance=newproraterent-transferCredits;
			}
			if(total>0.00&&newrentAmount>0.00) {
				rentAllowance=newproraterent-total;
				total=feesAllowance+rentAllowance+insAllowance-transferCredits;
			}
			else if(total<0.00&&newrentAmount>0.00) {
				rentAllowance=total-newproraterent;
				total=feesAllowance+rentAllowance+insAllowance-transferCredits;
			}
			else {
				rentAllowance=total-newproraterent;
				total=transferCredits-feesAllowance+rentAllowance+insAllowance;

			}

			if(total>0.00&&newinsAmount>0.00) {
				insAllowance=total-newinsAmount;
				total=feesAllowance+rentAllowance+insAllowance-transferCredits;

			}
			else if(total<0.00&&newinsAmount>0.00) {
				insAllowance=newprorateins;
				total=transferCredits-feesAllowance+rentAllowance+insAllowance;
			}
			else {
				insAllowance=newprorateins;
				total=feesAllowance+rentAllowance+insAllowance-transferCredits;

			}


		}


		System.out.printf("rentAllowance:%2f\n", rentAllowance);
		System.out.printf("insAllowance:%2f\n", insAllowance);
		System.out.printf("feesAllowance:%2f\n", feesAllowance);
		System.out.printf("diffAmount:%2f\n", diffAmount);
		System.out.printf("newRent:%2f\n", newRent);
		System.out.printf("newIns:%2f\n", newIns);
		System.out.printf("newFees:%2f\n", newFees);
		System.out.printf("newtotal:%2f\n", newtotal);
	}
}
