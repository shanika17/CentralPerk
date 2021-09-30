package com.example.log;

public class RoomCalculation {
    protected String calculateRoomDiscount(int room_one, int room_two, int room_three, int room_four){
        int Price1, Price2, Price3, Price4, roomRate;
        double roomDiscount, roomPay, roomTotal;
        String rDiscount, rPayment, rTotal;

        switch(room_one){
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

        switch(room_two){
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

        switch(room_three){
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

        switch(room_four){
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

        roomTotal = Price1 + Price2 + Price3 + Price4;

        if(roomTotal > 35000){
            roomRate = 50;
        }
        else if(roomTotal > 25000){
            roomRate = 25;
        }
        else if(roomTotal > 15000){
            roomRate = 10;
        }
        else{
            roomRate = 0;
        }

        roomDiscount = roomTotal * (roomRate/100.0);
        roomPay = roomTotal - roomDiscount;

        rDiscount = String.format("Rs%.2f", roomDiscount);
        rPayment = String.format("Rs%.2f", roomPay);
        rTotal = String.format("Rs%.2f", roomTotal);


        String answer = "Total  :  " +rTotal+ "\nDiscount  :  " +roomRate+ "% off" + "\nDiscount Amount  :  " +rDiscount+ "\nAmount Payable  :  " +rPayment;
        return answer;
    }
}
