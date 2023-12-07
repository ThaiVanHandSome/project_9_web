
package hcmute.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import hcmute.model.OrderDetailEntity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Integer idOrder;

	@Column(name = "total_product")
	private int totalProduct;

	@Column(name = "total_price")
	private int totalPrice;
	
	@Column(name = "final_price")
	private int finalPrice;

	@Column(name = "order_day")
	private LocalDate orderDay;

	@Column(name = "order_state")
	private int orderState;

	@Column(name = "ship_day")
	private LocalDate shipDay;
	
	@Column(name = "note", columnDefinition = "nvarchar(1000)")
	private String note;
	
	@Column(name = "address", columnDefinition = "nvarchar(1000)")
	private String address;
	
	@Column(name = "phoneNumber",columnDefinition = "varchar(50)")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "id_pay_method")
	private PayMethodEntity payMethodByOrder;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private CustomerEntity customerByOrder;

	@OneToMany(mappedBy = "orderByOrderDetail")
	private Set<OrderDetailEntity> orderDetails;
}
