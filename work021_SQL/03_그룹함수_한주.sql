-- �׷��Լ�
/*
    COUNT, SUM, AVG, MAX, MIN
    
    SUM, AVG - ���� �����Ϳ����� �۵���(��¥, ���� �Ұ���)
    
    COUNT, MAX, MIN - ��� �����Ϳ��� ����
    
*/

--COUNT()
--��ü ������� ��ȸ
SELECT COUNT(*) ��ü����� FROM emp;
SELECT COUNT(empno) ��ü����� FROM emp;
--ROW�� �� ���� �ִ� �� ���
SELECT COUNT(-1) ��ü����� FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal) FROM emp;

-- �Ի����� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� �˻�
SELECT MIN(hiredate), MAX(hiredate) FROM emp;

--�μ���ȣ�� 10���̰ų� 20�� �μ��� ��� �� �˻�
SELECT COUNT(-1) FROM emp WHERE deptno IN(10,20);

--emp ���̺��� �μ���ȣ ���� �˻� :: DISTINCT�� �ߺ� ���� �� ���� ����
SELECT COUNT(DISTINCT deptno) FROM emp;

-- ��� ����� ���ʽ��� ���
-- step 1
SELECT AVG(comm) FROM emp;

--step 2
SELECT ROUND(AVG(NVL(comm,0))) as ���ʽ���� FROM emp;

--����� �޿��� ��հ��� �˻�
-- step 1
-- �׷� �Լ��� ���Ե��� ���� �÷��� SELECT ���� ������ �� ����.
-- GROUP BY ���� ��õǾ����� �Ѵ�.
SELECT deptno, AVG(sal) FROM emp;

--step 2
-- �μ��� ��� �޿�(����ȭ ����)
SELECT deptno, ROUND(AVG(sal)) FROM emp GROUP BY deptno;

-- step 3
SELECT deptno, ROUND(AVG(sal)) "AvgSalary" FROM emp GROUP BY deptno ORDER BY 2;

-- step 4
SELECT deptno, ROUND(AVG(sal)) "AvgSalary" FROM emp GROUP BY deptno ORDER BY 2;

-- step 5
--�μ��� �޿��� ����� �˻�... 10�� �μ��� �����ϰ� �˻�... ������ �μ���ȣ
-- deptno/DNumber , round(avg(sal)) AVGSAL
-- �������
-- 1. FROM --> 2. WHERE --> GROUP BY --> SELECT --> ORDER BY
SELECT deptno DNumber, ROUND(AVG(SAL)) AVGSAL
FROM emp
WHERE deptno != 10
GROUP BY deptno
ORDER BY 2;

--�Ի� �⵵�� ��� �� �˻�
SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

--step1
SELECT EXTRACT(YEAR FROM hiredate) as �Ի�⵵, COUNT(*) �ο���
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

--step2
SELECT to_char(hiredate,'YY') �⵵��, COUNT(empno) ����� 
FROM emp 
GROUP BY to_char(hiredate,'YY')
ORDER BY 1;

--step 1 WHERE ���� �׷� �Լ� ��� ����(������� ����)
-- alias�� ��� �Ұ�
SELECT deptno, ROUND(AVG(sal))
FROM emp a
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

--step 2 
-- GROUPING�� �� ������ �߷��� ���÷��� �ϴ�.
-- GROUP �Լ� ������ HAVING�� ��(WHERER �ƴ�)
SELECT deptno, ROUND(AVG(sal))
FROM emp a
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- �ִ� �޿��� 2900�޷��� �Ѵ� �μ����� �ִ� �޿��� ���
-- 1. �μ��� �ִ� �޿� ���ϰ�
-- 2. �� �߿��� 2900�޷� �Ѵ� �μ��鸸 ����
SELECT deptno, MAX(sal)
FROM emp
GROUP by deptno
HAVING MAX(SAL) > 2900;

--ROLLUP�� ���ؼ� �׷� �Լ� ����� �����
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
SELECT to_char(deptno) ��, SUM(sal)
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
��� ���� �ۼ� �� ������ �������� Group by ���� �ۼ��ϰ� ����Ǵ� �κе��� ������ �ۼ��� �� 
UNION ALL�� �����ϴ� ��İ�
GROUPING SETS�� ����ϴ� ����� �ִµ�

GROUPING SETS�� ����� ����� �ξ� �ӵ��� ������

*/

