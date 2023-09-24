package com.example.moviewebsite.user_data.repository;

import com.example.moviewebsite.user_data.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionListRepository extends JpaRepository<WatchList, String> {
}
