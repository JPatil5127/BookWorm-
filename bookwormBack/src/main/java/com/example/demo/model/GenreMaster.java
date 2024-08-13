package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="GenreMaster")
public class GenreMaster {
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="GenreId")
private Integer GenreId;
@Column(name="GenreDesc")
private String GenreDesc;

@ManyToOne
@JoinColumn(name = "LanguageId", referencedColumnName = "LanguageId")
private LanguageMaster LanguageMaster;
public GenreMaster() {
	
}
public GenreMaster(String genreDesc, LanguageMaster languageMaster) {
	GenreDesc = genreDesc;
	LanguageMaster = languageMaster;
}


public Integer getGenreId() {
	return GenreId;
}


public void setGenreId(Integer genreId) {
	GenreId = genreId;
}


public String getGenreDesc() {
	return GenreDesc;
}


public void setGenreDesc(String genreDesc) {
	GenreDesc = genreDesc;
}


public LanguageMaster getLanguageMaster() {
	return LanguageMaster;
}


public void setLanguageMaster(LanguageMaster languageMaster) {
	this.LanguageMaster = languageMaster;
}


}
