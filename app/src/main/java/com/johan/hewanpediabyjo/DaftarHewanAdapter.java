package com.johan.hewanpediabyjo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johan.hewanpediabyjo.model.Hewan;

import java.util.List;

public class DaftarHewanAdapter  extends ArrayAdapter<Hewan> {

    Context context;

    public DaftarHewanAdapter(DaftarHewanActivity context, List<Hewan> hewans) {
        super(context, R.layout.row_daftar_burung, hewans);
        this.context = context;
    }

    private static class ViewHolder {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hewan hewan = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_burung, parent, false);
            viewHolder.textJenis = convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_hewan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJenis.setText(hewan.getRas());
        viewHolder.textAsal.setText(hewan.getAsal());
        viewHolder.gambar.setImageDrawable(context.getDrawable(hewan.getDrawableRes()));
        return convertView;
    }
}
