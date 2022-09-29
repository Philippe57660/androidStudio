package edu.fbansept.dfsr_presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Button;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                "https://zoo-animal-api.herokuapp.com/animals/rand/10",
                response -> {

                    productList = new ArrayList<>();

                    try {
                        JSONArray jsonProductList = response.getJSONArray("data");

                        for(int i = 0; i < jsonProductList.length(); i++ ) {
                            try {
                                JSONObject json = jsonProductList.getJSONObject(i);
                                Product produit = new Product(json);
                                productList.add(produit);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        RecyclerView rvProductList = findViewById(R.id.rvProductList);
                        rvProductList.setLayoutManager(new LinearLayoutManager(this));
                        rvProductList.setAdapter(new ProductListAdapter(productList));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.d("volley",error.toString())
        );

        RequestManager.getInstance(this).addToRequestQueue(jsonArrayRequest);



    }
}