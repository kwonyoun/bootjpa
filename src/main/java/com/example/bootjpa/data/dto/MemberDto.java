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
import lombok.ToString;

@Getter
@NoArgsConstructor
public class MemberDto {

    public static Role USER;

    @NotBlank(message = "아이디 는 필수 입력 값입니다.")
    private String memberId;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String memberPw;
    
    @NotEmpty(message = "비밀번호 확인을 위해 입력해주세요.")
    private String memberPwConfirm;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String memberName;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String memberNickname;
    
    @Builder
    public MemberDto(String memberId, String memberPw, String memberPwConfirm,  String memberName, String memberNickname){
          this.memberId = memberId;
          this.memberPw = memberPw;
          this.memberPwConfirm = memberPwConfirm;
          this.memberName = memberName;
          this.memberNickname = memberNickname;
      }
      public void encodePassword(PasswordEncoder passwordEncoder) {
          this.memberPw = passwordEncoder.encode(this.memberPw);
      }

      
    
}
