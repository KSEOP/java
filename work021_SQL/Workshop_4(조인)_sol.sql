-- ### equi join ###

-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.

select  dept.deptno, dname, ename, sal
from emp , dept 
where emp.deptno = dept.deptno 
order by dept.deptno;

-- =====================================
select d.deptno, d.dname, e.ename, e.sal 
from emp e  join dept d on e.deptno=d.deptno
order by d.deptno;
-- =====================================
select deptno, d.dname, e.ename, e.sal 
from emp e  join dept d using (deptno);

-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.

select  dname
from emp, dept
where emp.deptno  = dept.deptno  and emp.ename='SMITH';
-- ========================================
select d.dname, e.ename
from emp e  join  dept d using (deptno)
where  e.ename='SMITH';

select d.dname, e.ename
from emp e  join  dept d on e.deptno=d.deptno
where  e.ename='SMITH';

 
-- ### outer join ###
-- 3.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;

-- ========================================

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e RIGHT JOIN  dept d
ON e.deptno(+)=d.deptno;



-- ###self join###
-- 4.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’


-- 연결 연산자 사용  || 

SELECT  e.ename  ||' 의 매니저는 ' || m.ename || '이다.'
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and m.empno = 7698;

select  e.ename, e.empno, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno and e.mgr = 7698;
-- ========================================
select e1.ename ename, e1.empno empno, e1.mgr, e2.ename
from  emp e1 JOIN  emp e2 ON  e1.mgr= e2.empno
WHERE e1.mgr='7698';

-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and (  job='MANAGER' or job='CLERK');

select empno, ename, job, dname
from emp, dept
where emp.deptno =  dept.deptno and  job in ('MANAGER' ,'CLERK');

-- ========================================
  select empno, ename, job, deptno, dname
  FROM   emp   JOIN dept   USING (deptno)
  WHERE  job ='MANAGER' or job='CLERK'  ;








