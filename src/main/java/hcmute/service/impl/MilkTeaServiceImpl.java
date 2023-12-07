package hcmute.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaEntity;
import hcmute.model.OrderDetailEntity;
import hcmute.repository.MilkTeaRepository;
import hcmute.repository.OrderDetailRepository;
import hcmute.service.IMilkTeaService;

@Service
public class MilkTeaServiceImpl implements IMilkTeaService {
	@Autowired
	MilkTeaRepository milkTeaRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	public MilkTeaServiceImpl(MilkTeaRepository milkTeaRepository, OrderDetailRepository orderDetailRepository) {
		this.milkTeaRepository = milkTeaRepository;
		this.orderDetailRepository = orderDetailRepository;
	}


	@Override
	public Optional<MilkTeaEntity> findByIdMilkTea(int id) {
		return milkTeaRepository.findByIdMilkTea(id);
	}

	@Override
	public List<MilkTeaEntity> findAll() {
		return milkTeaRepository.findAll();
	}

	@Override
	public List<MilkTeaEntity> findRelevantProducts(int typeId, int milkTeaId) {
		return milkTeaRepository.findRelevantProducts(typeId, milkTeaId);
	}

	@Override
	public List<MilkTeaEntity> findFiveProduct() {
		List<MilkTeaEntity> temp = milkTeaRepository.findAll();
		List<MilkTeaEntity> list = new ArrayList<>();
		if (temp.size() >= 5) {
			list.addAll(temp.subList(0, 5));
		} else {
			list.addAll(temp);
		}
		return list;
	}

	@Override
	public List<MilkTeaEntity> findFiveProductOutstanding() {
		return milkTeaRepository.findFiveProductOutstanding();
	}

	@Override
	public List<MilkTeaEntity> findFourProductsOutstanding() {
		return null;
	}

	@Override

	public List<MilkTeaEntity> findByNameContaining(String name) {
		return milkTeaRepository.findByNameContaining(name);
	}

	@Override
	public List<MilkTeaEntity> findByNameContainingAndSortAscendingByCost(String name) {
		return milkTeaRepository.findByNameContainingAndSortAscendingByCost(name);
	}

	@Override
	public List<MilkTeaEntity> findByNameContainingAndSortDescendingByCost(String name) {
		return milkTeaRepository.findByNameContainingAndSortDescendingByCost(name);
	}

	public Page<MilkTeaEntity> findBynameContaining(String name, Pageable pageable) {
		return milkTeaRepository.findBynameContaining(name, pageable);
	}

	@Override
	public long count() {
		return milkTeaRepository.count();
	}

	@Override
	public Page<MilkTeaEntity> findAll(Pageable pageable) {
		return milkTeaRepository.findAll(pageable);
	}
	
	@Override
	public List<MilkTeaEntity> findAllByTypeId(int typeId) {
		return milkTeaRepository.findAllByTypeId(typeId);
	}



	@Override
	public int countByTypeId(int typeId) {
		return milkTeaRepository.countByTypeId(typeId);
	}


	@Override
	public Page<MilkTeaEntity> findAllByTypeId(int idType, Pageable pageable) {
		return  milkTeaRepository.findAllByTypeId(idType, pageable);
	}

	private int getQuantity(List<OrderDetailEntity> oderDetails) {
		
		if (oderDetails != null && !oderDetails.isEmpty()) {
			int res = 0;
			for (OrderDetailEntity orderDetail : oderDetails) {
				res += orderDetail.getQuantity();
			}
			return res;
		}
		return 0;
	}

	@Override
	public void sortByOrderDetailQuantity(List<MilkTeaEntity> milkTeaList) {
		try {
			int n = milkTeaList.size();
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	            	List<OrderDetailEntity> oderDetails1 = orderDetailRepository.findOrderDetailsByIDMilkTea(milkTeaList.get(j).getIdMilkTea());
	            	List<OrderDetailEntity> oderDetails2 = orderDetailRepository.findOrderDetailsByIDMilkTea(milkTeaList.get(j + 1).getIdMilkTea());
	                int quantity1 = getQuantity(oderDetails1);
	                int quantity2 = getQuantity(oderDetails2);

	                if (quantity1 < quantity2) {
	                    MilkTeaEntity temp = milkTeaList.get(j);
	                    milkTeaList.set(j, milkTeaList.get(j + 1));
	                    milkTeaList.set(j + 1, temp);
	                }
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
