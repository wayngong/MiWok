package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gongkai on 2016/12/25.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorCategory = R.color.tan_background;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorCategory) {
        super(context, 0, words);
        mColorCategory = colorCategory;
    }

//    public WordAdapter(Activity context, ArrayList<Word> words) {
//        super(context, 0, words);
//    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.miwok_text_view_list);
        linearLayout.setBackgroundResource(mColorCategory);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwok_image_view);
        if (currentWord.hasImage()) {
            imageView.setVisibility(ImageView.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageView.setVisibility(ImageView.GONE);
        }

        TextView englistView = (TextView) listItemView.findViewById(R.id.default_text_view);
        if(currentWord.hasEnglishId())
            englistView.setText(currentWord.getEnglishId());
        else
            englistView.setText(currentWord.getEnglish());

        TextView miwokView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        if(currentWord.hasMiwokId())
            miwokView.setText(currentWord.getMiwokId());
        else
            miwokView.setText(currentWord.getMiwok());

//        if (currentWord.hasSong()) {
//            final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentWord.getSongId());
//            listItemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mediaPlayer.start();
//                }
//            });
//        }

        return listItemView;
    }
}
