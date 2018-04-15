package uinbdg.skripsi.kopertais;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skripsi.kopertais.Activities.MasterUnivActivity;
import uinbdg.skripsi.kopertais.Activities.MenuActivity;
import uinbdg.skripsi.kopertais.Helper.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        session = new Session(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etUsername.getText().toString().equals("rektorat@gmail.com") && etPassword.getText().toString().equals("password")){
                    session.setEmail("pegawai@gmail.com");
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    // Add new Flag to start new Aktifitas
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else if(etUsername.getText().toString().equals("keuangan@gmail.com") && etPassword.getText().toString().equals("password")){
                    session.setEmail("keuangan@gmail.com");
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    // Add new Flag to start new Aktifitas
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else if(etUsername.getText().toString().equals("pimpinan@gmail.com") && etPassword.getText().toString().equals("password")){
                    session.setEmail("pimpinan@gmail.com");
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    // Add new Flag to start new Aktifitas
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Username atau password yang anda masukan tidak sesuai", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}
