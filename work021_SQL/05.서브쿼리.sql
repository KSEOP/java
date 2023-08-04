--Sub Query
-- ? 에 해당하는 부분을 ( ) 안에 먼저 수행하고, 그 결과가 main 쿼리에서 실행
-- CLARK의 급여보다 더 많은 급여를 받는 사원의 이름과 급여, 업무를 검색
-- 위 문장에서 ? 는 CLARK의 급여임.

SELECT ENAME, SAL, JOB
FROM EMP
WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='CLARK'); -- 1. CLARK의 급여가 나오는 곳.

-- 용어정리
-- MAIN 쿼리  = OUTER 쿼리
-- 서브쿼리    = INNER 쿼리

-- 서브쿼리가 먼저 실행이됨. 
-- 1의 서브쿼리에서는 결과물로 결과가 1줄나옴. (1ROW 1COL)
-- 이렇게 1개의 값, 단독값을 "스칼라" 값이라고 함. -- [스칼라 -- 1ROW 1COL] 
-- 즉 위 형태의 서브쿼리를 '스칼라 서브쿼리' 라고 함.
-- 즉 SAL > 스칼라(2490) 형태이므로 >, <, = 와 같은 연산자를 씀.
-- >, <, = 은 "단일행 연산자"로 이럴 때 사용 가능함.
/*
즉 서브쿼리가 만약 "여러개의 결과값"을 내놓는 경우라면
>, < 와 같은 단일행 연산자가 아닌
"IN" 을 써야한다.

즉 실행 순서는

WHERE 서브쿼리 -- 1.
아우터(메인) 쿼리 -- 2.


3. 서브쿼리 절에서는 'ORDER BY'절이 딱히 의미가 없다.
WHY? -- 어차피 메인쿼리에서 할 가능성이 높으므로.

결론적으로 ? 를 해결하는 것이 서브쿼리 활용의 목적임.
*/

--예제1) 7566 사원보다 급여를 많이 받는 사원의 이름, 급여
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE EMPNO=7566);

--예제2) EMP 테이블에서 사원번호가 7521인 사원과 업무가 같고 급여가 7934인 사원보다
-- 많은 사원의 사원번호, 이름, 담당업무, 입사일자, 급여를 조회하라.

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE EMPNO = 7521)
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7934);

--예제3) EMP 테이블에서 급여를 제일 많이 받는 사원의 이름 부서 급여 입사일
-- 작성 필요

SELECT ENAME, DEPTNO, SAL, HIREDATE
FROM EMP
WHERE SAL = (SELECT MAX(SAL) FROM EMP);





-- 10번 부서에서 근무하는 사원 중에서, 사원의 전체 평균 급여보다 더 많은 급여를 받는 사원을 검색.
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=10
AND SAL>(SELECT AVG(SAL) FROM EMP); -- AVG 보면 스칼라임을 이해해야함


-- JOB별 가장 작은 평균급여를 검색.... 업무, 평균 급여를 출력
-- 여기서 '?' 는  '가장 작은 평균 급여' 임. JOB별 이므로 GROUP BY 필요할 것.


-- [[[  HAVING절 뒤에오는 서브쿼리  ]]]
-- 그룹함수 중첩
SELECT JOB, ROUND(AVG(SAL))
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MIN(AVG(SAL)) FROM EMP GROUP BY JOB); -- MYSQL에서는 이게 안됨(그룹 함수 중첩을 못함)
-- 오라클은 이렇게, 그룹함수 중첩이 가능하다.


-- 아래 서브쿼리 코드가 먼저 돌고, 위의 쿼리 실행됨.
SELECT MIN(AVG(SAL)) FROM EMP GROUP BY JOB;

-- FROM절 뒤에 오는 서브쿼리.
-- 사원 중에서 급여를 가장 많이 받는 사원 랭킹 3을 검색

SELECT ENAME, ROWNUM 급여순위
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM <=3;


-- 모든 서브쿼리 중에서 가장 많은 유형이 WHERE 뒤에 쓰는게 많음. 대부분임.
-- HAVING절 뒤의 서브쿼리는? -- 그룹함수 ? 가 있을 때.
-- 위처럼 순위대로 뽑아야할 때에는 FROM 절에 쓰는 듯.

--//////////////////////////////////
-- SCOTT 급여보다 더 많은 급여를 받는 사원 검색 (가장 전형적인 서브쿼리
-- WHERE절 서브쿼리

-- STEP1.
SELECT ENAME, JOB 
FROM EMP
WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='SCOTT');

-- STEP2.
SELECT A.ENAME, A.JOB, A.SAL FROM EMP A, (SELECT SAL FROM EMP WHERE ENAME='SCOTT') B
WHERE A.SAL > B.SAL;
-- 여기서는 메인 쿼리의 셀렉트에 * 해도 되긴함. A.~~ 하기 싫다면.

-- 부서별 최저값 SAL를 갖는 직원 정보
-- 에러 발생
-- 다중행 서브쿼리에서 단일행 연산자 사용
-- 다중행 서브쿼리에서는 다중행 연산자를 사용해야함.
SELECT EMPNO, ENAME
FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO);

SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO; -- 다중행 서브쿼리.

SELECT EMPNO, ENAME
FROM EMP
WHERE SAL IN (SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO);


-- 160 예제2)
SELECT ENAME, SAL, JOB
FROM EMP
WHERE JOB!='SALESMAN'
AND
SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN')
ORDER BY ENAME;
-- 강사님 선호형태 (나도 이게 나은듯함)
SELECT ENAME, SAL, JOB
FROM EMP
WHERE JOB!='SALESMAN'
AND
SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN')
ORDER BY ENAME;

--161 예제3) 업무가 SALESMAN인 모든 사원보다 급여를 많이 받는 사원의 이름 급여 어부 입사일 부서번호
SELECT ENAME, SAL, JOB, HIREDATE, DEPTNO
FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')
AND JOB != 'SALESMAN';

-- 부서 번호가 30번인 사원의 급여 중에서 가장 낮은 급여(950)보다 더 높은 급여를 받는
-- 사원의 이름, 급여, 부서번호
-- 1) 그룹함수
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30')
ORDER BY ENAME;

-- 2) 다중행 연산자.
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO='30')
ORDER BY ENAME;


-- 서브쿼리에서 NULL 값.
-- EMP 테이블에서 부하직원을 거느린 사원 검색

SELECT ENAME FROM EMP
WHERE EMPNO IN (SELECT NVL(MGR,'') FROM EMP);

-- 강사님 쿼리 1
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);
-- 셀프 조인도 해본 강사님 쿼리
SELECT E.ENAME, E.EMPNO FROM EMP E WHERE E.EMPNO IN (SELECT M.MGR FROM EMP M);

--EMP 테이블에서 부하직원을 거느리지 않는 사원
SELECT ENAME FROM EMP
WHERE EMPNO NOT IN (SELECT NVL(MGR, 0) FROM EMP);
-- 아무것도 안나옴. 왜냐하면 NOT IN 은 '아니다' 가 AND로 연결됨
-- 그리고 MGR에는 NULL값이 있음.
-- NULL은 비교 연산자를 못써서 레코드가 안나와버림. 하나라도 있으면 전체가 안나옴. 그래서 NOT IN이 안됨






