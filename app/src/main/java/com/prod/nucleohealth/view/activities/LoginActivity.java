package com.prod.nucleohealth.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.prod.nucleohealth.R;
import com.prod.nucleohealth.data.model.User;
import com.prod.nucleohealth.data.model.UserData;
import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.utils.Constants;
import com.prod.nucleohealth.utils.CustomProgressDialog;
import com.prod.nucleohealth.utils.SessionManager;
import com.prod.nucleohealth.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    CustomProgressDialog progressDialog;
    LoginViewModel loginViewModel;
    EditText txtUserName,txtPassword;
    RelativeLayout userNameContainer,passwordContainer;
    Button btnSignup,btnLogin;
    ToggleButton tbtnshowPassword;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);
        initComponents();
    }
    private void initComponents(){
        txtUserName = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        userNameContainer = findViewById(R.id.username_container);
        passwordContainer = findViewById(R.id.password_container);
        btnSignup = findViewById(R.id.btn_signup);
        btnLogin = findViewById(R.id.btn_login);
        tbtnshowPassword = findViewById(R.id.tbtn_show_password);
        btnLogin.setOnClickListener(v -> loginUser());

        btnSignup.setOnClickListener(v -> {

        });
        tbtnshowPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int cursorPosition = txtPassword.getSelectionStart();
            if(isChecked)
            {
                txtPassword.setTransformationMethod(null);
            }
            else
            {
                txtPassword.setTransformationMethod(new PasswordTransformationMethod());

            }
            txtPassword.setSelection(cursorPosition);

        });
    }
    @Override
    protected void onStart() {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        super.onStart();
    }
    /*
    * private void loginUser(){
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setEmail("chennaiappolo@gmail.com");
        loginRequestModel.setPassword("123456");

        loginViewModel.loginUser(loginRequestModel);
        loginViewModel.getUserData().observe(this, loginResponseModel -> {
            if(loginResponseModel.getStatus().equals("1")){
                Toast.makeText(this,"Login Success",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Login Failure",Toast.LENGTH_LONG).show();
            }

        });
    }
    * */
    private void loginUser(){

        String email = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
//validateEmail(txtUserName,userNameContainer, "Enter Valid email") &&
        if ( validatePassword(txtPassword,passwordContainer, "Enter correct password")) {
            progressDialog = CustomProgressDialog.show(this, true, false);
            LoginRequestModel loginRequestModel = new LoginRequestModel();
            loginRequestModel.setEmail(email);
            loginRequestModel.setPassword(password);

           loginViewModel.loginUser(loginRequestModel);
            loginViewModel.getUserData().observe(this, loginResponseModel -> {
                // Update UI.
                if(loginRequestModel == null) return;
                if(loginResponseModel.getStatus().equals(Constants.STATUS_SUCCESS)){
                    if (progressDialog != null && progressDialog.isShowing()) {
                        UserData userData = loginResponseModel.getData();
                        User user = userData.getUser();
                        progressDialog.dismiss();
                        sessionManager.setLoginStatus(true);
                        sessionManager.saveUserName(user.getEmail());
                        sessionManager.savePassword(password);
                        sessionManager.saveFirstName(user.getFirstName());
                        sessionManager.saveLastName(user.getLastName());
                        sessionManager.saveUserType(Constants.UserType.Patient.toString());
                        sessionManager.saveSessionToken("Bearer "+userData.getAccessToken());
                        sessionManager.saveClientId(user.getId());
                        if(user.getFirstName()!=null)
                            Toast.makeText(LoginActivity.this,"Welcome "+user.getFirstName()+"!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    }
                } else{
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        Toast toast = Toast.makeText(getApplicationContext(), loginResponseModel.getMessage(), Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
            });
        }
    }

    /*private void redirectRegistration(){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
        finish();
    }*/
    public boolean validatePassword(EditText editText, RelativeLayout linearLayout, String tag) {
        String password = editText.getText().toString().trim();

        if (password.isEmpty()) {
            //editText.setError(tag);
//Shake animation
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                editText.setError(Html.fromHtml("<font color=\"#0080D9\">"+tag+"</font>"));
            } else{
                editText.setError(tag);
            }
            editText.requestFocus();
            return false;
        } else {
            editText.setError(null);
        }
        return true;
    }
    public boolean validateEmail(EditText editText, RelativeLayout linearLayout, String tag) {
        if ((!android.util.Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString().trim()).matches())) {
            editText.setError(tag);

            editText.requestFocus();
            return false;
        } else {
            editText.setError(null);
        }
        return true;
    }
}
