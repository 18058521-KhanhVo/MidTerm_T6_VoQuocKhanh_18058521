package com.example.midterm_t6_10_12;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private static SendingData sendingData= (SendingData) MainActivity.context;
    private ImageView detailImage;
    private TextView detailName, detailDesc, detailPrice;
    private Button detailAddToCartButton;
    private int imgID;
    private String name, description, price;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(int imgID, String name, String description, String price) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("imgID", imgID);
        args.putString("name", name);
        args.putString("description", description);
        args.putString("price", price);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imgID = getArguments().getInt("imgID");
            name = getArguments().getString("name");
            description = getArguments().getString("description");
            price = getArguments().getString("price");

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailImage = view.findViewById(R.id.detail_image);
        detailName = view.findViewById(R.id.detail_name);
        detailDesc = view.findViewById(R.id.detail_description);
        detailPrice = view.findViewById(R.id.detail_price);
        detailAddToCartButton = view.findViewById(R.id.detail_addtocartbtn);
        detailAddToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendingData.sendData(getProduct());
                Log.i("Test","add to cart button was clicked!");
            }
        });

        detailImage.setImageResource(imgID);
        detailName.setText(name);
        detailDesc.setText(description);
        detailPrice.setText(price);
        return view;
    }

    public Product getProduct() {
        Product product = new Product(imgID, name, description, price);
        return product;
    }
}