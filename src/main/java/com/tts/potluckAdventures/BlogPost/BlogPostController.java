package com.tts.potluckAdventures.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BlogPostController {

	@Autowired
	private BlogPostRepository blogPostRepository;

	@GetMapping("/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/index";
	}

	// getting new blog form
	@GetMapping("blogposts/new")
	public String newBlogPost(BlogPost blogPost) {
		return "blogpost/new";
	}

	// post new blog to database
	@PostMapping("blogposts/new")
	public String submitBlogPost(BlogPost blogPost, Model model) {
		BlogPost post = blogPostRepository.save(blogPost);
		model.addAttribute("title", post.getTitle());
		model.addAttribute("author", post.getAuthor());
		model.addAttribute("blogEntry", post.getBlogEntry());
		return "blogpost/result";
	}

	@DeleteMapping("/blogpost/{id}")
	public String deletePostById(BlogPost blogPost, @PathVariable Long id) {
		blogPostRepository.deleteById(id);
		return "blogpost/deleted";
	}

	@GetMapping("/blogpost/{id}")
	public String showSinglePost(BlogPost blogPost, Model model, @PathVariable Long id) {

		BlogPost post = blogPostRepository.findById(id)
				.orElseThrow(() -> (new IllegalArgumentException("invalid id " + id)));
		model.addAttribute("post", post);
		return "blogpost/show";
	}

	@GetMapping("/blogpost/edit/{id}")
	public String editBlogPost(BlogPost blogPost, Model model, @PathVariable Long id) {
		BlogPost post = blogPostRepository.findById(id)
				.orElseThrow(() -> (new IllegalArgumentException("invalid id " + id)));
		model.addAttribute("post", post);
		return "blogpost/edit";
	}

	@PutMapping("/blogpost/edit/{id}")
	public String submitBlogPostEdit(BlogPost blogPost, Model model, @PathVariable Long id) {
		BlogPost post = blogPostRepository.save(blogPost);
		model.addAttribute("title", post.getTitle());
		model.addAttribute("author", post.getAuthor());
		model.addAttribute("blogEntry", post.getBlogEntry());
		model.addAttribute("id", post.getId());
		return "blogpost/result";
	}
}
