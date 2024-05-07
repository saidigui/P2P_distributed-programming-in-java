package modules;

/**
 * this class is used to the parametre of seraching file , containing the filename and the depth of serach
 */
public class RechercheFichier {
    
    public String filename;
    public int tentation;

    public RechercheFichier() {
    }

    public RechercheFichier(String filename, int depth) {
        this.filename = filename;
        this.tentation = depth;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getDepth() {
        return tentation;
    }

    public void setDepth(int depth) {
        this.tentation = depth;
    }
    
    
    
}
