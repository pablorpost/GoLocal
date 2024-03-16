package es.hack4good.golocal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import es.hack4good.golocal.ProductAdapter;
import es.hack4good.golocal.R;
import es.hack4good.golocal.database.AppDatabase;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.database.services.DbInitializer;
import es.hack4good.golocal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //View root = binding.getRoot();
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ListView listView = view.findViewById(R.id.listView2);
            AppDatabase db = AppDatabase.buildDatabaseInstance(getActivity(),"golocal",false);
        if(db.productDAO().getAllProducts().isEmpty()){
            DbInitializer.initialize(db);
        }
        List<Product> products = db.productDAO().getAllProducts();
        System.out.println("prueba");
        System.out.println(products);
        ProductAdapter adapter = new ProductAdapter(getActivity(),products);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}