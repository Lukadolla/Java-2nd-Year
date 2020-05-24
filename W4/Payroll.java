package com.company.W4;

public class Payroll {

    static double OVERTIME_RATE = 1.5;
    static int REGULAR_WEEK = 40;
    static int LEVEL_ONE_PAY = 15;
    static int LEVEL_TWO_PAY = 25;
    static int LEVEL_THREE_PAY = 40;

    enum PayLevel {ONE, TWO, THREE}

    private PayLevel pay;
    int noHoursWorked;

    public static void main(String[] args) {

    }

    public static double calculatePay(int noHoursWorked, PayLevel pay)
    {
        if(noHoursWorked < 1 || noHoursWorked > 80)
        {
            throw new IllegalArgumentException("Hours Worked exceeds the maximum");
        }

        int excess;
        switch (pay) {
            case ONE:
                if (noHoursWorked <= REGULAR_WEEK) {
                    return noHoursWorked * LEVEL_ONE_PAY;
                } else {
                    excess = noHoursWorked - REGULAR_WEEK;
                    return REGULAR_WEEK * LEVEL_ONE_PAY + excess * LEVEL_ONE_PAY * OVERTIME_RATE;
                }
            case TWO:
                if (noHoursWorked <= REGULAR_WEEK) {
                    return noHoursWorked * LEVEL_TWO_PAY;
                } else {
                    excess = noHoursWorked - REGULAR_WEEK;
                    return REGULAR_WEEK * LEVEL_TWO_PAY + excess * LEVEL_TWO_PAY * OVERTIME_RATE;
                }
            case THREE:
                if (noHoursWorked <= REGULAR_WEEK) {
                    return noHoursWorked * LEVEL_THREE_PAY;
                } else {
                    excess = noHoursWorked - REGULAR_WEEK;
                    return REGULAR_WEEK * LEVEL_THREE_PAY + excess * LEVEL_THREE_PAY * OVERTIME_RATE;
                }

            default: return REGULAR_WEEK;
            }
        }

}
