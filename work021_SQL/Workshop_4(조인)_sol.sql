-- ### equi join ###

-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.

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

-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.

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
-- 3.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;

-- ========================================

SELECT e.ename, e.deptno, d.dname, e.sal
FROM emp e RIGHT JOIN  dept d
ON e.deptno(+)=d.deptno;



-- ###self join###
-- 4.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�


-- ���� ������ ���  || 

SELECT  e.ename  ||' �� �Ŵ����� ' || m.ename || '�̴�.'
FROM emp e, emp m
WHERE e.mgr = m.empno;



-- ### join �ǽ� ###

-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.

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

-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���
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








