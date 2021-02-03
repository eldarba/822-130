package app.core.beans.b.lombok;

import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Person {

	@Include
	private Integer id;
	@NonNull
	@lombok.ToString.Include
	private String name;
	@NonNull
	@lombok.ToString.Include
	private Integer age;

	public static void main(String[] args) {
		Person p = new Person("Dan", 25);
		p.setId(101);
		System.out.println(p);
	}

}
