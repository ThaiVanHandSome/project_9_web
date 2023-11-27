package vn.iostar.ajax.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import vn.iostar.ajax.Entity.*;
import vn.iostar.ajax.Model.*;
import vn.iostar.ajax.Service.*;


@Controller
@RequestMapping("admin/category")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("add")
	public String add(ModelMap model) {
		CategoryModel cateModel = new CategoryModel();
		cateModel.setIsEdit(false);
		model.addAttribute("category",cateModel);
		return "admin/category/addOrEdit";
	}
	
	@PostMapping("saveOrUpdate") 
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryModel cateModel, BindingResult result) {
//		if (result.hasErrors()) {
//			return new ModelAndView("admin/category/addOrEdit");
//		}
		Category entity = new Category();
		BeanUtils.copyProperties(cateModel, entity);
		categoryService.save(entity);
		String message = "";
		if (cateModel.getIsEdit() == true) {
			message = "Category is Edited";
		}
		else {
			message = "Category is saved";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/category",model);
		
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list",list);
		return "admin/category/ajax";
	}
	
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Long categoryID) {
		Optional<Category> optCategory = categoryService.findById(categoryID);
		CategoryModel cateModel = new CategoryModel();
		if (optCategory.isPresent()) {
			Category entity = optCategory.get();
			BeanUtils.copyProperties(entity, cateModel);
			cateModel.setIsEdit(true);
			model.addAttribute("category", cateModel);
			return new ModelAndView("admin/category/addOrEdit",model);
		}
		model.addAttribute("message", "Category is not existed");
		return new ModelAndView("forward:/admin/category",model);
	}
	
	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model, @PathVariable("categoryId") Long categoryID) {
		categoryService.deleteById(categoryID);
		model.addAttribute("message", "Category is deleted");
		return new ModelAndView("forward:/admin/category",model);
	}
}
