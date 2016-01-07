package com.example.fastsms.app.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fastsms.app.R;

public class ContactsFragment extends Fragment {
    private Callbacks mCallbacks;
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_for_contacts, container, false);
        floatingActionButton=(FloatingActionButton) v.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener();
        return v;

    }

    public static ContactsFragment newInstance(Bundle args) {
        ContactsFragment myFragment = new ContactsFragment();
        myFragment.setArguments(args);
        return myFragment;
    }
    private class FloatinfActionButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
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
