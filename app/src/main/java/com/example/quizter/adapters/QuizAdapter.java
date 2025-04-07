package com.example.quizter.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizter.R;
import com.example.quizter.models.Quiz;
import com.example.quizter.utils.ColorPicker;
import com.example.quizter.utils.IconPicker;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder>{
    private ArrayList<Quiz> data;
    private Context context;

    public QuizAdapter(Context context,ArrayList<Quiz> quiz){
        this.data = quiz;
        this.context = context;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quiz_item,parent,false);

        return new QuizViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder( QuizAdapter.QuizViewHolder holder, int position) {
        String title = data.get(position).title;
        holder.text_title.setText(title);
        holder.card.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()));
        holder.image_quiz.setImageResource(IconPicker.getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+data.get(position).title,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder{
        TextView text_title;
        ImageView image_quiz;
        CardView card;
        public QuizViewHolder( View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.quiz_text);
            image_quiz = itemView.findViewById(R.id.quiz_image);
            card = itemView.findViewById(R.id.quiz_list);
        }
    }
}

