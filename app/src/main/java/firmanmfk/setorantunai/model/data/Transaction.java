package firmanmfk.setorantunai.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public class Transaction {

    @SerializedName("id_setoran")
    private String idSetoran;
    @SerializedName("id_invoice")
    private String idInvoice;
    @SerializedName("no_rekening")
    private String noRekening;
    @SerializedName("bea_setoran")
    private String beaSetoran;
    @SerializedName("total_biaya")
    private String totalBiaya;
    private String kantor;

    public Transaction(String idSetoran, String idInvoice, String noRekening, String beaSetoran, String totalBiaya, String kantor) {
        this.idSetoran = idSetoran;
        this.idInvoice = idInvoice;
        this.noRekening = noRekening;
        this.beaSetoran = beaSetoran;
        this.totalBiaya = totalBiaya;
        this.kantor = kantor;
    }

    public Transaction() {
    }

    public String getIdSetoran() {
        return idSetoran;
    }

    public void setIdSetoran(String idSetoran) {
        this.idSetoran = idSetoran;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getBeaSetoran() {
        return beaSetoran;
    }

    public void setBeaSetoran(String beaSetoran) {
        this.beaSetoran = beaSetoran;
    }

    public String getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(String totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String getKantor() {
        return kantor;
    }

    public void setKantor(String kantor) {
        this.kantor = kantor;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idSetoran='" + idSetoran + '\'' +
                ", idInvoice='" + idInvoice + '\'' +
                ", noRekening='" + noRekening + '\'' +
                ", beaSetoran='" + beaSetoran + '\'' +
                ", totalBiaya='" + totalBiaya + '\'' +
                ", kantor='" + kantor + '\'' +
                '}';
    }
}
