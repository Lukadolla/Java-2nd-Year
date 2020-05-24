package com.company.W4;

public class PayClaim {

    public int noWorkingHours;
    public Payroll.PayLevel payLevel;
    public double calculatePay;

    public PayClaim(int nWH, Payroll.PayLevel p) //Constructor
    {
        noWorkingHours = nWH;
        payLevel = p;

        if(noWorkingHours < 1 || noWorkingHours > 80)
        {
            throw new IllegalArgumentException("Working Hours are outside parameter boundaries");
        }
    }

    public int getNoHoursWorked() //Accessor
    {
        return noWorkingHours;
    }

    public Payroll.PayLevel getPayLevel()  //Accessor
    {
        return payLevel;
    }

    public double getCalculatedPay() //Accessor
    {
        return calculatePay;
    }

    public void setCalculatedPay(double calculatePay) //Mutator
    {
        this.calculatePay = calculatePay;

        if(calculatePay < 0)
        {
            throw new IllegalArgumentException("calculatePay variable is less than 0");
        }
    }

    public void calculatePay()
    {
        calculatePay = Payroll.calculatePay(this.noWorkingHours, this.payLevel);
    }

    public static void main(String[] args) {
        Payroll.OVERTIME_RATE = 2;
        Payroll.REGULAR_WEEK = 37;
        Payroll.LEVEL_ONE_PAY = 20;
        PayClaim p = new PayClaim(45, Payroll.PayLevel.ONE);
        p.calculatePay();
        System.out.println(p.getCalculatedPay());

        Payroll.OVERTIME_RATE = 2;
        Payroll.REGULAR_WEEK = 37;
        Payroll.LEVEL_ONE_PAY = 20;
        PayClaim p1 = new PayClaim(45, Payroll.PayLevel.ONE);
        p.calculatePay();
        System.out.println(p1);

        Payroll.OVERTIME_RATE = 1.25;
        Payroll.REGULAR_WEEK = 55;
        Payroll.LEVEL_TWO_PAY = 40;
        PayClaim p2 = new PayClaim(70, Payroll.PayLevel.TWO);
        p.calculatePay();
        System.out.println(p2.getCalculatedPay());

        Payroll.OVERTIME_RATE = 1.25;
        Payroll.REGULAR_WEEK = 55;
        Payroll.LEVEL_TWO_PAY = 40;
        PayClaim p3 = new PayClaim(70, Payroll.PayLevel.TWO);
        p.calculatePay();
        System.out.println(p3);

    }

    public String toString()
    {
        String str = "";

        if(calculatePay == 0 && noWorkingHours == 1)
        {
            str = "PayClaim for " + noWorkingHours + " hour, at PayLevel " + payLevel;
            return str;
        }

        else if(calculatePay == 0 && noWorkingHours != 1)
        {
            str = "PayClaim for " + noWorkingHours + " hours, at PayLevel " + payLevel;
            return str;
        }

        else if(calculatePay != 0 && noWorkingHours == 1)
        {
            str = "PayClaim for " + noWorkingHours + " hour, at PayLevel " + payLevel + ", which gives " + calculatePay;
            return str;
        }

        else if(calculatePay != 0 && noWorkingHours != 1)
        {
            str = "PayClaim for " + noWorkingHours + " hours, at PayLevel " + payLevel + ", which gives " + calculatePay;
            return str;
        }

        else
        {
            return str;
        }
    }
}
