package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "KAKAO_LOGIN";
    private final String NATIVE_APP_KEY = "e829e0c08c9e8f08a3515bd27c5d9ac2";
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txt_result);
        KakaoSdk.init(this,NATIVE_APP_KEY);

        Log.d(TAG, "onCreate: "+Utility.INSTANCE.getKeyHash(this));


        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this, new Function2<OAuthToken, Throwable, Unit>() {
                    @Override
                    public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                        if (throwable != null) {
                            Log.e(TAG, "로그인 실패 " + throwable);
                        }
                        else if (oAuthToken != null) {
                            Log.i(TAG, "로그인 성공 " + oAuthToken);
                            UserApiClient.getInstance().me( new Function2<User, Throwable, Unit>() {
                                @Override
                                public Unit invoke(User user, Throwable throwable) {
                                    Log.d(TAG, "invoke: " + user.getKakaoAccount().getProfile().getNickname());
                                    Log.d(TAG, "invoke: " + user.getKakaoAccount().getProfile().getProfileImageUrl());
                                    return null;
                                }
                            });
                        }
                        return null;
                    }
                });


            }
        });
    }
}