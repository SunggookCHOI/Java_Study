package model.domain;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Customer extends People {
	private String grade;
	private Cart cart;
	
	public Customer(String name, String phone, String grade, Cart cart) {
		super(name,phone);
		this.grade=grade;
		this.cart=cart;
	}
	@Override
	public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(super.toString());
      builder.append("\n3. 고객 등급 : ");
      builder.append(grade);
      builder.append("\n4. 장바구니 내역 : ");
      builder.append(cart);
      return builder.toString();
	}
}
