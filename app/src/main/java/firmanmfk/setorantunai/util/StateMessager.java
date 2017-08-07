package firmanmfk.setorantunai.util;

/**
 * Created by FirmanMFK on 7/12/17.
 */

public class StateMessager {

    public static String getMessage(int code){
        String message = "";
        switch(code) {
            case 0:
                message = "Berhasil";
                break;
            case 1:
                message = "Gagal";
                break;
            case 2:
                message = "Bermasalah di Engine";
                break;
            case 3:
                message = "Data yang dimasukkan tidak valid";
                break;
            case 4:
                message = "Tidak tersambung dengan database";
                break;
            case 5:
                message = "Library tidak ditemukan";
                break;
            case 6:
                message = "File yang diunggah tidak ditemukan";
                break;
            case 7:
                message = "Bermasalah di I/O";
                break;
            case 8:
                message = "Tidak ada record";
                break;
            default:
                message = "Belum ada perubahan/aktivitas yang dijalankan";
                break;
        }
        return message;
    }


}
