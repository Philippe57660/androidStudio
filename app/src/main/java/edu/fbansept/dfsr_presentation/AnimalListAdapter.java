package edu.fbansept.dfsr_presentation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private ArrayList<Animal> animalList;

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {

        TextView itemProductTitle;
        ImageView itemProductDescription;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            itemProductTitle = itemView.findViewById(R.id.itemProductTitle);
            itemProductDescription = itemView.findViewById(R.id.itemProductDescription);
        }
    }

    public AnimalListAdapter(ArrayList<Animal> animalList) {
        this.animalList = productList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_product,parent,false);

        AnimalViewHolder viewHolder = new AnimalViewHolder(view);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.itemAnimalTitle.setText(animalList.get(position).getAnimal_name());
        holder.itemAnimalDescription.setImageBitmap(this.getBitmapFromURL(animalList.get(position).getAnimal_image_link()));

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }
}
