package firmanmfk.setorantunai.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import butterknife.ButterKnife;
import firmanmfk.setorantunai.R;

/**
 * Created by FirmanMFK on 7/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private ActionBar myActionBar;
    private Bundle myBundle;
    private Context myContext;
    private ProgressDialog myProgressDialog;

    public static String MESSAGE = "message";

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        myContext = this;

        myBundle = getIntent().getExtras();

        myToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (myToolbar != null) {
            setSupportActionBar(myToolbar);
            myActionBar = getSupportActionBar();

            myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNavigationClick();
                }
            });
        }

        if (myBundle != null) {
            if (myBundle.getString(MESSAGE) != null) {
                showToast(myBundle.getString(MESSAGE));
            }
        }

        myProgressDialog = new ProgressDialog(myContext);

        Hawk.init(myContext).build();
    }

    public void showProgressDialog(String message){
        myProgressDialog.setMessage(message);
        if(!myProgressDialog.isShowing()){
            myProgressDialog.show();
        }
    }

    public void dismissProgressDialog(){
        myProgressDialog.dismiss();
    }

    public void showToast(String message){
        Toast.makeText(getMyContext(), message, Toast.LENGTH_LONG).show();
    }

    public void showSnackBar(String message){
        Snackbar.make(getRootView(), message, Snackbar.LENGTH_LONG).show();
    }

    public Context getMyContext() {
        return myContext;
    }

    public Bundle getMyBundle() {
        return myBundle;
    }

    public void onNavigationClick() {
        onBackPressed();
    }

    public View getRootView() {
        return findViewById(android.R.id.content);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void setActionBarTitle(String title) {
        myActionBar.setTitle(title);
    }

    public void displayHome() {
        myActionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void displayHome(int resId) {
        myActionBar.setHomeAsUpIndicator(resId);
        myActionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void goToActivity(Class c, Bundle bundle, boolean isFinish) {
        Intent i = new Intent(this, c);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivity(i);
        if (isFinish) {
            finish();
        }
    }

    public void goToActivityClearAllStack(Class c, Bundle bundle) {
        Intent i = new Intent(this, c);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }

    public void goToActivityForResult(Class c, Bundle bundle, int result) {
        Intent i = new Intent(this, c);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivityForResult(i, result);
    }

    public void finishActivityforResult(Bundle bundle, int result) {
        Intent i = new Intent();
        if (bundle != null) {
            i.putExtras(bundle);
        }
        setResult(result, i);
        finish();
    }
}
