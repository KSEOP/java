-- IN연산자
-- 여러개의 값 중에서 어느 하나의 값과 일치하는 지를 비교

-- 사원번호가 7369이거나, 7521이거나, 7782번인 사원을 검색

-- 1 STEP
SELECT* FROM EMP WHERE EMPNO=7369;
SELECT* FROM EMP WHERE EMPNO=7521;
SELECT* FROM EMP WHERE EMPNO=7782;
-- 3번 접근하는 가장 안좋은 방법.

-- 2 STEP
SELECT * FROM EMP WHERE EMPNO=7369 OR EMPNO=7521 OR EMPNO=7782; 

-- 3 STEP
SELECT * FROM EMP WHERE EMPNO IN(7369, 7521, 7782); 

-- ////////////////
-- 사원 번호가 7369가 아니고, 7521도 아니고 7782도 아닌 사원을 검색.
SELECT * FROM EMP WHERE EMPNO NOT IN(7369, 7521, 7782);
-- 논리 연산자로 바꾸기.
SELECT * FROM EMP WHERE EMPNO !=7369 AND EMPNO !=7521 AND EMPNO !=7782;
-- 문제가 될 소지가 있음. --> NULL이 있는 컬럼이 있으면 비교 불가해짐.
-- AND 는 다루는 것들이 모두 문제가 없어야함.
-- 즉 IN을 쓸 때, NULL 주의 해야함.



-- 문자 함수 :: SUBSTR()
-- SUBSTR(문자열, 시작위치, 추출할 개수)
SELECT SUBSTR('HelloWorld',6) FROM DUAL; -- 추출개수 안쓰면 끝까지 다 나옴.

-- WOR 추출
SELECT SUBSTR('HelloWorld',6,3) FROM DUAL;

SELECT SUBSTR('HelloWorld',-4,2) FROM DUAL;

-- EMP테이블에서 사원의 이름이 N으로 끝나는 사원을 검색 :: SUBSTR(), LIKE() 사용
SELECT ENAME FROM EMP
WHERE SUBSTR(ENAME,-1,1)='N';

SELECT ENAME FROM EMP
WHERE SUBSTR(LOWER(ENAME),-1,1)='n';

SELECT ENAME FROM EMP
WHERE ENAME LIKE '%N';

-- EMP테이블에서 사원들의 입사년도만 검색
SELECT SUBSTR(HIREDATE,1,2) 년도 FROM EMP;

-- TRIM() :: 공백을 제거하는 함수
SELECT RTRIM('JAMES GOSLING            ') NAME FROM DUAL;
SELECT LTRIM('            JAMES GOSLING') NAME FROM DUAL;
SELECT TRIM('      JAMES GOSLING       ') NAME FROM DUAL;

--REPLACE(): 
SELECT REPLACE(JOB, 'MAN', 'PERSON') NEWJOB FROM EMP
WHERE JOB='SALESMAN';

--TRIM 대신 REPLACE로 
SELECT REPLACE('         JAMES   GOSLING  IS   GOOD    ',' ','') MESSAGE FROM DUAL;


--숫자함수ㅡ

--ROUND
/*
2번째 인자값 2ㅢ 의미는 소수점 이하 2자리 까지 숫자를 나타내라는 뜻
이렇게 되기 위해서는 소수점 이하 3자리에서 실질적으로 반올림이 진행된다.
*/
SELECT ROUND(45.923, 2) FROM DUAL; -- 2는 소수점 2자리 까지 출력하겠다. == 3째 자리에서 반올림 하겠다.

SELECT ROUND(45.923, 0) FROM DUAL; -- 정수표시 / 디폴트

SELECT ROUND(45.923) FROM DUAL; -- 디폴트 적용된 것.

/*
2번째 인자 값이 음수일 때에는,

45 . 923
. 점을 중심으로 일 십 백... 단위로 거슬로 올라감.
<<양수일 때와 달리 해당 자리에서 바로 반올림이 일어남.>>
*/
SELECT ROUND(45.923, -1) FROM DUAL;

-- FLOOR() :: 내림(소수점 아래를 버림)

SELECT FLOOR(45.923) FROM DUAL;

-- SELECT FLOOR(45.923, 2) FROM DUAL; -- 오류남. FLOOR는 자릿수를 지정 못함. 소숫점은 무조건 다 버리도록 만들어짐.
SELECT FLOOR(7.6) FROM DUAL;

-- TRUNC() :: 버림. FLOOR와 차이점은 "자릿수 지정" 가능. == 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923) FROM DUAL;

SELECT TRUNC(45.923, 0) FROM DUAL;

SELECT TRUNC(45.923, 2) FROM DUAL; -- 소수점 2째 자리까지 출력, 미만은 버림

-- CEIL()::올림 / FLOOR()의 반대 :: 자릿수 지정 안됨.

SELECT CEIL(45.923) FROM DUAL; -- 자릿수 지정안됨 == 정수로 나타내겠다.

SELECT CEIL(45.923,2) FROM DUAL; -- 즉 오류 발생.

--

SELECT GREATEST(1,2,3) FROM DUAL; -- 최대값 하나 출력
SELECT LEAST(1,2,3) FROM DUAL; -- 최솟값 하나 출력


-- 날짜 함수
SELECT SYSDATE FROM DUAL;

SELECT SYSTIMESTAMP FROM DUAL;

-- 오늘로 부터. 100일
SELECT SYSDATE+100 FROM DUAL;
SELECT SYSDATE+1 내일 FROM DUAL;
SELECT SYSDATE-1 어제 FROM DUAL;

-- 여러분들이 그동안 살아오신 생애
-- 오늘에서, 생년월일 빼기.
SELECT TRUNC(SYSDATE-TO_DATE('94/04/06')) 살아온생애 FROM DUAL;

SELECT TRUNC(SYSDATE-TO_DATE('2000/04/17')) 살아온생애 FROM DUAL;

SELECT EXTRACT(DAY FROM SYSDATE) 일자, EXTRACT(MONTH FROM SYSDATE) 월, EXTRACT(YEAR FROM SYSDATE) 년도 FROM DUAL;

--예제 7 사원의 이름, 입사일, 입사년도, 입사 월 정보를 조회하라.
SELECT ENAME, HIREDATE, EXTRACT(YEAR FROM HIREDATE) "YEAR", EXTRACT(MONTH FROM HIREDATE) "MONTH" FROM EMP;

--근무 월수 계산 69P
SELECT ENAME, HIREDATE, SYSDATE, MONTHS_BETWEEN(SYSDATE, HIREDATE) 근무월수, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE),0) T근무월수 FROM EMP
WHERE DEPTNO = 10
ORDER BY 4;

--입사일자로부터 돌아오는 금요일, 토요일 계산
SELECT ENAME, HIREDATE, NEXT_DAY(HIREDATE, '금요일') 돌아오는금요일, 
       NEXT_DAY(HIREDATE, '토요일') 돌아오는토요일 
FROM EMP;

-- 날짜와 날짜 사이의 개월수 :: MONTHS_BETWEEN(DAY1, DAY2)
-- EMP 테이블에서 사원이 입사한 날로부터 2023년 07/25 일 까지의 일한 개월 수.
SELECT TRUNC(MONTHS_BETWEEN(HIREDATE, '2023/07/25')) FROM EMP;
-- TO_DATE 안썼는데도 자동 형변환을 했음.
-- 1. 명시적 형변환
-- 2. 자동 형변환 V
-- 결괏값이 음수임.
-- 1. 두 인자 자리를 바꾼다
-- 2. ABS() 절댓값 쓰기.
SELECT ABS(TRUNC(MONTHS_BETWEEN(HIREDATE, '2023/07/25'))) FROM EMP;

-- 3자리 마다 , 출력
SELECT EMPNO, ENAME, JOB, SAL, TO_CHAR(SAL, '999,999')
FROM EMP
WHERE DEPTNO = 20
ORDER BY SAL DESC;

-- YYYY MM DD 형태 출력
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY"년" MM"월" DD"일"') 입사일자
FROM EMP
WHERE DEPTNO=20
ORDER BY HIREDATE DESC;

-- 77P 예제 7 추후 수행



-- 일반함수 :: DECODE()
-- EMP 테이블에서 업무가 PRESIDENT / 사장,
--               업무가 MANAGER / 관리자,
--               업무가 ANALYST / 분석가,
--                         기타 / 직원, 
--                         ALIAS = 직업분류

SELECT EMPNO, ENAME, 
        DECODE(JOB, 'ANALYST', '분석가',
                    'PRESIDENT', '사장',
                    'MANAGER', '관리자',
                    '직원') AS 직업분류
        FROM EMP;
--
SELECT EMPNO, ENAME,
        DECODE(SAL, '5000', 'OWNER 급여', '3000', '고액급여', '일반급여') AS 급여구분
FROM EMP;
--
-- CASE WHEN 쓰기
SELECT EMPNO, ENAME, SAL, CASE WHEN SAL=(SELECT MAX(SAL) FROM EMP) THEN 'OWNER 급여'
                               WHEN SAL=3000 THEN '고액급여'
                               ELSE '일반급여' END "급여구분" -- ELSE 처리 안해주면 그 외 케이스는 NULL이 들어감.
FROM EMP;












