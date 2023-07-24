package com.codenation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    final String TAG = "KaKaoSearch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class KaKaoSearch extends AsyncTask<Void, Void, String>{
        private final String URL = "https://dapi.kakao.com/v2/search/image?query=";
        private final String USER_INFO = "KakaoAK -";

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(Void... voids) {
            String result = null;

            try {
                String search = URLEncoder.encode("갤럭시","UTF-8");
                URL url = new URL(URL + search);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //GET으로 전송하고 데이터를 받음
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization",USER_INFO);
                connection.setRequestProperty("content-type","application/json");
                connection.setDoOutput(true);
                connection.setUseCaches(false);
                connection.setDefaultUseCaches(false);

                //데이터를 받아오는 부분
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String str = "";
                while((str = br.readLine()) != null) result += str;

                Log.d(TAG, "doInBackground: "+result);
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









