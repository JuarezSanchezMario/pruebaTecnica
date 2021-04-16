package com.pruebaTwitter.pruebaTecnica.model.repository;

import com.pruebaTwitter.pruebaTecnica.model.repository.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    List<Tweet> findByValidTrue();

}
