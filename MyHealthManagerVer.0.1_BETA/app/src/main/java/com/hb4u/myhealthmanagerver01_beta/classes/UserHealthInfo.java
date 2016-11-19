package com.hb4u.myhealthmanagerver01_beta.classes;



public class UserHealthInfo {
    private String totalSugar;
    private String totalFat;
    private String totalSaturatedFat;
    private String totalSodium;

    //region Constructors
    public UserHealthInfo(String totalSugar, String totalFat, String totalSaturatedFat, String totalSodium){
        this.setTotalSugar(totalSugar);
        this.setTotalFat(totalFat);
        this.setTotalSaturatedFat(totalSaturatedFat);
        this.setTotalSodium(totalSodium);
    }
    //endregion

    //region Get Set
    public String getTotalSugar() {
        return totalSugar;
    }

    public void setTotalSugar(String totalSugar) {
        this.totalSugar = totalSugar;
    }

    public String getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(String totalFat) {
        this.totalFat = totalFat;
    }

    public String getTotalSaturatedFat() {
        return totalSaturatedFat;
    }

    public void setTotalSaturatedFat(String totalSaturatedFat) {
        this.totalSaturatedFat = totalSaturatedFat;
    }

    public String getTotalSodium() {
        return totalSodium;
    }

    public void setTotalSodium(String totalSodium) {
        this.totalSodium = totalSodium;
    }
    //endregion


}
