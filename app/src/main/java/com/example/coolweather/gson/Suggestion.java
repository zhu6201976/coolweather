package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by My on 2017/3/26.
 */

public class Suggestion {
    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    @SerializedName("sport")
    public Sport sport;

    /**
     * 舒适度
     */
    public class Comfort {
        @SerializedName("txt")
        public String info;
    }

    /**
     * 洗车场
     */
    public class CarWash {
        @SerializedName("txt")
        public String info;
    }

    /**
     * 运动
     */
    public class Sport {
        @SerializedName("txt")
        public String info;
    }
}
