package com.edu.collection.test;

import java.util.*;

public class HashMapTest1 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("아이유", 90);
		map.put("박나래", 80);
		map.put("미미", 78);
		map.put("제임스", 85);
		
		ArrayList<Integer> scorelist = new ArrayList<>();
		
		
		System.out.println(map);
		// 1. map 안에 있는 사람들의 이름들만 받아옴 ... keyset()
		Set<String> set = map.keySet();
		System.out.println(set);
		
		// 2. 이름에 해당되는 성적들을 출력
		for(String name:set) {
			//System.out.println(name);
			int score = map.get(name);
			System.out.println(name+", "+score);
		}
		
		
		// 4. 사람들의 성적의 평균과 최고성적을 구해서 출력.
		int sum = 0;
		int avg = 0;
		int max = 0;
		
		for(String name:set) {
			sum += map.get(name);
		}
		for(String name:set) {
			if(max < map.get(name)) {
				max = map.get(name);
			}
		}
		
		avg = (sum/map.size());
		System.out.println("성적 평균:"+avg+", 최고 성적:"+max);
			
		// 3. map에 있는 사람들의 성적만 받아옴.
		Collection<Integer> scores = map.values();
		System.out.println(scores);
		
		
		// TEST, 점수들이 모인 리스트 만들기
		for(String name:set) {
			scorelist.add(map.get(name));
		}
		System.out.println(scorelist);
		
		Collections.sort(scorelist);
		
		System.out.println(scorelist);
		
		
		// 강사님 Sol
		
		
		Collection<Integer> scores1 = map.values();
		int total = 0;
		for(int score:scores1) {
			total += score;
		}
		
		System.out.println("평균: " + total/map.size());
		System.out.println("최고점: ");
		// 추가 작성 필요.
		
		
		
		
		
		
		
		
		
	}

}
