package com.app.assettelematicsyask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.assettelematicsyask.databinding.VehicleTypeRowBinding;
import com.bumptech.glide.Glide;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {
    private Context context;
    private List<VehicleTypeModel> vehicleTypeModelList;
    private LayoutInflater layoutInflater;

    public VehicleAdapter(Context context,List<VehicleTypeModel> vehicleTypeModelList) {
        this.context = context;
        this.vehicleTypeModelList = vehicleTypeModelList;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VehicleTypeRowBinding binding;
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.vehicle_type_row,parent,false);
        return new VehicleAdapter.VehicleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        VehicleTypeModel data = vehicleTypeModelList.get(position);
        Glide.with(context).load(data.getImage()).into(holder.binding.ivImage);
        holder.binding.tvName.setText(data.getName());

    }

    @Override
    public int getItemCount() {
        return vehicleTypeModelList.size();
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {
        VehicleTypeRowBinding binding;
        public VehicleViewHolder(@NonNull VehicleTypeRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
