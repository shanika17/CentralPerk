package com.example.log;

public class FoodCalculation {
    protected String calculateFoodDiscount(int food_one, int food_two, int food_three){
        int Price1, Price2, foodRate;
        double foodDiscount, foodPay, foodTotal;
        String fDiscount, fPayment, fTotal;

        switch(food_one){
            case 1:
                Price1 = 2500;
                break;
            case 2:
                Price1 = 3000;
                break;
            case 3:
                Price1 = 4000;
                break;
            case 4:
                Price1 = 5500;
                break;
            default:
                Price1 = 0;
                break;
        }

        switch(food_two){
            case 1:
                Price2 = 500;
                break;
            case 2:
                Price2 = 650;
                break;
            case 3:
                Price2 = 700;
                break;
            case 4:
                Price2 = 800;
                break;
            default:
                Price2 = 0;
                break;
        }


        foodTotal = (Price1 + Price2) * food_three;

        if(foodTotal > 10000){
            foodRate = 50;
        }
        else if(foodTotal > 8000){
            foodRate = 25;
        }
        else if(foodTotal > 6500){
            foodRate = 10;
        }
        else{
            foodRate = 0;
        }

        foodDiscount = foodTotal * (foodRate/100.0);
        foodPay = foodTotal - foodDiscount;

        fDiscount = String.format("Rs%.2f", foodDiscount);
        fPayment = String.format("Rs%.2f", foodPay);
        fTotal = String.format("Rs%.2f", foodTotal);


        String answer = "Total  :  " +fTotal+ "\nDiscount  :  " +foodRate+ "% off" + "\nDiscount Amount  :  " +fDiscount+ "\nAmount Payable  :  " +fPayment;
        return answer;
    }
}
