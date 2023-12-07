package hcmute.model;

import java.io.Serializable;

import hcmute.embeddedId.OrderDetailId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayRestModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private String status;
	private String message;
	private String URL;

}
