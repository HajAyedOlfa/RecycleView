package com.example.recycleview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    String data1[], data2[];
    int images[];
    Context context ;

    public MyAdapter(Context context,String[] data1, String[] data2, int[] images  ) {
        this.data1 = data1;
        this.data2 = data2;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context) ;
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.imageView.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("myImage", images[position]);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView myText1,myText2 ;
        ImageView imageView ;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.textView1);
            myText2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.image);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}