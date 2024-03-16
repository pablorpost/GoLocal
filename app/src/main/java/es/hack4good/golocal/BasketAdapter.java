package es.hack4good.golocal;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import es.hack4good.golocal.database.entity.Product;

public class BasketAdapter extends BaseAdapter {
    Context context;
    List<Pair<Product,Integer>> products;

    public BasketAdapter(Context context, List<Pair<Product,Integer>> lst) {
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

        Product p = products.get(position).first;
        Integer quantity = products.get(position).second;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.shopitem,null);
        }

        textView = convertView.findViewById(R.id.nameView);
        TextView quantityView = convertView.findViewById(R.id.storeView);
        TextView priceView = convertView.findViewById(R.id.priceView);


        textView.setText(p.getName());
        quantityView.setText("Cantidad: "+String.valueOf(quantity));
        priceView.setText(String.valueOf(p.getPrice())+"€");
        return convertView;
    }
}
