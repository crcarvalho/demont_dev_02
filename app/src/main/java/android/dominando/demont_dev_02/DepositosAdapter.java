package android.dominando.demont_dev_02;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Carlos Carvalho on 18/11/2016.
 */
public class DepositosAdapter extends BaseAdapter {

    Context ctx;
    List<Deposito> lstDepositos;

    public DepositosAdapter(Context ctx, List< Deposito > lstDepositos){
        this.ctx = ctx;
        this.lstDepositos = lstDepositos;
    }

    @Override
    public int getCount(){
        return lstDepositos.size();
    }

    @Override
    public Object getItem(int position){
        return lstDepositos.get( position );
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public class ViewHolder{
        ImageView imgDeposito;
        TextView nome;
        TextView endereco;
        RatingBar rating;
        TextView telefone;
        TextView website;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Deposito deposito = lstDepositos.get( position );
        ViewHolder holder = null;
        if( convertView == null ){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.deposito_lista_destaque, null);
            holder = new ViewHolder();
            holder.imgDeposito = (ImageView) convertView.findViewById(R.id.imgDeposito);
            holder.nome = (TextView) convertView.findViewById(R.id.nome);
            holder.endereco = (TextView) convertView.findViewById(R.id.endereco);
            //holder.rating = (RatingBar) convertView.findViewById(R.id.rating);
            holder.telefone = (TextView) convertView.findViewById(R.id.telefone);
            holder.website = (TextView) convertView.findViewById(R.id.website);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Resources res = ctx.getResources();
        //Essa parte deve ser alterada quando as imagens vierem de uma base de dados
        TypedArray depositos = res.obtainTypedArray(R.array.depositos);

        holder.imgDeposito.setImageDrawable(depositos.getDrawable(0));
        holder.nome.setText(deposito.nome);
        holder.endereco.setText(deposito.endereco);
       // holder.rating.setRating(deposito.rating);
        holder.telefone.setText(String.valueOf(deposito.telefone));
        holder.website.setText(deposito.website);

        return convertView;
    }

}
