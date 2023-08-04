-- ##################  �׷� �Լ� �ǽ� ######################

-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
-- �ø��� CEIL�̴�. CEIL�� �ڸ��� �����̾����Ƿ�, *100�� �ؼ� 2�ڸ��� �ø� ��,
-- �ø� ���� CEIL�� �̿��ؼ�(���ų� �ϳ� ū ������ ����) 2�ڸ� �Ʒ��� �ø� �� ó�� �ϰ�
-- �ٽ� 100 ������ �Ҽ��� 2�ڸ��� ����
-- �ø��ε� �����ϰ� �׳� ���嵵 ���̾����ʳ� ��. �׷����ȵ�.

SELECT CEIL(AVG(SAL)*100)/100, MAX(SAL), MIN(SAL), COUNT(-1) 
FROM EMP
WHERE DEPTNO = 30;

-- 2) �� �μ��� �޿��� ���(�Ҽ����� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT DEPTNO, ROUND(AVG(SAL)), MAX(SAL), MIN(SAL), COUNT(-1)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;


-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT DEPTNO, JOB, COUNT(*) FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO; --SOL
-- GROUP BY ROLLUP(DEPTNO, JOB); -- ��������, �Ұ� ���϶� ���̾���. �׸��� ������� ���� �̻���. �̷��Ծ���


-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
SELECT JOB, COUNT(-1) FROM EMP
GROUP BY JOB
HAVING COUNT(-1)>=2;


-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
SELECT DEPTNO, TRUNC(AVG(SAL)) ���, SUM(SAL), MAX(SAL), MIN(SAL) FROM EMP
GROUP BY DEPTNO
ORDER BY ��� DESC;
--ORDER BY TRUNC(AVG(SAL)) DESC;
-- ************************************* �̺κк��� SOL ���� �߰� �ʿ�

-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �޿��� �Ұ�� ������ ����϶�.
-- �μ��� �����Ѵ�.
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB)
ORDER BY DEPTNO;


-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT DEPTNO, COUNT(-1) FROM EMP
GROUP BY DEPTNO
HAVING COUNT(-1) >= 5;

-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧���� ��ȸ������� ���ܽ�Ų��.
SELECT DEPTNO, MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL)!=MIN(SAL)
ORDER BY DEPTNO;

/* 9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
   ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
   �μ����� ��µǵ��� �ؾ� �Ѵ�. */

SELECT DEPTNO, ROUND(AVG(SAL),0) FROM EMP
WHERE DEPTNO IN (10,20,30)
GROUP BY DEPTNO
HAVING AVG(SAL) BETWEEN 2500 AND 5000;



 -- 10)