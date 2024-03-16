package es.hack4good.golocal.ui.dashboard;

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
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import es.hack4good.golocal.BasketAdapter;
import es.hack4good.golocal.ProductAdapter;
import es.hack4good.golocal.R;
import es.hack4good.golocal.ShowProduct;
import es.hack4good.golocal.database.AppDatabase;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.Basket;
import es.hack4good.golocal.database.services.DbInitializer;
import es.hack4good.golocal.databinding.FragmentDashboardBinding;

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
                basket.clear();
                //Payment process will be taken here
            }
        });

        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basket.clear();
            }
        });



        return view;
    }


}