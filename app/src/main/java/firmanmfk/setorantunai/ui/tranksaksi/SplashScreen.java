package firmanmfk.setorantunai.ui.tranksaksi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.ui.login.LoginActivity;

/**
 * Created by Firman on 7/20/2017.
 * github.com/FirmanMFK
 * UwaCoding.github.io
 */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}