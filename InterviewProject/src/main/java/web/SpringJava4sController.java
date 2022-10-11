package web;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import word_functions.File_Functions;
import word_functions.Word_Split_And_Store;





@Controller
@ComponentScan
public class SpringJava4sController {	

	@RequestMapping( value="/home")
	public String home() {
		// loadTest("lTEST");
		return "OverPage";
	}
	
	@ResponseBody
	@GetMapping("/loadFromFile")
	public String loadFromFile(@RequestParam(name = "fileUrl", required = true) String fileUrl) {
		String decoded = URLDecoder.decode(fileUrl, StandardCharsets.UTF_8);
		
		String fileText = File_Functions.ReadFile(decoded);
		Word_Split_And_Store word_Split_And_Store = new Word_Split_And_Store(fileText);
		word_Split_And_Store.toString();
		return word_Split_And_Store.getResultInJson().toString();
	}
	
	
	@ResponseBody
	@GetMapping("/getWordsFromUrl")
	public JSONArray startGraber(@RequestParam(name = "url", required = true) String url) {
		String decoded = URLDecoder.decode(url, StandardCharsets.UTF_8);
		Word_Split_And_Store word_Split_And_Store = new Word_Split_And_Store(decoded);
		return word_Split_And_Store.getResultInJson();
	}
	
	@ResponseBody
	@GetMapping("/getSimpleWordCount")
	public String simpleWordCount(@RequestParam(name = "text", required = true) String text) {
		String decoded = URLDecoder.decode(text, StandardCharsets.UTF_8);
		Word_Split_And_Store word_Split_And_Store = new Word_Split_And_Store(decoded);
		word_Split_And_Store.toString();
		return word_Split_And_Store.getResultInJson().toString();
	}
	
}