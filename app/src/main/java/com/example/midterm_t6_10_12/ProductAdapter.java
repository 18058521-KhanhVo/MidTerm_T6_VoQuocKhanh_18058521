package com.example.midterm_t6_10_12;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private SendingData sendingData = (SendingData) MainActivity.context;
    private ArrayList<Product> arrayList;
    private Context context;
    private LayoutInflater inflater;

    /**
     * @param arrayList
     * @param context
     */
    public ProductAdapter(Context context, ArrayList<Product> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem_portrait, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = arrayList.get(position);
        holder.productImage.setImageResource(product.getImgID());
        holder.productName.setText(product.getName());
        holder.productDesc.setText(product.getDescription());
        holder.productPrice.setText(product.getPrice());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPortrait.class);
                intent.putExtra("productImage", product.getImgID());
                intent.putExtra("productName", product.getName());
                intent.putExtra("productDesc", product.getDescription());
                intent.putExtra("productPrice", product.getPrice());
                context.startActivity(intent);

            }
        });
        holder.productAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendingData.sendData(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * @param filteredList
     */
    public void filterList(ArrayList<Product> filteredList) {
        arrayList = filteredList;
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productName, productDesc, productPrice;
        private ImageButton productAddButton;
        private ConstraintLayout mainLayout;

        /**
         * @param itemView
         */
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.item_image);
            productName = itemView.findViewById(R.id.item_name);
            productDesc = itemView.findViewById(R.id.item_description);
            productPrice = itemView.findViewById(R.id.item_price);
            productAddButton = itemView.findViewById(R.id.item_addbtn);
            mainLayout = itemView.findViewById(R.id.main_layout);

        }
    }
}
