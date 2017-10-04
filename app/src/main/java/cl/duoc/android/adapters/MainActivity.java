package cl.duoc.android.adapters;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.duoc.android.adapters.adapter.ProductoAdapter;
import cl.duoc.android.adapters.entity.Producto;

public class MainActivity extends AppCompatActivity {

    List<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView1 = (ListView) findViewById(R.id.listView1);

        ProductoAdapter productoAdapter = new ProductoAdapter(this, getListaProductos());
        listView1.setAdapter(productoAdapter);

        // evento
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                Producto producto = listaProductos.get(position);
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Confirmación")
                    .setMessage("Realmente desea eliminar el elemento: "+producto.getNombre())
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            listaProductos.remove(position);
                            listView1.invalidateViews();
                            Toast.makeText(MainActivity.this, "Elemento borrado", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("NO", null)
                    .show();
                return true;
            }
        });
    }

    private List<Producto> getListaProductos() {
        listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto(1, "Toalla baño", 10990));
        listaProductos.add(new Producto(2, "Set juguetes de playa", 15990));
        listaProductos.add(new Producto(3, "Paletas", 5990));
        return listaProductos;
    }

    public void irASpinner(View view) {
        startActivity(new Intent(this, SpinnerActivity.class));
    }
}
