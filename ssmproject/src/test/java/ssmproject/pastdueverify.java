package ssmproject;

public class pastdueverify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double AmountPaid=11.00;
		double rent=100;
		double rentAmount=100.00;
		double prorateRent=10.00;
		double prorateIns=1.50;
		double prorateFees=0.00;
		double insAmount=11.00;	
		double feesAmount=0.00;
		double totalMonthly=111.00;
		double rentL=prorateRent;
		double insL=prorateIns;
		double diff=0.00;
		double rentPaid=0.00;
		double insPaid=0.00;

		if(AmountPaid>0.00) {
		while(AmountPaid<prorateRent) {
			rentPaid=AmountPaid;
			diff=rentPaid-AmountPaid;
			if(diff!=0) {
				if(diff<prorateIns) {
					insPaid=diff;
					diff=insPaid-diff;
					
				}
				else {
					diff=diff-prorateIns;
					insPaid=diff;
					break;
				}
			}
			else {
				diff=diff-prorateRent;
				rentPaid=diff;
				break;
			}
		}
		}
		
		
		
/*double total=prorateRent+prorateIns;//11.5
		if(AmountPaid>0.00&&AmountPaid<totalMonthly) {
			diff=AmountPaid-total;
			if(diff<0.00) {
				if(AmountPaid>prorateRent) {//10=10
					diff=AmountPaid-prorateRent;//10-10=0
					rentL=prorateRent;//10

					if(AmountPaid>prorateIns) {
						diff=AmountPaid-prorateIns;
						insL=diff-prorateIns;
					}
					else {
						
						insL=AmountPaid;
					}}

				else {
					
					rentL=AmountPaid;
				}

			}
			if(diff>0.00) {
				while(AmountPaid>total) {
				if(diff>prorateRent) {//15=10
					diff=AmountPaid-prorateRent;//15-10=5
					rentL=prorateRent;//10
					total=prorateRent+prorateIns;

					if(diff>prorateIns) {//5>1.5
						diff=AmountPaid-prorateIns;//15-1.5=13.5
						insL=prorateIns;//13.5-10=3.5
						total=prorateRent+prorateIns;
					}
					else {
						
						insL=AmountPaid;
						diff=AmountPaid-prorateIns;

					}}

				else {
					
					rentL=AmountPaid;
					diff=AmountPaid-prorateRent;
				}

			}
			}

		}*/
	System.out.printf("rentPaid: %2f\n",rentPaid);
	System.out.printf("insPaid: %2f\n",insPaid);
	}

}


