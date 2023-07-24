package com.codenation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private EditText edtSearch;
    private Button btnSearch;
    private ListView lstResult;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        lstResult = findViewById(R.id.lst_result);
        adapter = new CustomListAdapter();
        lstResult.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtSearch.getText().toString().length() == 0) return;
                adapter.clear();
                BlogSearch search = new BlogSearch();
                search.execute();
            }
        });
        lstResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListItem item = (ListItem) adapter.getItem(i);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getPostUrl()));
                startActivity(intent);
            }
        });
    }

    public class BlogSearch extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("BloggerSearch", "onPostExecute: " + s);
            try {
                JSONObject json = new JSONObject(s);
                JSONArray array = json.getJSONArray("items");
                for(int i=0;i<array.length();i++){
                    JSONObject item = array.getJSONObject(i);
                    String title = item.getString("title");
                    String bloggerName = item.getString("bloggername");
                    String postUrl = item.getString("link");
                    String postDate = item.getString("postdate");
                    String description = item.getString("description");
                    adapter.addItem(title,bloggerName,postUrl,postDate,description);
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";
            String clientId = "awMpx6mgF0anlMxarfxH";
            String clientSecret = "wIy75AhoH0";
            String text = null;
            try {
                text = URLEncoder.encode(edtSearch.getText().toString(),"UTF-8");
                String apiURL = "https://openapi.naver.com/v1/search/blog.json?query="+text +"&sort=date";
                URL url = new URL(apiURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("X-Naver-Client-Id",clientId);
                connection.setRequestProperty("X-Naver-Client-Secret",clientSecret);

                int responseCode = connection.getResponseCode();
                BufferedReader br = null;
                if(responseCode == 200){
                    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                }else{
                    br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }
                String str = "";
                while((str = br.readLine()) != null) result += str;

                br.close();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }
    }
}












