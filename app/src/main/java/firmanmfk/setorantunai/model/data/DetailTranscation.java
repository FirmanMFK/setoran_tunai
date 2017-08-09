package firmanmfk.setorantunai.model.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by FirmanMFK on 7/12/17.
 */

public class DetailTranscation extends Transaction implements Serializable {

    @SerializedName("no_cetak")
    private String noCetak;
    @SerializedName("no_nota")
    private String noNota;
    @SerializedName("tgl_invoice")
    private String tglInvoice;
    @SerializedName("asal_biaya")
    private String asalBiaya;
    @SerializedName("nm_karyawan")
    private String namaKaryawan;

    public DetailTranscation(String idSetoran, String idInvoice, String noRekening, String totalBiaya, String kantor, String noCetak, String noNota, String tglInvoice, String asalBiaya, String namaKaryawan) {
        super(idSetoran, idInvoice, noRekening, totalBiaya, kantor);
        this.noCetak = noCetak;
        this.noNota = noNota;
        this.tglInvoice = tglInvoice;
        this.asalBiaya = asalBiaya;
        this.namaKaryawan = namaKaryawan;
    }

    public DetailTranscation() {
    }

    public String getNoCetak() {
        return noCetak;
    }

    public void setNoCetak(String noCetak) {
        this.noCetak = noCetak;
    }

    public String getNoNota() {
        return noNota;
    }

    public void setNoNota(String noNota) {
        this.noNota = noNota;
    }

    public String getTglInvoice() {
        return tglInvoice;
    }

    public void setTglInvoice(String tglInvoice) {
        this.tglInvoice = tglInvoice;
    }

    public String getAsalBiaya() {
        return asalBiaya;
    }

    public void setAsalBiaya(String asalBiaya) {
        this.asalBiaya = asalBiaya;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    @Override
    public String toString() {
        return "DetailTranscation{" +
                "idSetoran='" + getIdSetoran() + '\'' +
                ", idInvoice='" + getIdInvoice() + '\'' +
                ", noRekening='" + getNoRekening() + '\'' +
                ", totalBiaya='" + getTotalBiaya() + '\'' +
                ", kantor='" + getKantor() + '\'' +
                "noCetak='" + noCetak + '\'' +
                ", noNota='" + noNota + '\'' +
                ", tglInvoice='" + tglInvoice + '\'' +
                ", asalBiaya='" + asalBiaya + '\'' +
                ", namaKaryawan='" + namaKaryawan + '\'' +
                '}';
    }
}
