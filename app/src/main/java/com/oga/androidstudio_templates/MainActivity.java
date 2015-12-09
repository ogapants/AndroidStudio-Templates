package com.oga.androidstudio_templates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oga.androidstudio_templates.activities.BlankActivity;
import com.oga.androidstudio_templates.activities.BlankUseFragmentActivity;
import com.oga.androidstudio_templates.activities.EmptyActivity;
import com.oga.androidstudio_templates.activities.NavigationDrawerActivity;
import com.oga.androidstudio_templates.activities.TabbedSwipeActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Class<? extends AppCompatActivity>> classes = Arrays.asList(
            EmptyActivity.class,
            BlankActivity.class,
            BlankUseFragmentActivity.class,
            NavigationDrawerActivity.class,
            TabbedSwipeActivity.class
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();
        for (Class<? extends Activity> aClass : classes) {
            list.add(aClass.getSimpleName() + ".java");
        }

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, classes.get(position)));
            }
        });
    }
}
