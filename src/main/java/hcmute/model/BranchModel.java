package hcmute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchModel{
	private int idBranch;
	private String name;
	private String addressDetail;
	private String opentime;
	private String image;
	private String description;
	private int idCity;
	private CityModel cityByBranch;
	private AccountModel accounts;
	private MilkTeaModel milkTeas;
	private Boolean isEdit = false;
}
