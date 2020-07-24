package tn.keyrus.dekorateApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String city;
	private String street;
	private String houseNo;
	private Integer flatNo;

}
