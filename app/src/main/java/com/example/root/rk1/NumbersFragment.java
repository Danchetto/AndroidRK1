package com.example.root.rk1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NumbersFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        int columns = 3;
        List<Item> items = buildItemList();
        NumberGridAdapter adapter = new NumberGridAdapter(items);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), columns);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.numbers_fragment, container, false);
    }

    private List<Item> buildItemList() {
        List<Item> items = new ArrayList<>();
        for (Integer i = 0; i < 1000; i++) {
            items.add(new Item(i.toString()));
        }
        return items;
    }
}
