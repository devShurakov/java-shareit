package ru.practicum.shareit.item;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i " +
            "WHERE (UPPER(i.name)) LIKE UPPER(CONCAT('%', ?1, '%')) " +
            " OR (UPPER(i.description)) LIKE UPPER(CONCAT('%', ?1, '%'))" +
            " AND i.available = true"
    )

    List<Item> search(String text);

    @Query("SELECT i FROM Item i " +
            "WHERE UPPER(i.name) LIKE UPPER(CONCAT('%', ?1, '%')) " +
            " OR UPPER(i.description) LIKE UPPER(CONCAT('%', ?1, '%'))" +
            " AND i.available = true"
    )
    List<Item> search(String text, Pageable page);

    List<Item> findAllItemsByOwnerIdOrderByIdAsc(long userId, Pageable page);

    List<Item> findAllByRequestId(Long id);

}
