package com.mtmi.listview;


public class listeSinif {
    private String simge;
    private String isimsoyisim;
    private int gosterimTarhi;
    public listeSinif(String resim,String isim,int gosterimTarhi){
        super();
        this.simge=resim;
        this.isimsoyisim=isim;
        this.gosterimTarhi=gosterimTarhi;
    }
    public String getIsım(){
        return isimsoyisim;
    }
    public String getSimge(){
        return simge;
    }
    public int getGosterimTarhi(){ return gosterimTarhi; }

}
