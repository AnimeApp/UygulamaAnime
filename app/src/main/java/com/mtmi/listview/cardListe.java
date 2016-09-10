package com.mtmi.listview;


public class cardListe {
    private String simge;
    private String isimsoyisim;
    private String tur;
    public cardListe(String resim,String isim,String ftur){
        super();
        this.simge=resim;
        this.isimsoyisim=isim;
        this.tur=ftur;
    }
    public String getTur(){return tur;}
    public String getIsım(){
        return isimsoyisim;
    }
    public String getSimge(){
        return simge;
    }

}
