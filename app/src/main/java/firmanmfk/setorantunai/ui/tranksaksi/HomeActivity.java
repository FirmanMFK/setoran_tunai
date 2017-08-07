package firmanmfk.setorantunai.ui.tranksaksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.ui.addtranksaksi.AddTranksaksiActivity;
import firmanmfk.setorantunai.ui.tranksaksi.slider.SliderIndicator;
import firmanmfk.setorantunai.ui.tranksaksi.slider.SliderPagerAdapter;
import firmanmfk.setorantunai.ui.tranksaksi.slider.SliderView;

/**
 * Created by Firman on 7/20/2017.
 * github.com/FirmanMFK
 * UwaCoding.github.io
 */

public class HomeActivity extends AppCompatActivity  {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;


    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(HomeActivity.this, AddTranksaksiActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_logout);
                    Intent intent1 = new Intent(HomeActivity.this, TranksaksiActivity.class);
                    startActivity(intent1);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, homeFragment);
        fragmentTransaction.commit();


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }



}
