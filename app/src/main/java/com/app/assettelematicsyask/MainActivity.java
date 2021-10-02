package com.app.assettelematicsyask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.app.assettelematicsyask.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static ActivityMainBinding binding;
    private List<VehicleTypeModel> vehicleTypeModelList;
    String[] brand = {"Maruti Suzuki", "Honda"};
    String[] name = {"Grand Vitara"};
    String[] year = {"2010"};
    String[] flue = {"Petrol"};
    String[] no = {"0-5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        getData();
        initRecyclerView();

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brand);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner1.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner2.setAdapter(aa1);

        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, year);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner3.setAdapter(aa2);


        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, flue);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner4.setAdapter(aa3);


        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, no);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner5.setAdapter(aa4);

        binding.qrScanner.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ScannerViewActivity.class));
        });
    }
    private void initRecyclerView(){
        binding.rvVehicleDetails.setHasFixedSize(true);
        binding.rvVehicleDetails.setLayoutManager(new GridLayoutManager(this,3));
        VehicleAdapter vehicleAdapter = new VehicleAdapter(this,vehicleTypeModelList);
        binding.rvVehicleDetails.setAdapter(vehicleAdapter);
    }

    private void getData(){
        vehicleTypeModelList = new ArrayList<>();
        vehicleTypeModelList.add(new VehicleTypeModel(R.drawable.android_picture,"Truck"));
        vehicleTypeModelList.add(new VehicleTypeModel(R.drawable.android_picture,"Semi Truck"));
        vehicleTypeModelList.add(new VehicleTypeModel(R.drawable.android_picture,"Dump Truck"));
    }


}