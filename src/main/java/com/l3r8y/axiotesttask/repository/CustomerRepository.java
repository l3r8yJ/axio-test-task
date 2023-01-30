package com.l3r8y.axiotesttask.repository;

import com.l3r8y.axiotesttask.entity.CustomerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("from CustomerEntity where fio like concat('%', :fio, '%')")
    List<CustomerEntity> findAllByFio(@Param("fio") String fio);

    @Query("from CustomerEntity where passport like concat('%', :passport, '%')")
    List<CustomerEntity> findAllByPassport(@Param("passport") String passport);

    @Query("from CustomerEntity where phone like concat('%', :phone, '%')")
    List<CustomerEntity> findAllByPhone(@Param("phone") String phone);

}
