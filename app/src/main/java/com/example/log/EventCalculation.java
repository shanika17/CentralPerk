package com.example.log;

public class EventCalculation {
    protected String calculateEventDiscount(int event_one, int event_two, int event_three, int event_four){
        int Price1, Price2, Price3, Price4, eventRate;
        double eventDiscount, eventPay, eventTotal;
        String eDiscount, ePayment, eTotal;

        switch(event_one){
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

        switch(event_two){
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

        switch(event_three){
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

        switch(event_four){
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

        eventTotal = Price1 + Price2 + Price3 + Price4;

        if(eventTotal > 35000){
            eventRate = 50;
        }
        else if(eventTotal > 25000){
            eventRate = 25;
        }
        else if(eventTotal > 15000){
            eventRate = 10;
        }
        else{
            eventRate = 0;
        }

        eventDiscount = eventTotal * (eventRate/100.0);
        eventPay = eventTotal - eventDiscount;

        eDiscount = String.format("Rs%.2f", eventDiscount);
        ePayment = String.format("Rs%.2f", eventPay);
        eTotal = String.format("Rs%.2f", eventTotal);


        String answer = "Total  :  " +eTotal+ "\nDiscount  :  " +eventRate+ "% off" + "\nDiscount Amount  :  " +eDiscount+ "\nAmount Payable  :  " +ePayment;
        return answer;
    }
}
