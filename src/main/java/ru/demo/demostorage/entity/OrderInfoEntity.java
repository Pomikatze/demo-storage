package ru.demo.demostorage.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Информация о заказе.
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "order_info")
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoEntity {

    @Id
    @Column(name = "order_info_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_info_seq_gen")
    @SequenceGenerator(name = "order_info_seq_gen", sequenceName = "order_info_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    @ToString.Exclude
    private StorageEntity storage;

    @Column(name = "file_id", nullable = false)
    private Long fileId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderInfoEntity that = (OrderInfoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
