package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by My on 2017/3/25.
 */

public class City extends DataSupport{
    public int id;
    public int cityCode;
    public String cityName;
    public int provinceId;
}
