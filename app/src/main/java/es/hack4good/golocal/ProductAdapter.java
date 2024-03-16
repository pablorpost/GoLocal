package es.hack4good.golocal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.hack4good.golocal.database.AppDatabase;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.database.entity.Store;

public class ProductAdapter extends BaseAdapter {
    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> lst) {
        this.context = context;
        this.products = lst;
    }
    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        Product p = products.get(position);
        //AppDatabase db = AppDatabase.buildDatabaseInstance(context,"golocal",false);
        //String storeName = db.storeDAO().getStoreById(products.get(position).getStoreId()).getName();


        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.shopitem,null);
        }

        textView = convertView.findViewById(R.id.nameView);
        TextView storeView = convertView.findViewById(R.id.storeView);
        TextView priceView = convertView.findViewById(R.id.priceView);


        textView.setText(p.getName());
        //storeView.setText(storeName);
        priceView.setText(String.valueOf(p.getPrice())+"€");
        return convertView;
    }
}
