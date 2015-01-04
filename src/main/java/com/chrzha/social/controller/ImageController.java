package com.chrzha.social.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrzha.social.entity.Image;
import com.chrzha.social.service.ImagesService;

@Controller
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImagesService imagesService;

	@RequestMapping("/getAll")
	public @ResponseBody String getImages() {
		List<Image> list = imagesService.getImages();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		for(Image image : list){
			jsonObject.put("title", image.getTitle());
			jsonObject.put("content", image.getContent());
			jsonObject.put("path", image.getPath());
			jsonArray.add(jsonObject);
		}
		return jsonArray.toString(2);
	}
	@RequestMapping("/save")
	public String saveImage() {

		Image image = new Image("dd", "cwev", "cwv");
		imagesService.saveImage(image);
		return image.toString();
	}
}
