package com.example.clickyhero.Screen;

import static com.example.clickyhero.MainActivity.imagePatrenArrayList;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.clickyhero.R;
import com.example.clickyhero.Utils.Constant;

import java.util.ArrayList;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
         int position;
    TextView comboName;
    ImageView imageOne,imageTwo,imageThree,imageFour,imageFive;
    ArrayList<Integer> imageList=new ArrayList<Integer>();
    int counter=0;
    boolean allImageCheckTrue=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        position=getIntent().getIntExtra("position",0);
        imageOne=findViewById(R.id.imageOne);
        imageTwo=findViewById(R.id.imageTwo);
        imageThree=findViewById(R.id.imageThree);
        imageFour=findViewById(R.id.imageFour);
        imageFive=findViewById(R.id.imageFive);
        comboName=findViewById(R.id.comboName);
    }

    @Override
    protected void onStart() {
         setView();
        super.onStart();
    }

    public void setView(){
        counter=0;
        imageList.clear();
        imageList.add(imagePatrenArrayList.get(position).image1);
        imageList.add(imagePatrenArrayList.get(position).image2);
        imageList.add(imagePatrenArrayList.get(position).image3);
        imageList.add(imagePatrenArrayList.get(position).image4);
        imageList.add(imagePatrenArrayList.get(position).image5);
        comboName.setText(imagePatrenArrayList.get(position).name);
       imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, imagePatrenArrayList.get(position).image1));
        imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, imagePatrenArrayList.get(position).image2));
       imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, imagePatrenArrayList.get(position).image3));
      imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, imagePatrenArrayList.get(position).image4));

        if (imagePatrenArrayList.get(position).image5 == 0) {
           imageFive.setVisibility(View.GONE);
        } else {
           imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, imagePatrenArrayList.get(position).image5));
        }
    }

    public void updateCharAtPosition(char newChar) {
        StringBuilder stringBuilder = new StringBuilder(Constant.getViewDesign(this));
        stringBuilder.setCharAt(position, newChar);
       Constant.setViewDesign(DetailActivity.this,stringBuilder.toString());
    }


    public void ImageUp(View view) {
        ImageButton imageButton = (ImageButton) view;
        Drawable drawable = imageButton.getDrawable();
        // Assuming the drawable resource ID you want to check against
        int expectedDrawableId = imageList.get(counter);
        if (Objects.equals(drawable.getConstantState(), Objects.requireNonNull(ContextCompat.getDrawable(DetailActivity.this, expectedDrawableId)).getConstantState())) {
            // Image of ImageButton is the expected drawable
            // Change the corresponding ImageView to golden star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                  //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
            }
        } else {
            allImageCheckTrue=false;
            // Image of ImageButton is not the expected drawable
            // Change the corresponding ImageView to gray star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
            }
        }
        counter++;
        if(imagePatrenArrayList.get(position).image5==0){
            if(counter==4){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                  updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );
                }else {
                    finish();
                }
            }
        }else {
            if(counter==5){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );
                }else {
                    finish();
                }
            }
        }

    }

    public void ImageBack(View view){
        ImageButton imageButton = (ImageButton) view;
        Drawable drawable = imageButton.getDrawable();
        // Assuming the drawable resource ID you want to check against
        int expectedDrawableId = imageList.get(counter);
        if (Objects.equals(drawable.getConstantState(), Objects.requireNonNull(ContextCompat.getDrawable(DetailActivity.this, expectedDrawableId)).getConstantState())) {
            // Image of ImageButton is the expected drawable
            // Change the corresponding ImageView to golden star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
            }
        } else {
            allImageCheckTrue=false;
            // Image of ImageButton is not the expected drawable
            // Change the corresponding ImageView to gray star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
            }
        }
        counter++;
        if(imagePatrenArrayList.get(position).image5==0){
            if(counter==4){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );                }else {
                    finish();
                }

            }
        }else {
            if(counter==5){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );                }else {
                    finish();
                }
            }
        }
    }
    public void ImageDown(View view){
        ImageButton imageButton = (ImageButton) view;
        Drawable drawable = imageButton.getDrawable();
        // Assuming the drawable resource ID you want to check against
        int expectedDrawableId = imageList.get(counter);
        if (Objects.equals(drawable.getConstantState(), Objects.requireNonNull(ContextCompat.getDrawable(DetailActivity.this, expectedDrawableId)).getConstantState())) {
            // Image of ImageButton is the expected drawable
            // Change the corresponding ImageView to golden star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
            }
        } else {
            allImageCheckTrue=false;
            // Image of ImageButton is not the expected drawable
            // Change the corresponding ImageView to gray star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
            }
        }
        counter++;
        if(imagePatrenArrayList.get(position).image5==0){
            if(counter==4){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );
                }else {
                    finish();
                }
            }
        }else {
            if(counter==5){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );                }else {
                    finish();
                }
            }
        }
    }
    public void ImageForward(View view){
        ImageButton imageButton = (ImageButton) view;
        Drawable drawable = imageButton.getDrawable();
        // Assuming the drawable resource ID you want to check against
        int expectedDrawableId = imageList.get(counter);
        if (Objects.equals(drawable.getConstantState(), Objects.requireNonNull(ContextCompat.getDrawable(DetailActivity.this, expectedDrawableId)).getConstantState())) {
            // Image of ImageButton is the expected drawable
            // Change the corresponding ImageView to golden star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.golden_star));
                    break;
            }
        } else {
            allImageCheckTrue=false;
            // Image of ImageButton is not the expected drawable
            // Change the corresponding ImageView to gray star
            switch (counter) {
                case 0:
                    imageOne.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    //  imageOne.setImageDrawable(getResources().getDrawable(R.drawable.golden_star));
                    break;
                case 1:
                    imageTwo.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 2:
                    imageThree.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 3:
                    imageFour.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
                case 4:
                    imageFive.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.gray_star));
                    break;
            }
        }
        counter++;
        if(imagePatrenArrayList.get(position).image5==0){
            if(counter==4){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));

                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );                }else {
                    finish();
                }
            }
        }else {
            if(counter==5){
                Constant.setAppStatus(DetailActivity.this,true);
                if(allImageCheckTrue){
                    updateCharAtPosition('1');
                    Constant.setCorrectCombo(DetailActivity.this,(Constant.getCorrectCombo(DetailActivity.this)+1));
                }
                else {
                    updateCharAtPosition('2');
                }
                if(Constant.getViewDesign(DetailActivity.this).equals("11111")){
                    startActivity(new Intent(DetailActivity.this,ThanksActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    );
                }else {
                    finish();
                }
            }
        }
    }
}