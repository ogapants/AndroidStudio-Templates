package com.oga.androidstudio_templates;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.oga.androidstudio_templates.fragments.BlankFragment;
import com.oga.androidstudio_templates.fragments.ItemFragment;
import com.oga.androidstudio_templates.fragments.PlusOneFragment;


public class FragmentContainerActivity extends AppCompatActivity implements
        BlankFragment.OnFragmentInteractionListener,
        ItemFragment.OnFragmentInteractionListener,
        PlusOneFragment.OnFragmentInteractionListener {


    public static final String INTENT_KEY_TYPE = "frag";

    public static Intent createIntent(Context c, Fragments type) {
        Intent intent = new Intent(c, FragmentContainerActivity.class);
        intent.putExtra(INTENT_KEY_TYPE, type);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        if (savedInstanceState == null) {
            Fragment fragment;
            switch ((Fragments) getIntent().getSerializableExtra(INTENT_KEY_TYPE)) {
                case BLANK:
                    fragment = BlankFragment.newInstance("str1", "str2");
                    break;
                case ITEM:
                    fragment = ItemFragment.newInstance("str1", "str2");
                    break;
                case PLUS:
                    fragment = PlusOneFragment.newInstance("str1", "str2");
                    break;
                default:
                    return;
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    enum Fragments {
        BLANK, ITEM, PLUS;
    }
}
