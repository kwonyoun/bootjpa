package com.example.bootjpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {

    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberRoles;
    
}
