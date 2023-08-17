package jpabook.jpashop.service;


import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class OrderQueryService {
}
