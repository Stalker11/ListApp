package com.example.oleg.testmylybrary.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oleg.testmylybrary.MainActivity;
import com.example.oleg.testmylybrary.R;
import com.example.oleg.testmylybrary.models.ListPositionModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oleg on 15.07.2017.
 */

public class ListAdapter extends BaseAdapter {
    private Unbinder unbinder;
    private ViewHolder holder;
    private List<ListPositionModel> models;
    private static final String TAG = ListAdapter.class.getSimpleName();
    private MainActivity act;

    public ListAdapter(MainActivity act, List<ListPositionModel> models) {
        this.act = act;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = act.getLayoutInflater();
        convertView = inflater.inflate(R.layout.list_layout_first, null, true);
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
        holder = (ViewHolder) convertView.getTag();
        holder.aboutPhoto.setText(models.get(position).getPhotoDescription());
        int imageResource = act.getResources().getIdentifier(models.get(position).getPhotoLinks()[0]
                , null, act.getPackageName());
        Picasso.with(act).load(imageResource).resize(getDisplayWidth(), 0).into(holder.mainImage);

        if (models.get(position).getPhotoLinks().length > 1) {
            View im = convertView.findViewById(R.id.list_ask_icon);
            if (im != null) {

                ((ViewGroup) im.getParent()).removeView(im);
            }
            int image = act.getResources().getIdentifier(models.get(position).getPhotoLinks()[1]
                    , null, act.getPackageName());
            Picasso.with(act).load(image).resize(getDisplayWidth(), 0).into(holder.secondImage);
            holder.buttonRestore.setBackground(act.getResources().getDrawable(R.drawable.button_restore_grey));
            holder.capture.setTextSize(20);
            holder.capture.setTypeface(null, Typeface.BOLD);
            holder.capture.setTextColor(act.getResources().getColor(R.color.colorBlack));
        }
        holder.capture.setText(models.get(position).getHead());
        holder.photoDescription.setText(models.get(position).getPhotoDescription());
        holder.photoTime.setText(models.get(position).getPhotoTime());
        holder.photoLocal.setText(models.get(position).getPhotoLocal());
        holder.aboutPhoto.setText(models.get(position).getBody());
        holder.photoName.setText(models.get(position).getPhotoCaption());

        return convertView;
    }

    public void unbindButterKnife() {
        if (unbinder != null) unbinder.unbind();
    }

    class ViewHolder {
        @BindView(R.id.list_image_fr)
        ImageView mainImage;
        @BindView(R.id.list_image_caption_fr)
        TextView photoName;
        @BindView(R.id.list_image_time_fr)
        TextView photoTime;
        @BindView(R.id.list_image_description_fr)
        TextView photoDescription;
        @BindView(R.id.list_local_name_fr)
        TextView photoLocal;
        @BindView(R.id.list_second_image_fr)
        ImageView secondImage;
        @BindView(R.id.list_local_icon)
        ImageView localImage;
        @BindView(R.id.list_description_name_fr)
        TextView capture;
        @BindView(R.id.list_body_text_fr)
        TextView aboutPhoto;
        @BindView(R.id.list_button_more_fr)
        Button buttonMore;
        @BindView(R.id.list_button_restore_fr)
        Button buttonRestore;

        public ViewHolder(View itemView) {
            unbinder = ButterKnife.bind(this, itemView);
        }
    }

    private int getDisplayWidth() {
        WindowManager windowManager = (WindowManager) act.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = windowManager.getDefaultDisplay().getWidth();
        return screenWidth;
    }

}
