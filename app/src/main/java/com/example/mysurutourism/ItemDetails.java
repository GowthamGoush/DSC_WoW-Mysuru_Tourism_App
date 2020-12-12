package com.example.mysurutourism;

public class ItemDetails {

    private String itemName;
    private String itemImage;
    private String itemUrl;

    public ItemDetails(String itemName, String itemImage, String itemUrl) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemUrl = itemUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
