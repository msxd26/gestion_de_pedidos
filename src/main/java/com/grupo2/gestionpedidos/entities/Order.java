package com.grupo2.gestionpedidos.entities;

import com.grupo2.gestionpedidos.utils.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_date", nullable = false, updatable = false)
    private LocalDateTime orderDate = LocalDateTime.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal total;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order() {
        this.orderDetails = new ArrayList<>();
    }

    @PrePersist
    private void prePersist() {
        this.orderDate = LocalDateTime.now();
    }

    public void removeOrderDetail(OrderDetail orderDetail) {
        if(orderDetail != null && this.orderDetails != null) {
            this.orderDetails.remove(orderDetail);
            orderDetail.setOrder(null);
        }
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if(orderDetail != null) {
            if(this.orderDetails == null) {
                this.orderDetails = new ArrayList<>();
            }
            this.orderDetails.add(orderDetail);
            orderDetail.setOrder(this);
        }
    }


}