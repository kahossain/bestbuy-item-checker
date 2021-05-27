package com.zahidhossain;

public class Product {

    private String sku;
    private boolean onlineAvailability;
    private String condition;
    private String name;
    private String url;
    private String addToCartUrl;

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean isOnlineAvailability() {
        return onlineAvailability;
    }

    public void setOnlineAvailability(boolean onlineAvailability) {
        this.onlineAvailability = onlineAvailability;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("Product [sku=");
        builder.append(sku);
        builder.append(", onlineAvailability=");
        builder.append(onlineAvailability);
        builder.append(", condition=");
        builder.append(condition);
        builder.append(", name=");
        builder.append(name);
        builder.append(", url=");
        builder.append(url);
        builder.append("]");
        return builder.toString();
    }

}
