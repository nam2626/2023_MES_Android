package com.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;
import com.nhn.android.oauth.databinding.ActivityOauthWebviewBinding;

public class MainActivity extends AppCompatActivity {
    private final String CLIENT_ID = "KHkektMREM4uRRubtXSl";
    private final String CLIENT_SECRET_ID = "trD4iQ7zjS";
    private final String TAG = "APILogin";
    private OAuthLoginCallback callback;
    private NidOAuthLogin login;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btnNaverLogin = findViewById(R.id.btn_naver_login);
        txtResult = findViewById(R.id.txt_result);
        btnNaverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NaverIdLoginSDK.INSTANCE.initialize(MainActivity.this,CLIENT_ID,CLIENT_SECRET_ID,"2022파파고");

                callback = new OAuthLoginCallback() {

                    @Override
                    public void onSuccess() {
                        Log.d(TAG, "onSuccess: 로그인 성공 " + NaverIdLoginSDK.INSTANCE.getAccessToken());
                        login = new NidOAuthLogin();
                        login.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                            @Override
                            public void onSuccess(NidProfileResponse nidProfileResponse) {
                                //txtResult.setText(nidProfileResponse.toString());
                                String str = nidProfileResponse.getProfile().getProfileImage() + "\n";
                                str += nidProfileResponse.getProfile().getEmail()+ "\n";
                                str += nidProfileResponse.getProfile().getNickname()+ "\n";
                                txtResult.setText(str);
                            }

                            @Override
                            public void onFailure(int i, @NonNull String s) {
                                //실패 했을때
                            }

                            @Override
                            public void onError(int i, @NonNull String s) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {
                        Log.d(TAG, "onFailure: 로그인 실패");
                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                };
                NaverIdLoginSDK.INSTANCE.authenticate(MainActivity.this,callback);
            }
        });
        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NaverIdLoginSDK.INSTANCE.logout();
                txtResult.setText("로그아웃");
            }
        });
        Button btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.callDeleteTokenApi(MainActivity.this,callback);
                txtResult.setText("회원탈퇴 완료");
            }
        });
    }



}