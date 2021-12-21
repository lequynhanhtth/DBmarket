package com.example.dbmarket.repository;

import com.example.dbmarket.entities.Category;
import com.example.dbmarket.entities.Order;
import com.example.dbmarket.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    @Query(value = "SELECT SUM(o.quantity) FROM OrderDetail o WHERE o.order.status like 'Done' and o.order.supplier.supplierId = :supplierId")
    Double getNumberProductBySupplierId(int supplierId);
    @Query(value = "SELECT SUM(o.quantity*o.product.price) FROM OrderDetail o WHERE o.order.status like 'Done' and o.order.supplier.supplierId = :supplierId")
    Double getTotalPriceBySupplierId(int supplierId);

}
