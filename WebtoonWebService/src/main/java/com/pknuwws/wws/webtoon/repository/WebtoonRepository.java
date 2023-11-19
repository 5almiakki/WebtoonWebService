package com.pknuwws.wws.webtoon.repository;


import com.pknuwws.wws.webtoon.domain.Webtoon;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WebtoonRepository extends JpaRepository<Webtoon, Long> , WebtoonRepositoryCustom{
  Page<Webtoon> findAll(Pageable pageable);

  @Query("SELECT w FROM Webtoon w WHERE w.genre = :genre")
  Page<Webtoon> findByGenre(@Param("genre") String genre, Pageable pageable);

  @Query("SELECT w FROM Webtoon w WHERE w.firstDate > :firstDate")
  Page<Webtoon> findByFirstDate(@Param("firstDate") LocalDate firstDate,Pageable pageable);
}