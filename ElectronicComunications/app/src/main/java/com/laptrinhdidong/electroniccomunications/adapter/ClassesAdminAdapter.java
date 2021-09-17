package com.laptrinhdidong.electroniccomunications.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.laptrinhdidong.electroniccomunications.R;
import com.laptrinhdidong.electroniccomunications.model.Classes;
import com.laptrinhdidong.electroniccomunications.model.Teacher;

import java.util.ArrayList;
import java.util.List;


public class ClassesAdminAdapter extends RecyclerView.Adapter<ClassesAdminAdapter.MyViewHolder> {

    Context context;
    ArrayList<Classes> newClasses;
    private OnLongClick onLongClick;

    public ClassesAdminAdapter(Context context, ArrayList<Classes> newClasses, OnLongClick onLongClick) {
        this.context = context;
        this.newClasses = newClasses;
        this.onLongClick = onLongClick;
    }

    public interface OnLongClick {
        void showDialogUpdateDelete(Classes newClass);
    }

    public void setData (ArrayList<Classes> mListClasses) {
        newClasses = mListClasses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.class_admin_itemview, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Classes newClass = newClasses.get(position);

        holder.myText1.setText(Integer.toString(newClass.getClassID()));
        holder.myText2.setText(newClass.getClassName());
        holder.myText3.setText(Integer.toString(newClass.getNos()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClick.showDialogUpdateDelete(newClass);
                return true;
            }
        });

    }

    @Override
    public int getItemCount()
    {
        if (newClasses != null) {
            return newClasses.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2, myText3;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.txtClassNo);
            myText2 = itemView.findViewById(R.id.txtClassName);
            myText3 = itemView.findViewById(R.id.txtClassNoS);

        }
    }

}
