<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		JavaScript
			| JQuery : Ajax
			| VueJs : vuex / pinia / nuxtjs 
			| ReactJS : redux / tanStack-Query / nextjs
		--------------------------------------------------
	자바스크립트
	1) 정의 : 웹브라우저에서 동작하는 스크립트 언어
							   ------ 단순한 언어
	2) 용도 : 동적 웹페이지 제작 , 서버 개발 (NodeJS) , 앱 개발 (React Native)
	3) 실행 환경 : 브라우저
	4) 특징 : 인터프리터 언어 , 객체 기반 , 이벤트 중심
	
	1. 기본 문법
	   변수  : 1개의 데이터를 저장하는 메모리 공간
	   		  데이터형이 없다 : 저장되는 데이터를 통해서 자동 인식
	   		  var a=10 => a:int
	   		  var b=10.5 => b:double
	   		  				 -------- number
	   		  var c='hello' c:String
	   		  var d="Hello" d:String
	   		  	  ---------- ----------
	   		  var e={"name":"홍길동",sex:"남자",age:20}
	   		  	  e:object => 객체 (JSON)
	   		  	  JavaScript Object Notation
	   		  	  => 자바스크립트 객체 표현법
	   		  	  => 전송 (자바 === 자바스크립트)
	   		  	  		   |		  |
	   		  	  		   ------------
	   		  	  		       | 연결시 사용
	   		  var f=["","",""] => f:array
	   		  ==========> 재선언이 가능 (스코프가 명확하지 않는다)
	   		  			  | 변수 사용범위가 명확하지 않는다
	   		  var : ES5
	   		  let : ES6 => 재선언이 불가능
	   		  		블록을 벗어나면 자동으로 메모리가 해제
	   		  		사용법은 동일 => 지역변수
	   		  const : 상수형 변수 (final)
	   		  
	   		  ** 단점 
	   		  let a=10;
	   		  a="HELLO";
	   		  a=[];
	   		  a={};
	   		  -------------------- 가독성이 떨어진다
	   		  => 데이터형을 고정
	   		  let a:string="10" => TypeScript
	   		  	  --------
	   		=> 자료형 : number, string, boolean
	   				  null, undefined , bigint
	   		   참조형 : object , array , function
	   		   ** function도 데이터형의 일종
	   		      ----------------------
	   		      | 매개변수로 사용이 가능 => CallBack
	   		      | 시스템에 의해 자동으로 호출되는 함수
	   	   => 형변환
	   	      숫자 변환 : Number("10") => 10
	   	      			parseInt("10") => 10
	   	      			String(10) => "10"
	   	      			Boolean(0) => false
	   	      			   0,0.0
	   	      			Boolean(1) => true
	   	    ------------------------------------
	   	      				| 호환 => VO , List
	   	      					    { }	  []
	   	      					    JSON  Array	
	   	      	 ---------------------
	   	         |					 |
	   	     자바스크립트 ============ 자바 ============= 오라클
	   	     	 |									   |
	   	     	 ---------------------------------------
	   	     	 			 		| 연결이 안된다
	   	     = 사용법
						외부 자바스크립트 : 여러개의 파일에서 공통으로 사용
                       => 자바스크립트 파일 생성 (.js)
                          = .js, .jsx, .ts , .tsx
                    <scropt type="text/javascript" src="파일명">
                    내부 자바스크립트 : 한개의 파일에서 사용
                    <head>
                       <script>
                          => 설정
                       </script>
                    </head>
                    인라인 자바스크립트 : 한개 태그 안에서 사용
                    <input type ="button"
                       onclick="javascript:history.back()">
                    인라인 자바스크립트 : 한개 태그안에서 사용
	   연산자
	   제어문
	   함수
	   객체지향
	   DOM => 태그를 제어하는 프로그램
	   라이브러리 => JQuery
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 한줄 주석
/*
 * 		여러줄 주석
 */
 // 변수 선언 => main함수 => 자동호출
 // function aaa() => 반드시 호출후에 사용
 // Jquery : $(function(){})
 // Vuejs : mounted()
 // react : effect()
 window.onload=function(){
	/*
		변수 선언 => var / let(권장) / const
		=> 식별자
			= 알파벳으로 시작(대소문자 구분)
			= 숫자 사용이 가능 (앞에 사용 금지)
			= 공백이 있으면 안된다
			= 문자 길이는 상관없다
			= 키워드는 사용할 수 없다
			= 특수문자 사용 : ($,_)
	*/
	let a=10;
	// ; 은 사용할 수도 있고, 사용하지 않아도 된다.
	let b=10.5;
	/*
		출력
		console.log() : console에 출력 => 개발자 도구
		document.write() : 브라우저에 출력
		alert() : 팝업창
		innerHTML : HTML안에 HTML을 첨부
	*/
	//1. 변수의 데이터형 확인 typeof
	console.log("a:"+typeof a);
	console.log("b:"+typeof b); // number
	let c="Hello"
	let d='hello'
	console.log("c:"+typeof c);	
	console.log("d:"+typeof d); // string
	let e=true;
	let f; // undefined
	console.log("e:"+typeof e);
	console.log("f:"+typeof f);
	let i=["홍길동","심청이","강감찬"] // array
	console.log("i="+typeof i)
	let j={"name":"홍길동",age:20}; // Object
	console.log("j="+typeof j)
	let k=function(){}
	console.log("k="+typeof k)
	
	let m ="hello javascript"
	m="JAVAScript ES6"
	console.log("m="+m)	
	// 단점 => 데이터형 변경이 가능 => 가독성 (X)
	
	let o=10
	console.log("o="+typeof o)
	o="Hello"
	console.log("o="+typeof o)
	o={"name":"심청이",age:20}
	console.log("o="+typeof o)
	o=function(){}
	console.log("o="+typeof o)
	o=true
	console.log("o="+typeof o)

}
</script>
</head>
<body>

</body>
</html>