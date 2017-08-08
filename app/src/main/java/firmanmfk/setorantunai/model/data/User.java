package firmanmfk.setorantunai.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public class User {

    @SerializedName("id_user")
    private String idUser;
    @SerializedName("nm_user")
    private String nmUser;
    @SerializedName("level_user")
    private String levelUser;

    public User(String nmUser, String idUser, String levelUser) {
        this.nmUser = nmUser;
        this.idUser = idUser;
        this.levelUser = levelUser;
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

    public String getLevelUser() {
        return levelUser;
    }

    public void setLevelUser(String levelUser) {
        this.levelUser = levelUser;
    }
}
