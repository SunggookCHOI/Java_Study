package model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class People {
	private String name;
	private String phone;
	
	@Override
   public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append("1. 이름 : ");
         builder.append(name);
         builder.append("\n2. 전화번호 : ");
         builder.append(phone);
         return builder.toString();
      }
}
