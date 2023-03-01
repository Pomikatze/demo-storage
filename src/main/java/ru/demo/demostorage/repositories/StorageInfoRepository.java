package ru.demo.demostorage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demo.demostorage.entity.StorageInfoEntity;

/**
 * Репозиторий для "информация по скалду".
 */
public interface StorageInfoRepository extends JpaRepository<StorageInfoEntity, Long> {
}
