package org.baltimorecityschools.restaurantappproject;

public class MenuItem {
    private String name;
    private String size;
    private String crust;
    private int quantity;

    public MenuItem(String name, String size, String crust, int quantity) {
        this.name = name;
        this.size = size;
        this.crust = crust;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        double basePrice = 8.00;
        double sizePrice = 0.00;
        if ("Medium".equalsIgnoreCase(size)) {
            sizePrice = 2.00;
        } else if ("Large".equalsIgnoreCase(size)) {
            sizePrice = 4.00;
        }

        double crustPrice = 0.00;
        if ("Stuffed".equalsIgnoreCase(crust)) {
            crustPrice = 1.50;
        }

        return (basePrice + sizePrice + crustPrice) * quantity;
    }
}
