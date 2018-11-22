package android.dominando.demont_dev_02;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;
import java.util.List;

/**
 * Created by Carlos Carvalho on 21/09/2016.
 */
public class ProdutosAdapter extends BaseAdapter {

    Context ctx;
    List<Produto> lstProdutos;

    public ProdutosAdapter(Context ctx, List< Produto > lstProdutos){
        this.ctx = ctx;
        this.lstProdutos = lstProdutos;
    }

    @Override
    public int getCount(){
        return lstProdutos.size();
    }

    @Override
    public Object getItem(int position){
        return lstProdutos.get( position );
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public class ViewHolder{
        ImageView imgProduto;
        TextView nome;
        TextView precoUnitario;
        TextView precoAnterior;
        TextView desconto;
        TextView deposito;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Produto produto = lstProdutos.get( position );
        ViewHolder holder = null;
        if( convertView == null ){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_da_lista_destaque, null);
            holder = new ViewHolder();
            holder.imgProduto = (ImageView) convertView.findViewById(R.id.imgProduto);
            holder.nome = (TextView) convertView.findViewById(R.id.txtNome);
            holder.precoUnitario = (TextView) convertView.findViewById(R.id.vlUnitario);
            holder.precoAnterior = (TextView) convertView.findViewById(R.id.vlAnterior);
            holder.desconto = (TextView) convertView.findViewById(R.id.vlDesconto);
            holder.deposito = (TextView) convertView.findViewById(R.id.txtDeposito);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Resources res = ctx.getResources();
        //Essa parte deve ser alterada quando as imagens vierem de uma base de dados
        TypedArray produtos = res.obtainTypedArray(R.array.produtos);
        holder.imgProduto.setImageDrawable(produtos.getDrawable(produto.tipo));
        holder.nome.setText(produto.nome);
        holder.precoAnterior.setText(String.valueOf("R$ " + produto.precoAnterior));
        holder.precoUnitario.setText(String.valueOf("R$ " + produto.precoUnitario));
        holder.desconto.setText(String.valueOf(produto.desconto));
        holder.deposito.setText(produto.deposito);

        return convertView;
    }
}