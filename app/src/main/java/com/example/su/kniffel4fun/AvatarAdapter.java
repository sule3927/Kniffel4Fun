package com.example.su.kniffel4fun;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Su on 17.03.2018.
 */

public class AvatarAdapter extends ArrayAdapter<AvatarItem> {

    public AvatarAdapter(Context context, ArrayList<AvatarItem> avatarList){
        super(context, 0, avatarList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.avatar_spinner_row, parent, false);
        }

        ImageView imageViewAvatar = convertView.findViewById(R.id.img_v_avatar);

        AvatarItem currentItem = getItem(position);

        if (currentItem != null) {
            imageViewAvatar.setImageResource(currentItem.getAvatarImage());
        }
        return convertView;
    }
}
