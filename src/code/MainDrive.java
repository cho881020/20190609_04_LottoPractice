package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
		System.out.println("로또 프로그램 입니다.");
		
		int[] thisWeekLottoNum = {10, 34, 38, 40, 42, 43};
		int thisWeekBonusNum = 32;
		
		int[] userInputLottoNum = new int[6];
		
		
		int[] userAutoLottoNum = new int[6];
		
		// Math.random의 결과 : 1 <= Math.random()*45+1 < 46 (1~45) 소수를 랜덤으로 생성.
//		Ex. 0.75124321564 => double
		
		for (int i=0 ; i < userAutoLottoNum.length ; i++) {
			
			while (true) {
				
				int randomNum = (int) (Math.random()*45+1);
				
				boolean isDuplOk = true;
				
				for (int num : userAutoLottoNum) {
					
					if (num == randomNum) {
						isDuplOk = false;
					}
				}
				
				if (isDuplOk) {
					userAutoLottoNum[i] = randomNum;
					break;
				}
				
				
			}
			
		}
		
		
		for (int auto : userAutoLottoNum) {
			System.out.println(auto);
		}
		
		
		for (int i=0 ; i < userAutoLottoNum.length ; i++) {
			
			for (int j=0 ; j < userAutoLottoNum.length-1 ; j++) {
				
				if (userAutoLottoNum[j] > userAutoLottoNum[j+1]) {
					
					int temp = userAutoLottoNum[j];
					userAutoLottoNum[j] = userAutoLottoNum[j+1];
					userAutoLottoNum[j+1] = temp;
					
				}
				
			}
			
		}
		
		System.out.println("정리된 랜덤 숫자");
		
		for (int sorted : userAutoLottoNum) {
			System.out.println(sorted);
		}
		
		
		
		Scanner scan = new Scanner(System.in);

		for (int i=0 ; i < userInputLottoNum.length ; i++) {
			
			while (true) {

				String messsage =  String.format("%d번째 숫자 입력 : ", i+1);
				System.out.print(messsage);
				int tempInput = scan.nextInt();
				
				boolean isRangeOk = false;
				
				if (1 <= tempInput && tempInput <= 45) {
					isRangeOk = true;
				}
				
				boolean isDuplOk = true;
				
				for (int j=0 ; j < userInputLottoNum.length ; j++) {
					if (userInputLottoNum[j] == tempInput) {
						isDuplOk = false;
					}
				}
				
				if ( isRangeOk && isDuplOk) {
					userInputLottoNum[i] = tempInput;
					break;
				}
				else if (!isRangeOk) {
					System.out.println("잘못된 범위의 숫자입니다.");
					System.out.println("다시 입력해주세요.");
				}
				else if (!isDuplOk) {
					System.out.println("이미 중복된 숫자가 있습니다.");
					System.out.println("다시 입력해주세요.");
				}
				
				
			}

		}
		
		
		int correntCount = 0;
		
		for(int i=0 ; i<userInputLottoNum.length ; i++) {
			
			for (int j=0 ; j < thisWeekLottoNum.length ; j++) {
				
				if (userInputLottoNum[i] == thisWeekLottoNum[j]) {
					correntCount++;
				}
				
			}
			
		}
		
		if (correntCount == 6) {
			System.out.println("1등 당첨!");
		}
		else if (correntCount == 5) {
			
			boolean bonusNumCorrect = false;
			
			for (int i=0 ; i < userInputLottoNum.length ; i++) {
				if (thisWeekBonusNum == userInputLottoNum[i]) {
					bonusNumCorrect = true;
				}
			}
			
			if (bonusNumCorrect) {
				System.out.println("2등 당첨!");				
			}
			else {
				System.out.println("3등 당첨!");
			}
			
			
		}
		else if (correntCount == 4) {
			System.out.println("4등 당첨!");
		}
		else if (correntCount == 3) {
			System.out.println("5등 당첨!");
		} 
		else {
			System.out.println("꽝!");
		}
		
		
	}
	
}
















