package com.hb4u.myhealthmanagerver01_beta.classes;


import android.icu.text.DecimalFormat;

public class Users {
    private int userId;
    private String userName;
    private String firstName;
    private String secondName;
    private String lastName;
    private transient DecimalFormat weight;
    private transient DecimalFormat totalSugar;

    //region Constructors
    public Users(String userName, String firstName, String secondName,
                 String lastName, DecimalFormat weight, DecimalFormat totalSugar){
        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setLastName(lastName);
        this.setWeight(weight);
        this.setTotalSugar(totalSugar);
    }
    //endregion

    //region Get Set
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DecimalFormat getWeight() {
        return weight;
    }

    public void setWeight(DecimalFormat weight) {
        this.weight = weight;
    }

    public DecimalFormat getTotalSugar() {
        return totalSugar;
    }

    public void setTotalSugar(DecimalFormat totalSugar) {
        this.totalSugar = totalSugar;
    }
    //endregion
}
