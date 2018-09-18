package gardianangel.www.quaketechs.com.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gardianangel.www.quaketechs.com.mvptest.model.User;
import gardianangel.www.quaketechs.com.mvptest.presenter.ILoginPresenter;
import gardianangel.www.quaketechs.com.mvptest.presenter.LoginPresenter;
import gardianangel.www.quaketechs.com.mvptest.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private EditText email;
    private EditText password;
    private ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.button);
        loginPresenter = new LoginPresenter(new User());
        loginPresenter.attachView(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(email.getText().toString(), password.getText().toString());
            }
        });
    }


    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}