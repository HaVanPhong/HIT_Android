package com.example.btvn6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {
    String arrayCountry = "";
    String url = "https://apincov.herokuapp.com/countries";
    EditText edtSearch;
    RecyclerView recyclerView;
    SearchView searchView;
    CountryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(parseColor("#0099FF")));
        actionBar.setTitle("Thông Tin Dịch Bệnh");
//        actionBar.hide();

        AnhXa();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                arrayCountry = response;
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(arrayCountry);

                    List<Country> list = new ArrayList<>();
                    int size = jsonArray.length();
                    for (int i = 0; i < size; i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String name = jsonObject1.getString("Country_Region");
                        long confirm = jsonObject1.getLong("Confirmed");
                        long deaths = jsonObject1.getLong("Deaths");
                        long recovered = jsonObject1.getLong("Recovered");

                        list.add(new Country(name, confirm, deaths, recovered));

                        adapter = new CountryAdapter(list, MainActivity.this);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                arrayCountry = "Không lấy được API";

            }
        });
        requestQueue.add(stringRequest);


        //list

    }

    public void AnhXa(){
//        edtSearch = findViewById(R.id.edtSearch);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager= (SearchManager)  getSystemService(Context.SEARCH_SERVICE);
        searchView= (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()){
            searchView.setIconified(true);
            return ;
        }
        super.onBackPressed();
    }
}