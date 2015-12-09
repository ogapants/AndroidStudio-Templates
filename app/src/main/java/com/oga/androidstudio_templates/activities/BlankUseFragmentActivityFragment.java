package com.oga.androidstudio_templates.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oga.androidstudio_templates.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class BlankUseFragmentActivityFragment extends Fragment {

    public BlankUseFragmentActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank_use_fragment, container, false);
    }
}
