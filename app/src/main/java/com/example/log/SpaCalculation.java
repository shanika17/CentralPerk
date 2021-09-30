package com.example.log;

public class SpaCalculation {
    protected String calculateSpaDiscount(int spa_one, int spa_two, int spa_three, int spa_four){
        int Price1, Price2, Price3, Price4, spaRate;
        double spaDiscount, spaPay, spaTotal;
        String sDiscount, sPayment, sTotal;

        switch(spa_one){
            case 1:
                Price1 = 6500;
                break;
            case 2:
                Price1 = 4000;
                break;
            case 3:
                Price1 = 10000;
                break;
            case 4:
                Price1 = 8000;
                break;
            default:
                Price1 = 0;
                break;
        }

        switch(spa_two){
            case 1:
                Price2 = 6500;
                break;
            case 2:
                Price2 = 4000;
                break;
            case 3:
                Price2 = 10000;
                break;
            case 4:
                Price2 = 8000;
                break;
            default:
                Price2 = 0;
                break;
        }

        switch(spa_three){
            case 1:
                Price3 = 6500;
                break;
            case 2:
                Price3 = 4000;
                break;
            case 3:
                Price3 = 10000;
                break;
            case 4:
                Price3 = 8000;
                break;
            default:
                Price3 = 0;
                break;
        }

        switch(spa_four){
            case 1:
                Price4 = 6500;
                break;
            case 2:
                Price4 = 4000;
                break;
            case 3:
                Price4 = 10000;
                break;
            case 4:
                Price4 = 8000;
                break;
            default:
                Price4 = 0;
                break;
        }

        spaTotal = Price1 + Price2 + Price3 + Price4;

        if(spaTotal > 35000){
            spaRate = 50;
        }
        else if(spaTotal > 25000){
            spaRate = 25;
        }
        else if(spaTotal > 15000){
            spaRate = 10;
        }
        else{
            spaRate = 0;
        }

        spaDiscount = spaTotal * (spaRate/100.0);
        spaPay = spaTotal - spaDiscount;

        sDiscount = String.format("Rs%.2f", spaDiscount);
        sPayment = String.format("Rs%.2f", spaPay);
        sTotal = String.format("Rs%.2f", spaTotal);


        String answer = "Total  :  " +sTotal+ "\nDiscount  :  " +spaRate+ "% off" + "\nDiscount Amount  :  " +sDiscount+ "\nAmount Payable  :  " +sPayment;
        return answer;
    }
}
