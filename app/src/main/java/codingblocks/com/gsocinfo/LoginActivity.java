package codingblocks.com.gsocinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import codingblocks.com.gsocinfo.activities.AboutActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;
    Button btnSignin;
    Button btnSignup;
    LoginButton btnFacebookLogin;
    SignInButton  btnGmailLogin;
    FirebaseUser user;
    FirebaseAuth auth;
    CallbackManager callbackManagerFb;
    GoogleSignInOptions googleSignInOptions;
    GoogleApiClient googleApiClient;
    public static final int GOOGLE_REQ_CODE  = 123;
    public static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.email_edittext);
        etPassword = findViewById(R.id.password_edittext);
        btnSignin = findViewById(R.id.custom_signin_button);
        btnSignup = findViewById(R.id.custom_signup_button);
        btnFacebookLogin = findViewById(R.id.facebook_login_button);
        btnGmailLogin = findViewById(R.id.google_login_button);
        auth = FirebaseAuth.getInstance();
        callbackManagerFb = CallbackManager.Factory.create();
        String serverClientId = getResources().getString(R.string.server_client_id);
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(serverClientId)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(LoginActivity.this)
                .enableAutoManage(LoginActivity.this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.d(TAG, "onConnectionFailed: ");
                    }
                }).addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        FirebaseUser user = auth.getCurrentUser();
                        userLogin(user);
                    }
                });
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    user = auth.getCurrentUser();
                                    Log.d(TAG, "onComplete: " + user);
                                    userLogin(user);
                                } else {
                                    Toast.makeText(LoginActivity.this, "Cannot Login right now", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
//        Facebook Login
        btnFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFacebookLogin.setReadPermissions("email", "public_profile");
                btnFacebookLogin.registerCallback(callbackManagerFb, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        Log.d(TAG, "onSuccess: ");
                        AuthCredential credential = FacebookAuthProvider.getCredential(AccessToken.getCurrentAccessToken().getToken());
                        auth.signInWithCredential(credential).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                user = auth.getCurrentUser();
                                userLogin(user);
                            }
                        });
//                        userLogin(user);
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "onCancel: ");
                        Toast.makeText(LoginActivity.this, "Cannot Login right now", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d(TAG, "onError: ");
                        Toast.makeText(LoginActivity.this, "Cannot Login right now", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
//        Google Login - not working becoz of SHA
//        TODO: @the-Dagger sha hash dal ke client server replace kr  dena
        btnGmailLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent,GOOGLE_REQ_CODE );
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GOOGLE_REQ_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
        callbackManagerFb.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = auth.getCurrentUser();
        if (user != null) {
            userLogin(user);
        }
    }

    public void userLogin(FirebaseUser user) {
        Intent i = new Intent(LoginActivity.this, AboutActivity.class);
        startActivity(i);
    }
// google login not workign right now
    public void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            Log.d(TAG, "handleSignInResult: " + account.getDisplayName());
            AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
            Log.d(TAG, "handleSignInResult: " + credential);
            auth.signInWithCredential(credential).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    FirebaseUser user = auth.getCurrentUser();
                    userLogin(user);
                }
            });
        }else{
            Log.d(TAG, "handleSignInResult: " + result.getStatus().getStatusCode());
            Log.d(TAG, "handleSignInResult: " + result.getStatus());
            Toast.makeText(this, "Cannot Login", Toast.LENGTH_SHORT).show();
        }

    }
}
