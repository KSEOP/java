-- �м��Լ�
-- OVER �Լ���, ORDER BY �� �ڿ� �۵��Ѵ�.
SELECT EMPNO, ENAME, DEPTNO, SAL,
RANK() OVER(ORDER BY SAL DESC) "RANK" -- �޿������� ������ �ϰ� ���� RANK��.
FROM EMP; -- 2� �����ڰ� ���� ��, 3�� SKIP�ϰ� �������� 4������ �´�.


SELECT EMPNO, ENAME, DEPTNO, SAL,
DENSE_RANK() OVER(ORDER BY SAL DESC) "RANK"
FROM EMP;  -- �����ڰ� �־, RANK ��ȣ�� SKIP ���� �ʴ´�.

SELECT EMPNO, ENAME, DEPTNO, SAL,
DENSE_RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) "RANK"
FROM EMP; -- �׷����� DEPTNO ���ο��� ������ ���� ����.
-- GROUP BY���� ������. 
-- GROUP BY�� "Ư�� �׷�" ���� "�����" "�ϳ��� ��" �� ������.
-- �ݸ� PARTITION BY �� SUM�� �ᵵ, ��� �ึ�� ���� ǥ����.

-- �м� �Լ��� OVERHEAD�� �ٿ��ش� -- ������ ����. -- JOINSUBQUERY�� �پ���.

-- STEP 1. ����� ���� ���� ROWNUM
SELECT ENAME, SAL, ROWNUM FROM EMP ORDER BY SAL DESC;

-- STEP 2.
SELECT ENAME, SAL, ROWNUM
FROM (SELECT * FROM EMP ORDER BY SAL DESC)
WHERE ROWNUM <=3; -- ROWNUM�� ~ �̻� ���� �ȵȴ�. ������ ~ ���� ��������. POINTING�� �ȵ�.

-- STEP 3. ROW_NUMBER() OVER() �Բ� ����ؼ� STEP�� ������ ��� ���
SELECT ENAME, SAL, ROW_NUMBER() OVER (ORDER BY SAL DESC) �޿���ŷ
FROM EMP;

-- ROW_NUMBER()
-- GROUP BY, ORDER BY ������ ������ ���� ������ �Ҵ��ϴ� �м� �Լ�.

SELECT ENAME, SAL, HIREDATE,
ROW_NUMBER() OVER(ORDER BY SAL DESC, HIREDATE ASC) ����
FROM EMP;

SELECT ENAME, SAL, HIREDATE,
ROW_NUMBER() OVER(ORDER BY SAL DESC) ����
FROM EMP; -- ROW_NUMBER�� ��ŷ�� �ƴ� ������ �ű�� ���� ���̹Ƿ�, UNIQUE �ϰ� ����.
-- �׷��� ������ ��츦 �����Ͽ� 2������ ���� ������ �δ°� ������ �� ����.




