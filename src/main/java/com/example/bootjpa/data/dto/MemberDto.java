package com.example.bootjpa.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    @NotBlank(message = "아이디 는 필수 입력 값입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;
    
    @NotEmpty(message = "비밀번호 확인을 위해 입력해주세요.")
    private String passwordconfirm;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String usernickname;
    
    @Builder
    public MemberDto(String username, String password, String passwordconfirm,  String usernickname){
          this.username = username;
          this.password = password;
          this.passwordconfirm = passwordconfirm;
          this.usernickname = usernickname;
      }
      public void encodePassword(PasswordEncoder passwordEncoder) {
          this.password = passwordEncoder.encode(this.password);
      }

      
    
}
