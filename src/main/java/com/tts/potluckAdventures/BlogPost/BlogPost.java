package com.tts.potluckAdventures.BlogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private String blogEntry;

	public BlogPost() {

	}

	public BlogPost(String title, String author, String blogEntry) {
		this.title = title;
		this.author = author;
		this.blogEntry = blogEntry;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getBlogEntry() {
		return blogEntry;
	}

	public long getId() {
		return id;
	}

	public BlogPost setTitle(String title) {
		this.title = title;
		return this;
	}

	public BlogPost setAuthor(String author) {
		this.author = author;
		return this;
	}

	public BlogPost setBlogEntry(String blogEntry) {
		this.blogEntry = blogEntry;
		return this;
	}

	@Override
	public String toString() {
		return "BlogPost [id= mom" + id + ", title=" + title + ", author=" + author + ", blogEntry=" + blogEntry + "]";
	}

}
