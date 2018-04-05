package com.fluffy.sam.phonebook;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mister_Brown on 12/27/2016.
 */

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.itemViewHolder> implements Filterable {
        private Context context ;
        private List<Contact> rowItem;
        private List<Contact> listFiltered;
        private RowListener rowListener;
        
        

    public RowAdapter(Context context, ArrayList<Contact> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
        listFiltered = rowItem;
    }

    public void setOnClick(RowListener rowListener){
        this.rowListener = rowListener;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if(viewType ==0 ){
            view = inflater.inflate(R.layout.feature_row,parent,false);
        }
        else{
            view = inflater.inflate(R.layout.feature_row1,parent,false);
        }


        itemViewHolder viewHolder = new itemViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {

        final int itemType = getItemViewType(position);
        if (itemType == 0) {
            holder.engname.setText(listFiltered.get(position).engname);
            holder.khname.setText(listFiltered.get(position).khname);
            holder.phone.setText(listFiltered.get(position).phone);

            Uri uri = Uri.parse("android.resource://"+context.getPackageName()+"/drawable/"+listFiltered.get(position).image);
            try{
                holder.logo.setImageURI(uri);

            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            holder.txtNameRow1.setText(listFiltered.get(position).engname+"--"+rowItem.get(position).type );

            Uri uri = Uri.parse("android.resource://"+context.getPackageName()+"/drawable/"+listFiltered.get(position).image);
            try{
                holder.logo.setImageURI(uri);

            }catch (Exception e){
                e.printStackTrace();
            }

        }




    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().toLowerCase();
                if (charString.isEmpty()) {
                     listFiltered= rowItem;
                } else {
                    List<Contact> filteredList = new ArrayList<>();
                    for(int i =0;i<rowItem.size();i++){
                        if (rowItem.get(i).engname.toLowerCase().contains(charString)){

                            filteredList.add(rowItem.get(i));
                            Log.d("professor",rowItem.get(i).engname);

                        }
                    }
                    listFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listFiltered = (ArrayList<Contact>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class itemViewHolder extends RecyclerView.ViewHolder{
        public ImageView logo;
        public TextView engname;
        public TextView phone;
        public TextView khname;
        public TextView txtNameRow1;

        public itemViewHolder(final View itemView) {
            super(itemView);
            engname = (TextView)itemView.findViewById(R.id.engname);
            khname = (TextView)itemView.findViewById(R.id.khname);
            phone = (TextView)itemView.findViewById(R.id.phone);
            logo = (ImageView) itemView.findViewById(R.id.rowImage);

            txtNameRow1= (TextView)itemView.findViewById(R.id.rowName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(listFiltered != null){
                        rowListener.onRowClick(listFiltered.get(getAdapterPosition()));
                    }else{
                        rowListener.onRowClick(rowItem.get(getAdapterPosition()));
                    }

                    Log.d("rowClick",listFiltered.size() +"--"+rowItem.size());
                }
            });
        }
        
        
        
    }

    @Override
    public int getItemViewType(int position) {
        if (rowItem.get(position).type!=null){
            return 1;
        }
        else{
            return 0;
        }

    }
    
    
    
}

