package com.example.midterm_t6_10_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Cart_Portrait extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private ArrayList<Product> cart=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_portrait);

        cartRecyclerView = findViewById(R.id.cart_recyclerview);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        getData();
        ProductAdapter adapter = new ProductAdapter(this, cart);
        cartRecyclerView.setAdapter(adapter);
    }

    public void getData() {
        if (getIntent().hasExtra("cart")) {
            Log.i("test", "getData in Cart class was access!");
            ArrayList<Product> temp = getIntent().getParcelableArrayListExtra("cart");
            if (temp != null) cart.addAll(temp);
        }

    }
}