package com.learnSeries.structures.arrays.noorder;


/**
 * 
 * 练习无序带索引数组
 * @author jiang-zh
 *
 */
public class NoOrderWithIndex {
	
	private int length = 0;
	private int currentIndex = 0;
	private int[] arrs = null;

	public NoOrderWithIndex(int length){
		arrs = new int[length];
		this.length = length;
	}
	
	/**
	 * Use this function you will insert a data into an array
	 * @param The data what want to add array
	 */
	public void insertArr(int data){
		
		//如果索引小于length才可以继续添加
		if(currentIndex<length-1){
			arrs[currentIndex] = data;
			currentIndex ++;
		}else{
			System.out.println("数组长度不足，请扩大长度");
		}
	}
	
	/**
	 * With this method, You will delete a data in an array by the data index
	 * @param The index of data what want to remove in arrays
	 */
	public void removeArr(int dataIndex){
		if(dataIndex>currentIndex){
			System.out.println("当前位置没有数据");
		}else{
			// 删除任意一条数据，后面的数据都要依次向前挪动一位
			for(int i=dataIndex;i<currentIndex;i++){
				arrs[i] = arrs[i+1];
			}
			currentIndex--;
		}
		
	}
	
	/**
	 * With this method, You will query a data in an array by the data index
	 * @param dataIndex
	 * @return The data what you want to get;
	 */
	public int queryByIndex(int dataIndex){
		int result = -1;
		
		if(dataIndex>currentIndex-1){
			System.out.println("当前位置没有数据");
		}else{
			result = arrs[dataIndex];
		}
		
		return result;
	}
	
	public void printArrays(){
		System.out.println("=======================================>");
		for(int i=0;i<arrs.length;i++){
			System.out.println("This is arr["+i+"] = "+arrs[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoOrderWithIndex nowi = new NoOrderWithIndex(6);
		nowi.insertArr(5);
		nowi.insertArr(3);
		nowi.insertArr(1);
		nowi.insertArr(4);
		nowi.insertArr(6);
		nowi.insertArr(6);
		nowi.insertArr(6);
		
		nowi.printArrays();
		
		nowi.removeArr(5);
		nowi.printArrays();
	}

}
