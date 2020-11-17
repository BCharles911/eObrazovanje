package com.eobrazovanje.ssluzba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eobrazovanje.ssluzba.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, String> {

}
