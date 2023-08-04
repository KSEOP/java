-- ##################  그룹 함수 실습 ######################

-- 1)  30번 부서 월급의 평균(소수2자리 아래 올림), 최고, 최저, 인원수를 구하여 출력하라.
-- 올림은 CEIL이다. CEIL은 자릿수 지정이없으므로, *100을 해서 2자리를 올린 후,
-- 올린 값의 CEIL을 이용해서(같거나 하나 큰 정수가 나옴) 2자리 아래를 올린 것 처럼 하고
-- 다시 100 나눠서 소숫점 2자리를 만듬
-- 올림인데 안일하게 그냥 라운드도 차이없지않나 함. 그래선안됨.

SELECT CEIL(AVG(SAL)*100)/100, MAX(SAL), MIN(SAL), COUNT(-1) 
FROM EMP
WHERE DEPTNO = 30;

-- 2) 각 부서별 급여의 평균(소수이하 반올림), 최고, 최저, 인원수를 구하여 출력하라.
SELECT DEPTNO, ROUND(AVG(SAL)), MAX(SAL), MIN(SAL), COUNT(-1)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;


-- 3) 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호,업무명, 인원수를 출력하라.
SELECT DEPTNO, JOB, COUNT(*) FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO; --SOL
-- GROUP BY ROLLUP(DEPTNO, JOB); -- 내가쓴답, 소계 구하란 말이없다. 그리고 결과물도 조금 이상함. 이렇게쓰면


-- 4) 같은 업무를 하는 사람의 수가 2명 이상인 업무와 인원수를  출력하라.
SELECT JOB, COUNT(-1) FROM EMP
GROUP BY JOB
HAVING COUNT(-1)>=2;


-- 5) 각 부서별 평균 월급(소수이하 버림), 전체 월급, 최고 월급, 최저 월급을 구하여 평균 월급이 많은 순으로 출력하라. 
SELECT DEPTNO, TRUNC(AVG(SAL)) 평균, SUM(SAL), MAX(SAL), MIN(SAL) FROM EMP
GROUP BY DEPTNO
ORDER BY 평균 DESC;
--ORDER BY TRUNC(AVG(SAL)) DESC;
-- ************************************* 이부분부터 SOL 리뷰 추가 필요

-- 6) 각 부서별 같은 업무를 하는 사람의 급여의 합계를 구하여 부서번호,업무명별 급여의 소계와 총합을 출력하라.
-- 부서별 정렬한다.
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO;


-- 7) 각 부서별 인원수를 조회하되 인원수가 5명 이상인 부서만 출력되도록 하시오.
SELECT DEPTNO, COUNT(-1) FROM EMP
GROUP BY DEPTNO
HAVING COUNT(-1) >= 5;

-- 8)  각 부서별 최대급여와 최소급여를 조회하시오.
--   단, 최대급여와 최소급여가 같은 부서는 직원이 한명일 가능성이 높기때문에 조회결과에서 제외시킨다.
SELECT DEPTNO, MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL)!=MIN(SAL)
ORDER BY DEPTNO;

/* 9) 부서가 10, 20, 30 번인 직원들 중에서 급여를 2500 이상 5000 이하를 받는
   직원들을 대상으로 부서별 평균 급여를 조회하시오.
   다, 평균급여가 2000 이상인 부서만 출력되어야 하며, 출력결과를 평균급여가 높은
   부서먼저 출력되도록 해야 한다. */

SELECT DEPTNO, ROUND(AVG(SAL),0) FROM EMP
WHERE DEPTNO IN (10,20,30)
GROUP BY DEPTNO
HAVING AVG(SAL) BETWEEN 2500 AND 5000;



 -- 10)