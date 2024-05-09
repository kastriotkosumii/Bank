package com.linkplus.Bank.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String bankName;
    
    @OneToMany(mappedBy = "bank")
    @Column(nullable = false)
    @JsonManagedReference
    private List<Account> accounts;

    @Column(nullable = false)
    private Double transactionFeeAmmount;

    @Column(nullable = false)
    private Double totalTransferAmmount;

    @Column(nullable = false)
    private Double transactionFlatFeeAmmount;

    @Column(nullable = false)
    private Double transactionPercentFeeValue;

}
