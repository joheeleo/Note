package com.example.notebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.VeiwHolder> {

    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        mContext = context;
        mNotes = notes;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_note_list, parent, false);

        return new VeiwHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VeiwHolder holder, int position) {
        NoteInfo note = mNotes.get(position);
        holder.mTextCourse.setText(note.getCourse().getTitle());
        holder.mTextTitle.setText(note.getTitle());
        holder.mCurrentPositon = position;
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class VeiwHolder extends RecyclerView.ViewHolder{

        public final TextView mTextCourse;
        public final TextView mTextTitle;
        public int mCurrentPositon;

        public VeiwHolder(@NonNull View itemView) {
            super(itemView);
            mTextCourse = (TextView) itemView.findViewById(R.id.text_course);
            mTextTitle = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_POSITION, mCurrentPositon);
                    mContext.startActivity(intent);

                }
            });
        }
    }
}
