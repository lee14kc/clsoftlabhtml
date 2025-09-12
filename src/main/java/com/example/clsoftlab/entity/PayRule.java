package com.example.clsoftlab.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.clsoftlab.dto.pay.PayRuleRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ZHR_PAY_RULE")
public class PayRule {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RULE_ID")
    private Long ruleId;

    @Column(name = "ZITEM_CD", nullable = false, length = 20)
    private String itemCode;

    @Column(name = "ZRULE_TY", nullable = false, length = 10)
    private String ruleType;

    @Column(name = "ZFORMULA", length = 2000)
    private String formula;

    @Column(name = "ZFIXED_VAL", precision = 18, scale = 2)
    private BigDecimal fixedValue;

    @Column(name = "ZFROM_DT", nullable = false)
    private LocalDate fromDate;

    @Column(name = "ZTO_DT", nullable = false)
    private LocalDate toDate;

    @Column(name = "ZUSE_YN", nullable = false, length = 1)
    private String useYn;

    @Column(name = "ZNOTE", length = 500)
    private String note;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "CREATED_BY", nullable = false, updatable = false, length = 50)
    private String createdBy;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    // ZHR_PAY_ITEM 테이블과의 연관관계 매핑
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ZITEM_CD", referencedColumnName = "ZITEM_CD", insertable = false, updatable = false)
    private PayItem payItem;

    // 데이터 저장 전 생성일시/생성자 자동 설정
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        // 실제 프로젝트에서는 SecurityContextHolder 등을 통해 현재 로그인 사용자를 createdBy에 할당합니다.
        if (this.createdBy == null) this.createdBy = "system"; 
    }

    // 데이터 업데이트 전 수정일시/수정자 자동 설정
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        // createdBy와 마찬가지로 현재 로그인 사용자를 updatedBy에 할당합니다.
        if (this.updatedBy == null) this.updatedBy = "system";
    }
    
    public void update(PayRuleRequestDto dto) {
        this.ruleType = dto.getRuleType();
        this.formula = dto.getFormula();
        this.fixedValue = dto.getFixedValue();
        this.fromDate = dto.getFromDate();
        this.toDate = dto.getToDate();
        this.useYn = dto.getUseYn();
        this.note = dto.getNote();
    }
    
}
