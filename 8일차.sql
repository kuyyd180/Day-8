/* CUSTOMERS 고객 정보를 출력하시오
    (1)젊은 고객부터 출력   (정렬: 젊은고객부터, 이름)
    (2)원하는 표현으로 출력 (성별, 나이, 국가[countries])
*/
SELECT CUST_NAME                                               이름
      ,DECODE(CUST_GENDER , 'M', '남자', 'F', '여자')            성별
      ,TO_CHAR(SYSDATE, 'YYYY') - CUST_YEAR_OF_BIRTH            나이
      ,CUST_CITY                                                도시                                      
      ,(select CUST_NAME
        from countries
        where country_id = a.country_id)                         국가
FROM customers a
    ,countries
ORDER BY 3 asc;

-- 직원과 고객의 실적내용이 많은 관계는?
-- 아래 쿼리를 -> 조인으로 바꿔서 출력하시오
select (select cust_name
        from customers
        where cust_id = a.cust_id)          as 구매고객
     ,(select emp_name
        from employees
        where employee_id = a.employee_id) as 판매직원
     , count(*)
from sales a
group by a.cust_id, a.employee_id
order by 3 desc;

-- 아래 쿼리를 -> 조인으로 바꿔서 출력하시오
select b.cust_name
    , c.emp_name
    , count(*)
from sales a
    , customers b
    , employees c
where a.cust_id = b.cust_id
and     a.employee_id = c.employee_id
group by b.cust_id, b.cust_name
        ,c.emp_name, c.emp_name
ORDER BY 3 DESC;

--세미 조인 (EXISTS <----- 존재하는) 
SELECT department_id
    , department_name
FROM departments a
WHERE not EXISTS (select 1
              from employees b
              where a.department_id = b. department_id);
-- 수강이력이 없는 학생 조회
SELECT *
FROM 학생 a
WHERE NOT EXISTS (select *
                  from 수강내역
                  where 학번 = a.학번);
/* ANSI JOIN
*/            
-- 일반 내부조인 (INNER JOIN)
SELECT *
FROM 학생
    ,수강내역
    ,과목
WHERE 학생.학번 = 수강내역.학번;
AND 수강내역.과목번호 = 과목.과목번호;
-- ANSI 내부조인 (조인관련 내용이모두 FROM절에 위치함)
SELECT *
FROM 학생
INNER JOIN 수강내역
ON(학생.학번 = 수강내역.학번)
INNER JOIN 과목
ON (수강내역.과목번호 = 과목.과목번호);
-- 일반 외부조인 OUTER JOIN
SELECT *
FROM 학생
    ,수강내역
    ,과목
WHERE 학생.학번 = 수강내역.학번(+)
AND 수강내역.과목번호 = 과목.과목번호(+);
-- ANSI 외부조인
SELECT *
FROM 수강내역
RIGHT JOIN 학생 -- OUTER <-- 숨김가능
ON(학생.학번 = 수강내역.학번)
RIGHT OUTER JOIN 과목
ON (수강내역.과목번호 = 과목.과목번호);

-- FULL OUTER JOIN
CREATE TABLE test_a (emp_id number);
CREATE TABLE test_b (emp_id number);
INSERT INTO test_a VALUES(10);
INSERT INTO test_a VALUES(20);
INSERT INTO test_a VALUES(40);

INSERT INTO test_b VALUES(10);
INSERT INTO test_b VALUES(20);
INSERT INTO test_b VALUES(30);

SELECT a.emp_id
      ,b.emp_id
FROM test_a a, test_b b
WHERE a.emp_id = b.emp_id; -- 일반조인에서는 안됨

SELECT a.emp_id
      ,b.emp_id
FROM test_a a
FULL OUTER JOIN test_b b
ON(a.emp_id = b.emp_id);

-- 2000년도 (검색조건) 판매(금액)왕을 출력하시오 (sales) 
-- 직원명은 서브쿼리사용 (select)
-- (1) sales 테이블을 활용하여 직원별 판매금액(amount_sold), 수량을 집계
-- (2) 판매금액 기준으로 정렬하여 1건 출력 (인라인 뷰 사용)
-- (3) 사번으로 employees 테이블 이용하여 이름가져오기 (스칼라서브쿼리사용)

select (select emp_name 
        from employees
        where employee_id = a.employee_id) as 직원
        , 판매수량 , to_char(판매금액, '999,999,999.99') as 판매금액
        
from( SELECT EMPLOYEE_ID
      ,SUM (QUANTITY_SOLD) 판매수량
      ,SUM (AMOUNT_SOLD)    판매금액
      FROM sales
      WHERE to_char(sales_date,'YYYY') = '2000'
      GROUP BY employee_id
      ORDER BY 3 desc
      ) a
WHERE rownum = 1;

-- 2000년도 최다판매상품 (수량으로) 1 ~ 3등까지 출력하시오
--(1) 필요한 컬럼 출력
--(2) 집계 및 정렬 후 3건 출력
--(3) 상품아이디로 상품명 출력

select (select PROD_NAME 
        from products
        where PROD_NAME = a.PROD_DESC)           as 상품명
            , to_char(판매금액, '999,999,999.99')           as 판매금액
        
from( SELECT PROD_DESC 
      ,SUM (PROD_LIST_PRICE)    판매금액
      ,SUM (QUANTITY_SOLD) 판매수량
      FROM products
      WHERE to_char(sales_date,'YYYY') = '2000'
      GROUP BY products
      ORDER BY 3 desc
      ) 
WHERE rownum = 3;

select *
from products;

