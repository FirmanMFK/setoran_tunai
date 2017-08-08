package firmanmfk.setorantunai.ui.addtranksaksi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.api.ApiCallback;
import firmanmfk.setorantunai.api.RestApi;
import firmanmfk.setorantunai.api.RetrofitBuilder;
import firmanmfk.setorantunai.model.data.Result;
import firmanmfk.setorantunai.model.other.Spin;
import firmanmfk.setorantunai.ui.base.BaseActivity;
import retrofit.Call;

public class AddTranksaksiActivity extends BaseActivity {

    @Bind(R.id.spv_bea_biaya)
    Spinner spvBeaBiaya;
    @Bind(R.id.et_no_rekening)
    EditText etNoRekening;
    @Bind(R.id.et_asal_biaya)
    EditText etAsalBiaya;
    @Bind(R.id.et_jumlah)
    EditText etJumlah;
    @Bind(R.id.et_kantor)
    EditText etKantor;
    @Bind(R.id.et_terbilang)
    EditText etTerbilang;

    List<Spin> beaBiayas;

    RestApi restApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tranksaksi);
        setActionBarTitle(getString(R.string.add_tranksaksi));
        displayHome();
        restApi = RetrofitBuilder.create(RestApi.class);
        setSpinnerBeaBiaya();
    }

    private void setSpinnerBeaBiaya(){
        beaBiayas = new ArrayList<>();
        beaBiayas.add(new Spin("Tunai", "Tunai"));
        beaBiayas.add(new Spin("Non Tunai", "Non Tunai"));
        String[] arrBeaBiaya = new String[beaBiayas.size()];
        for (int i = 0; i < beaBiayas.size(); i++) {
            arrBeaBiaya[i] = beaBiayas.get(i).getText();
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getMyContext(), android.R.layout.simple_spinner_item, arrBeaBiaya);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spvBeaBiaya.setAdapter(adapter);
    }

    public void addTransaction(){
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.confirmation))
                .setMessage(getString(R.string.really_want_to_add))
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        showProgressDialog(getString(R.string.adding_tranksaksi));

                        String noRekening = etNoRekening.getText().toString();
                        String beaBiaya = beaBiayas.get(spvBeaBiaya.getSelectedItemPosition()).getValue();
                        String jumlah = etJumlah.getText().toString();
                        String asalBiaya = etAsalBiaya.getText().toString();
                        String kantor = etKantor.getText().toString();
                        String terbilang = etTerbilang.getText().toString();
                        String idKaryawan = Hawk.get("userid");

                        Call<Result<String>> service =
                                restApi.postAddTransaction(noRekening, asalBiaya,
                                        jumlah, terbilang, kantor, beaBiaya, idKaryawan);
                        service.enqueue(new ApiCallback<Result<String>>() {
                            @Override
                            public void onSuccess(Result<String> data) {
                                dismissProgressDialog();
                                showSnackBar(data.getResult());
                                if(data.getResult().equals("success")){
                                    onBackPressed();
                                }
                            }

                            @Override
                            public void onFailed(Throwable t) {
                                dismissProgressDialog();
                                showToast("error");
                            }
                        });
                    }})
                .setNegativeButton(getString(R.string.cancel), null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_add_tranksaksi, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_add :
                addTransaction();
                break;
        }
        return true;
    }

}
