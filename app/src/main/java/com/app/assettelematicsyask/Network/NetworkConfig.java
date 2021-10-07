package com.app.assettelematicsyask.Network;

public class NetworkConfig {

    private static String _ENV  = "DEV"; // DEV / PRODUCTION

    public static String GET_BASE_URL(){
        if(_ENV.equals("PRODUCTION"))
            return _BASE_URL_PROD;
        else
            return _BASE_URL_DEV;
    }

    //Production Url
    public static String _BASE_URL_PROD="http://34.70.239.163/jhsmobileapi/mobile/configure/v1/";
    //Development Url
    public static String _BASE_URL_DEV="http://34.70.239.163/jhsmobileapi/mobile/configure/v1/";



}
