package excercise;

public class pastdueLedger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double AmountPaid=0.00;
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
		double PaidAmount;
		double totalfirst=prorateRent+prorateIns;//21.5
		diff=AmountPaid-totalfirst;//11-21.5=10.5

		if(AmountPaid<totalfirst) {//11<21.5

			if(AmountPaid>=prorateRent) {//11>10
				rentPaid=prorateRent;
				
				rentL=0.00;
				diff=AmountPaid-rentPaid;//11-10=1
				if(diff>=prorateIns) {//1>1.5
					insPaid=prorateIns-diff;
				
					insL=0.00;
				}
				else {
					
					insL=prorateIns-diff;//1.5-1
					insPaid=prorateIns-insL;
					
				}}
				else {//20>11
					rentL=prorateRent-AmountPaid;//9
					rentPaid=AmountPaid;
					diff=AmountPaid-rentPaid;
				}
		}
		

		
		/*if(AmountPaid>0.00&&AmountPaid<totalfirst) {
			diff=AmountPaid-totalfirst;
			while(diff<0.00) {
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
				while(AmountPaid>totalfirst) {
				if(diff>prorateRent) {//15=10
					diff=AmountPaid-prorateRent;//15-10=5
					rentL=prorateRent;//10
					totalfirst=prorateRent+prorateIns;

					if(diff>prorateIns) {//5>1.5
						diff=AmountPaid-prorateIns;//15-1.5=13.5
						insL=prorateIns;//13.5-10=3.5
						totalfirst=prorateRent+prorateIns;
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
	System.out.printf("rentL: %2f\n",rentL);
	System.out.printf("insL: %2f\n",insL);
	System.out.printf("diff: %2f\n",diff);
	}

}
