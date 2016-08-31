package com.mtmi.listview;


public class listeSinif {
    private String simge;
    private String isimsoyisim;
    public listeSinif(String resim,String isim){
        super();
        this.simge=resim;
        this.isimsoyisim=isim;
    }
    public String getIsım(){
        return isimsoyisim;
    }
    public String getSimge(){
        return simge;
    }

}
