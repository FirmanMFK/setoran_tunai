package firmanmfk.setorantunai.model.other;
/**
 * Created by FirmanMFK on 7/12/17.
 */


public class Spin {

    private String text;
    private String value;

    public Spin() {
    }

    public Spin(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
