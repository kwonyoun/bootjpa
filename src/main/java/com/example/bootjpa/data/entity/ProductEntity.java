package com.example.bootjpa.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

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

    @Id
    String productId; //primaryKey
    String productName;
    int productPrice;
    int productStock;
    
}
