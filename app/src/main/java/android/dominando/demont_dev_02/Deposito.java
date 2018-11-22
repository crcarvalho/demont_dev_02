package android.dominando.demont_dev_02;

import java.io.Serializable;

/**
 * Created by Carlos Carvalho on 18/11/2016.
 */
public class Deposito implements Serializable{

    public String nome;
    public String endereco;
    public float rating;
    public String telefone;
    public String website;
    public boolean ativo;
    public Double latitude;
    public Double logitude;

    public Deposito(String nome, String endereco, float rating, String telefone, String website,
                    boolean ativo, Double latitude, Double longitude){
        this.nome = nome;
        this.endereco = endereco;
        this.rating = rating;
        this.telefone = telefone;
        this.website = website;
        this.ativo = ativo;
        this.latitude = latitude;
        this.logitude = longitude;
    }
}
