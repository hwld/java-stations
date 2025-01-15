package com.example.coupon;

import java.util.stream.IntStream;

import com.example.price.PriceSettings;

public class CouponC {
    public static float calculate(int[] carItems) {
        double subtotalPrice = IntStream.of(carItems)
                .mapToDouble(price -> price >= 2000 ? price * 0.8 : price)
                .sum();

        double totalPrice = subtotalPrice < PriceSettings.FREE_SHIPPING_THRESHOLD
                ? subtotalPrice + PriceSettings.SHIPPING_FEE
                : subtotalPrice;
        return (float) totalPrice;
    }
}
