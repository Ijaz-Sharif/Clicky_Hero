package com.example.clickyhero;

import static com.example.clickyhero.Utils.Constant.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clickyhero.Model.ImagePatren;
import com.example.clickyhero.Screen.DetailActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
      TextView correct_combo;
      RecyclerView recyclerView;
      String viewDesign;
    public  static   ArrayList<ImagePatren> imagePatrenArrayList=new ArrayList<ImagePatren>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correct_combo=findViewById(R.id.correct_combo);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    protected void onStart() {
       getData();
        super.onStart();
    }

    @SuppressLint("SetTextI18n")
    public void getData(){
        correct_combo.setText("Correct Combos :"+ getCorrectCombo(this));
        imagePatrenArrayList.clear();
        viewDesign= getViewDesign(this);
        imagePatrenArrayList= getList(this);
        recyclerView.setAdapter(new ArrayAdapter());
    }

    public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ImageViewHolder> {

        public ArrayAdapter(){
        }
        @NonNull
        @Override
        public ArrayAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_images,parent,false);
            return  new ArrayAdapter.ImageViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final ArrayAdapter.ImageViewHolder holder, @SuppressLint("RecyclerView") int position) {
                 holder.comboName.setText(imagePatrenArrayList.get(position).name);
            holder.imageOne.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imagePatrenArrayList.get(position).image1));
            holder.imageTwo.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imagePatrenArrayList.get(position).image2));
            holder.imageThree.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imagePatrenArrayList.get(position).image3));
            holder.imageFour.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imagePatrenArrayList.get(position).image4));

            if (imagePatrenArrayList.get(position).image5 == 0) {
                holder.imageFive.setVisibility(View.GONE);
            } else {
                holder.imageFive.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imagePatrenArrayList.get(position).image5));
            }

            /* Convert integer to string */
            char digitAtIndex;
            digitAtIndex = viewDesign.charAt(position);
            if(digitAtIndex=='0'){
                holder.view_background.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            }else if(digitAtIndex=='1'){
                holder.view_background.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.light_green));
            }else if(digitAtIndex=='2'){
                holder.view_background.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));

            }

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(digitAtIndex=='1'){
                        Toast.makeText(MainActivity.this, "You can not play again", Toast.LENGTH_SHORT).show();
                    }else {
                        startActivity(new Intent(MainActivity.this, DetailActivity.class)
                                .putExtra("position",position));
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return imagePatrenArrayList.size();
        }

        public class ImageViewHolder extends RecyclerView.ViewHolder {

           TextView comboName;
            CardView cardView;
            ImageView imageOne,imageTwo,imageThree,imageFour,imageFive;
            LinearLayout view_background;
            public ImageViewHolder(@NonNull View itemView) {
                super(itemView);
                cardView=itemView.findViewById(R.id.cardView);
                imageOne=itemView.findViewById(R.id.imageOne);
                imageTwo=itemView.findViewById(R.id.imageTwo);
                imageThree=itemView.findViewById(R.id.imageThree);
                imageFour=itemView.findViewById(R.id.imageFour);
                imageFive=itemView.findViewById(R.id.imageFive);
                comboName=itemView.findViewById(R.id.comboName);
                view_background=itemView.findViewById(R.id.view_background);
            }
        }
    }

    public void restart(View view){
        resetData(this);
       getData();
    }
}