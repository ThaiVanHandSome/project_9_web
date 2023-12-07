package hcmute.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.CustomerEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.OrderEntity;
import hcmute.entity.PayMethodEntity;
import hcmute.model.MilkTeaModel;
import hcmute.model.OrderData;
import hcmute.model.OrderDetailEntity;
import hcmute.model.OrderModel;
import hcmute.model.OrderProduct;
import hcmute.model.OrderProduct.OrderItem;
import hcmute.service.ICustomerService;
import hcmute.service.IMilkTeaService;
import hcmute.service.IOrderDetailService;
import hcmute.service.IOrderService;
import hcmute.service.IPayMethodService;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	IOrderService orderService;

	@Autowired
	IOrderDetailService orderDetailService;

	@Autowired
	ICustomerService customerService;

	@Autowired
	IPayMethodService payMethodService;

	@Autowired
	IMilkTeaService milkTeaService;

	@GetMapping("")
	private String displayPayment(ModelMap model, @RequestParam("data") String data)
			throws UnsupportedEncodingException {
//		data = URLDecoder.decode(data, "UTF-8");
		byte[] decodedBytes = Base64.getDecoder().decode(data);
        data = new String(decodedBytes, StandardCharsets.UTF_8);
		model.addAttribute("dataJSON", data);
		List<PayMethodEntity> listPayMethod = payMethodService.findAll();
		model.addAttribute("listPayMethod", listPayMethod);
		Optional<CustomerEntity> optCustomer = customerService.findById(1);
		if (optCustomer.isPresent()) {
			CustomerEntity customer = optCustomer.get();
			model.addAttribute("customer", customer);
		}

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			OrderProduct orderProduct = objectMapper.readValue(data, OrderProduct.class);
			List<MilkTeaModel> listMilkTea = new ArrayList<MilkTeaModel>();
			for (OrderItem item : orderProduct.getList()) {
				Optional<MilkTeaEntity> entity = milkTeaService.findByIdMilkTea(Integer.parseInt(item.getIdMilkTea()));
				if (entity.isPresent()) {
					MilkTeaModel milkTeaModel = new MilkTeaModel();
					BeanUtils.copyProperties(entity.get(), milkTeaModel);
					milkTeaModel.setSize(item.getSize());
					milkTeaModel.setOrderQuantity(Integer.parseInt(item.getQuantity()));
					milkTeaModel.setCost(item.getPrice());
					listMilkTea.add(milkTeaModel);
				}
			}
			model.addAttribute("orderProduct", orderProduct);
			model.addAttribute("listMilkTea", listMilkTea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/payment";
	}

	@GetMapping("/order")
	private String insertOrder(ModelMap model, @RequestParam("data") String data) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException
	{
		data = URLDecoder.decode(data, "UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			OrderData orderData = objectMapper.readValue(data, OrderData.class);
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setTotalProduct(orderData.getTotalProduct());
			orderEntity.setTotalPrice(orderData.getTotalPrice());
			orderEntity.setFinalPrice(orderData.getFinalPrice());
			orderEntity.setOrderDay(LocalDate.parse(orderData.getOrderDay(), formatter));
			orderEntity.setOrderState(orderData.getOrderState());
			orderEntity.setShipDay(LocalDate.parse(orderData.getShipDay(), formatter));
			orderEntity.setNote(orderData.getNote());
			orderEntity.setAddress(orderData.getAddress());
			orderEntity.setPhoneNumber(orderData.getPhoneNumber());
			
			if(orderData.getIdPayMethod()!= null)
			{
				Optional<PayMethodEntity> payMethodOpt = payMethodService.findById(orderData.getIdPayMethod());
				if(payMethodOpt.isPresent())
				{
					orderEntity.setPayMethodByOrder(payMethodOpt.get());
				}
			}
			
			Optional<CustomerEntity> optCustomer = customerService.findById(1);
			if(optCustomer.isPresent())
			{
				orderEntity.setCustomerByOrder(optCustomer.get());
			}
			orderService.save(orderEntity);
			
			for(OrderData.OrderItem item : orderData.getList())
			{
				OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
				orderDetailEntity.setQuantity(item.getQuantity());
				orderDetailEntity.setCurrPrice(item.getPrice());
				
				Optional<MilkTeaEntity> milkTeaEntity = milkTeaService.findByIdMilkTea(item.getIdMilkTea());
				
				if(milkTeaEntity.isPresent())
				{
					orderDetailEntity.setMilkTeaByOrderDetail(milkTeaEntity.get());
				}
				
				orderDetailEntity.setOrderByOrderDetail(orderEntity);
				
				OrderDetailId idOrderDetail = new OrderDetailId();
				idOrderDetail.setSize(item.getSize());
				idOrderDetail.setIdOrder(orderDetailEntity.getOrderByOrderDetail().getIdOrder());
				idOrderDetail.setIdMilkTea(orderDetailEntity.getMilkTeaByOrderDetail().getIdMilkTea());
				orderDetailEntity.setIdOrderDetail(idOrderDetail);
				
				orderDetailService.save(orderDetailEntity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "user/home";
	}
}
