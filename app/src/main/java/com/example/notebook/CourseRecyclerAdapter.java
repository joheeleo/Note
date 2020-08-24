package com.example.notebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.VeiwHolder> {

    private final Context mContext;
    private final List<CourseInfo> mCourses;
    private final LayoutInflater mLayoutInflater;

    public CourseRecyclerAdapter(Context context, List<CourseInfo> courses) {
        mContext = context;
        mCourses = courses;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_course_list, parent, false);

        return new VeiwHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VeiwHolder holder, int position) {
        CourseInfo course = mCourses.get(position);
        holder.mTextCourse.setText(course.getTitle());
        holder.mCurrentPositon = position;
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class VeiwHolder extends RecyclerView.ViewHolder{

        public final TextView mTextCourse;
        public int mCurrentPositon;

        public VeiwHolder(@NonNull View itemView) {
            super(itemView);
            mTextCourse = (TextView) itemView.findViewById(R.id.text_course);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, mCourses.get(mCurrentPositon).getTitle(),
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }
}
