package com.example.coolweather.util;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;
import com.example.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     *
     * @param response 中国所有省份信息(json)
     * @return 是否解析保存数据库成功
     */
    public static boolean handleProvinceResponse(String response) {
        if (!response.isEmpty()) {
            try {
                // 解析
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    // 保存到本地数据库
                    Province province = new Province();
                    province.provinceCode = provinceObject.getInt("id");
                    province.provinceName = provinceObject.getString("name");
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     *
     * @param response   省份所有市级信息(json)
     * @param provinceId 所属省份id
     * @return 是否解析保存数据库成功
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!response.isEmpty()) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.cityCode = cityObject.getInt("id");
                    city.cityName = cityObject.getString("name");
                    city.provinceId = provinceId;
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     *
     * @param response 市所有县数据(json)
     * @param cityId   所属市id
     * @return 是否解析保存数据库成功
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!response.isEmpty()) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject cityObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.countyName = cityObject.getString("name");
                    county.weatherId = cityObject.getString("weather_id");
                    county.cityId = cityId;
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析json数据成Weather对象
     *
     * @param response 待解析json数据
     * @return Weather对象
     */
    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.get(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
