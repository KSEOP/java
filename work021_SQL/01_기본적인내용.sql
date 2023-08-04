-- <= �ּ�

/*
 ���� ���� �ּ�.
*/ 

SELECT * FROM emp

-- SELECT :: Projection | Selection
-- Projection : ���ϴ� �÷��� ������

SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;

SELECT 
EMPNO, ENAME, JOB, DEPTNO 
FROM EMP; -- �̷��� ���κ��� ���� �ϴ°� ������ �ų�.

-- EMP ���̺��� ��� ����� �̸��� �Ի����� �˻�

-- �̷��� �ʿ��� �͸� ���°� Projection (���ϴ� �÷��� ������)
-- SELECTION�� ���ϴ� "��"�� ������ -- WHERE ���� ������ �ο��ؾ���.
SELECT ENAME, HIREDATE FROM EMP
WHERE JOB='SALESMAN';
-- ���� ������ �˾ƾ� ���� ������ §��
-- FROM �������� WHERE���� ����ȴ�. �׷��� �� ���� ���δ�.

-- EMP ���̺��� �μ���ȣ�� 10�� �μ��� ����� �̸�, ����, �޿�, �μ���ȣ �˻�.
SELECT ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = '10';

-- �޿��� ����... ORDER BY ����.. ���� ������������ �۵��� ������
SELECT ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = '10'
ORDER BY SAL DESC; -- ��������.

SELECT ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE DEPTNO = 10
ORDER BY 3 DESC; -- SQL�� ù��°�� 1��. SQL�� ���� �Ҽ��� ���� �÷��ѹ��� ��.


SELECT ENAME, JOB, SAL AS �޿�, DEPTNO
FROM EMP
WHERE DEPTNO = 10
ORDER BY �޿� DESC; -- SQL�� ù��°�� 1��. SQL�� ���� �Ҽ��� ���� �÷��ѹ��� ��.
-- ��Ī ���� ����.

-- ��� �߿��� �Ի����� ���� ���� ��� ������ �˻�
SELECT ENAME, JOB, HIREDATE
FROM EMP
ORDER BY HIREDATE;

--
SELECT ENAME, JOB, HIREDATE
FROM EMP
ORDER BY 3;

-- ��� �߿��� �޿��� ���� �޴� ������ ����, �̸�, �޿�, ������ �˻�
SELECT ENAME, SAL, JOB
FROM EMP
ORDER BY 2 DESC;

-- ���� ��Ÿ���� Ű���� :: ROWNUM
-- ���� ������ �� ���
SELECT ENAME, SAL JOB, ROWNUM
FROM EMP
ORDER BY SAL DESC;


SELECT ENAME, SAL JOB, ROWNUM
FROM EMP
WHERE ROWNUM <=3
ORDER BY SAL DESC;
-- �� �ǵ�ġ ����, ORDER BY ���� ROWNUM ��ȣ�� �Ű����°�?
-- ������ �ϰ�, ROWNUM�� ���;��ϴµ� ���� �׷��� ����. // ����Ŭ�� ����������
-- ORDER BY�� ����Ŭ������ ROWNUM���� ����, ���� �������� �����.
-- MYSQL ������ LIMIT�� ORDER BY ������ �����ؼ� ����.

-- ������ ���������� ���� ��Ų ���� ROWNUM ����.
SELECT ENAME, SAL, JOB, ROWNUM AS RANKING 
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM<=3; 

/*
SELECT ������ ���� �ȿ��� ���� ����
(���� ����)
SELECT -> FROM -> WHERE -> ORDER BY
(���� ���� ����)
1. ORACLE
FROM(���̺� ã��) -> WHERE(�� ����) -> SELECT(�÷� ����)-> ROWNUM -> ORDER BY(����)

2. MYSQL
FROM(���̺� ã��) -> WHERE(�� ����) -> SELECT(�÷� ����)-> ORDER BY(����) -> LIMIT

*/

/*
Alias
�ַ� ��� �����ڰ� ����� �÷��� Alias�� �����Ѵ�.
1. �÷��� as ��Ī | �÷��� ��Ī | �÷��� "��Ī"  -- ��� ����.
2. "��Ī" ����ǥ�� ��Ī�� ������ �ְų� Ư�����ڰ� ���� ��, Ȥ�� ��ҹ��ڸ� ������ �� ����Ѵ�.

*/

-- ��� ����� �޿��� �����޿����� 100�� ���� ���� 2��� ����, ������(����̸�, �޿�, ������ �޿�, ����)
--1.
SELECT ENAME, SAL, ((SAL+100)*2), JOB
FROM EMP;

--2.
SELECT ENAME, SAL, ((SAL+100)*2) AS �����޿�, JOB
FROM EMP;

SELECT ENAME, SAL, ((SAL+100)*2) �����޿�, JOB
FROM EMP;
ORDER BY �����޿�;

SELECT ENAME, SAL, ((SAL+100)*2) AS �����޿�, JOB
FROM EMP
ORDER (SAL+100)*2;

SELECT ENAME, SAL, ((SAL+100)*2) AS �����޿�, JOB
FROM EMP
ORDER BY 3;

SELECT ENAME, SAL, ((SAL+100)*2) AS "���� �޿�", JOB
FROM EMP
ORDER BY "���� �޿�"; --����Ŭ�� �� �κе� �����.!! �̰� MYSQL�� ����� �Ǵµ� ���� �ȵ� ���·� ����. (�ȵ�).

-- ��� �޿����� ������ �����ϰ� ������ �޿��� �˻�(������ �޿��� 10%�� ����)
-- �̸�, ����, �޿�, ���� ������ �޿� -- ������ ���� ������ �޿� ������
SELECT ENAME, JOB, SAL, SAL-(SAL*0.1) AS "���� ������ �޿�"
FROM EMP
ORDER BY 4;

-- ����� �޿��� ������ �˻�
SELECT ENAME, SAL, SAL*12 AS "AnnualSalary"
FROM EMP;

-- Ŀ�̼��� NULL�� ����� ����. �׸��� NULL�� ���꿡�� ���ܵ�.
-- NULL�� ������ �� ���� ����.
SELECT ENAME, SAL, SAL*12+COMM AS "AnnualSalary"
FROM EMP;

/*
 NULL ����
 1. 0�� �ƴϰ� ���鵵 �ƴϴ�.
 2. ������ �ǹ̸� ������ ���̴�.
    "�ڰ� ����" Ȥ�� "��Ȯ��(Unknown)" �� ���ϴ� ���� �� �ַ� ���ȴ�.
 3. ���� ���� �ȵ�.(+, -, *, /), �񱳵� �Ұ���(=, !=, ><, >, <, >=, <=)
 4. null ���� ������ �����ؾ� �� ������ �ٸ� ������ ġȯ���Ѽ� �����Ѵ�. -- NVL()�Լ��� ���. MYSQL�� IFNULL() ����.
 5. ����Ŭ���� NULL���� ���� ū ������ ��޵ȴ�. MYSQL�� �ݴ�� ���� ���� ������ ��޵ȴ�.
*/

SELECT JOB, COMM FROM EMP ORDER BY COMM DESC; -- NULL�� ��ܿ� ��ġ��. �� NULL�� ���� ū ��ó�� ó����. MYSQL�� NULL ���� ���� ���� ������ ó����.

--

SELECT ENAME, SAL, SAL*12+NVL(COMM, 0) AS "AnnualSalary"
FROM EMP;

-- EMP ��� �߿��� COMM�� NULL�� ����� �̸��� ���� �޿��� �˻�
-- NULL���� �� �Ұ��� �Ʒ��� ���� �ϸ� ��µǴ� ����� ����.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE COMM = NULL;

-- �Ʒ� ó�� IS NULL, �Ǵ� IS NOT NULL �������.
SELECT ENAME, JOB, SAL
FROM EMP
WHERE COMM IS NULL;

--EMP ���̺��� ������ SALESMAN�� ����� �̸�, �޿�, ���� �˻�.
--������ ���� ������ ���� ������
SELECT ENAME, SAL, (SAL*12)+NVL(COMM,0) AS "����"
FROM EMP
WHERE JOB = 'SALESMAN' -- ALIAS�� �ֵ���ǥ ������. �� �ܿ� ���� ����ǥ �ؾ���.
ORDER BY ���� DESC;

-- Ŀ�̼��� ���� ���� �޴� ��� ������ �˻�(���, �̸�, ����, COMM)
SELECT EMPNO, ENAME, JOB, COMM
FROM EMP
ORDER BY COMM DESC;
-- �̷��� ���� ����� �ȳ���
-- �Ʒ� ó�� �׳� NULL�̸� ���ֹ����� ��� ����
SELECT EMPNO, ENAME, JOB, COMM
FROM EMP
WHERE COMM IS NOT NULL
ORDER BY COMM DESC;

-- EMP TABLE����, �μ�(��ȣ)�� �˻�
-- �̷��� �ߺ����� �μ� ��ȣ�� �ٺ�����. �� �μ��� ������ ���� �ʹ� ���� �����ְԵ�.
SELECT DEPTNO FROM EMP;

--STEP1. �ߺ��� �����ϴ� DISTINCT�� ����. �� ���ı��� �������� ����.
SELECT DISTINCT DEPTNO FROM EMP;

--STEP2.
SELECT DISTINCT DEPTNO FROM EMP 
ORDER BY 1;

SELECT DISTINCT(DEPTNO) FROM EMP 
ORDER BY 1;

/*
DISTINCT
�ߺ��� ���ܳ��� Ű����.

1. SELECT�� �ٷ� �ڿ� �´�.
2. 10G �������� ���� ����� �����־ ������ ������ �������.
+ �������� ���ɻ� �ſ� ġ������ Ű������. -- ��� �����͸� ���������ϹǷ�...
3. �ߺ����� �����ϴ� ������ ���� �ð��� �ɸ���.
   ����, �Ұ����ϰ� ����ؾ��ϴ� ��Ȳ�̶�� DISTINCT ������ ��ü�ϴ� ����̳�
   Ȥ�� ������ ����� �Ǵ� ���̺��� ũ�⸦ �ּ�ȭ �ϴ� ����� �����Ѵ�.
   
   ���� ��ǥ���� ���, EXIST�� Ȱ���ϴ� ����� �ִ�.
   
*/

SELECT DEPTNO FROM DEPT D
WHERE EXISTS(
SELECT * FROM EMP E
WHERE D.DEPTNO = E.DEPTNO);


/*
 LIKE �����ڿ� ���ϵ�ī��(%,_)
 Ư�� �ܾ ���ԵǾ� �ִ� �����͸� �˻��� �� ���� �����.
 
*/
-- ����� �̸� �߿��� S�� �����ϴ� ����� �˻�.
SELECT ENAME FROM EMP
WHERE ENAME LIKE 'S%'; 
-- S% : %�� 0Ȥ�� MANY. S �ڿ� �ƹ��͵� ����ǰ�, �׳� �ְų� ���� �־ �ǰ�.
-- %S : S�� ������ ���.
-- '_S%' : _ �� �ݵ�� 1���� ���ε�. 2��° ���ڰ� S�� �̸�. �ڴ� ��� ����.

-- ����� �̸� �߿��� S�� ���Ե� �̸��� ����� �˻�.
SELECT ENAME FROM EMP
WHERE ENAME LIKE '%S%'; 
-- �ι�° ���ڿ� A�� �� �ִ� �̸��� ����� �˻�
SELECT ENAME FROM EMP
WHERE ENAME LIKE '_A%'; 
-- 81�⵵�� �Ի��� ����� �˻�
SELECT ENAME, HIREDATE FROM EMP
WHERE HIREDATE LIKE '81%'; 

