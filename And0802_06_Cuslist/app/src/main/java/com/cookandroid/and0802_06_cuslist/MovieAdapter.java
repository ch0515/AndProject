package com.cookandroid.and0802_06_cuslist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    Context context; //메인액티비티 컨텍스트 저장변수
    ArrayList<Movie> data; //데이터
    //생성자

    public MovieAdapter(Context context, ArrayList<Movie> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();//배열 원소의 개수
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) { // i>>인덱스
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){ //초기화
            view = View.inflate(context, R.layout.listitem,null);
        }
        ImageView img = view.findViewById(R.id.imgPoster);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtGenre = view.findViewById(R.id.txtGenre);
        img.setImageDrawable(data.get(i).getImage());//Movie의 image 변수 값 가져와서 연결
        txtTitle.setText(data.get(i).getTitle());//Movie의 title값 가져와서 연결
        txtGenre.setText(data.get(i).getGenre());//Movie의 Genre값 가져와서 연결

        return view;
    }
}
