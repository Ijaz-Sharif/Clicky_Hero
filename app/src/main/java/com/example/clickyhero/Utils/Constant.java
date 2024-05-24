package com.example.clickyhero.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.clickyhero.Model.ImagePatren;
import com.example.clickyhero.R;

import java.util.ArrayList;
import java.util.Random;

public class Constant {
    private static final String PREF_NAME = "app_preferences";
    public static boolean getAppStatus(Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean("reset", false);
    }
    public static void setAppStatus(Context context , boolean s){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean("reset", s).apply();
    }
    public static int getCorrectCombo(Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getInt("CorrectCombo",0);
    }
    public static void setCorrectCombo(Context context , int s){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt("CorrectCombo", s).apply();
    }

    public static int getViewStatus(Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getInt("ViewStatus",0);
    }
    public static void setViewStatus(Context context , int s){
        SharedPreferences prefs =context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt("ViewStatus", s).apply();
    }

    public static int getRandomNumber(Context context){
        SharedPreferences prefs =context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getInt("RandomNumber",0);
    }
    public static void setRandomNumber(Context context , int s){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt("RandomNumber", s).apply();
    }


    public static String getViewDesign(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString("ViewDesign", "00000");
    }
    public static void setViewDesign(Context context , String s){
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString("ViewDesign", s).apply();
    }

 public static int generateNumber(){
     // Create a Random object
     Random random = new Random();
     // Generate a random number between 1 and 5
     return random.nextInt(5) + 1;
 }

    public static ArrayList<ImagePatren> getList(Context context){
        ArrayList<ImagePatren> imagePatrenArrayList=new ArrayList<ImagePatren>();

        if(getAppStatus(context)){
            int randomNumber=getRandomNumber(context);
               if(randomNumber==1){
                   imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));

                   imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                           ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                           ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));

                   imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                           ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

               }else if(randomNumber==2){
                   imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));

                   imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                           ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));
                   imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                           ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                           ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));


               }
               else if(randomNumber==3){

                   imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));
                   imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                           ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));

                   imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                           ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));


                   imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                           ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));




               }
               else if(randomNumber==4){

                   imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));
                   imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                           ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));

                   imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));



                   imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                           ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                           ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));




               }
               else {
                   imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));

                   imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                           ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));
                   imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                           ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                           ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));

                   imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                           ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));


               }


        }else {
            setRandomNumber(context,generateNumber());
            int randomNumber=getRandomNumber(context);
            if(randomNumber==1){
                imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));

                imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));

                imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                        ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));

                imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                        ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));

                imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                        ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

            }else if(randomNumber==2){
                imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));

                imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));

                imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                        ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));
                imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                        ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

                imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                        ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));


            }
            else if(randomNumber==3){

                imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));
                imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                        ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));

                imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));

                imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                        ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));


                imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                        ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));




            }
            else if(randomNumber==4){


                imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                        ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));

                imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));
                imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));



                imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                        ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

                imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                        ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));




            }
            else {

                imagePatrenArrayList.add(new ImagePatren("Resupply", R.drawable.arrow_downward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_forward,0));
                imagePatrenArrayList.add(new ImagePatren("Eagle 500k Bomb", R.drawable.arrow_upward
                        ,R.drawable.arrow_back,R.drawable.arrow_downward,R.drawable.arrow_downward,R.drawable.arrow_downward));

                imagePatrenArrayList.add(new ImagePatren("Eagle Rearm", R.drawable.arrow_upward
                        ,R.drawable.arrow_upward,R.drawable.arrow_back,R.drawable.arrow_upward,R.drawable.arrow_forward));

                imagePatrenArrayList.add(new ImagePatren("Eagle Airstrike", R.drawable.arrow_upward
                        ,R.drawable.arrow_forward,R.drawable.arrow_downward,R.drawable.arrow_forward,0));
                imagePatrenArrayList.add(new ImagePatren("Reinforce", R.drawable.arrow_upward
                        ,R.drawable.arrow_downward,R.drawable.arrow_forward,R.drawable.arrow_back,R.drawable.arrow_upward));


            }
        }




        return imagePatrenArrayList;
    }


    public static void  resetData(Context context){
       setAppStatus(context,false);
        setCorrectCombo(context,0);
       setViewDesign(context,"00000");
    }

}
