package com.example.shadow.heartrecreation.ui.main.adapter;

import java.util.List;

public class ExpListBean {

    private String name;
    private String id;
    private List<DrinkBean> drink;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DrinkBean> getDrink() {
        return drink;
    }

    public void setDrink(List<DrinkBean> drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "ExpListBean{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", drink=" + drink +
                '}';
    }

    public static class DrinkBean {
        /**
         * drinkID : 3
         * drinkImage : http://china.qudao.com/upload/article/20140902/36982754171409641596.jpg
         * drinkMoney : 500.0
         * drinkName : 啤酒
         * drinkNum : 5
         * drinkText :
         * id : 2
         * mealId : 3
         * mealName : 啤酒
         */

        private String drinkID;
        private String drinkImage;
        private String drinkMoney;
        private String drinkName;
        private String drinkNum;
        private String drinkText;
        private Long id;
        private String mealId;
        private String mealName;

        public String getDrinkID() {
            return drinkID;
        }

        public void setDrinkID(String drinkID) {
            this.drinkID = drinkID;
        }

        public String getDrinkImage() {
            return drinkImage;
        }

        public void setDrinkImage(String drinkImage) {
            this.drinkImage = drinkImage;
        }

        public String getDrinkMoney() {
            return drinkMoney;
        }

        public void setDrinkMoney(String drinkMoney) {
            this.drinkMoney = drinkMoney;
        }

        public String getDrinkName() {
            return drinkName;
        }

        public void setDrinkName(String drinkName) {
            this.drinkName = drinkName;
        }

        public String getDrinkNum() {
            return drinkNum;
        }

        public void setDrinkNum(String drinkNum) {
            this.drinkNum = drinkNum;
        }

        public String getDrinkText() {
            return drinkText;
        }

        public void setDrinkText(String drinkText) {
            this.drinkText = drinkText;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMealId() {
            return mealId;
        }

        public void setMealId(String mealId) {
            this.mealId = mealId;
        }

        public String getMealName() {
            return mealName;
        }

        public void setMealName(String mealName) {
            this.mealName = mealName;
        }

        @Override
        public String toString() {
            return "DrinkBean{" +
                    "drinkID='" + drinkID + '\'' +
                    ", drinkImage='" + drinkImage + '\'' +
                    ", drinkMoney='" + drinkMoney + '\'' +
                    ", drinkName='" + drinkName + '\'' +
                    ", drinkNum='" + drinkNum + '\'' +
                    ", drinkText='" + drinkText + '\'' +
                    ", id=" + id +
                    ", mealId='" + mealId + '\'' +
                    ", mealName='" + mealName + '\'' +
                    '}';
        }
    }
}
