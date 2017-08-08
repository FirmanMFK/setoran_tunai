package firmanmfk.setorantunai.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public class User {

    @SerializedName("id_pengguna")
    private String idUser;
    @SerializedName("nm_pengguna")
    private String nmUser;


    public User(String nmUser, String idUser) {
        this.nmUser = nmUser;
        this.idUser = idUser;

    }

    public User() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

}
