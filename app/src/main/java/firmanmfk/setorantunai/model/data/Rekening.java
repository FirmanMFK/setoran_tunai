package firmanmfk.setorantunai.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public class Rekening {

    @SerializedName("nama_pemilik_rekening")
    private String namaPemilikRekening;
    @SerializedName("no_rekening")
    private String noRekening;

    public Rekening(String namaPemilikRekening, String noRekening) {
        this.namaPemilikRekening = namaPemilikRekening;
        this.noRekening = noRekening;
    }

    public Rekening() {
    }

    public String getNamaPemilikRekening() {
        return namaPemilikRekening;
    }

    public void setNamaPemilikRekening(String namaPemilikRekening) {
        this.namaPemilikRekening = namaPemilikRekening;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    @Override
    public String toString() {
        return "Rekening{" +
                "namaPemilikRekening='" + namaPemilikRekening + '\'' +
                ", noRekening='" + noRekening + '\'' +
                '}';
    }
}
