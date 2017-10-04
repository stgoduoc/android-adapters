package cl.duoc.android.adapters.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cl.duoc.android.adapters.R;
import cl.duoc.android.adapters.entity.Producto;

/**
 * Created by zero on 26/09/17.
 */

public class ProductoAdapter extends BaseAdapter {

    private Context context;
    private List<Producto> productos;

    public ProductoAdapter(Context context, List<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int i) {
        return productos.get(i);
    }

    @Override
    public long getItemId(int i) {
        for(Producto p: productos) {
            if(p.getId() == i) {
                return i;
            }
        }
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return implementacionLayoutPropio(position, convertView, parent);
        return implementacionLayoutAndroid(position, convertView, parent);
    }

    private View implementacionLayoutAndroid(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView ==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(android.R.layout.simple_list_item_2, null);
        }

        TextView textView1 = (TextView) convertView.findViewById(android.R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(android.R.id.text2);

        Producto producto = (Producto) getItem(position);

        textView1.setText(producto.getNombre());
        textView2.setText(producto.getPrecio()+"");
        return convertView;
    }

    private View implementacionLayoutPropio(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView ==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.producto_list_item, null);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.text2);

        Producto producto = (Producto) getItem(position);

        textView1.setText(producto.getNombre());
        textView2.setText(producto.getPrecio()+"");
        return convertView;
    }
}
