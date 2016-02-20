package com.learnSeries.structures.arrays.disorder;

public class DisorderNoIndexNoRepetition {

	private int length = 0;
	private int currentIndex = 0;
	private int[] arrs = null;
	
	public DisorderNoIndexNoRepetition(int length){
		arrs = new int[length];
		this.length = length;
	}
	
	/**
	 * Use this function you will insert a data into an array
	 * @param The data what you1 want to add array
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
	 * With this method, You will delete a data in an array
	 * @param The data what you want to remove in arrays
	 */
	public void removeArr(int data){
		
		int dataIndex = getIndexByData(data);
		
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
	public int queryByIndex(int data){
		int dataIndex = getIndexByData(data);
		int result = -1;
		
		if(dataIndex>currentIndex-1){
			System.out.println("当前位置没有数据");
		}else{
			result = arrs[dataIndex];
		}
		
		return result;
	}
	
	/**
	 * Get a data in array what you want to
	 * @param data
	 * @return
	 */
	public int queryByData(int data){
		
		for(int i=0;i<currentIndex;i++){
			if(arrs[i] == data){
				return arrs[i];
			}
		}
		
		return -1;
	}
	
	/**
	 * Get a data index by a data what you want to
	 * @param data
	 * @return the data index
	 */
	private int getIndexByData(int data){
		
		for(int i=0;i<currentIndex;i++){
			if(arrs[i] == data){
				return i;
			}
		}
		
		return -1;
	}
	
	public void printArrays(){
		System.out.println("=======================================>");
		for(int i=0;i<arrs.length;i++){
			System.out.println("This is arr["+i+"] = "+arrs[i]);
		}
	}
	
	public static void main(String[] args) {

		DisorderNoIndexNoRepetition noOrdernr = new DisorderNoIndexNoRepetition(6);
		noOrdernr.insertArr(5);
		noOrdernr.insertArr(3);
		noOrdernr.insertArr(1);
		noOrdernr.insertArr(4);
		noOrdernr.insertArr(6);
		
		noOrdernr.printArrays();
		
		noOrdernr.removeArr(3);
		noOrdernr.printArrays();
		
		System.out.println("===============================>"+noOrdernr.queryByData(3));
		
	}

}
