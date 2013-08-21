package com.kroy.zeckendorf;

import java.util.ArrayList;
import java.util.List;

public class ZeckendorfSprint {

	public String findZeckendorf(int inputNumber) {
		List<Integer> zeckDigits = new ArrayList<Integer>();
		int zeckExtract;
		String zeckenDorfRawDigits = "";
		String zeckenDorfNumber = "";
		while(inputNumber > 0){
			zeckExtract = extractFibbonaciDigits(inputNumber);
			inputNumber = inputNumber - zeckExtract;
			zeckDigits.add(zeckExtract);
		}

		zeckenDorfNumber = convertToZeckendorf(zeckDigits);
		
		zeckenDorfNumber = removeLeadingZeros(zeckenDorfNumber);
		
		return zeckenDorfNumber;
	}

	public String buildZeckendorfNumber(List<Integer> zeckDigits,
			String zeckenDorfRawDigits) {
			StringBuilder zeckenDorfNumber = new StringBuilder();
				
		for(Integer number : zeckDigits) {
			if (number == 13){
				appendZeckDigits(zeckenDorfNumber, number, 13);
			} else if(number > 5) {
				appendZeckDigits(zeckenDorfNumber, number, 8);
			} else if(number > 3) {
				appendZeckDigits(zeckenDorfNumber, number, 5);
			} else if(number > 2) {
				appendZeckDigits(zeckenDorfNumber, number, 3);
			} else if(number > 1) {
				appendZeckDigits(zeckenDorfNumber, number, 2);
			} else {
				appendZeckDigits(zeckenDorfNumber, number, 1);
			}


		}
		
		

		return zeckenDorfNumber.toString();
	}

	public StringBuilder appendZeckDigits(StringBuilder zeckenDorfNumber, Integer number, int zeckNum) {
		if(number == zeckNum) {
			return zeckenDorfNumber.append("1");
		} else {
			return zeckenDorfNumber.append("0");
		}
	}

	public int extractFibbonaciDigits(int i) {
		Integer result;
		if (i < 1) {
			result = 0;
		} else if (i < 2) {
			result = 1;
		} else if (i < 3) {
			result = 2;
		} else if (i < 5) {
			result = 3;
		} else if (i < 8) {
			result = 5;
		} else if (i < 13) {
			result = 8;
		} else {
			result = 13;
		}
		return result;
	}

	public String removeLeadingZeros(String unfinishedZeck) {
		StringBuilder sb = new StringBuilder(unfinishedZeck);
		
		while(sb.charAt(0) == '0') {
			sb.replace(0, 1, "");
			
		}
		
		String finishedZeck = sb.toString();
		
		return finishedZeck;
	}

	public String convertToZeckendorf(List<Integer> eightTwo) {
		StringBuilder zeckNumber = new StringBuilder("000000");
		
		for(Integer number : eightTwo) {
			if (number == 13) {
				zeckNumber.replace(0, 1, "1");
			}
			if (number == 8) {
				zeckNumber.replace(1, 2, "1");
			}
			if (number == 5) {
				zeckNumber.replace(2, 3, "1");
			}
			if (number == 3) {
				zeckNumber.replace(3, 4, "1");
			}
			if (number == 2) {
				zeckNumber.replace(4, 5, "1");
			}
			if (number == 1) {
				zeckNumber.replace(5, 6, "1");
			}
		}
		
		return zeckNumber.toString();
	}

}
