package com.example.project.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    private TextView titleTextView;
    private TextView contentTextView;
    private ImageView mainImageView;

    ArrayList<ContentClass> listViewItemList=new ArrayList<ContentClass>();

    public ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos=position;

        final Context context=parent.getContext();

        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_listitem, parent, false);
        }

        titleTextView=(TextView) convertView.findViewById(R.id.titleTextView);
        contentTextView=(TextView) convertView.findViewById(R.id.contentTextView);
        mainImageView=(ImageView) convertView.findViewById(R.id.mainImageView);

        ContentClass contentClass=listViewItemList.get(position);
        titleTextView.setText(contentClass.getTitle());
        contentTextView.setText(contentClass.getContent());
        int id=context.getApplicationContext().getResources().getIdentifier("drawable/"+contentClass.getMainImageView(), null, context.getApplicationContext().getPackageName());
        mainImageView.setImageResource(id);

        return convertView;
    }

    public void addItem(String title, String content, String detail, String mainImageView, String link){
        ContentClass item=new ContentClass();

        item.setTitle(title);
        item.setContent(content);
        item.setMainImageView(mainImageView);
        item.setDetail(detail);
        item.setlink(link);
        listViewItemList.add(item);
    }

    public String getTitle(int position){
        return listViewItemList.get(position).getTitle();
    }
    public String getContent(int position){
        return listViewItemList.get(position).getContent();
    }
    public String getDetail(int position){
        return listViewItemList.get(position).getDetail();
    }
    public String getMainImageView(int position){return listViewItemList.get(position).getMainImageView();}
    public String getLink(int position){return listViewItemList.get(position).getLink();}
}
