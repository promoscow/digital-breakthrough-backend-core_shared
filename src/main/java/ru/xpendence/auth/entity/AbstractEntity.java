package ru.xpendence.auth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.08.19
 * Time: 10:41
 * e-mail: v.chernyshov@pflb.ru
 */
@MappedSuperclass
@Data
@EqualsAndHashCode
@ToString
abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created")
    @CreatedDate
    private LocalDateTime created;

    @Column(name = "updated")
    @LastModifiedDate
    private LocalDateTime updated;

    @PrePersist
    private void toSave() {
        if (Objects.isNull(created)) {
            created = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void toUpdate() {
        if (Objects.isNull(updated)) {
            updated = LocalDateTime.now();
        }
    }
}
