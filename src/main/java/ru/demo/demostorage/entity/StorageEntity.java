package ru.demo.demostorage.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Склад.
 */
@Entity
@Table(name = "storage")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StorageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_seq_gen")
    @SequenceGenerator(name = "storage_seq_gen", sequenceName = "storage_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_info_id")
    @ToString.Exclude
    private StorageInfoEntity storageInfo;

    @OneToMany(mappedBy = "storage")
    @ToString.Exclude
    private Set<OrderInfoEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StorageEntity that = (StorageEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
