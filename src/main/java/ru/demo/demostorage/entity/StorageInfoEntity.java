package ru.demo.demostorage.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Информация о скалде.
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "storage_info")
public class StorageInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_info_seq_gen")
    @SequenceGenerator(name = "storage_info_seq_gen", sequenceName = "storage_info_seq", allocationSize = 1)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", length = 11)
    private String phone;

    @OneToOne(mappedBy = "storageInfo")
    @ToString.Exclude
    private StorageEntity storage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StorageInfoEntity that = (StorageInfoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
