package com.lilibethtorres.hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View rootView;
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ImageButton DisplayAccount  = (ImageButton) rootView.findViewById(R.id.DisplayAccountimageButton);

        DisplayAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the intent
                Intent I = new Intent(getActivity(), AccountListActivity.class);
                // Execute
                startActivity(I);

            }
        });

        // Get the AppInfo  button instance
        ImageButton AppInfo  = (ImageButton) rootView.findViewById(R.id.AppInfoimageButton);

        AppInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the intent
                Intent I = new Intent(getActivity(), AppInfoActivity.class);
                // Execute
                startActivity(I);

            }
        });

        return rootView;
    }
}
