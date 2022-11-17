package com.esprit.bluegymproject;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.bluegymproject.entity.Produits;

import java.util.ArrayList;
import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.MyViewHolder> {

    List<Produits> produits;
    Context context;

    void setUserList(List<Produits> produits){
        this.produits=produits;
    }

    public ProduitAdapter(Context context) {
        this.produits = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.list_items_produit,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Intent intent = new Intent(context,listProduit.class);
        holder.nom.setText(produits.get(position).getName());
        holder.role.setText(produits.get(position).getDescription());
        holder.marque.setText(produits.get(position).getMarque());
        holder.price.setText(produits.get(position).getPrice());


        holder.itemView.setOnClickListener(e->{
            intent.putExtra("name",produits.get(position).getName());
            intent.putExtra("description",produits.get(position).getDescription());
            intent.putExtra("marque",produits.get(position).getMarque());
            intent.putExtra("price",produits.get(position).getPrice());

            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return produits.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nom,role,marque,price;
        //ImageView avatar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nom = itemView.findViewById(R.id.name);
            role = itemView.findViewById(R.id.description);
            marque = itemView.findViewById(R.id.marque);
            price = itemView.findViewById(R.id.price);



        }
    }
}
