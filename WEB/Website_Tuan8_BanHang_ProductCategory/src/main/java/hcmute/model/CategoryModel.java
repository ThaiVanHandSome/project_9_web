package hcmute.model;
import lombok.Data;
import java.io.Serializable;
@Data
public class CategoryModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private int cateID;
	private String cateName;
	private String images;
}
