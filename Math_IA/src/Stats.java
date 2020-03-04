
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stats {
	
	public static float getStdDev(ArrayList<Long> al, float mean) {
		float out = 0;
		for (long l : al) {
			out += Math.pow(Math.abs(mean-l),2);
		}
		return out/al.size();
	}
	
	
	public static float getMean(ArrayList<Long> al) {
		float sum = 0;
		for (long l : al) {
			sum += l;
		}
		return sum/al.size();
	}
	
	
	public static ArrayList<Integer> getOutliers(int[] arr) {
		ArrayList<Integer> outliers = new ArrayList<Integer>();
		ArrayList<Integer> raw = new ArrayList<Integer>();
		for (int i : arr) {
			raw.add(i);
		}
		ArrayList<Integer> data = new ArrayList<Integer>();
				
		for (int i = 0; i < raw.size(); i++) {
						
			int el = raw.get(i);
			
			if (i == 0) {
				data.add(el);
			} else {
				boolean placed = false;
				for (int j = 0; j < data.size(); j++) {
					if (el < data.get(j) && !placed) {
						data.add(j, el);
						placed = true;
					}
				}
				if (!placed) {
					data.add(el);
				}
				
			}
			
		}
		
		//Calculation
		
		int dSize = data.size();
		boolean evenSize = (dSize % 2 == 0); 
		float median = 0;
		float q1 = 0;
		float q3 = 0;
		float IQR = 0;
		float min = (float) data.get(0);
		float max = (float) data.get(dSize-1);
		
		median = getMedian(data);
		
		List<Integer> half1;
		List<Integer> half2;
		
		if (evenSize) {
			half1 = data.subList(0, dSize/2);
			half2 = data.subList(dSize/2, dSize);
		} else {
			half1 = data.subList(0, dSize/2);
			half2 = data.subList(dSize/2+1, dSize);
		}
		
		q1 = getMedian(half1);
		q3 = getMedian(half2);
		
		IQR = q3 - q1;
		
		float lowerBound = (float) (q1 - (IQR*1.5));
		float higherBound = (float) (q3 + (IQR*1.5));
		
		for (int i = 0; i < data.size(); i++) {
			int el = data.get(i);
			if (el < lowerBound || el > higherBound) {
				outliers.add(el);
			}
		}
		
		return outliers;
	}
	
	public static ArrayList<Integer> getOutliers(long[] arr) {
		ArrayList<Integer> outliers = new ArrayList<Integer>();
		ArrayList<Integer> raw = new ArrayList<Integer>();
		for (long i : arr) {
			raw.add((int) i);
		}
		ArrayList<Integer> data = new ArrayList<Integer>();
				
		for (int i = 0; i < raw.size(); i++) {
						
			int el = raw.get(i);
			
			if (i == 0) {
				data.add(el);
			} else {
				boolean placed = false;
				for (int j = 0; j < data.size(); j++) {
					if (el < data.get(j) && !placed) {
						data.add(j, el);
						placed = true;
					}
				}
				if (!placed) {
					data.add(el);
				}
				
			}
			
		}
		
		//Calculation
		
		int dSize = data.size();
		boolean evenSize = (dSize % 2 == 0); 
		float median = 0;
		float q1 = 0;
		float q3 = 0;
		float IQR = 0;
		float min = (float) data.get(0);
		float max = (float) data.get(dSize-1);
		
		median = getMedian(data);
		
		List<Integer> half1;
		List<Integer> half2;
		
		if (evenSize) {
			half1 = data.subList(0, dSize/2);
			half2 = data.subList(dSize/2, dSize);
		} else {
			half1 = data.subList(0, dSize/2);
			half2 = data.subList(dSize/2+1, dSize);
		}
		
		q1 = getMedian(half1);
		q3 = getMedian(half2);
		
		IQR = q3 - q1;
		
		float lowerBound = (float) (q1 - (IQR*1.5));
		float higherBound = (float) (q3 + (IQR*1.5));
		
		for (int i = 0; i < data.size(); i++) {
			int el = data.get(i);
			if (el < lowerBound || el > higherBound) {
				outliers.add(el);
			}
		}
		
		return outliers;
	}
	
	public static float getMedian(ArrayList<Integer> al) {
		int s = al.size();
		if (s % 2 == 0)
			return (al.get(s/2-1) + al.get(s/2))/2;
		return al.get(s/2);
	}
	
	public static float getMedian(List<Integer> al) {
		int s = al.size();
		if (s % 2 == 0)
			return (al.get(s/2-1) + al.get(s/2))/2;
		return al.get(s/2);
	}
	
	public static double square(double in) {
		
		return Math.pow(in, 2);
		
	}
	
}
