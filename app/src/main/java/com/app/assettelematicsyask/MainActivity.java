package com.app.assettelematicsyask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.app.assettelematicsyask.Listener.AppListener;
import com.app.assettelematicsyask.Models.FuelType;
import com.app.assettelematicsyask.Models.ManufactureYear;
import com.app.assettelematicsyask.Models.Request;
import com.app.assettelematicsyask.Models.Response;
import com.app.assettelematicsyask.Models.VehicleCapacity;
import com.app.assettelematicsyask.Models.VehicleMake;
import com.app.assettelematicsyask.Network.ApiController;
import com.app.assettelematicsyask.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static ActivityMainBinding binding;
    private ApiController apiController;
    String[] name = {"Grand Vitara"};

    private List<VehicleMake> makeList;
    private List<ManufactureYear> manufactureYearList;
    private List<FuelType> fuelTypeList;
    private List<VehicleCapacity> vehicleCapacityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        apiController = new ApiController(this);

        Request request = new Request();
        request.setClientid(11);
        request.setEnterpriseCode(1007);
        request.setMno("9889897789");
        request.setPasscode(3476);
        getAllData(request);

//        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brand);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        binding.spinner1.setAdapter(aa);
//
        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, name);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner2.setAdapter(aa1);
//
//        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, year);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        binding.spinner3.setAdapter(aa2);
//
//
//        ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, flue);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        binding.spinner4.setAdapter(aa3);
//
//
//        ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, no);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        binding.spinner5.setAdapter(aa4);

        binding.qrScanner.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ScannerViewActivity.class));
        });
    }



    private void getAllData(Request request){
        apiController.getAllData(request, new AppListener.OnDataListener() {
            @Override
            public void onSuccess(Response response) {
                if (response.getStatus() == 200){
                    binding.rvVehicleDetails.setHasFixedSize(true);
                    binding.rvVehicleDetails.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
                    VehicleAdapter vehicleAdapter = new VehicleAdapter(MainActivity.this,response.getVehicleType());
                    binding.rvVehicleDetails.setAdapter(vehicleAdapter);
                    Toast.makeText(MainActivity.this,response.getMessage(),Toast.LENGTH_LONG).show();

                    //VehicleMake
                    makeList = response.getVehicleMake();
                    VehicleMake responseData = new VehicleMake();
                    responseData.setText("Select VehicleMake");
                    responseData.setValue(-1);
                    makeList.add(0,responseData);
                    List<String> catList = new ArrayList<>();
                    for (int i = 0; i <makeList.size() ; i++) {
                        catList.add(makeList.get(i).getText());

                    }
                    ArrayAdapter<String> adapter;
                    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, catList);
                    binding.spinner1.setAdapter(adapter);


                    //ManufactureYear
                    manufactureYearList = response.getManufactureYear();
                    ManufactureYear responseData1 = new ManufactureYear();
                    responseData1.setText("Select ManufactureYear");
                    responseData1.setValue(-1);
                    manufactureYearList.add(0,responseData1);
                    List<String> catList1 = new ArrayList<>();
                    for (int i = 0; i <manufactureYearList.size() ; i++) {
                        catList1.add(manufactureYearList.get(i).getText());

                    }
                    ArrayAdapter<String> adapter1;
                    adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, catList1);
                    binding.spinner3.setAdapter(adapter1);


                    //FuelType
                    fuelTypeList = response.getFuelType();
                    FuelType responseData2 = new FuelType();
                    responseData2.setText("Select FuelType");
                    responseData2.setValue(-1);
                    fuelTypeList.add(0,responseData2);
                    List<String> catList2 = new ArrayList<>();
                    for (int i = 0; i <fuelTypeList.size() ; i++) {
                        catList2.add(fuelTypeList.get(i).getText());

                    }
                    ArrayAdapter<String> adapter2;
                    adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, catList2);
                    binding.spinner4.setAdapter(adapter2);


                    //VehicleCapacity
                    vehicleCapacityList = response.getVehicleCapacity();
                    VehicleCapacity responseData3 = new VehicleCapacity();
                    responseData3.setText("Select VehicleCapacity");
                    responseData3.setValue(-1);
                    vehicleCapacityList.add(0,responseData3);
                    List<String> catList3 = new ArrayList<>();
                    for (int i = 0; i <vehicleCapacityList.size() ; i++) {
                        catList3.add(vehicleCapacityList.get(i).getText());

                    }
                    ArrayAdapter<String> adapter3;
                    adapter3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, catList3);
                    binding.spinner5.setAdapter(adapter3);

                }else {

                }
            }

            @Override
            public void onFailure(String message) {
                Log.d("svdjvsd", "onFailure: "+message);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }


}