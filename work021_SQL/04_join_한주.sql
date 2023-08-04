--JOIN
--여러 테이블로부터 데이터를 가져올 때 사용되는 기법


-- 직원에 대한 정보를 가져옴
SELECT * FROM emp;

-- 부서에 대한 정보를 가져옴
SELECT * FROM dept;

-- 직원, 부서에 대한 정보를 가져옴
SELECT * FROM emp, dept;

/*
위 처럼 나온 결과를 Cartesian Product라 한다.
emp와 dept 테이블의 수평적인 결합 결과
14 x 4 = 56 행

Cartesian Product가 도출되는 경우
1) Join 조건을 주지 않으면
2) Join 조건을 잘못 주면
*/

--step1
-- 1. 조인조건은 양쪽 테이블의 공통적인 컬럼이 조인 조건이 되는 컬럼이다.
-- 2. 조인조건은 where 절에 지정하고 = 를 사용해서 명시

-- * 표현은 자제 해야 한다. Projection 요구됨
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step2
--deptno 어느 테이블 것을 가져와야 하는지 ... 에러도출
-- 모든 테이블을 다 뒤적거리기 때문에 성능에 치명적인 영향을 끼친다.
SELECT empno, ename, sal, deptno, dname FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step3
SELECT empno, ename, sal, emp.deptno, dname FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step4
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname FROM emp e, dept d
WHERE e.deptno = d.deptno;

--사원이름, 급여, 부서번호, 부서이름, 부서위치를 검색
-- 단, 급여가 2000이상익 30번 부서에 한해서만 검색
-- WHERE 절에서 조인 조건과 함께 비조인 조건이 같이 나온다.
SELECT e.ename, e.sal, e.deptno, d.dname, d.loc
FROM emp e,dept d
WHERE e.sal >= 2000 AND e.deptno = 30 AND d.deptno = e.deptno;

-- 뉴욕에서 근무하는 사원의 이름과 급여를 검색
select e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND
d.loc = 'NEW YORK';

-- self 조인 - 하나의 테이블을 자체적을 조인함
-- 특정 사원의 상사의 이름을 검색

SELECT empno, ename, mgr FROM emp;

--1step
/*
    EMP E
1. 특정 사원의 ename을 조회해서 emp 테이블에서 찾는다... SMITH
2 SMITH의 상사번호 MGR을 조회..관리자번호를 찾는다... 7902
---------------------------------------------------------------------------------------------------
    EMP M
3. 다시 7902번호의 empno을 찾는다
4. empno가 7902번인 사원의 이름 ename을 찾는다.
*/

-- 1step
 SELECT empno, ename, mgr FROM emp; -- 사원의 상사번호를 찾고
SELECT empno, ename FROM emp; -- m 사원의 이름을 찾고

-- 2step
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m WHERE e.mgr = m.empno;

-- 3step Alias
SELECT e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 FROM emp e,
emp m WHERE e.mgr = m.empno ORDER BY 1;

--4step - 특정사원 (BLACKE)의 상사이름 검색
SELECT e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 FROM emp e,
emp m WHERE e.mgr = m.empno AND e.ename = 'BLAKE';

--OUTER JOIN
SELECT DISTINCT     deptno FROM emp;
SELECT deptno FROM dept;

SELECT e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
AND e.sal > 2000;