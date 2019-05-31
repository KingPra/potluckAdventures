package com.tts.potluckAdventures.BlogPost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class BlogPostController {

	@Autowired
	private BlogPostRepository blogPostRepository;

	private static List<BlogPost> posts = new ArrayList<>();

	@GetMapping(value = "/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}

	@GetMapping(value = "/blog_posts/new")
	public String newBlog(BlogPost blogPost) {
		return "blogpost/new";

	}

	@PostMapping(value = "/")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
		posts.add(blogPost);
		model.addAttribute("id", blogPost.getId());
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}

	private BlogPost blogPost;

	@PostMapping(value = "/blog_posts/new")
	public String create(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
		posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}

	@RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.DELETE)
	public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
		for (int i = 0; i < posts.size(); i++) {
			if (id == posts.get(i).getId()) {
				posts.remove(i);
			}
		}

		blogPostRepository.deleteById(id);
		return "blogpost/index";

	}
}
