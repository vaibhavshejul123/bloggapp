package com.blogapp.apis.paylods;	


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private int UserId;

	@NotEmpty
	@Size(min=4, message ="Username must be minimum of 4 character!!")
	private String userName;

	@Email(message="Email Address is not valid!!")
	private String email;

	@NotEmpty
	@Size(min=3, max=10 ,message="Password must be min of 3 chars and max of 10 chars")
	private String password;

	@NotEmpty
	private String about;

}
