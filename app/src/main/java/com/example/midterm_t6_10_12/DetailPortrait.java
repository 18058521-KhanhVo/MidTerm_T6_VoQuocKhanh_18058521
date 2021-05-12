package com.example.midterm_t6_10_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailPortrait extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailName, detailDesc, detailPrice;
    private Button detailAddToCartButton;
    private int imgID;
    private String name, description, price;
    private SendingData sendingData = (SendingData) MainActivity.context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_portrait);

        detailImage = findViewById(R.id.detail_image);
        detailName = findViewById(R.id.detail_name);
        detailDesc = findViewById(R.id.detail_description);
        detailPrice = findViewById(R.id.detail_price);
        detailAddToCartButton = findViewById(R.id.detail_addtocartbtn);
        detailAddToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("test","add to cart was clicked!");
                sendingData.sendData(getProduct());
            }
        });

        getData();
        setData();

//        detailImage = findViewById(R.id.detail_image);
//        detailImage.setImageResource(imgID);
//        detailImage.getResources().
//        context = this;

//        detailAddToCartButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, MainActivity.class);
//                intent.putExtra("img", imgID);
//                intent.putExtra("name", name);
//                intent.putExtra("description", description);
//                intent.putExtra("price", price);
////                setResult(RESULT_OK,intent);
////                startActivityForResult(intent,RESULT_OK);
//                context.startActivity(intent);
//                finish();
//            }
//        });

    }

    public void getData() {
        if (getIntent().hasExtra("productImage") && getIntent().hasExtra("productName") &&
                getIntent().hasExtra("productDesc") && getIntent().hasExtra("productPrice")) {
            imgID = getIntent().getIntExtra("productImage", 0);
            name = getIntent().getStringExtra("productName");
            description = getIntent().getStringExtra("productDesc");
            price = getIntent().getStringExtra("productPrice");
        } else Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
    }

    public void setData() {
        detailImage.setImageResource(imgID);
        detailName.setText(name);
        detailDesc.setText(description);
        detailPrice.setText(price);
    }

    public Product getProduct() {
        Product product = new Product(imgID, name, description, price);
        return product;
    }
}