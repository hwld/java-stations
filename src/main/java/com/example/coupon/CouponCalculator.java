package com.example.coupon;

import java.util.Arrays;
import java.util.Collections;

public class CouponCalculator {
    public String findBestCoupon(int[] cartItems) {
        float totalPriceWithCouponA = CouponA.calculate(cartItems);
        float totalPriceWithCouponB = CouponB.calculate(cartItems);
        float totalPriceWithCouponC = CouponC.calculate(cartItems);

        float minTotal = Collections
                .min(Arrays.asList(totalPriceWithCouponA, totalPriceWithCouponB, totalPriceWithCouponC));

        if (minTotal == totalPriceWithCouponA) {
            return "A";
        } else if (minTotal == totalPriceWithCouponB) {
            return "B";
        } else {
            return "C";
        }
    }
}
