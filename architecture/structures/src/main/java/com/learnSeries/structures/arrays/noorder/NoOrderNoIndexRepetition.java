package com.learnSeries.structures.arrays.noorder;

import java.util.ArrayList;
import java.util.List;

public class NoOrderNoIndexRepetition {

	private int length = 0;
	private int currentIndex = 0;
	private int[] arrs = null;
	
	public NoOrderNoIndexRepetition(int length){
		arrs = new int[length];
		this.length = length;
	}
	
	/**
	 * Use this function you will insert a data into an array
	 * @param The data what you1 want to add array
	 */
	public void insertArr(int data){
		
		//如果索引小于length才可以继续添加
		if(currentIndex<length){
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
		while(dataIndex!=-1){
			if(dataIndex>currentIndex){
				System.out.println("当前位置没有数据");
			}else{
				// 删除任意一条数据，后面的数据都要依次向前挪动一位
				for(int i=dataIndex;i<currentIndex;i++){
					if(currentIndex==length && i==currentIndex-1){
						arrs[length-1] = 0;
						break;
					}
					arrs[i] = arrs[i+1];
				}
				currentIndex--;
			}
			dataIndex = getIndexByData(data);
		}
	}
	
	/**
	 * With this method, You will query a data in an array by the data index
	 * @param dataIndex
	 * @return The data what you want to get;
	 */
	public List<Integer> queryByIndex(int data){
		List<Integer> result = new ArrayList<Integer>();
		int dataIndex = getIndexByData(data);
		while(dataIndex!=-1){
				result.add(arrs[dataIndex]);
				dataIndex = getIndexByData(data);
		}
		
		return result;
	}
	
	/**
	 * Get a data in array what you want to
	 * @param data
	 * @return
	 */
	public List<Integer> queryByData(int data){
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<currentIndex;i++){
			if(arrs[i] == data){
				result.add(arrs[i]);
			}
		}
		
		return result;
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

		NoOrderNoIndexRepetition noOrdernr = new NoOrderNoIndexRepetition(6);
		noOrdernr.insertArr(5);
		noOrdernr.insertArr(3);
		noOrdernr.insertArr(6);
		noOrdernr.insertArr(1);
		noOrdernr.insertArr(4);
		noOrdernr.insertArr(6);
		
		noOrdernr.printArrays();
		
		noOrdernr.removeArr(6);
		noOrdernr.printArrays();
		
		System.out.println("===============================>"+noOrdernr.queryByData(3));
		
	}

}
