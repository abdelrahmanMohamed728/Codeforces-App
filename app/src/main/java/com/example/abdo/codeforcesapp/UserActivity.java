package com.example.abdo.codeforcesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<User> list;
    userAdapter adapter;
    URL url;
    HttpURLConnection urlConnection;
    InputStream inputStream;
    String result;
    StringBuffer buffer1;
    String finalResult;
    ProgressBar progress1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        listView = findViewById(R.id.list2);
        list = new ArrayList<>();
        LoadData("https://codeforces.com/api/user.info?handles="+getIntent().getStringExtra("Username"));
        adapter = new userAdapter(UserActivity.this,list);
        listView.setAdapter(adapter);
    }
    public void LoadData(String url)
    {
        progress1 =findViewById(R.id.progress2);
        progress1.setVisibility(View.VISIBLE);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    progress1.setVisibility(View.INVISIBLE);
                    JSONArray array = response.getJSONArray("result");
                    JSONObject object = array.getJSONObject(0);
                    User user = new User(getIntent().getStringExtra("Username"),object.getInt("rating"),object.getInt("maxRating"),object.getString("rank"),object.getInt("friendOfCount"),object.getString("titlePhoto"));
                    list.add(user);
                    adapter.notifyDataSetChanged();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Log.e("tag",e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
