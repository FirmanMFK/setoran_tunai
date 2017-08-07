package firmanmfk.setorantunai.ui.tranksaksi;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.orhanobut.hawk.Hawk;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.api.ApiCallback;
import firmanmfk.setorantunai.api.RestApi;
import firmanmfk.setorantunai.api.RetrofitBuilder;
import firmanmfk.setorantunai.model.data.Result;
import firmanmfk.setorantunai.model.data.Transaction;
import firmanmfk.setorantunai.ui.addtranksaksi.AddTranksaksiActivity;
import firmanmfk.setorantunai.ui.base.BaseActivity;
import firmanmfk.setorantunai.ui.detailtranksaksi.DetailTranksaksiActivity;
import firmanmfk.setorantunai.ui.login.LoginActivity;
import firmanmfk.setorantunai.util.adapter.ListTransactionItemAdapter;
import retrofit.Call;

public class TranksaksiActivity extends BaseActivity {

    @Bind(R.id.rv_tranksaksi)
    RecyclerView rvTranksaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranksaksi);
        setActionBarTitle(getString(R.string.list_transaksi));
        loadTransactionsData();
    }

    private void setRecyclerView(final List<Transaction> transactions){
        ListTransactionItemAdapter adapter =
                new ListTransactionItemAdapter(getMyContext(), transactions) {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("idInvoice", transactions.get(position).getIdInvoice());
                bundle.putSerializable("idSetoran", transactions.get(position).getIdSetoran());
                goToActivity(DetailTranksaksiActivity.class, bundle, false);
            }
        };
        rvTranksaksi.setLayoutManager(new LinearLayoutManager(getMyContext()));
        rvTranksaksi.setAdapter(adapter);
    }

    public void loadTransactionsData(){
        RestApi restApi = RetrofitBuilder.create(RestApi.class);
        Call<Result<List<Transaction>>> service =
                restApi.getTransactions();
        service.enqueue(new ApiCallback<Result<List<Transaction>>>() {
            @Override
            public void onSuccess(Result<List<Transaction>> data) {
                setRecyclerView(data.getResult());
            }

            @Override
            public void onFailed(Throwable t) {
                showToast("error");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTransactionsData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_tranksaksi, menu);
        return true;
    }

    @OnClick(R.id.fab_add_tranksaksi)
    public void onFabAddTranksaksiClicked(){
        goToActivity(AddTranksaksiActivity.class, null, false);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_quit :
                logout();
                break;
        }
        return true;
    }

    private void logout(){
       Hawk.deleteAll();
        goToActivityClearAllStack(LoginActivity.class, null);
    }
}
