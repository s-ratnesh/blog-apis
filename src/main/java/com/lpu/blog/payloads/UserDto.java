package com.lpu.blog.payloads;

import org.hibernate.annotations.BatchSize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	
	@NotEmpty
	@Size(min=4,message="username mudt be of 4 character")
	private String name;
	@Email(message="email is not valid")
	private String email;
	@NotEmpty
	@Size(min=6,max=10,message="password must be of atleast 6-character")
	private String password;
	@NotEmpty
	private String about;

}
