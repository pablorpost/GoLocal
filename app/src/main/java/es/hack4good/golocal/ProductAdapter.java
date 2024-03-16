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

public class ProductAdapter extends BaseAdapter {
    Context context;
    List<Product> products = AppDatabase.getInstance(context).productDAO().getAllProducts();

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

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.shopitem,null);
        }

        textView = convertView.findViewById(R.id.nombreProducto);
        textView.setText(p.getName());
        return null;
    }
}
