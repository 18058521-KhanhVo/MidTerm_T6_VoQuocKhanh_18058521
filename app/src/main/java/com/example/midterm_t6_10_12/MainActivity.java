package com.example.midterm_t6_10_12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SendingData {

    protected static Context context;
    private int imgID[] = {R.drawable.donut_yellow_1, R.drawable.tasty_donut_1, R.drawable.green_donut_1, R.drawable.donut_red_1};
    private String productName[];
    private String productDesc[];
    private String productPrice[];
    private final ArrayList<Product> arrayList = new ArrayList<>();
    private final ArrayList<Product> cart = new ArrayList<>();
    private RecyclerView mainRecyclerView;
    private ProductAdapter adapter;
    private TextView mainSearchBox;
    private FloatingActionButton mainCartFAB;
    private Button detailAddToCartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_portrait);
        context = this;
        productName = getResources().getStringArray(R.array.product_name);
        productDesc = getResources().getStringArray(R.array.product_desc);
        productPrice = getResources().getStringArray(R.array.product_price);

        Product product;
        for (int i = 0; i < imgID.length; i++) {
            product = new Product(imgID[i], productName[i], productDesc[i], productPrice[i]);
            arrayList.add(product);
        }
        mainRecyclerView = findViewById(R.id.main_recyclerview);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        SendingData sendingData = new SendingData() {
//            @Override
//            public void sendData(Product product) {
//                if (cart.contains(product) == false)
//                    cart.add(product);
//                else
//                    Toast.makeText(MainActivity.this, product.getName() + "This item already add!", Toast.LENGTH_SHORT).show();
//            }
//        };
        adapter = new ProductAdapter(this, arrayList);
        mainRecyclerView.setAdapter(adapter);

        mainSearchBox = findViewById(R.id.main_searchBox);
        mainSearchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        mainCartFAB = findViewById(R.id.main_cartFAB);
        mainCartFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("test","main cart fab was clicked!");
                Intent intent = new Intent(MainActivity.this, Cart_Portrait.class);
                intent.putParcelableArrayListExtra("cart", cart);
                MainActivity.this.startActivity(intent);
            }
        });


//        if (getIntent().hasExtra("name")) {
//            Toast.makeText(this, getIntent().getStringExtra("name") + "", Toast.LENGTH_SHORT).show();
//            cart.add(new Product(getIntent().getIntExtra("img", 0), getIntent().getStringExtra("name"), (String) getIntent().getStringExtra("description"), (String) getIntent().getStringExtra("price")));
//            for (Product product1 : cart) {
//                Log.i("TestCart", product1.getName()+"");
//            }
//            Log.i("TestCart", cart.size()+"");
//            for (int i = 0; i < 10; i++) {
//                Log.i("TestCart", i+"");
//            }

//            finish();
//        }
    }

    private void filter(String text) {
        ArrayList<Product> filteredList = new ArrayList<>();
        for (Product product : arrayList
        ) {
            if (product.getName().toLowerCase().contains(text.toLowerCase()))
                filteredList.add(product);
        }
        adapter.filterList(filteredList);
    }


    @Override
    public void sendData(Product product) {
//        Log.i("Test","sendData in main was accessed");
        if (cart.contains(product) == false) {
            cart.add(product);
//            Log.i("test",product.getName()+"");
//            Log.i("test","product was add!");
//            Log.i("test",cart.size()+"");
        } else
            Toast.makeText(this, product.getName() + " already add to cart!", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.i("TestCart", "onActivityResult has access");
//    }
}