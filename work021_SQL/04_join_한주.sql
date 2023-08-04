--JOIN
--���� ���̺�κ��� �����͸� ������ �� ���Ǵ� ���


-- ������ ���� ������ ������
SELECT * FROM emp;

-- �μ��� ���� ������ ������
SELECT * FROM dept;

-- ����, �μ��� ���� ������ ������
SELECT * FROM emp, dept;

/*
�� ó�� ���� ����� Cartesian Product�� �Ѵ�.
emp�� dept ���̺��� �������� ���� ���
14 x 4 = 56 ��

Cartesian Product�� ����Ǵ� ���
1) Join ������ ���� ������
2) Join ������ �߸� �ָ�
*/

--step1
-- 1. ���������� ���� ���̺��� �������� �÷��� ���� ������ �Ǵ� �÷��̴�.
-- 2. ���������� where ���� �����ϰ� = �� ����ؼ� ���

-- * ǥ���� ���� �ؾ� �Ѵ�. Projection �䱸��
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step2
--deptno ��� ���̺� ���� �����;� �ϴ��� ... ��������
-- ��� ���̺��� �� �����Ÿ��� ������ ���ɿ� ġ������ ������ ��ģ��.
SELECT empno, ename, sal, deptno, dname FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step3
SELECT empno, ename, sal, emp.deptno, dname FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step4
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname FROM emp e, dept d
WHERE e.deptno = d.deptno;

--����̸�, �޿�, �μ���ȣ, �μ��̸�, �μ���ġ�� �˻�
-- ��, �޿��� 2000�̻��� 30�� �μ��� ���ؼ��� �˻�
-- WHERE ������ ���� ���ǰ� �Բ� ������ ������ ���� ���´�.
SELECT e.ename, e.sal, e.deptno, d.dname, d.loc
FROM emp e,dept d
WHERE e.sal >= 2000 AND e.deptno = 30 AND d.deptno = e.deptno;

-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� �˻�
select e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno AND
d.loc = 'NEW YORK';

-- self ���� - �ϳ��� ���̺��� ��ü���� ������
-- Ư�� ����� ����� �̸��� �˻�

SELECT empno, ename, mgr FROM emp;

--1step
/*
    EMP E
1. Ư�� ����� ename�� ��ȸ�ؼ� emp ���̺��� ã�´�... SMITH
2 SMITH�� ����ȣ MGR�� ��ȸ..�����ڹ�ȣ�� ã�´�... 7902
---------------------------------------------------------------------------------------------------
    EMP M
3. �ٽ� 7902��ȣ�� empno�� ã�´�
4. empno�� 7902���� ����� �̸� ename�� ã�´�.
*/

-- 1step
 SELECT empno, ename, mgr FROM emp; -- ����� ����ȣ�� ã��
SELECT empno, ename FROM emp; -- m ����� �̸��� ã��

-- 2step
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e,
(SELECT empno, ename FROM emp) m WHERE e.mgr = m.empno;

-- 3step Alias
SELECT e.empno �����ȣ, e.ename ����̸�, m.ename ����̸� FROM emp e,
emp m WHERE e.mgr = m.empno ORDER BY 1;

--4step - Ư����� (BLACKE)�� ����̸� �˻�
SELECT e.empno �����ȣ, e.ename ����̸�, m.ename ����̸� FROM emp e,
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