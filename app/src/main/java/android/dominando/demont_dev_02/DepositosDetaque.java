package android.dominando.demont_dev_02;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Carvalho on 27/09/2016.
 */
public class DepositosDetaque extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.depositos_destaque, container, false);

        List< Deposito > depositos = new ArrayList<Deposito>();

        depositos.add(new Deposito("C&C", "Rua Eleonor, n°78 - Barueri - SP",4, "11 5200-4455",
                "www.cec.com.br", true, null, null));
        depositos.add(new Deposito("Telhanorte", "Rua Edu Tavares, n°455 - São Paulo - SP",4, "11 6500-5541",
                "www.telhanorte.com.br", true, null, null));
        depositos.add(new Deposito("Deposito do Ipiranga", "Rua Clementino Almeida, n°778 - Osasco - SP",
                4, "11 4100-4455", "www.ipirangadep.com.br", true, null, null));
        depositos.add(new Deposito("Materiais de Contrução Imigrantes", "Avenida dos Imigrantes, n°1080 - São Paulo- SP",
                4, "11 3520-7755", "www.mcimigrantes", true, null, null));
        DepositosAdapter adapterDepositos = new DepositosAdapter(getActivity(), depositos);
        setListAdapter(adapterDepositos);

        return view;
    }
}
