package com.example.root.rk1;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumberFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.number_view);

        if (getArguments() != null) {
            int num = Integer.valueOf(getArguments().getString(getContext().getString(R.string.number)));
            textView.setText(String.valueOf(num));

            int clr = Color.BLACK;
            if (Integer.valueOf(num) % 2 == 0) {
                clr = Color.CYAN;
            }
            textView.setTextColor(clr);
        }

    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.number_fragment, container, false);
    }

}