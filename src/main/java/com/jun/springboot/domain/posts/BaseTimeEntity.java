package com.jun.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {   // 모든 Entity이 상위 클래스 -> 데이터의 생성, 수정시간 자동 관리

    @CreatedDate
    private LocalDateTime createdDate;   

    @LastModifiedDate
    private LocalDateTime modifiedDate;


}
