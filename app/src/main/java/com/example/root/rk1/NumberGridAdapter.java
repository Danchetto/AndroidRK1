package com.example.root.rk1;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class NumberGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

//    private static final int ITEM_CARD = R.layout.item;

    private List<Item> items;

    NumberGridAdapter(List<Item> itemList) {
        items = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View cardView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CardViewHolder(cardView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);
        CardViewHolder cardHolder = ((CardViewHolder) holder);
        String number = item.getTitle();
        cardHolder.number.setText(number);

        int clr = Color.BLACK;
        if (Integer.valueOf(number) % 2 == 0) {
            clr = Color.CYAN;
        }
        cardHolder.number.setTextColor(clr);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView number;

        CardViewHolder(final View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            number = itemView.findViewById(R.id.text);

            cardView.setOnClickListener(new ClickListener(this));
        }
    }

    class ClickListener implements View.OnClickListener {
        CardViewHolder holder;

        ClickListener(CardViewHolder holder) {
            this.holder = holder;
        }

        @Override
        public void onClick(View v) {
            int position = holder.getLayoutPosition();
            if (position != RecyclerView.NO_POSITION) {
                Item item = items.get(position);

                FragmentManager manager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = new NumberFragment();

                Bundle bundle = new Bundle();
                bundle.putString(v.getContext().getString(R.string.number), item.getTitle());
                fragment.setArguments(bundle);

                transaction.replace(R.id.numbers_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }

        }
    }
}
