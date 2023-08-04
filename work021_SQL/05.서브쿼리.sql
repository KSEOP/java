--Sub Query
-- ? �� �ش��ϴ� �κ��� ( ) �ȿ� ���� �����ϰ�, �� ����� main �������� ����
-- CLARK�� �޿����� �� ���� �޿��� �޴� ����� �̸��� �޿�, ������ �˻�
-- �� ���忡�� ? �� CLARK�� �޿���.

SELECT ENAME, SAL, JOB
FROM EMP
WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='CLARK'); -- 1. CLARK�� �޿��� ������ ��.

-- �������
-- MAIN ����  = OUTER ����
-- ��������    = INNER ����

-- ���������� ���� �����̵�. 
-- 1�� �������������� ������� ����� 1�ٳ���. (1ROW 1COL)
-- �̷��� 1���� ��, �ܵ����� "��Į��" ���̶�� ��. -- [��Į�� -- 1ROW 1COL] 
-- �� �� ������ ���������� '��Į�� ��������' ��� ��.
-- �� SAL > ��Į��(2490) �����̹Ƿ� >, <, = �� ���� �����ڸ� ��.
-- >, <, = �� "������ ������"�� �̷� �� ��� ������.
/*
�� ���������� ���� "�������� �����"�� ������ �����
>, < �� ���� ������ �����ڰ� �ƴ�
"IN" �� ����Ѵ�.

�� ���� ������

WHERE �������� -- 1.
�ƿ���(����) ���� -- 2.


3. �������� �������� 'ORDER BY'���� ���� �ǹ̰� ����.
WHY? -- ������ ������������ �� ���ɼ��� �����Ƿ�.

��������� ? �� �ذ��ϴ� ���� �������� Ȱ���� ������.
*/

--����1) 7566 ������� �޿��� ���� �޴� ����� �̸�, �޿�
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE EMPNO=7566);

--����2) EMP ���̺��� �����ȣ�� 7521�� ����� ������ ���� �޿��� 7934�� �������
-- ���� ����� �����ȣ, �̸�, ������, �Ի�����, �޿��� ��ȸ�϶�.

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE EMPNO = 7521)
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO =7934);

--����3) EMP ���̺��� �޿��� ���� ���� �޴� ����� �̸� �μ� �޿� �Ի���
-- �ۼ� �ʿ�

SELECT ENAME, DEPTNO, SAL, HIREDATE
FROM EMP
WHERE SAL = (SELECT MAX(SAL) FROM EMP);





-- 10�� �μ����� �ٹ��ϴ� ��� �߿���, ����� ��ü ��� �޿����� �� ���� �޿��� �޴� ����� �˻�.
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=10
AND SAL>(SELECT AVG(SAL) FROM EMP); -- AVG ���� ��Į������ �����ؾ���


-- JOB�� ���� ���� ��ձ޿��� �˻�.... ����, ��� �޿��� ���
-- ���⼭ '?' ��  '���� ���� ��� �޿�' ��. JOB�� �̹Ƿ� GROUP BY �ʿ��� ��.


-- [[[  HAVING�� �ڿ����� ��������  ]]]
-- �׷��Լ� ��ø
SELECT JOB, ROUND(AVG(SAL))
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) = (SELECT MIN(AVG(SAL)) FROM EMP GROUP BY JOB); -- MYSQL������ �̰� �ȵ�(�׷� �Լ� ��ø�� ����)
-- ����Ŭ�� �̷���, �׷��Լ� ��ø�� �����ϴ�.


-- �Ʒ� �������� �ڵ尡 ���� ����, ���� ���� �����.
SELECT MIN(AVG(SAL)) FROM EMP GROUP BY JOB;

-- FROM�� �ڿ� ���� ��������.
-- ��� �߿��� �޿��� ���� ���� �޴� ��� ��ŷ 3�� �˻�

SELECT ENAME, ROWNUM �޿�����
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM <=3;


-- ��� �������� �߿��� ���� ���� ������ WHERE �ڿ� ���°� ����. ��κ���.
-- HAVING�� ���� ����������? -- �׷��Լ� ? �� ���� ��.
-- ��ó�� ������� �̾ƾ��� ������ FROM ���� ���� ��.

--//////////////////////////////////
-- SCOTT �޿����� �� ���� �޿��� �޴� ��� �˻� (���� �������� ��������
-- WHERE�� ��������

-- STEP1.
SELECT ENAME, JOB 
FROM EMP
WHERE SAL>(SELECT SAL FROM EMP WHERE ENAME='SCOTT');

-- STEP2.
SELECT A.ENAME, A.JOB, A.SAL FROM EMP A, (SELECT SAL FROM EMP WHERE ENAME='SCOTT') B
WHERE A.SAL > B.SAL;
-- ���⼭�� ���� ������ ����Ʈ�� * �ص� �Ǳ���. A.~~ �ϱ� �ȴٸ�.

-- �μ��� ������ SAL�� ���� ���� ����
-- ���� �߻�
-- ������ ������������ ������ ������ ���
-- ������ �������������� ������ �����ڸ� ����ؾ���.
SELECT EMPNO, ENAME
FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO);

SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO; -- ������ ��������.

SELECT EMPNO, ENAME
FROM EMP
WHERE SAL IN (SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO);


-- 160 ����2)
SELECT ENAME, SAL, JOB
FROM EMP
WHERE JOB!='SALESMAN'
AND
SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN')
ORDER BY ENAME;
-- ����� ��ȣ���� (���� �̰� ��������)
SELECT ENAME, SAL, JOB
FROM EMP
WHERE JOB!='SALESMAN'
AND
SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN')
ORDER BY ENAME;

--161 ����3) ������ SALESMAN�� ��� ������� �޿��� ���� �޴� ����� �̸� �޿� ��� �Ի��� �μ���ȣ
SELECT ENAME, SAL, JOB, HIREDATE, DEPTNO
FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')
AND JOB != 'SALESMAN';

-- �μ� ��ȣ�� 30���� ����� �޿� �߿��� ���� ���� �޿�(950)���� �� ���� �޿��� �޴�
-- ����� �̸�, �޿�, �μ���ȣ
-- 1) �׷��Լ�
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO='30')
ORDER BY ENAME;

-- 2) ������ ������.
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO='30')
ORDER BY ENAME;


-- ������������ NULL ��.
-- EMP ���̺��� ���������� �Ŵ��� ��� �˻�

SELECT ENAME FROM EMP
WHERE EMPNO IN (SELECT NVL(MGR,'') FROM EMP);

-- ����� ���� 1
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);
-- ���� ���ε� �غ� ����� ����
SELECT E.ENAME, E.EMPNO FROM EMP E WHERE E.EMPNO IN (SELECT M.MGR FROM EMP M);

--EMP ���̺��� ���������� �Ŵ����� �ʴ� ���
SELECT ENAME FROM EMP
WHERE EMPNO NOT IN (SELECT NVL(MGR, 0) FROM EMP);
-- �ƹ��͵� �ȳ���. �ֳ��ϸ� NOT IN �� '�ƴϴ�' �� AND�� �����
-- �׸��� MGR���� NULL���� ����.
-- NULL�� �� �����ڸ� ���Ἥ ���ڵ尡 �ȳ��͹���. �ϳ��� ������ ��ü�� �ȳ���. �׷��� NOT IN�� �ȵ�






