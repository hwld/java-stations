package com.example.coupon;

import java.util.stream.IntStream;

import com.example.price.PriceSettings;

public class CouponB {
    public static float calculate(int[] carItems) {
        float subtotalPrice = IntStream.of(carItems).sum() * 0.9f;

        float totalPrice = subtotalPrice < PriceSettings.FREE_SHIPPING_THRESHOLD
                ? subtotalPrice + PriceSettings.SHIPPING_FEE
                : subtotalPrice;
        return totalPrice;
    }
}
