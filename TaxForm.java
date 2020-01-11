import java.util.Scanner;
import java.text.NumberFormat;
/**
 * Write a description of class TaxForm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TaxForm
{
    private int wages;
    private int taxableInterest;
    private int unemploymentCompensation;
    private int federalIncomeTaxWithHeld;
    private int exemptions;
    private double deduction;
    private double adjustedGrossIncome;
    private double taxableIncome;
    private double tax;
    private double amountOwed;
    private double refund;
    private final double FIFTEEN_PCT = 0.15;
    private final double TWEENTY_FIVE_PCT = 0.25;
    private final double TWEENTY_EIGHT_PCT = 0.28;
    private final double TEN_PCT = 0.10;

    public void estimateTaxes()
    {
        Scanner scnr = new Scanner(System.in);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Your information");

        System.out.print("Wages, salaries and tips:");
        wages = scnr.nextInt();
        System.out.print("Taxable interest:");
        taxableInterest = scnr.nextInt();
        System.out.print("Umemployment compensation:");
        unemploymentCompensation = scnr.nextInt();
        System.out.print("Exemptions:");
        exemptions = scnr.nextInt();
        System.out.print("Federal income tax withheld:");
        federalIncomeTaxWithHeld = scnr.nextInt();

        adjustedGrossIncome = wages + taxableInterest + unemploymentCompensation;
        if(exemptions == 0)
        {
            deduction = 6200;
        }else if(exemptions == 1)
        {
            deduction = 10150;
        }else{
            System.out.println("exemption must be 0 or 1");
        }
        taxableIncome = adjustedGrossIncome - deduction;
        if((taxableIncome > 0) && (taxableIncome <= 9075))
        {
            tax = Math.round(taxableIncome * TEN_PCT);
        }else if ((taxableIncome > 9075) && (taxableIncome <= 36900))
        {
            tax = Math.round((taxableIncome - 9075) * FIFTEEN_PCT + 908);

        }else if ((taxableIncome > 36900) && (taxableIncome <= 89350))
        {
            tax = Math.round((taxableIncome - 36900) * TWEENTY_FIVE_PCT + 5081);
        }
        else if ((taxableIncome > 89350) && (taxableIncome <= 186350))
        {
            tax = Math.round((taxableIncome - 89350) * TWEENTY_EIGHT_PCT + 18194);

        }

        System.out.println("Your results");
        System.out.println("AGI: " + adjustedGrossIncome);
        System.out.println("Taxable income: " + taxableIncome);
        System.out.println("Federal tax: " + tax);

        if(tax > federalIncomeTaxWithHeld)
        {
            amountOwed = tax - federalIncomeTaxWithHeld ;
            System.out.println("Amound due: " + amountOwed);
        }else if (tax < federalIncomeTaxWithHeld)
        {
            amountOwed = 0 ;
            refund = federalIncomeTaxWithHeld - tax;
            System.out.println("Your refund: " + refund);
        }
    }

}
