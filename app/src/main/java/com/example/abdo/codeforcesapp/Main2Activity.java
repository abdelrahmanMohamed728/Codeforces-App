package com.example.abdo.codeforcesapp;

import android.content.Intent;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ArrayList<Contestant> list;
    standingsAdapter adapter;
    URL url;
    HttpURLConnection urlConnection;
    InputStream inputStream;
    String result;
    StringBuffer buffer1;
    String finalResult;
    ProgressBar progress1;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.list1);
        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,SearchActivity.class));
            }
        });
        list = new ArrayList<>();
        LoadData("https://codeforces.com/api/user.ratedList?activeOnly=true");
        adapter = new standingsAdapter(Main2Activity.this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main2Activity.this,UserActivity.class);
                intent.putExtra("Username",list.get(position).getName());
                startActivity(intent);
            }
        });
    }
    public void LoadData(String url)
    {
        progress1 =findViewById(R.id.progress1);
        progress1.setVisibility(View.VISIBLE);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
              try {
                  progress1.setVisibility(View.INVISIBLE);
                  JSONArray array = response.getJSONArray("result");
                  for (int i = 0; i < 100; i++) {
                      JSONObject o = array.getJSONObject(i);
                      list.add(new Contestant(o.getString("handle"), o.getInt("rating"), o.getString("rank")));
                  }
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
    public class JSONTask extends AsyncTask<String,String,ArrayList<Contestant>> {
        @Override
        protected void onPreExecute() {
            progress1 =findViewById(R.id.progress1);
            progress1.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Contestant> doInBackground(String... strings) {
            try {
                url=new URL("https://codeforces.com/api/user.ratedList?activeOnly=true");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                urlConnection= (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                inputStream=urlConnection.getInputStream();
                int c=0;
                StringBuffer buffer=new StringBuffer();
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    while ((c = inputStream.read()) != -1) {
                        buffer.append((char) c);
                    }
                }
                result=buffer.toString();
                buffer1=new StringBuffer();
                JSONObject o1=new JSONObject(result);
                JSONArray array =o1.getJSONArray("result");

                for(int i=0;i<50;i++) {
                    JSONObject o =array.getJSONObject(i);
                    list.add(new Contestant(o.getString("handle"),o.getInt("rating"),o.getString("rank")));
                }
                finalResult=buffer1.toString();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("tag",e.toString());

            }

            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<Contestant> characters) {
            super.onPostExecute(characters);
            standingsAdapter adapter=new standingsAdapter(Main2Activity.this,list);

            listView.setAdapter(adapter);
            progress1.setVisibility(View.INVISIBLE);
        }
    }
}

