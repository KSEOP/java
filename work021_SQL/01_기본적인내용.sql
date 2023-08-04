-- <= 주석

/*
 여러 라인 주석.
*/ 

SELECT * FROM emp

-- SELECT :: Projection | Selection
-- Projection : 원하는 컬럼만 가져옴

SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;

SELECT 
EMPNO, ENAME, JOB, DEPTNO 
FROM EMP; -- 이렇게 라인별로 구분 하는게 일종의 매너.

-- EMP 테이블에서 모든 사원의 이름과 입사일을 검색

-- 이렇게 필요한 것만 보는게 Projection (원하는 컬럼만 가져옴)
-- SELECTION은 원하는 "행"만 가져옴 -- WHERE 절로 조건을 부여해야함.
SELECT ENAME, HIREDATE FROM EMP
WHERE JOB='SALESMAN';
-- 실행 순서를 알아야 좋은 쿼리를 짠다
-- FROM 다음으로 WHERE절이 실행된다. 그렇게 행 수를 줄인다.

-- EMP 테이블에서 부서번호가 10번 부서인 사원의 이름, 업무, 급여, 부서번호 검색.
SELECT ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = '10';

-- 급여순 정렬... ORDER BY 정렬.. 가장 마지막에오고 작동도 마지막
SELECT ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = '10'
ORDER BY SAL DESC; -- 내림차순.

SELECT ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 10
ORDER BY 3 DESC; -- SQL은 첫번째가 1임. SQL을 많이 할수록 정수 컬럼넘버를 씀.


SELECT ENAME, JOB, SAL AS 급여, DEPTNO
FROM EMP
WHERE DEPTNO = 10
ORDER BY 급여 DESC; -- SQL은 첫번째가 1임. SQL을 많이 할수록 정수 컬럼넘버를 씀.
-- 별칭 정렬 가능.

-- 사원 중에서 입사일이 가장 빠른 사원 순으로 검색
SELECT ENAME, JOB, HIREDATE
FROM EMP
ORDER BY HIREDATE;

--
SELECT ENAME, JOB, HIREDATE
FROM EMP
ORDER BY 3;

-- 사원 중에서 급여를 많이 받는 순으로 정렬, 이름, 급여, 업무를 검색
SELECT ENAME, SAL, JOB
FROM EMP
ORDER BY 2 DESC;

-- 행을 나타내는 키워드 :: ROWNUM
-- 행을 제한할 때 사용
SELECT ENAME, SAL JOB, ROWNUM
FROM EMP
ORDER BY SAL DESC;


SELECT ENAME, SAL JOB, ROWNUM
FROM EMP
WHERE ROWNUM <=3
ORDER BY SAL DESC;
-- 왜 의도치 않은, ORDER BY 전에 ROWNUM 번호가 매겨지는가?
-- 정렬을 하고, ROWNUM이 나와야하는데 현재 그렇지 않음. // 오라클의 불편한점임
-- ORDER BY가 오라클에서는 ROWNUM보다 빨리, 제일 마지막에 실행됨.
-- MYSQL 에서는 LIMIT가 ORDER BY 다음에 동작해서 편함.

-- 정렬을 강제적으로 먼저 시킨 다음 ROWNUM 적용.
SELECT ENAME, SAL, JOB, ROWNUM AS RANKING 
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM<=3; 

/*
SELECT 구문의 서버 안에서 실행 순서
(문법 순서)
SELECT -> FROM -> WHERE -> ORDER BY
(실제 실행 순서)
1. ORACLE
FROM(테이블 찾기) -> WHERE(행 제한) -> SELECT(컬럼 제한)-> ROWNUM -> ORDER BY(정렬)

2. MYSQL
FROM(테이블 찾기) -> WHERE(행 제한) -> SELECT(컬럼 제한)-> ORDER BY(정렬) -> LIMIT

*/

/*
Alias
주로 산술 연산자가 적용된 컬럼에 Alias를 지정한다.
1. 컬럼명 as 별칭 | 컬럼명 별칭 | 컬럼명 "별칭"  -- 모두 가능.
2. "별칭" 따옴표는 별칭에 공백이 있거나 특수문자가 있을 때, 혹은 대소문자를 구분할 때 사용한다.

*/

-- 모든 사원의 급여를 기존급여에서 100을 더한 값의 2배로 증가, 결과출력(사원이름, 급여, 증가된 급여, 업무)
--1.
SELECT ENAME, SAL, ((SAL+100)*2), JOB
FROM EMP;

--2.
SELECT ENAME, SAL, ((SAL+100)*2) AS 증가급여, JOB
FROM EMP;

SELECT ENAME, SAL, ((SAL+100)*2) 증가급여, JOB
FROM EMP;
ORDER BY 증가급여;

SELECT ENAME, SAL, ((SAL+100)*2) AS 증가급여, JOB
FROM EMP
ORDER (SAL+100)*2;

SELECT ENAME, SAL, ((SAL+100)*2) AS 증가급여, JOB
FROM EMP
ORDER BY 3;

SELECT ENAME, SAL, ((SAL+100)*2) AS "증가 급여", JOB
FROM EMP
ORDER BY "증가 급여"; --오라클은 이 부분도 적용됨.!! 이거 MYSQL은 출력은 되는데 정렬 안된 상태로 나옴. (안됨).

-- 사원 급여에서 세금을 제외하고 수령한 급여를 검색(세금을 급여의 10%로 간주)
-- 이름, 업무, 급여, 실제 수령한 급여 -- 정렬은 실제 수령한 급여 순으로
SELECT ENAME, JOB, SAL, SAL-(SAL*0.1) AS "실제 수령한 급여"
FROM EMP
ORDER BY 4;

-- 사원의 급여와 연봉을 검색
SELECT ENAME, SAL, SAL*12 AS "AnnualSalary"
FROM EMP;

-- 커미션이 NULL인 사원이 있음. 그리고 NULL은 연산에서 제외됨.
-- NULL은 연산할 수 없는 값임.
SELECT ENAME, SAL, SAL*12+COMM AS "AnnualSalary"
FROM EMP;

/*
 NULL 정리
 1. 0도 아니고 공백도 아니다.
 2. 나름의 의미를 가지는 값이다.
    "자격 없음" 혹은 "미확정(Unknown)" 을 뜻하는 값일 때 주로 사용된다.
 3. 연산 적용 안됨.(+, -, *, /), 비교도 불가함(=, !=, ><, >, <, >=, <=)
 4. null 값을 가지고 연산해야 할 때에는 다른 값으로 치환시켜서 연산한다. -- NVL()함수를 사용. MYSQL은 IFNULL() 있음.
 5. 오라클에서 NULL값은 가장 큰 값으로 취급된다. MYSQL은 반대로 가장 작은 값으로 취급된다.
*/

SELECT JOB, COMM FROM EMP ORDER BY COMM DESC; -- NULL이 상단에 배치됨. 즉 NULL은 가장 큰 값처럼 처리됨. MYSQL은 NULL 값이 가장 작은 값으로 처리됨.

--

SELECT ENAME, SAL, SAL*12+NVL(COMM, 0) AS "AnnualSalary"
FROM EMP;

-- EMP 사원 중에서 COMM이 NULL인 사원의 이름과 업무 급여를 검색
-- NULL값은 비교 불가라 아래와 같이 하면 출력되는 결과물 없음.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE COMM = NULL;

-- 아래 처럼 IS NULL, 또는 IS NOT NULL 써줘야함.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE COMM IS NULL;

--EMP 테이블에서 업무가 SALESMAN인 사원의 이름, 급여, 연봉 검색.
--연봉이 높은 순에서 낮은 순으로
SELECT ENAME, SAL, (SAL*12)+NVL(COMM,0) AS "연봉"
FROM EMP
WHERE JOB = 'SALESMAN' -- ALIAS만 쌍따옴표 가능함. 그 외엔 단일 따옴표 해야함.
ORDER BY 연봉 DESC;

-- 커미션을 가장 많이 받는 사원 순으로 검색(사번, 이름, 업무, COMM)
SELECT EMPNO, ENAME, JOB, COMM
FROM EMP
ORDER BY COMM DESC;
-- 이렇게 쓰면 제대로 안나옴
-- 아래 처럼 그냥 NULL이면 없애버리는 방식 가능
SELECT EMPNO, ENAME, JOB, COMM
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY COMM DESC;

-- EMP TABLE에서, 부서(번호)를 검색
-- 이러면 중복으로 부서 번호를 다보여줌. 즉 부서의 개수에 비해 너무 많이 보여주게됨.
SELECT DEPTNO FROM EMP;

--STEP1. 중복을 제거하는 DISTINCT가 있음. 단 정렬까지 해주지는 않음.
SELECT DISTINCT DEPTNO FROM EMP;

--STEP2.
SELECT DISTINCT DEPTNO FROM EMP 
ORDER BY 1;

SELECT DISTINCT(DEPTNO) FROM EMP 
ORDER BY 1;

/*
DISTINCT
중복을 벗겨내는 키워드.

1. SELECT절 바로 뒤에 온다.
2. 10G 버전부터 정렬 기능이 빠져있어서 별도로 정렬을 해줘야함.
+ 현업에서 성능상 매우 치명적인 키워드임. -- 모든 데이터를 전수조사하므로...
3. 중복값을 제거하는 연산은 많은 시간이 걸린다.
   만약, 불가피하게 사용해야하는 상황이라면 DISTINCT 연산을 대체하는 방법이나
   혹은 연산의 대상이 되는 테이블의 크기를 최소화 하는 방법을 제안한다.
   
   가장 대표적인 방법, EXIST를 활용하는 방법이 있다.
   
*/

SELECT DEPTNO FROM DEPT D
WHERE EXISTS(
SELECT * FROM EMP E
WHERE D.DEPTNO = E.DEPTNO);


/*
 LIKE 연산자와 와일드카드(%,_)
 특정 단어가 포함되어 있는 데이터를 검색할 때 많이 사용함.
 
*/
-- 사원의 이름 중에서 S로 시작하는 사원을 검색.
SELECT ENAME FROM EMP
WHERE ENAME LIKE 'S%'; 
-- S% : %는 0혹은 MANY. S 뒤에 아무것도 없어도되고, 그냥 있거나 많이 있어도 되고.
-- %S : S로 끝나는 사원.
-- '_S%' : _ 는 반드시 1개와 매핑됨. 2번째 글자가 S인 이름. 뒤는 상관 없음.

-- 사원의 이름 중에서 S가 포함된 이름의 사원을 검색.
SELECT ENAME FROM EMP
WHERE ENAME LIKE '%S%'; 
-- 두번째 문자에 A가 들어가 있는 이름의 사원을 검색
SELECT ENAME FROM EMP
WHERE ENAME LIKE '_A%'; 
-- 81년도에 입사한 사원을 검색
SELECT ENAME, HIREDATE FROM EMP
WHERE HIREDATE LIKE '81%'; 

