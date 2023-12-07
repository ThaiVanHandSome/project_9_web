package hcmute.controller.user;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.entity.CustomerEntity;
import hcmute.entity.OrderEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.entity.UserEntity;
import hcmute.model.OrderDetailEntity;
import hcmute.service.IOrderDetailService;
import hcmute.service.IOrderService;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@Autowired
	IOrderDetailService orderDetailService;
	
	@RequestMapping("")
	public String showAllOrders(ModelMap model) {
		try {
			List<OrderEntity> list = orderService.findAll();
			model.addAttribute("orders", list);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/order";
	}
	@RequestMapping("order-detail/{idOrder}")
	public String showOrderDetail(ModelMap model,@PathVariable("idOrder") Integer idOrder) {
		try {
			List<OrderEntity> list = orderService.findAll();
			OrderEntity userOrder = orderService.getById(idOrder);
			model.addAttribute("orders", list);
			model.addAttribute("userOrder", userOrder);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/order";
	}
	
}
