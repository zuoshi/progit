package progit;

import java.util.ArrayList;

public class Helloboy {
	
	public boolean isPerfectDigit(int digit){
		int sum=0;
		for(int i=1;i<digit;i++){
			if(digit%i==0){
				sum+=i;
			}
		}
		if(sum==digit)
			return true;
		else
			return false;
	}
	
	public ArrayList findperfectDigit(int min,int max){
		ArrayList list=new ArrayList();
		for(int k=min;k<=max;k++){
			if(this.isPerfectDigit(k)){
				list.add(Integer.valueOf(k));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helloboy hb=new Helloboy();
		int min=1;
		int max=100000;
		ArrayList list=hb.findperfectDigit(min, max);
		if(list.isEmpty()){
			System.out.println("There is no perfectdigit between "+min+" and " +max);
		}else{
			String str="";
			for(int i=0;i<list.size();i++){
				str+=list.get(i)+" ";
			}
			System.out.println(str+"is the perfectdigit.");
		}
	}

}
