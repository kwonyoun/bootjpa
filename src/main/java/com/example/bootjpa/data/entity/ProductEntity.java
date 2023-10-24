package com.example.bootjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
    //entity란 데이터베이스의 테이블과 직접적으로 매핑이되는 클래스를 뜻함.

    @Id //어노테이션 Id ㅜ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 식별자 값이 자동으로 생성되도록 설정
    String productId; //primaryKey

    String productName;

    Integer productPrice;
    
    Integer productStock;
    
}
