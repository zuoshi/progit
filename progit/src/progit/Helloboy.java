package progit;

import java.util.ArrayList;

public class Helloboy {
	
	/**
	 * ��̬����ĺ�
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
	 * ��һ�������������������Լ����������һ����̬������
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
	 * �ж�һ�����Ƿ���������
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
	 * �ж��������Ƿ����Ѻ���
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
	 * �ڸ����ķ�Χ��Ѱ��������
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
	 * �ڸ����ķ�Χ��Ѱ���Ѻ�����˼·��ȡһ�������ҳ���Լ���ĺͣ����ж�����͵�Լ���Ƿ���ѡ������ȣ������ȣ���Ϊ�Ѻ�����ע��
	 * Ϊ�˲��ظ��ж�ĳ��������ѡȡ��ʱҪ�ж�֮ǰ�Ƿ��Ѿ��ȶԹ�������ȶԹ��������������������һ������Ҫע����������Ѻ�������
	 * ��ͬ
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
	 * �ж�һ���������Ƿ����ĳ����
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
				int[] arr=(int[])friendlist.get(i);;//���ת������������
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
