-- IN 연산자
-- 여러개의 값 중에서 어느 하나의 값과 일치하는지를 비교

-- 사원번호가 7369 이거나 7521 이거나 7782번의 사원을 검색
--1 Step
SELECT * FROM emp WHERE empno = 7369;
SELECT * FROM emp WHERE empno = 7521;
SELECT * FROM emp WHERE empno = 7782;

--2 Step
SELECT * FROM emp WHERE empno = 7782 OR empno = 7521 OR empno = 7369;

--3 Step
SELECT * FROM emp WHERE empno IN (7782,7521,7369);

-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
--사원번호가 7369가 아니고 7521 아니고 7782 아닌 사원을 검색
SELECT * FROM emp WHERE empno NOT IN (7782,7521,7369);

-- NULL을 걸러내고 써야함.
SELECT * FROM emp WHERE empno != 7782 AND empno != 7521 AND empno != 7369;


--문자 함수::SUBSTR(  )
--SUBSTR(문자열, 시작 위치, 개수)
select SUBSTR('HelloWorld',6) From dual;
select SUBSTR('HelloWorld',6,3) From dual;
select SUBSTR('HelloWorld',-4,2) From dual;

-- emp 테이블에서 사원이 이름이 N으로 끝나는 사원을 검색
select ename from emp where substr(ename,-1,1) = 'N';
select ename from emp where substr(lower(ename),-1,1) = 'n';
select ename from emp where ename like '%N';

-- emp 테이블에서 사원들의 입사년도만 검색
SELECT hiredate, substr(hiredate,1,2)  입사년도 from emp;

-- TRIM() : 공백을 제거하는 함수
SELECT rtrim('JAMES GOSLING              ') from dual;
SELECT ltrim('              JAMES GOSLING') from dual;
SELECT trim('              JAMES GOSLING            ') from dual;


--REPLACE() : 대체
select replace(job,'MAN','PERSON') NewJob from emp where job = 'SALESMAN';
select replace('              JAMES         GOSLING            ',' ','') from dual;

--숫자함수
--ROUND

/*
2번째 인자값 2의 의미는 소수점 이하 2자리까지 숫자를 나타내라는 뜻
이렇게 되기 위해서는 소수점 이하 3자리에서 실질적으로 반올림이 진행됨
*/
SELECT ROUND(45.923,2) FROM dual; -- 45.92
SELECT ROUND(45.923,0) FROM dual; -- 46
SELECT ROUND(45.923) FROM dual; -- 46
/*
두번째 인자값이 음수일 때는
.(점)을 중심으로 일, 십, 백, 천.... 단위로 거슬러 올라감

양수일 때와 달리 해당 자리에서 바로 반올림 일어남.
*/
SELECT ROUND(45.923,-1) FROM dual;  -- 50

-- FLOOR() :: 내림(소수점 아래를 버림)
SELECT FLOOR(45.923) FROM dual;

-- SELECT FLOOR(45.923,2) FROM dual; Floor()는 자리수 지정을 하지 않음.

--TRUNC() :: 자리수를 지정, 지정된 자리수 이하를 버림
SELECT TRUNC(45.923) FROM dual;
SELECT TRUNC(45.923,0) FROM dual;
SELECT TRUNC(45.923,2) FROM dual;

--CEIL() :: 올림 / FLOOR()의 반대 :: 자릿수 지정 안됨.
-- 즉, 정수를 결과값으로 나타냄
SELECT CEIL(45.923) FROM dual;

SELECT GREATEST(1,2,3) FROM dual;
SELECT LEAST(1,2,3) FROM dual;

-- 날짜 함수
SELECT SYSDATE FROM dual;
SELECT SYSTIMESTAMP FROM dual;

-- 그이를 만난지 100일째 되는 날 계산 법
SELECT SYSDATE + 100 FROM dual;

-- 내일
SELECT SYSDATE + 1 내일 FROM dual;

-- 어제
SELECT SYSDATE - 1 어제 FROM dual;
-- 여러분들이 그동안 살아오신 생애
SELECT TRUNC(SYSDATE - TO_DATE('00/02/29')) FROM dual;

SELECT extract (day from sysdate) 일자, extract(month from sysdate) 월, extract (year from sysdate) 년도 FROM dual;

SELECT ename, hiredate, extract(year from hiredate) year,
extract(day from hiredate) day
from emp
where deptno = 20;

SELECT ename, hiredate, sysdate, months_between(sysdate,hiredate) m_between,
trunc(months_between(sysdate,hiredate),0) t_between
FROM emp
WHERE deptno = 10
ORDER BY months_between(sysdate,hiredate) desc;

SELECT ename, hiredate, next_day(hiredate,'금요일') n_6,
next_day(hiredate,7) n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate desc;

-- 날짜와 날짜 사이의 개월 수 :: MONTHS_BETWEEND(DAY1, DAY2)
-- EMP 테이블에서 입사한 날로부터 "2023/07/25" 개월 수
-- 굳이 to_date를 하지 않아도 됨
SELECT abs(trunc(months_between(hiredate, '23/07/25'))) as 개월수 from emp;


-- 변환 함수
-- 급여를 3자리마다 , 출력
SELECT empno, ename, job, sal, to_char(sal,'999,999')
FROM emp
WHERE deptno = 20
ORDER BY sal desc;

-- EMP 테이블에서 20번 부서 중 입사 일자를 '1998년 1월 1일'의 형태로 출력하여라
SELECT ename, hiredate, to_char(hiredate, 'YYYY"년 "MM"월 "DD"일" ') t_kor
FROM emp
WHERE deptno = 20
ORDER BY hiredate desc;

-- to_number()
SELECT '0001230' 결과1, to_number('001230') 결과2 FROM dual;


--일반함수 : DECODE()
-- EMP테이블에서 업무가 PRESIDENT / 사장
--                                    MANAGER / 관리자,
--                                    ANALYST / 분석가,
--                                    기타        / 직원
--                                    직업분류
SELECT
DECODE( job,
'PRESIDENT','사장',
'MANAGER','관리자',
'ANALYST','분석가',
'직원'
) 직업분류
FROM emp;

SELECT
DECODE( sal,
5000,'OWNER  급여',
3000,'관리자',
'일반 급여'
) 급여구분
FROM emp;


SELECT
DECODE( sal,
5000,'OWNER  급여',
3000,'관리자',
'일반 급여'
) 급여구분
FROM emp;

SELECT ename, sal,
CASE WHEN sal = 5000 THEN 'OWNER 급여'
    WHEN sal = 3000 THEN '고액 급여'
    ELSE '일반 급여'
    END 급여구분
FROM emp;    