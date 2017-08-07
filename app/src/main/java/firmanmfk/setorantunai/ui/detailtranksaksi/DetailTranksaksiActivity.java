package firmanmfk.setorantunai.ui.detailtranksaksi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import firmanmfk.setorantunai.R;
import firmanmfk.setorantunai.api.ApiCallback;
import firmanmfk.setorantunai.api.RestApi;
import firmanmfk.setorantunai.api.RetrofitBuilder;
import firmanmfk.setorantunai.model.data.DetailTranscation;
import firmanmfk.setorantunai.model.data.Result;
import firmanmfk.setorantunai.ui.base.BaseActivity;
import retrofit.Call;

public class DetailTranksaksiActivity extends BaseActivity {


    @Bind(R.id.tv_id_setoran)
    TextView tvIdSetoran;
    @Bind(R.id.tv_id_invoice)
    TextView tvIdInvoice;
    @Bind(R.id.tv_jumlah)
    TextView tvJumlah;
    @Bind(R.id.tv_kantor)
    TextView tvKantor;
    @Bind(R.id.tv_no_rekening)
    TextView tvNoRekening;
    @Bind(R.id.tv_no_cetak)
    TextView tvNoCetak;
    @Bind(R.id.tv_no_nota)
    TextView tvNoNota;
    @Bind(R.id.tv_nm_karyawan)
    TextView tvNmKaryawan;
    @Bind(R.id.tv_tgl_invoice)
    TextView tvTglInvoice;
    @Bind(R.id.tv_asal_biaya)
    TextView tvAsalBiaya;

    String idInvoice, idSetoran;
    DetailTranscation detailTranscation;

    RestApi restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tranksaksi);
        setActionBarTitle(getString(R.string.detail_tranksaksi));
        displayHome();
        restApi = RetrofitBuilder.create(RestApi.class);
        loadTransactionsData();
    }

    private void setForm(){
        tvIdInvoice.setText(getString(R.string.id_invoice) + " : " + detailTranscation.getIdInvoice());
        tvIdSetoran.setText(getString(R.string.id_setoran) + " : " + detailTranscation.getIdSetoran());
        tvJumlah.setText(getString(R.string.jumlah) + " : " + String.valueOf(detailTranscation.getTotalBiaya()));
        tvKantor.setText(getString(R.string.kantor) + " : " + detailTranscation.getKantor());
        tvNoRekening.setText(getString(R.string.no_rekening) + " : " + detailTranscation.getNoRekening());
        tvNoNota.setText(getString(R.string.no_nota) + " : " + detailTranscation.getNoNota());
        tvNoCetak.setText(getString(R.string.no_cetak) + " : " + detailTranscation.getNoCetak());
        tvAsalBiaya.setText(getString(R.string.asal_biaya) + " : " + detailTranscation.getAsalBiaya());
        tvNmKaryawan.setText(getString(R.string.nama_karyawan) + " : " + detailTranscation.getNamaKaryawan());
        tvTglInvoice.setText(getString(R.string.tgl_invoice) + " : " + detailTranscation.getTglInvoice());
    }

    public void loadTransactionsData(){
        showProgressDialog(getString(R.string.loading_data));
        idInvoice = (String) getMyBundle().getSerializable("idInvoice");
        idSetoran = (String) getMyBundle().getSerializable("idSetoran");
        if(!idInvoice.isEmpty() && !idSetoran.isEmpty()){
            Call<Result<List<DetailTranscation>>> service =
                    restApi.getDetailTransactions(idSetoran);
            service.enqueue(new ApiCallback<Result<List<DetailTranscation>>>() {
                @Override
                public void onSuccess(Result<List<DetailTranscation>> data) {
                    dismissProgressDialog();
                    if(data.getResult().size() > 0){
                        detailTranscation = data.getResult().get(0);
                        setForm();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_detail_tranksaksi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_delete :
                deleteTransaction();
                break;
        }
        return true;
    }

    private void deleteTransaction(){
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.confirmation))
                .setMessage(getString(R.string.really_want_to_delete))
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        showProgressDialog(getString(R.string.deleting_tranksaksi));
                        Call<Result<String>> service = restApi.postDeleteTransaction(idSetoran, idInvoice);
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
                    }
                })
            .setNegativeButton(getString(R.string.cancel), null).show();
    }
}
