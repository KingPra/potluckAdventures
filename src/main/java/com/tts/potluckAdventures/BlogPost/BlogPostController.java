package com.tts.potluckAdventures.BlogPost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BlogPostController {
	@GetMapping("/")
	public String index(BlogPost blogPost) {
		return "blogpost/index";
	}
}
