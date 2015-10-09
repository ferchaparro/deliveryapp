package itson.mx.deliveryapp;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import itson.mx.deliveryapp.recycler.TipoPlatillosAdapter;

/**
 * Created by chapa on 02/10/2015.
 */
public class MenuActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int color = getIntent().getIntExtra("color", 0);
        getSupportActionBar().setTitle(getIntent().getStringExtra("titulo"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
        setContentView(R.layout.activiry_menu);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_menu);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] dataset = { "Platillos regulares", "Especiales", "Guarniciones" };
        mAdapter = new TipoPlatillosAdapter(this, dataset, color);
        mRecyclerView.setAdapter(mAdapter);
    }


}
