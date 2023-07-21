package com.papago;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText edtOrigin;
    EditText edtResult;
    PaPaGo papago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTranslate = findViewById(R.id.btn_translate);
        edtOrigin = findViewById(R.id.edt_origin);
        edtResult = findViewById(R.id.edt_result);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                papago = new PaPaGo();
                papago.execute();
            }
        });

    }

    public class PaPaGo extends AsyncTask<Void,Void,String>{
        private final String CLIENT_ID = "애플리케이션 클라이언트 아이디값";
        private final String CLIENT_SECRET = "애플리케이션 클라이언트 시크릿값";
        private final String API_URL = "https://openapi.naver.com/v1/papago/n2mt";
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                //번역된 결과를 JSON으로 파싱 한 후
                JSONObject json = new JSONObject(s);
                //번역된 내용만 edtResult에 출력
                String result = json.getJSONObject("message").getJSONObject("result").getString("translatedText");
                edtResult.setText(result);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            //edtOrigin 입력한 내용을 파파고로 번역된 결과를 받아서 리턴
            String result = "";
            DataOutputStream dos = null;
            BufferedReader br = null;
            HttpURLConnection con = null;

            try {
                //api 서버 접속 처리
                URL url = new URL(API_URL);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
                con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);

                String param = String.format("source=ko&target=en&text=%s",edtOrigin.getText().toString());

                //데이터 전송
                dos = new DataOutputStream(con.getOutputStream());
                dos.write(param.getBytes());
                dos.flush();

                //결과를 받아서 처리
                int responseCode = con.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                }else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String str = null;
                while((str = br.readLine()) != null) {
                    result += str;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                con.disconnect();
            }


            return result;
        }
    }
}








