package firmanmfk.setorantunai.api;

import java.util.List;

import firmanmfk.setorantunai.model.cons.Endpoint;
import firmanmfk.setorantunai.model.data.DetailTranscation;
import firmanmfk.setorantunai.model.data.Rekening;
import firmanmfk.setorantunai.model.data.Result;
import firmanmfk.setorantunai.model.data.Transaction;
import firmanmfk.setorantunai.model.data.User;
import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by FirmanMFK on 7/12/17.
 */

public interface RestApi {

    @GET(Endpoint.GET_TRANSACTIONS)
    Call<Result<List<Transaction>>> getTransactions();

    @GET(Endpoint.GET_DETAIL_TRANSACTIONS)
    Call<Result<List<DetailTranscation>>> getDetailTransactions(@Query("id_setoran") String idSetoran);

    @GET(Endpoint.GET_REKENINGS)
    Call<Result<List<Rekening>>> getRekenings();

    @FormUrlEncoded
    @POST(Endpoint.POST_DELETE_TRANSACTION)
    Call<Result<String>> postDeleteTransaction(@Field("id_setoran") String idSetoran,
                                               @Field("id_invoice") String idInvoice);

    @FormUrlEncoded
    @POST(Endpoint.POST_ADD_TRANSACTION)
    Call<Result<String>> postAddTransaction(@Field("no_rekening") String noRekening,
                                            @Field("asal_biaya") String asalBiaya,
                                            @Field("jumlah") String jumlah,
                                            @Field("terbilang") String terbilang,
                                            @Field("kantor") String kantor,
                                            @Field("id_karyawan") String idKaryawan);

    @FormUrlEncoded
    @POST(Endpoint.POST_LOGIN)
    Call<Result<List<User>>> postLogin(@Field("username") String username,
                                       @Field("password") String password);

}
