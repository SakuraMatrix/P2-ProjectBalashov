package com.sakuramatrix.microservicesezin.domain;

public class Order {
        private int customerId ;
        private int itemId;
        private String itemName ;
        private double itemPrice ;
        private String itemCategory ;


        public Order(int customerId, int itemId, String itemName, double itemPrice, String itemCategory) {
            this.customerId = customerId;
            this.itemId = itemId;
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemCategory = itemCategory;

        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public String getItemCategory() {
            return itemCategory;
        }

        public void setItemCategory(String itemCategory) {
            this.itemCategory = itemCategory;
        }
    }


