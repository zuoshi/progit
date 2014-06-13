package progit;

import java.util.ArrayList;

public class Helloboy {
	
	/**
	 * 动态数组的和
	 * @param list
	 * @return
	 */
	public int getSum(ArrayList list){
		int sum=0;
		for(int i=0;i<list.size();i++){
			sum+=Integer.parseInt(list.get(i).toString());
		}
		return sum;
	}
	
	/**
	 * 求一个数除本身以外的所有约数，保存在一个动态数组中
	 * @param number
	 * @return
	 */
	public ArrayList getDivisor(int number){
		ArrayList list=new ArrayList();
		for(int i=1;i<number;i++){
			if(number%i==0){
				list.add(Integer.valueOf(i));
			}
		}
		return list;
	}
	
	/**
	 * 判断一个数是否是完美数
	 * @param digit
	 * @return
	 */
	public boolean isPerfectDigit(int digit){
		if(this.getSum(this.getDivisor(digit))==digit)
			return true;
		else
			return false;
	}
	
	/**
	 * 判断两个数是否是友好数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public boolean isFriendDigit(int d1,int d2){
		int sum1=this.getSum(this.getDivisor(d1));
		int sum2=this.getSum(this.getDivisor(d2));
		if(sum1==d2&&sum2==d1)
			return true;
		else
			return false;
	}
	
	/**
	 * 在给定的范围内寻找完美数
	 * @param min
	 * @param max
	 * @return
	 */
	public ArrayList findPerfectDigit(int min,int max){
		ArrayList list=new ArrayList();
		for(int k=min;k<=max;k++){
			if(this.isPerfectDigit(k)){
				list.add(Integer.valueOf(k));
			}
		}
		return list;
	}
	
	/**
	 * 在给定的范围内寻找友好数，思路是取一个数，找出其约数的和，再判断这个和的约数是否与选的数相等，如果相等，就为友好数，注意
	 * 为了不重复判断某对数，在选取数时要判断之前是否已经比对过，如果比对过，就跳过这个数，还有一个条件要注意就是两个友好数不能
	 * 相同
	 * @param min
	 * @param max
	 * @return
	 */
	public ArrayList findFriendDigit(int min,int max){
		ArrayList list=new ArrayList();
		ArrayList temlist=new ArrayList();
		for(int k=min;k<=max;k++){
			if(temlist.isEmpty()||!this.isInclude(temlist, k)){
				int tem=this.getSum(this.getDivisor(k));
				if(tem<max&&this.isFriendDigit(k, tem)&&k!=tem){
					int[] perfect=new int[2];
					perfect[0]=k;
					perfect[1]=tem;
					list.add(perfect);
					temlist.add(Integer.valueOf(tem));
					}
			}
			}
		return list;
		}
	
	/**
	 * 判断一个数组中是否包含某个数
	 * @param list
	 * @param data
	 * @return
	 */
	public boolean isInclude(ArrayList list,int data){
		for(int i=0;i<list.size();i++){
			int k=Integer.parseInt(list.get(i).toString());
			if(k==data)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helloboy hb=new Helloboy();
		int min=1;
		int max=100000;
		
		ArrayList perfectlist=hb.findPerfectDigit(min, max);
		if(perfectlist.isEmpty()){
			System.out.println("There is no perfectdigit between "+min+" and " +max);
		}else{
			String str="";
			for(int i=0;i<perfectlist.size();i++){
				str+=perfectlist.get(i)+" ";
			}
			System.out.println(str+"is the perfectdigit between "+min+" and " +max);
		}
		
		ArrayList friendlist=hb.findFriendDigit(min, max);
		if(friendlist.isEmpty()){
			System.out.println("There is no frienddigit between "+min+" and " +max);
		}else{
			String string="";
			for(int i=0;i<friendlist.size();i++){
				int[] arr=(int[])friendlist.get(i);;//这个转换折腾死我了
				String str="(";
				for(int k=0;k<arr.length;k++){
					if(k!=arr.length-1)
						str+=arr[k]+" ";
					else
						str+=arr[k];
				}
				str+=") ";
				string+=str;
			}
			System.out.println(string+"are the perfectdigit between "+min+" and " +max);
		}
	}

}
