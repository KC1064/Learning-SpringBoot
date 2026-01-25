package com.Kiron.SpringJPA.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "productTable",
        uniqueConstraints = {
                @UniqueConstraint(name = "titleUnique", columnNames = {"txtTitle"})
        }
)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txtTitle", nullable = false, length = 55)
    private String title;

    @Column(name = "txtGenre", nullable = false)
    private String genre;

    @Column(name = "intPrice", nullable = false)
    private Integer price;

    @Column(name = "boolAvailable")
    private boolean available;

    @Column(name = "dtCreatedAt")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "dtUpdatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
