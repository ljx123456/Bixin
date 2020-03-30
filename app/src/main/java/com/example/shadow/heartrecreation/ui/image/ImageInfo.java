package com.example.shadow.heartrecreation.ui.image;

public class ImageInfo {
    private String imageUrl;
    private Boolean isAddButton;
    private int imageId;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getAddButton() {
        return isAddButton;
    }

    public void setAddButton(Boolean addButton) {
        isAddButton = addButton;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public ImageInfo(String imageUrl, Boolean isAddButton, int imageId) {
        this.imageUrl = imageUrl;
        this.isAddButton = isAddButton;
        this.imageId = imageId;
    }

    public ImageInfo() {
    }
}
