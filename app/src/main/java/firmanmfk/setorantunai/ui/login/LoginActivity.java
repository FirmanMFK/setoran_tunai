package firmanmfk.setorantunai.ui.login;

import android.os.Bundle;
import android.widget.EditText;

import com.orhanobut.hawk.Hawk;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.api.ApiCallback;
import firmanmfk.setorantunai.api.RestApi;
import firmanmfk.setorantunai.api.RetrofitBuilder;
import firmanmfk.setorantunai.model.data.Result;
import firmanmfk.setorantunai.model.data.User;
import firmanmfk.setorantunai.ui.base.BaseActivity;
import firmanmfk.setorantunai.ui.tranksaksi.HomeActivity;
import retrofit.Call;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.et_username)
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(Hawk.contains("userid") && Hawk.contains("username")){
            goToActivity(HomeActivity.class, null, true);
        }
    }

    @OnClick(R.id.btn_login)
    public void onBtnLoginClicked(){
        showProgressDialog(getString(R.string.logging_in));
        RestApi restApi = RetrofitBuilder.create(RestApi.class);
        Call<Result<List<User>>> service =
                restApi.postLogin(etUsername.getText().toString(), etPassword.getText().toString());
        service.enqueue(new ApiCallback<Result<List<User>>>() {
            @Override
            public void onSuccess(Result<List<User>> data) {
                dismissProgressDialog();
                if(data.getResult().size() > 0){
                    Hawk.put("userid", data.getResult().get(0).getIdUser());
                    Hawk.put("username", data.getResult().get(0).getNmUser());
                    goToActivity(HomeActivity.class, null, true);
                }else{
                    showSnackBar(getString(R.string.username_password_wrong));
                }
            }

            @Override
            public void onFailed(Throwable t) {
                dismissProgressDialog();
                showToast("error");
            }
        });
    }
}
