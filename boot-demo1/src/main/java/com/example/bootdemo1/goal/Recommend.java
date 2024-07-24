package com.example.bootdemo1.goal;

public class Recommend {
    private int ID;
    private String Image;
    private String Desc;
    private float Price;
    private int SaleNumber;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }


    public int getSaleNumber() {
        return SaleNumber;
    }

    public void setSaleNumber(int SaleNumber) {
        this.SaleNumber = SaleNumber;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }


}
