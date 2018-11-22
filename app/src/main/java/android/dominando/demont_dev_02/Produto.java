package android.dominando.demont_dev_02;

import java.io.Serializable;

/**
 * Created by Carlos Carvalho on 27/09/2016.
 */

public class Produto implements Serializable {

    public String nome;
    public String codigo;
    public boolean ativo;
    public Double precoUnitario;
    public Double precoAnterior;
    public Double desconto;
    public String descricao;
    public String codigoDeposito;
    public String deposito;
    public int tipo;//0 = pedra; 1 = tijolo; 2 = bloco; 3 = vergalhão;
    public long id;
    public Status status;
    public long idServidor;

    public Produto(String nome, String codigo, boolean ativo, Double precoUnitario, Double precoAnterior,
                   Double desconto, String descricao, String codigoDeposito, String deposito, int tipo,
                   long id, long idServidor, Status status){
        this.nome = nome;
        this.codigo = codigo;
        this.ativo = ativo;
        this.precoUnitario = precoUnitario;
        this.precoAnterior = precoAnterior;
        this.desconto = desconto;
        this.descricao = descricao;
        this.codigoDeposito = codigoDeposito;
        this.deposito = deposito;
        this.tipo = tipo;
        this.id = id;
        this.status = status;
        this.idServidor = idServidor;
    }

    public Produto(String nome, String codigo, boolean ativo, Double precoUnitario, Double precoAnterior,
                   Double desconto, String descricao, String codigoDeposito, String deposito, int tipo){
        this(nome, codigo, ativo, precoUnitario, precoAnterior, desconto, descricao, codigoDeposito, deposito, tipo, 0, 0, Status.INSERIR);
    }

    @Override
    public String toString(){
        return nome;
    }

    public enum Status {
        OK, INSERIR, ATUALIZAR, EXCLUIR
    }
}
