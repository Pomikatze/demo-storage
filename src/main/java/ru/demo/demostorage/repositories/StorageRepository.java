package ru.demo.demostorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.demostorage.entity.StorageEntity;

/**
 * Репозиторий для складов.
 */
public interface StorageRepository extends JpaRepository<StorageEntity, Long> {
}
