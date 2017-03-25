package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**County
 * Created by My on 2017/3/25.
 */

public class County extends DataSupport{
    public int id;
    public String countyName;
    public String weatherId;
    public int cityId;
}
