package hcmute.controller.admin;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import hcmute.entity.AccountEntity;
import hcmute.entity.BranchEntity;
import hcmute.model.AccountModel;
import hcmute.model.BranchModel;
import hcmute.service.IBranchService;
@Controller
@RequestMapping("admin")
public class BranchAdminController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	IBranchService branchService;
	@GetMapping("customize-branch")
	public String IndexCustomizeBranch() {
		return "admin/customize/customize-branch";
	}
	@GetMapping("view-branch")
	public String IndexViewBranch(ModelMap model) {
		List<BranchEntity> branch = branchService.findAll();
		model.addAttribute("branch", branch);
		return "admin/view/view-branch";
	}
	@GetMapping("customize-branch/add")
	public String Add(ModelMap model) {
		BranchModel branch = new BranchModel();
		branch.setIsEdit(false);
		model.addAttribute("branch", branch);
		return "admin/customize/customize-branch";
	}
	
	@PostMapping("customize-branch/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("branch") BranchModel branch, BindingResult result) {
	    if (result.hasErrors()) {
	        return new ModelAndView("admin/customize/customize-branch");
	    }
	    BranchEntity entity = new BranchEntity();
	    BeanUtils.copyProperties(branch, entity);
	    branchService.save(entity);
	    String message = "";
	    if (branch.getIsEdit()==true) {
	        message = "Branch đã được cập nhật thành công";
	    } else {
	        message = "Branch đã được thêm thành công";
	    }
	    model.addAttribute("message", message);
	    return new ModelAndView("forward:/admin/customize/customize-branch", model);
	}
	@GetMapping("customize-branch/edit/{idBranch}")
	public ModelAndView edit(ModelMap model, @PathVariable("idBranch") int idBranch) {
	    Optional<BranchEntity> opt = branchService.findById(idBranch);
	    BranchModel branch = new BranchModel();
	    if(opt.isPresent()) {
	    	BranchEntity entity = opt.get();
	    	BeanUtils.copyProperties(entity, branch);
	    	branch.setIsEdit(true);
	    	model.addAttribute("branch", branch);
	    	return new ModelAndView("admin/customize/customize-branch", model);
	    }
	    model.addAttribute("message", "Branch không tồn tại");
		return new ModelAndView("forward:/admin/view-branch", model);
	}
}
