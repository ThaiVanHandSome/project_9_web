package hcmute.entity;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
public class BookAuthorEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private int bookid;
	private int author_id;
}
