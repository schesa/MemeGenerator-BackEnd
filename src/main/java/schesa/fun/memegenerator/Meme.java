package schesa.fun.memegenerator;

public class Meme {
    private String path;
    private String textBottom;
    private String textTop;

    public Meme(String path, String textTop, String textBottom){
        this.path=path;
        this.textBottom=textBottom;
        this.textTop=textTop;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTextBottom() {
        return textBottom;
    }

    public void setTextBottom(String textBottom) {
        this.textBottom = textBottom;
    }

    public String getTextTop() {
        return textTop;
    }

    public void setTextTop(String textTop) {
        this.textTop = textTop;
    }
}
