-- JOIN
-- ���� ���̺�κ��� �����͸� ������ �� ���Ǵ� ���

-- ������ ���� ���� ������
SELECT *
FROM EMP;

-- �μ��� ���� ������ ������
SELECT * FROM DEPT;

-- ����, �μ��� ���� ������ ������

SELECT * FROM EMP, DEPT;
-- �����غ���, ������ �μ����� ������ ����� ���� ����, �׳� �ܼ��� �ٿ��� ���ϱ�� ������.

/*
�ٷ� �� ó�� ���� ����� Cartesian Product��� ��.
emp�� dept���̺��� �ܼ� ���� ���� ���
14x4 = 56���� �ǹ���.

�̷� Cartesian Product�� ����Ǵ� ���� 2������.
1) ���� ������ ���ִ� ���
2) ���� ������ �� �� �ָ� �̷��� ��.
��� -- ���� ������ �� ����.
*/

-- STEP 1.
-- 1. ���� ������ ���� ���̺��� �������� �÷���, ���� ������ �Ǵ� �÷�.
-- 2. ���������� WHERE ���� ����, =�� ����ؼ� ���.

-- * ǥ���� �����ؾ��Ѵ�. Projection �䱸��.
SELECT * FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- STEP 2. 
-- DEPTNO ��� ���̺��� �����;� �ϴ��� ��Ȯ���� ����������
-- �÷��� ��ó�� ǥ������ ������, ���� ���̺� ��ü�� Ȯ���Ͽ� ���ɿ� ġ������ ������ ��.

-- STEP3. ������̺� ����
SELECT EMP.empno, EMP.ename, EMP.sal, EMP.DEPTNO, DEPT.DNAME
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;
 
-- STEP4.  
SELECT e.empno, e.ename, e.sal, e.DEPTNO, d.DNAME
FROM EMP e, DEPT d
WHERE e.DEPTNO = d.DEPTNO;

-- <����̸�, �޿�> e table, �μ���ȣ, <�μ��̸�, �μ���ġ> d table�� �˻�
-- �� �޿��� 2000 �̻��̰�, 30�� �μ��� ���ؼ���, �˻�...
SELECT E.ENAME, E.SAL, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = d.deptno
AND
E.SAL >= 2000
AND
D.DEPTNO =30;
-- ���� ���ǰ� �� ���� ������ �̷��� �̾�Ե�

-- ���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ���
SELECT E.ENAME, E.SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND
D.LOC = 'NEW YORK';

SELECT * FROM DEPT;







