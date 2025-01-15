package com.example.coupon;

import java.util.stream.IntStream;

public class CouponA {
    public static float calculate(int[] carItems) {
        int totalPrice = IntStream.of(carItems).sum();
        return totalPrice;
    }
}
