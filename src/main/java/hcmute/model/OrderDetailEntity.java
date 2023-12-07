package hcmute.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hcmute.embeddedId.CartDetailId;
import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.MilkTeaEntity;
import hcmute.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailId idOrderDetail;
	
	
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "curr_price")
	private int currPrice;
	
	@ManyToOne
	@JoinColumn(name = "id_order", insertable = false, updatable = false)
	private OrderEntity orderByOrderDetail;

	@ManyToOne
	@JoinColumn(name = "id_milk_tea", insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByOrderDetail;
	
}
