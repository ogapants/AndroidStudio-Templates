package com.oga.androidstudio_templates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oga.androidstudio_templates.activities.BlankActivity;
import com.oga.androidstudio_templates.activities.BlankActivityWithFragment;
import com.oga.androidstudio_templates.activities.FullscreenActivity;
import com.oga.androidstudio_templates.activities.LoginActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Item> items = new ArrayList<>();
        items.add(new Item(BlankActivity.class.getSimpleName(),
                new Intent(getApplicationContext(), BlankActivity.class)));
        items.add(new Item(BlankActivityWithFragment.class.getSimpleName(),
                new Intent(getApplicationContext(), BlankActivityWithFragment.class)));
        items.add(new Item(FullscreenActivity.class.getSimpleName(),
                new Intent(getApplicationContext(), FullscreenActivity.class)));
        items.add(new Item(LoginActivity.class.getSimpleName(),
                new Intent(getApplicationContext(), LoginActivity.class)));
        items.add(new Item("BlankFragment",
                FragmentContainerActivity.createIntent(getApplicationContext(), FragmentContainerActivity.Fragments.BLANK)));
        items.add(new Item("ItemFragment",
                FragmentContainerActivity.createIntent(getApplicationContext(), FragmentContainerActivity.Fragments.ITEM)));
        items.add(new Item("PlusOneFragment",
                FragmentContainerActivity.createIntent(getApplicationContext(), FragmentContainerActivity.Fragments.PLUS)));

        final List<String> list = new ArrayList<>();
        for (Item item : items) {
            list.add(item.name);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(items.get(position).intent);
            }
        });
    }

    private class Item {
        private String name;
        private Intent intent;

        public Item(String name, Intent intent) {
            this.name = name;
            this.intent = intent;
        }
    }
}
