package com.example.fastsms.app.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fastsms.app.R;

public class ContactsFragment extends Fragment {
    private Callbacks mCallbacks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_for_contacts, container, false);
        return v;

    }

    public static ContactsFragment newInstance(Bundle args) {
        ContactsFragment myFragment = new ContactsFragment();
        myFragment.setArguments(args);
        return myFragment;
    }

    //callBack Interface
    public interface Callbacks {
        void onFragmentSelected(String fragment);

        void onFragmentSelected(String fragment, Bundle args);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }
}
