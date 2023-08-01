package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApi;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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

                //카카오톡이 설치되어 있을때
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(MainActivity.this)) {

                    UserApiClient.getInstance().loginWithKakaoTalk(MainActivity.this, new Function2<OAuthToken, Throwable, Unit>() {
                        @Override
                        public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                            if (throwable != null) {
                                Log.d(TAG, "로그인 실패 " + throwable);
                                if(ClientErrorCause.Cancelled.equals(throwable.getCause())){
                                    Log.d(TAG, "사용자가 취소로 로그인 실패");
                                }
                            } else if (oAuthToken != null) {
                                Log.d(TAG, "로그인 성공 " + oAuthToken);
                                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
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
                }else{
                    //카카오톡이 설치되지 않았을때 카카오 계정으로 로그인 하는 부분
                    UserApiClient.getInstance().loginWithKakaoAccount(MainActivity.this, (oAuthToken, throwable) -> {
                        if (throwable != null) {
                            Log.d(TAG, "카카오계정으로 로그인 실패"+ throwable);
                        } else if (oAuthToken != null) {
                            Log.i(TAG, "카카오계정으로 로그인 성공 " + oAuthToken);
                            UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                                @Override
                                public Unit invoke(User user, Throwable throwable) {
                                    Log.d(TAG, "invoke: " + user.getKakaoAccount().getProfile().getNickname());
                                    Log.d(TAG, "invoke: " + user.getKakaoAccount().getProfile().getProfileImageUrl());
                                    return null;
                                }
                            });
                        }
                        return null;
                    });
                }


            }
        });
        Button btnProfile = findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                    @Override
                    public Unit invoke(User user, Throwable throwable) {
                        if(!AuthApiClient.getInstance().hasToken()){
                            txtResult.setText("현재 로그인 되어있지 않습니다.");
                            return null;
                        }
                        String str = user.getKakaoAccount().getProfile().getNickname() + "\n";
                        str += user.getKakaoAccount().getProfile().getProfileImageUrl();
                        txtResult.setText(str);
                        return null;
                    }
                });

            }
        });

        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        if (throwable != null){
                            Log.d(TAG, "로그아웃 실패, SDK에서 토큰 삭제됨");
                        }else{
                            Log.d(TAG, "로그아웃 성공, SDK에서 토큰 삭제됨");

                        }
                        return null;
                    }
                });
            }
        });

        Button btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().unlink(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        if (throwable != null){
                            Log.d(TAG, "연결 끊기 실패");
                        }else{
                            Log.d(TAG, "연결 끊기 성공");

                        }
                        return null;
                    }
                });
            }
        });
    }
}