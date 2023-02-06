package excercise;

public class Smartstoppastdueledger {
	public static void main(String[] args) {
		double AmountPaid=1;
		double rent=100;
		double rentAmount=100.00;
		double prorateRent=10.00;
		double prorateIns=1.50;
		double prorateFees=0.5;
		double insAmount=11.00;	
		double feesAmount=0.00;
		double totalMonthly=111.00;
		double rentL=prorateRent;
		double insL=prorateIns;
		double feesL=prorateFees;
		double diff=0.00;
		double rentPaid=0.00;
		double insPaid=0.00;
		double feesPaid=0.00;
		double PaidAmount;
		double totalfirst=prorateRent+prorateIns+prorateFees;//21.5
		diff=AmountPaid-totalfirst;//11-21.5=10.5

		if(AmountPaid<totalfirst) {//10<21.5
			if(AmountPaid>=prorateFees) {
				feesPaid=prorateFees;
				feesL=0.00;
				diff=AmountPaid-feesPaid;
				
				
				if(diff>=prorateRent) {//11>10
					rentPaid=prorateRent;
					rentL=0.00;
					
					diff=diff-rentPaid;//11-10=1
				
					
					
					if(diff>=prorateIns) {//1>1.5
						insPaid=diff-prorateIns;
					
						insL=0.00;
					}
					else {
						
						insL=prorateIns-diff;//1.5-1
						insPaid=prorateIns-insL;
						
					}}
					else {//20>11
						rentL=prorateRent-diff;//10-10.75
						rentPaid=prorateRent-rentL;
						diff=AmountPaid-rentPaid;
					}
			}
			else {
				feesL=prorateFees-AmountPaid;
				feesPaid=AmountPaid;
				diff=AmountPaid-feesPaid;
			}
			}

			
		
	System.out.printf("rentPaid: %2f\n",rentPaid);
	System.out.printf("insPaid: %2f\n",insPaid);
	System.out.printf("feesPaid: %2f\n",feesPaid);
	System.out.printf("rentL: %2f\n",rentL);
	System.out.printf("insL: %2f\n",insL);
	System.out.printf("feesL: %2f\n",feesL);
	System.out.printf("diff: %2f\n",diff);
	System.out.printf("totalfirst: %2f\n",totalfirst);
	
	}

}
