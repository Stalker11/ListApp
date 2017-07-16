package com.example.oleg.testmylybrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.oleg.testmylybrary.adapters.ListAdapter;
import com.example.oleg.testmylybrary.models.ListPositionModel;
import com.example.oleg.testmylybrary.util.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ListAdapter(this, createModels());
        listView.setAdapter(adapter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        if (adapter != null) {
            adapter.unbindButterKnife();
        }
        super.onStop();
    }

    private List<ListPositionModel> createModels() {
        List<ListPositionModel> models = new ArrayList<>();
        ListPositionModel model = new ListPositionModel();
        model.setPhotoDescription(AppConstants.FIRST_PHOTO_DESCRIPTION);
        model.setPhotoCaption(AppConstants.FIRST_PHOTO_CAPTION);
        model.setPhotoTime(AppConstants.FIRST_PHOTO_TIME);
        model.setBody(AppConstants.FIRST_DESCRIPTION);
        model.setPhotoLocal(AppConstants.FIRST_PHOTO_LOCATION);
        model.setHead(AppConstants.FIRST_HEAD);
        model.setBody(AppConstants.FIRST_DESCRIPTION);
        String[] links = new String[1];
        links[0] = "@drawable/city_image";
        model.setPhotoLinks(links);
        models.add(model);

        ListPositionModel secondModel = new ListPositionModel();
        secondModel.setPhotoDescription(AppConstants.SECOND_PHOTO_DESCRIPTION);
        secondModel.setPhotoCaption(AppConstants.SECOND_PHOTO_CAPTION);
        secondModel.setPhotoTime(AppConstants.SECOND_PHOTO_TIME);
        secondModel.setBody(AppConstants.SECOND_DESCRIPTION);
        secondModel.setPhotoLocal(AppConstants.SECOND_PHOTO_LOCATION);
        secondModel.setHead(AppConstants.SECOND_HEAD);
        secondModel.setBody(AppConstants.SECOND_DESCRIPTION);
        String[] links1 = new String[2];
        links1[0] = "@drawable/sec_image";
        links1[1] = "@drawable/digital_image";
        secondModel.setPhotoLinks(links1);
        models.add(secondModel);
        return models;
    }
}
