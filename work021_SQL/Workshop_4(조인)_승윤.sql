-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.
SELECT e.deptno, d.dname, e.ename, e.sal 
FROM emp e, dept d
WHERE e.deptno = d.deptno;



-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.ename = 'SMITH'
;


 
-- ### outer join ###
-- 3.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
SELECT e.ename, d.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- ###self join###
-- 4.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
SELECT e.ename, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'SMITH';




-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.
SELECT e.ename, e.empno, e.mgr, m.ename m_name
FROM emp e, emp m
WHERE e.mgr = 7698 AND e.mgr = m.empno;


-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
SELECT e.empno, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE (e.deptno = d.deptno) AND (e.job = 'MANAGER' OR e.job = 'CLERK');









