/*
package com.example.log;

public class Calculations {

    protected String calculateDiscount(int food, int room, int event, int spar){
        int roomPrice, foodPrice, eventPrice, sparPrice, rate;
        double discount, pay, total;
        String Discount, Payment, Total;

        switch(food){
            case 1:
                foodPrice = 6500;
                break;
            case 2:
                foodPrice = 4000;
                break;
            case 3:
                foodPrice = 10000;
                break;
            case 4:
                foodPrice = 8000;
                break;
            default:
                foodPrice = 0;
                break;
        }

        switch(room){
            case 1:
                roomPrice = 6500;
                break;
            case 2:
                roomPrice = 4000;
                break;
            case 3:
                roomPrice = 10000;
                break;
            case 4:
                roomPrice = 8000;
                break;
            default:
                roomPrice = 0;
                break;
        }

        switch(event){
            case 1:
                eventPrice = 6500;
                break;
            case 2:
                eventPrice = 4000;
                break;
            case 3:
                eventPrice = 10000;
                break;
            case 4:
                eventPrice = 8000;
                break;
            default:
                eventPrice = 0;
                break;
        }

        switch(spar){
            case 1:
                sparPrice = 6500;
                break;
            case 2:
                sparPrice = 4000;
                break;
            case 3:
                sparPrice = 10000;
                break;
            case 4:
                sparPrice = 8000;
                break;
            default:
                sparPrice = 0;
                break;
        }

        total = roomPrice + eventPrice + foodPrice + sparPrice;

        if(total > 35000){
            rate = 50;
        }
        else if(total > 25000){
            rate = 25;
        }
        else if(total > 15000){
            rate = 10;
        }
        else{
            rate = 0;
        }

        discount = total * (rate/100.0);
        pay = total - discount;

        Discount = String.format("Rs%.2f", discount);
        Payment = String.format("Rs%.2f", pay);
        Total = String.format("Rs%.2f", total);


        String answer = "Total  :  " +Total+ "\nDiscount  :  " +rate+ "% off" + "\nDiscount Amount  :  " +Discount+ "\nAmount Payable  :  " +Payment;
        return answer;
    }
}
*/