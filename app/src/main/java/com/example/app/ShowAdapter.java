package com.example.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Show> showList;

    public ShowAdapter(Context context, List<Show> showList) {
        this.context = context;
        this.showList = (ArrayList<Show>) showList;
    }

    @Override
    public int getCount() {
        return showList.size();
    }

    @Override
    public Object getItem(int position) {
        return showList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.show_item, null);

        ImageView showImage = view.findViewById(R.id.showImage);
        TextView showName = view.findViewById(R.id.showName);

        Show show = showList.get(position);

        showImage.setImageResource(show.getImageResourceId());
        showName.setText(show.getName());

        return view;
    }
}

