-- 그룹함수
/*
    COUNT, SUM, AVG, MAX, MIN
    
    SUM, AVG - 숫자 데이터에서만 작동함(날짜, 문자 불가능)
    
    COUNT, MAX, MIN - 모든 데이터에서 가능
    
*/

--COUNT()
--전체 사원수를 조회
SELECT COUNT(*) 전체사원수 FROM emp;
SELECT COUNT(empno) 전체사원수 FROM emp;
--ROW의 맨 끝에 있는 걸 사용
SELECT COUNT(-1) 전체사원수 FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;

-- 입사한지 가장 오래된 사원의 입사일과 가장 최근에 입사한 사원의 입사일을 검색
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

--부서번호가 10번이거나 20번 부서의 사원 수 검색
SELECT COUNT(-1) FROM emp WHERE deptno IN(10,20);

--emp 테이블에서 부서번호 수를 검색 :: DISTINCT로 중복 제거 후 개수 세기
SELECT COUNT(DISTINCT deptno) FROM emp;

-- 모든 사원의 보너스의 평균
-- step 1
SELECT AVG(comm) FROM emp;

--step 2
SELECT ROUND(AVG(NVL(comm,0))) as 보너스평균 FROM emp;

--사원의 급여의 평균값을 검색
-- step 1
-- 그룹 함수에 포함되지 않은 컬럼이 SELECT 절에 나열될 수 없다.
-- GROUP BY 절에 명시되어져야 한다.
SELECT deptno, AVG(sal) FROM emp;

--step 2
-- 부서별 평균 급여(세분화 과정)
SELECT deptno, ROUND(AVG(sal)) FROM emp GROUP BY deptno;

-- step 3
SELECT deptno, ROUND(AVG(sal)) "AvgSalary" FROM emp GROUP BY deptno ORDER BY 2;

-- step 4
SELECT deptno, ROUND(AVG(sal)) "AvgSalary" FROM emp GROUP BY deptno ORDER BY 2;

-- step 5
--부서별 급여의 평균을 검색... 10번 부서는 제외하고 검색... 정렬은 부서번호
-- deptno/DNumber , round(avg(sal)) AVGSAL
-- 실행순서
-- 1. FROM --> 2. WHERE --> GROUP BY --> SELECT --> ORDER BY
SELECT deptno DNumber, ROUND(AVG(SAL)) AVGSAL
FROM emp
WHERE deptno != 10
GROUP BY deptno
ORDER BY 2;

--입사 년도별 사원 수 검색
SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

--step1
SELECT EXTRACT(YEAR FROM hiredate) as 입사년도, COUNT(*) 인원수
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

--step2
SELECT to_char(hiredate,'YY') 년도별, COUNT(empno) 사원수 
FROM emp 
GROUP BY to_char(hiredate,'YY')
ORDER BY 1;

--step 1 WHERE 절에 그룹 함수 사용 못함(실행순서 차이)
-- alias도 사용 불가
SELECT deptno, ROUND(AVG(sal))
FROM emp a
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

--step 2 
-- GROUPING을 한 다음에 추려서 디스플레이 하다.
-- GROUP 함수 조건은 HAVING에 들어감(WHERER 아님)
SELECT deptno, ROUND(AVG(sal))
FROM emp a
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- 최대 급여가 2900달러가 넘는 부서들의 최대 급여를 출력
-- 1. 부서별 최대 급여 구하고
-- 2. 그 중에서 2900달러 넘는 부서들만 선택
SELECT deptno, MAX(sal)
FROM emp
GROUP by deptno
HAVING MAX(SAL) > 2900;

--ROLLUP을 통해서 그룹 함수 결과를 출력함
SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno,job,sum(sal) from emp
group by rollup(deptno,job) ORDER BY deptno;

SELECT deptno,job,sum(sal) from emp
group by rollup(job,deptno) ORDER BY job;

--GROUPING SETS
--step1
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);

--step2
SELECT to_char(deptno) ㅇ, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;

--step3
SELECT deptno||'', SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;

--step4
SELECT deptno, NULL job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal)
FROM emp
GROUP BY job;

/*
통계 쿼리 작성 시 동일한 쿼리문을 Group by 절에 작성하고 변경되는 부분들을 일일이 작성한 후 
UNION ALL로 결합하는 방식과
GROUPING SETS를 사용하는 방법이 있는데

GROUPING SETS를 사용한 방식이 훨씬 속도가 빠르다

*/

