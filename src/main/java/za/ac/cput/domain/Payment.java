/*
Payment POJO Class
Author: Phindile Lisa Ngozi
Student Number: 230640893
Date: 2025/05/11
 */
package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    private LocalDate paymentDate;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    protected Payment() {

    }

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
        this.customerOrder = builder.customerOrder;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public CustomerOrder getOrder() {
        return customerOrder;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", order=" + (customerOrder != null ? customerOrder.getOrderId() : "null") +
                '}';
    }

    public static class Builder {
        private int paymentId;
        private LocalDate paymentDate;
        private String paymentMethod;
        private CustomerOrder customerOrder;

        public Builder setPaymentId(int paymentId) {
            this.paymentId = paymentId;
            return this;
        }
        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setOrder(CustomerOrder customerOrder) {
            this.customerOrder = customerOrder;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.getPaymentId();
            this.paymentDate = payment.getPaymentDate();
            this.paymentMethod = payment.getPaymentMethod();
            this.customerOrder = payment.getOrder();
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}

