package com.example.coolweather.gson;

/**
 * Created by My on 2017/3/26.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
