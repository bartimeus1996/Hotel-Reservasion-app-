package com.example.reservasyonjava.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button; 
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservasyonjava.DataModels.HotelDetails;
import com.example.reservasyonjava.R;
import com.example.reservasyonjava.ReservasyonActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{
    private Context context;
    private AdapterView.OnItemClickListener listener;
    private ArrayList<HotelDetails> hotelDetailsList;

    public HotelAdapter(Context context, ArrayList<HotelDetails> hotelDetailsList) {
        this.context = context;
        this.listener = listener;
        this.hotelDetailsList = hotelDetailsList;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, int position) {
        HotelDetails hotelDetailsArrayList = hotelDetailsList.get(position);
        holder.name.setText(hotelDetailsArrayList.getName());
        holder.score.setText(hotelDetailsArrayList.getReviewScoreWord());
        if(hotelDetailsArrayList.getResimUrl()!=null) {
            Picasso.get().load(hotelDetailsArrayList.getResimUrl()).fit().into(holder.resimUrl);

        }
        holder.reservasyonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReservasyonActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hotelDetailsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView score;
        ImageView resimUrl;
        Button reservasyonBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            score = itemView.findViewById(R.id.tvScore);
            resimUrl = itemView.findViewById(R.id.ivHotel);
            reservasyonBtn = itemView.findViewById(R.id.reservasyonBtn);
        }
    }
}
