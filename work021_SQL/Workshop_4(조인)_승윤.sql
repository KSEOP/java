-- ### equi join ###

-- 1.  emp�� dept Table�� JOIN�Ͽ� �μ���ȣ, �μ���, �̸�, �޿���  ����϶�.
SELECT e.deptno, d.dname, e.ename, e.sal 
FROM emp e, dept d
WHERE e.deptno = d.deptno;



-- 2.  �̸��� ��SMITH���� ����� �μ����� ����϶�.
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.ename = 'SMITH'
;


 
-- ### outer join ###
-- 3.  dept Table�� �ִ� ��� �μ��� ����ϰ�, emp Table�� �ִ� DATA�� JOIN�Ͽ� 
-- ��� ����� �̸�, �μ���ȣ, �μ���, �޿��� ��� �϶�.
SELECT e.ename, d.deptno, d.dname, e.sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;


-- ###self join###
-- 4.  emp Table�� �ִ� empno�� mgr�� �̿��Ͽ� ������ ���踦 ������ ���� ����϶�. ��SMTH�� �Ŵ����� FORD�̴١�
SELECT e.ename, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'SMITH';




-- ### join �ǽ� ###

-- 1. �����ڰ� 7698�� ����� �̸�, �����ȣ, �����ڹ�ȣ, �����ڸ��� ����϶�.
SELECT e.ename, e.empno, e.mgr, m.ename m_name
FROM emp e, emp m
WHERE e.mgr = 7698 AND e.mgr = m.empno;


-- 2. ������ MANAGER�̰ų� CLERK�� ����� �����ȣ, �̸�, �޿�, ����, �μ���
SELECT e.empno, e.sal, e.job, d.dname
FROM emp e, dept d
WHERE (e.deptno = d.deptno) AND (e.job = 'MANAGER' OR e.job = 'CLERK');









