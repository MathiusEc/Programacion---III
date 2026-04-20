import javax.print.Doc;
import java.util.ArrayList;

public class Documento {
    /** Atributte Declaration*/
    private String tipo;
    private int pags;

    /** Setters & Getters*/
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPags() {
        return pags;
    }

    public void setPags(int pags) {
        this.pags = pags;
    }


    /**Constrcutors & Destrcuctors*/
    public Documento(String tipo, int pags) {
        this.tipo = tipo;
        this.pags = pags;
    }

    public Documento() {
    }





}
