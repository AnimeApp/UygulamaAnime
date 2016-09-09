package com.mtmi.listview;


public class listeSinif {
    private String simge;
    private String isimsoyisim;
    private String gosterimTarhi;
    private String filmID;
    private String tur;
    public listeSinif(String resim,String isim,String gosterimTarhi,String id,String ftur){
        super();
        this.simge=resim;
        this.isimsoyisim=isim;
        this.gosterimTarhi=gosterimTarhi;
        this.filmID=id;
        this.tur=ftur;
    }
    public String getTur(){return tur;}
    public String getFilmID(){return filmID;}
    public String getIsım(){
        return isimsoyisim;
    }
    public String getSimge(){
        return simge;
    }
    public String getGosterimTarhi(){ return gosterimTarhi; }

}
