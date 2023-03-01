package ru.demo.demostorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.demostorage.entity.OrderInfoEntity;

/**
 * Репозиторий для "Информация о заказе".
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, Long> {
}
