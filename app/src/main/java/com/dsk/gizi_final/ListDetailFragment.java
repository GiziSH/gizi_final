package com.dsk.gizi_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListDetailFragment extends Fragment {

    private TextView titleView, authorView, contentView;
    private static String TAG = "phptest_MainActivity";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listdetailfragment, container, false);

        String title = getArguments().getString("title");
        String author = getArguments().getString("author");
        String content = getArguments().getString("content");

        Log.d(TAG, "response  - " + "title : " + title + ", " + "author : " + author + ", " + "content : " + content);

        titleView = (TextView) v.findViewById(R.id.titleview);
        authorView = (TextView) v.findViewById(R.id.authorview);
        contentView = (TextView) v.findViewById(R.id.contentview);

        titleView.setText(title);
        authorView.setText(author);
        contentView.setText(content);

        return v;
    }
}
