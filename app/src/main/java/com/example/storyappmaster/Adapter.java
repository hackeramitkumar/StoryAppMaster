package com.example.storyappmaster;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        private LayoutInflater inflater;
        private String[] sTitles;
        private String[] sContent;

 public Adapter (Context context, String[] titles, String[] contents){
    this.inflater = LayoutInflater.from(context);
    this.sTitles = titles;
    this.sContent = contents;
}



    public class ViewHolder extends  RecyclerView.ViewHolder{
    TextView storyTitle,storycontent,number;
    CardView circle;

    public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        itemView.setOnClickListener((v) -> {
            Intent i = new Intent(v.getContext(),Details.class);
            i.putExtra("title",sTitles[getAdapterPosition()]);
            i.putExtra("content",sContent[getAdapterPosition()]);
            v.getContext().startActivity(i);
        });
        storyTitle = itemView.findViewById(R.id.storyTitle);
        storycontent = itemView.findViewById(R.id.storyContent);
        number = itemView.findViewById(R.id.number);
        circle = itemView.findViewById(R.id.circle);
    }
}

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.custom_view,parent,false);
    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull Adapter.ViewHolder holder, int position) {
String title = sTitles[position];
String content = sContent[position];
holder.storyTitle.setText(title);
holder.storycontent.setText(content);
holder.number.setText(String.valueOf(title.charAt(0)));
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);



        Random r = new Random();

        int red = r.nextInt(255 - 0 + position);
        int green = r.nextInt(255 - position + 1);
        int blue = r.nextInt(255 - 0 + (position+1));
        shape.setColor(Color.rgb(red,green,blue));
        holder.circle.setBackground(shape);
    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }
}
