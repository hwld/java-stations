package com.example.station9;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] itemPrices1 = { 1000, 1100, 1200, 1300 };
        int[] itemPrices2 = { 1000, 1100, 1200, 1300, 1600, 1800 };
        int[] itemPrices3 = { 1000, 2100, 3200, 2300 };
        System.out.print("カート内: 1000円, 1100円, 1200円, 1300円。期待されるクーポン: A。結果: ");
        test(itemPrices1);
        System.out.print("カート内: 1000円, 1100円, 1200円, 1300円, 1600円, 1800円。期待されるクーポン: B。結果: ");
        test(itemPrices2);
        System.out.print("カート内: 1000円, 2100円, 3200円, 2300円。期待されるクーポン: C。結果: ");
        test(itemPrices3);
    }

    public static void test(int[] itemPrices) {

        double totalAfterCouponA = calculateTotalWithCouponA(itemPrices);
        double totalAfterCouponB = calculateTotalWithCouponB(itemPrices);
        double totalAfterCouponC = calculateTotalWithCouponC(itemPrices);

        double minTotal = Collections
                .min(Arrays.asList(totalAfterCouponA, totalAfterCouponB, totalAfterCouponC));

        if (minTotal == totalAfterCouponA) {
            System.out.println("A");
        } else if (minTotal == totalAfterCouponB) {
            System.out.println("B");
        } else if (minTotal == totalAfterCouponC) {
            System.out.println("C");
        }

    }

    public static int shippingFee = 800;

    public static double calculateTotalWithCouponA(int[] itemPrices) {
        int subtotalPrice = IntStream.of(itemPrices).sum();

        return subtotalPrice;
    }

    public static double calculateTotalWithCouponB(int[] itemPrices) {
        double subtotalPrice = IntStream.of(itemPrices).sum() * 0.9;

        double totalPrice = subtotalPrice < 5000 ? subtotalPrice + shippingFee : subtotalPrice;
        return totalPrice;
    }

    public static double calculateTotalWithCouponC(int[] itemPrices) {
        double subtotalPrice = IntStream.of(itemPrices)
                .mapToDouble(price -> price >= 2000 ? price * 0.8 : price)
                .sum();

        double totalPrice = subtotalPrice < 5000 ? subtotalPrice + shippingFee : subtotalPrice;
        return totalPrice;
    }
}
