package android.dominando.demont_dev_02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Carvalho on 27/09/2016.
 */
public class ItensDestaque extends ListFragment
{

    public List< Produto > produtos;
//    private ProdutosAdapter adapterProdutos;
    private View view;
    private int idContainer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        idContainer = container.getId();
        view = inflater.inflate(R.layout.itens_destaque, container, false);
        produtos = this.createList();

        Log.d("DEBUG************","carregou produtos");
        ProdutosAdapter adapterProdutos = new ProdutosAdapter(getActivity(), produtos);
        setListAdapter(adapterProdutos);

        return view;
    }


    public void buscar(String s)
    {
        Log.d("CR","TEXTO DE BUSCA= "+s);
        produtos.clear();

//        Log.d("CR","tamanho lista produtos="+produtos.size());
        List<Produto> produtosEncontrados = createList();
//        int cont = produtosEncontrados.size();

//        Log.d("CR","tamanho lista= "+cont);
        for(int i = produtosEncontrados.size()-1; i >= 0; i--){
            Produto produto = produtosEncontrados.get(i);
            if(! produto.nome.toUpperCase().contains(s.toUpperCase())){
                Log.d("CR", "Aqui remove um item");
                produtosEncontrados.remove(produto);
                Log.d("CR","TAMANHO LISTA= "+produtosEncontrados.size());
            }
        }

        produtos.addAll(produtosEncontrados);


        ProdutosAdapter adapterProdutos = (ProdutosAdapter) getListAdapter();

//        adapterProdutos.notifyDataSetChanged();
        setListAdapter(adapterProdutos);
        adapterProdutos.notifyDataSetChanged();

    }

    public void limparBusca()
    {
        produtos.clear();
        ProdutosAdapter adapterProdutos = (ProdutosAdapter) getListAdapter();
        adapterProdutos.notifyDataSetChanged();
    }

    public List<Produto > createList()
    {
        List<Produto >produtos = new ArrayList<Produto>();
        produtos.add( new Produto("Pedras", "112233", true, 49.0, 70.0, 49.0/70.0, "Pedras para construção.", "1", "C&C", 0));
        produtos.add( new Produto("Tijolo", "223344", true, 28.0, 35.0, 0.28/35.0, "Tijolo baiano", "1", "C&C", 2));
        produtos.add( new Produto("Bloco", "334455", true, 39.0, 60.0, 39.0/60.0, "Bloco de construção", "2", "Depósito São Luiz", 1));
        produtos.add( new Produto("Vergalhão", "445566", true, 62.0, 90.0, 62.0/90.0, "Vergalhão GG 50", "2", "Depósito São Luiz", 3));

        return produtos;


//        adapterProdutos = new ProdutosAdapter(getActivity(), produtos);
//        setListAdapter(adapterProdutos);
    }
}