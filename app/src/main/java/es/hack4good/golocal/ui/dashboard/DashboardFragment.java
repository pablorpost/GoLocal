package es.hack4good.golocal.ui.dashboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import es.hack4good.golocal.BasketAdapter;
import es.hack4good.golocal.MainPage;
import es.hack4good.golocal.ProductAdapter;
import es.hack4good.golocal.R;
import es.hack4good.golocal.ShowProduct;
import es.hack4good.golocal.database.AppDatabase;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.Basket;
import es.hack4good.golocal.database.services.DbInitializer;
import es.hack4good.golocal.databinding.FragmentDashboardBinding;
import es.hack4good.golocal.ui.home.HomeFragment;

public class DashboardFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ListView listView = view.findViewById(R.id.listView2);
        AppDatabase db = AppDatabase.buildDatabaseInstance(getActivity(),"golocal",false);
        if(db.productDAO().getAllProducts().isEmpty()){
            DbInitializer.initialize(db);
        }

        Basket b = new Basket(null, getContext());

        List<Pair<Product,Integer>> basket = b.getProducts();
        BasketAdapter adapter = new BasketAdapter(getActivity(),basket);
        listView.setAdapter(adapter);

        Button payButton = view.findViewById(R.id.payButton);
        Button emptyButton = view.findViewById(R.id.emptyButton);

        TextView totalText = view.findViewById(R.id.totalText);

        totalText.setText("Total: " + String.valueOf(b.totalCost()));

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                alertDialog(b.totalCost(), basket, container);

                //Payment process will be taken here
            }
        });

        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basket.clear();
                changeFragment();
            }
        });



        return view;
    }

    private void alertDialog(double price, List<Pair<Product,Integer>> basket, ViewGroup container){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Usted va a pagar: "+ String.valueOf(price) + "€");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                basket.clear();
                changeFragment();

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Action cancelled
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


    private void changeFragment(){
        getActivity().finish();
        Intent intent = new Intent(getContext(), MainPage.class);
        startActivity(intent);
    }
}