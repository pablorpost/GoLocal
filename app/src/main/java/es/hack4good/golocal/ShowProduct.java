package es.hack4good.golocal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import android.view.LayoutInflater;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.Basket;

public class ShowProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ActionBar act = getSupportActionBar();
        act.hide();

        TextView name = findViewById(R.id.productName);
        TextView price = findViewById(R.id.productPrice);

        Intent intent = getIntent();

        if(intent.getExtras() != null){
            Product p = (Product) intent.getSerializableExtra("product");
            name.setText(p.getName());
            price.setText(String.valueOf(p.getPrice()));

        }
        Basket basket = new Basket(null, this);
        Button buyButton = findViewById(R.id.buyProduct);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = (Product) intent.getSerializableExtra("product");
                basket.addProduct(p,1);
                finish();
            }
        });
    }
}