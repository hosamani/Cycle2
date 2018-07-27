package com.example.sony.cycle2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    Context context;
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList =wordList;
        this.context=context;
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView1;
        public final TextView wordItemView2;
        public final TextView wordItemView3;

        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView1 = (TextView) itemView.findViewById(R.id.textView);
            wordItemView2 = (TextView) itemView.findViewById(R.id.textView3);
            wordItemView3 = (TextView) itemView.findViewById(R.id.textView11);


            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, " Clicked! " + element);
            mAdapter.notifyDataSetChanged();
            Intent intent1=new Intent(context,Main2Activity.class);
            Intent intent2=new Intent(context,Main3Activity.class);

            context.startActivity(intent1);
            context.startActivity(intent2);
            Intent intent3=new Intent(context,Main4Activity.class);

            context.startActivity(intent3);
        }
    }
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView1.setText(mCurrent);
        holder.wordItemView2.setText(mCurrent);
        holder.wordItemView3.setText(mCurrent);


    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
