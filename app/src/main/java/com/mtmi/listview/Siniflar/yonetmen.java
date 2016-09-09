package com.mtmi.listview.Siniflar;


import java.util.HashMap;
import java.util.Map;

public class yonetmen {
    private String YonetmenAD;
/*izinleri değiş */
    public String getYonetmenAd(){
        return YonetmenAD;
    }
    public void setYonetmenAd(String ad){
        this.YonetmenAD=ad;
    }
    public Map<String,Object> harita(){
        Map<String,Object> dizi = new HashMap<>();
        dizi.put("YonetmenAd",this.YonetmenAD);
        return  dizi;
    }
}
