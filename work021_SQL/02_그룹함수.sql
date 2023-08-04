-- �׷��Լ�
/*
COUNT, SUM, AVG, MAX, MIN

SUM, AVG
-> ���ڵ����͸� ����. (��¥, ���� �� ���� �ȵ�.)
COUNT, MAX, MIN
*/

-- COUNT()
-- ��ü ��� ���� ��ȸ
SELECT COUNT(*)FROM EMP;
SELECT COUNT(EMPNO) FROM EMP; -- NOT NULL�� ������ �⺻Ű �÷��� ���� �� (*)�� ������ ����.
SELECT COUNT(-1) ��ü����� FROM EMP; -- ROW�� �����ΰ��� �ε����� ������.

SELECT ROUND(AVG(SAL)), SUM(SAL), MIN(SAL) FROM EMP;

-- �Ի����� ���� ������ ����� �Ի��ϰ�, ���� �ֱ� �Ի��� ����� �Ի����� �˻�
SELECT MIN(HIREDATE), MAX(HIREDATE) FROM EMP;

-- �μ� ��ȣ�� 10���̰ų� 20�� �μ��� ��� ���� �˻�
SELECT COUNT(EMPNO) -- *, -1 ���� �� �� �ִ�.
FROM EMP
WHERE DEPTNO IN (10,20);

-- EMP ���̺��� �μ���ȣ ���� �˻�
SELECT COUNT(DISTINCT(DEPTNO)) FROM EMP;

-- ��� ����� ���ʽ��� ���
SELECT AVG(COMM) FROM EMP;

-- STEP2
SELECT ROUND(AVG(NVL(COMM, 0))) AS "���ʽ����" FROM EMP;

--///////////////////////////////////////////////////

-- ����� �޿��� ��հ��� �˻�
-- STEP 1
-- �׷��Լ��� ���Ե��� ���� �÷��� SELECT���� ������ �� ����.
-- GROUP BY�� �� ��õǾ����� �Ѵ�.
SELECT DEPTNO, AVG(SAL) FROM EMP;

-- STEP 2
-- �μ��� ��� �޿�
SELECT DEPTNO, ROUND(AVG(SAL)) "AvgSalary"
FROM EMP
GROUP BY DEPTNO;
ORDER BY 2;

-- STEP 4 -- GROUPBY���� ALIAS �ν� �Ұ�
SELECT DEPTO, ROUND(AVG(SAL)) "AvgSalary"
FROM EMP
GROUP BY 'AvgSalary'
ORDER BY 2;

-- STEP 5
-- �μ��� �޿��� ����� �˻�, 10�� �μ��� �����ϰ� �˻�, ������ �μ���ȣ,
-- DEPTNO -> DNUMBER, ROUND(AVG(SAL)) -> AVGSAL,
-- 1.FROM -> 2.WHERE -> 3.GROUP BY -> 4.SELECT -> 5.ORDER BY
SELECT DEPTNO DNUMBER, ROUND(AVG(SAL)) AVGSAL FROM EMP
WHERE DEPTNO !=10
GROUP BY DEPTNO
ORDER BY 2;


SELECT  EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT  EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT  EXTRACT(DAY FROM hiredate) as DAY FROM emp;

-- STEP1
SELECT EXTRACT(YEAR FROM HIREDATE) AS �Ի�⵵, COUNT(*) �ο���
FROM EMP
GROUP BY EXTRACT(YEAR FROM HIREDATE);


-- STEP2
SELECT TO_CHAR(HIREDATE, 'YY') FROM EMP;

SELECT TO_CHAR(HIREDATE, 'YY') �⵵��, COUNT(EMPNO) �����
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YY')
ORDER BY 1;


-- ////////////////
-- STEP 1
-- ERROR
SELECT DEPTNO, ROUND(AVG(SAL))
FROM EMP
WHERE ROUND(AVG(SAL)) >= 2000 -- WHERE ���� �׷��Լ� ��� ����. WHERE�� �������� ������ �׷���.
GROUP BY DEPTNO;
-- WHERE ���� ALIAS ���� !!!!

--STEP 2.
SELECT DEPTNO, ROUND(AVG(SAL))
FROM EMP
HAVING ROUND(AVG(SAL)) >= 2000 -- HAVING�� GROUPING�� �� ���� �߷��� DISPLAY��.
GROUP BY DEPTNO;

--STEP 3. �̿ϼ�.
SELECT DEPTNOM ROUND(AVG(SAL))
FROM EMP;


-- �ִ� �޿��� 2900�� �Ѵ� �μ����� �ִ� �޿��� ���
-- �׷��Լ� ������ ������ HAVING ���� ��.
-- 1) �μ��� �ִ� �޿�... 5000, 3000, 2850,...
-- 2) 5000, 3000
SELECT DEPTNO, MAX(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL)>2900;

--ROLLUP 1
SELECT DEPTNO, JOB,COUNT(*), SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO,JOB);

--ROLLUP 2
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY ROLLUP(JOB, DEPTNO);


--GROUPING SET
--���� 1
SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY GROUPING SETS(DEPTNO, JOB);

SELECT DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB);

-- ROLLUP�� �μ����� ������, �� �ȿ��� �� JOB���� ����. (�����Ϳ��� �� ����)
-- �� ���� ������ �̷�. �׷��� ���� ������ ������ �ִ� ��.
-- GROUPING SETS�� ���� ������ �ƴ�, ���� ���� ���� ��ģ ��.

-- GROUPING SETS
-- STEP 1.
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(job, deptno)
ORDER BY JOB,DEPTNO ;

-- STEP 2. UNION ALL
SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
UNION ALL -- ���� ������ �� �Ʒ� �����͸� ��ħ (�׷��μ�ó����)
SELECT JOB, SUM(SAL)
FROM EMP
GROUP BY JOB;
-- DATATYPE ERROR

-- STEP 3. ���ڸ� ���ڷ� �ٲ��ֱ�
SELECT TO_CHAR(DEPTNO), SUM(SAL)
FROM EMP
GROUP BY DEPTNO
UNION ALL -- ���� ������ �� �Ʒ� �����͸� ��ħ (�׷��μ�ó����)
SELECT JOB, SUM(SAL)
FROM EMP
GROUP BY JOB;

-- STEP 4.
SELECT DEPTNO ||'', SUM(SAL) -- �̷����ϸ� ���� ���� �����.
FROM EMP
GROUP BY DEPTNO
UNION ALL
SELECT JOB, SUM(SAL)
FROM EMP
GROUP BY JOB;

-- STEP5.

SELECT DEPTNO, NULL JOB, SUM(SAL) -- å����. ����ȯ ������, NULL�� �̿��ؼ� ��������.
FROM EMP
GROUP BY DEPTNO
UNION ALL 
SELECT NULL DEPTNO, JOB, SUM(SAL)
FROM EMP
GROUP BY JOB;

/*
������� �ۼ� �� ������ �������� GROUP BY���� �ۼ��ϰ�
����Ǵ� �κе��� ������ �ۼ��� �� UNION ALL�� �����ϴ� ��İ� (STEP 3 4 5)

GROUPING SETS�� ����ϴ� ����� �ִµ� (STEP 1)

GROUPING SETS�� ����� ����� �ξ� �ӵ��� ������.

*/








