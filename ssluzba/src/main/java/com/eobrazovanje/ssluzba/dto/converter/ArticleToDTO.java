package com.eobrazovanje.ssluzba.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eobrazovanje.ssluzba.dto.ArticleDTO;
import com.eobrazovanje.ssluzba.dto.LecturerDTO;
import com.eobrazovanje.ssluzba.entities.Article;
import com.eobrazovanje.ssluzba.entities.Lecturer;

@Component
public class ArticleToDTO implements Converter<Article, ArticleDTO> {
	
	@Autowired
	LecturerToDTO lectToDTO;

	@Override
	public ArticleDTO convert(Article source) {
		
		
		if(source == null) {
			return null;
		}
		
		ArticleDTO articleDTO = new ArticleDTO();
		
		articleDTO.setArticleName(source.getArticleName());
		articleDTO.setArticleText(source.getArticeText());
		articleDTO.setDateCreated(source.getDateCreated());
		articleDTO.setImportant(source.isImportant());
		articleDTO.setLecturer(lectToDTO.convert(source.getLecturer()));
		
		
		return articleDTO;
	}
	
	public List<Article> convertSetToList(Set<Article> set){
        // create an empty list 
        List<Article> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (Article a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	
	public List<ArticleDTO> convert(List<Article> source){
		List<ArticleDTO> lecturers = new ArrayList<ArticleDTO>();
		for(Article acc : source) {
			lecturers.add(convert(acc));
		}
		return lecturers;
	}

}
