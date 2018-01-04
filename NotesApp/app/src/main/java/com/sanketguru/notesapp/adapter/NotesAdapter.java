package com.sanketguru.notesapp.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanketguru.notesapp.R;
import com.sanketguru.notesapp.models.MemberDiffUtilCallback;
import com.sanketguru.notesapp.models.TextNote;

import java.util.List;

/**
 * Created by Bhavesh on 04-01-2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<TextNote> dataList;
    private int layoutResourceId = 0;
    private LayoutInflater inflater;

    public NotesAdapter(List<TextNote> dataList) {
        this.dataList = dataList;
        this.layoutResourceId = 0;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view;
        view = inflater.inflate(R.layout.list_child, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvTitle.setText(dataList.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private View mView;

        private TextView tvTitle;


        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);


        }
    }

    public void updateScrollList(List<TextNote> employees, boolean isUpdate) {
        final MemberDiffUtilCallback diffCallback = new MemberDiffUtilCallback(this.dataList, employees);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        if (!isUpdate) {
            this.dataList.clear();
        }
        this.dataList.addAll(employees);
        diffResult.dispatchUpdatesTo(this);
    }
}
