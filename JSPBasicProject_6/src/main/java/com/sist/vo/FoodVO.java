package com.sist.vo;

import lombok.Data;

/*
 *  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 FNO                                       NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(200)
 TYPE                                      NOT NULL VARCHAR2(100)
 PHONE                                              VARCHAR2(20)
 ADDRESS                                   NOT NULL VARCHAR2(500)
 SCORE                                              NUMBER(2,1)
 THEME                                              CLOB
 PRICE                                              VARCHAR2(50)
 TIME                                               VARCHAR2(100)
 PARKING                                            VARCHAR2(100)
 POSTER                                    NOT NULL VARCHAR2(260)
 IMAGES                                             CLOB
 CONTENT                                            CLOB
 HIT                                                NUMBER
 JJIMCOUNT                                          NUMBER

 * 
 */
@Data
public class FoodVO {
	private int FNO,HTI,JJIMCOUNT;
	private double SCORE;
	private String NAME,TYPE,PHONE,ADDRESS,THEME,PRICE,TIME,PARKING,POSTER,IMAGES,CONTENT;
}
