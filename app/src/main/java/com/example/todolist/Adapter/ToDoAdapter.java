package com.example.todolist.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox; // Import CheckBox
import androidx.recyclerview.widget.RecyclerView;
import com.example.todolist.MainActivity;
import com.example.todolist.Model.ToDoModel;
import com.example.todolist.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoModel> todoList;
    private MainActivity activity;

    public ToDoAdapter(MainActivity activity) {
        this.activity = activity;
    }

    // Correct the method signature
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    // Correct the method signature
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
        // Correct the method name from "setChekced" to "setChecked"
        holder.task.setChecked(toBoolean(item.getStatus()));
    }

    @Override
    public int getItemCount() {
        return todoList != null ? todoList.size() : 0; // Return 0 if todoList is null
    }

    private boolean toBoolean(int n) {
        return n != 0;
    }

    public void setTasks(List<ToDoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox task; // Correct the variable name from "Checkbox" to "CheckBox"

        ViewHolder(View view) {
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }
}
