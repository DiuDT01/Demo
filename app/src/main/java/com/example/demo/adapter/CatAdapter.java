package com.example.demo.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private List<Cat> mList;
    private CatItemListener itemListener;

    public CatAdapter() {
        mList = new ArrayList<>();

    }

    public void setItemListener(CatItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public Cat getItem(int position) {
        return mList.get(position);
    }

    public List<Cat> getListCat() {
        return mList;
    }
    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {

        Cat cat = mList.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice() + "");
        holder.infor.setText(cat.getInfor());
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan xoa " + cat.getName() + "nay khong?");
                builder.setIcon(R.drawable.remove);
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mList.remove(position);
                        notifyDataSetChanged();// lam tuoi
                    }
                });
                builder.setNegativeButton("khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView name, price, infor;
        Button btRemove;


        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.item_img);
            name = itemView.findViewById(R.id.editName);
            price = itemView.findViewById(R.id.editPrice);
            infor = itemView.findViewById(R.id.editDesc);
            btRemove = itemView.findViewById(R.id.item_btRemove);
            btRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemListener != null) {
                itemListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    //tao interface de sua xoa
    public interface CatItemListener {
        void onItemClick(View view, int position);
    }

    public void add(Cat cat) {
        mList.add(cat);
        notifyDataSetChanged();
    }

    public void update(int position, Cat cat) {
        mList.set(position, cat);
        notifyDataSetChanged();
    }
}

