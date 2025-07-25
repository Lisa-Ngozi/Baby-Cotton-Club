/*
PaymentFactory POJO Class
Author: Phindile Lisa Ngozi
Student Number: 230640893
Date: 2025/05/18
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(String paymentDate,
                                        String paymentMethod,int paymentId,
                                        Order order) {
        if (Helper.isNullOrEmpty(paymentMethod) || Helper.isNullOrEmpty(paymentMethod) || order == null) {
            return null;
        }

        LocalDate date = Helper.isValidDate(paymentDate);
        if (date == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentDate(date)
                .setPaymentMethod(paymentMethod)
                .setPaymentId(paymentId)
                .setOrder(order)
                .build();
    }
}