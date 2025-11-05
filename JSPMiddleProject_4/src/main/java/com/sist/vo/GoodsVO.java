package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO                                                 NUMBER(38)
 GOODS_NAME                                         VARCHAR2(4000)
 GOODS_SUB                                          VARCHAR2(4000)
 GOODS_PRICE                                        VARCHAR2(128)
 GOODS_DISCOUNT                                     NUMBER(38)
 GOODS_FIRST_PRICE                                  VARCHAR2(128)
 GOODS_DELIVERY                                     VARCHAR2(128)
 GOODS_POSTER                                       VARCHAR2(4000)
 HIT                                                NUMBER(38)
 * 
 */
@Getter
@Setter

public class GoodsVO {
	private int no,goods_discount,hit,won;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
}
