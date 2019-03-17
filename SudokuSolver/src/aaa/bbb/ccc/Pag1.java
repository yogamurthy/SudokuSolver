package aaa.bbb.ccc;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Pag1 
{

	public int[][] a=new int[9][9];;
	public String b[]=new String[81] ;

	public int box1[]= {0,1,2,9,10,11,18,19,20};
	public int box2[]= {3,4,5,12,13,14,21,22,23};
	public int box3[]= {6,7,8,15,16,17,24,25,26};
	public int box4[]= {27,28,29,36,37,38,45,46,47};
	public int box5[]= {30,31,32,39,40,41,48,49,50};
	public int box6[]= {33,34,35,42,43,44,51,52,53};
	public int box7[]= {54,55,56,63,64,65,72,73,74};
	public int box8[]= {57,58,59,66,67,68,75,76,77};
	public int box9[]= {60,61,62,69,70,71,78,79,80};
	public String current="";
	public String previous="";

	
	public static void main(String[] args) 
	{
		
		System.out.println(System.currentTimeMillis());
		Pag1 m=new Pag1();
		m.main1();
		System.out.println(System.currentTimeMillis());
	}
	
	
	public void main1()
	{
		
		//enter the input in this array like given example for your sudoku
//		a[0][0]=0;a[0][1]=0;a[0][2]=0;a[0][3]=0;a[0][4]=0;a[0][5]=0;a[0][6]=0;a[0][7]=0;a[0][8]=0;
//		a[1][0]=0;a[1][1]=0;a[1][2]=0;a[1][3]=0;a[1][4]=0;a[1][5]=0;a[1][6]=0;a[1][7]=0;a[1][8]=0;
//		a[2][0]=0;a[2][1]=0;a[2][2]=0;a[2][3]=0;a[2][4]=0;a[2][5]=0;a[2][6]=0;a[2][7]=0;a[2][8]=0;
//		a[3][0]=0;a[3][1]=0;a[3][2]=0;a[3][3]=0;a[3][4]=0;a[3][5]=0;a[3][6]=0;a[3][7]=0;a[3][8]=0;
//		a[4][0]=0;a[4][1]=0;a[4][2]=0;a[4][3]=0;a[4][4]=0;a[4][5]=0;a[4][6]=0;a[4][7]=0;a[4][8]=0;
//		a[5][0]=0;a[5][1]=0;a[5][2]=0;a[5][3]=0;a[5][4]=0;a[5][5]=0;a[5][6]=0;a[5][7]=0;a[5][8]=0;
//		a[6][0]=0;a[6][1]=0;a[6][2]=0;a[6][3]=0;a[6][4]=0;a[6][5]=0;a[6][6]=0;a[6][7]=0;a[6][8]=0;
//		a[7][0]=0;a[7][1]=0;a[7][2]=0;a[7][3]=0;a[7][4]=0;a[7][5]=0;a[7][6]=0;a[7][7]=0;a[7][8]=0;
//		a[8][0]=0;a[8][1]=0;a[8][2]=0;a[8][3]=0;a[8][4]=0;a[8][5]=0;a[8][6]=0;a[8][7]=0;a[8][8]=0;
		
		a[0][0]=0;a[0][1]=0;a[0][2]=0;a[0][3]=0;a[0][4]=4;a[0][5]=5;a[0][6]=0;a[0][7]=2;a[0][8]=0;
		a[1][0]=7;a[1][1]=0;a[1][2]=0;a[1][3]=0;a[1][4]=1;a[1][5]=0;a[1][6]=5;a[1][7]=0;a[1][8]=4;
		a[2][0]=2;a[2][1]=0;a[2][2]=0;a[2][3]=8;a[2][4]=0;a[2][5]=0;a[2][6]=0;a[2][7]=0;a[2][8]=0;
		a[3][0]=0;a[3][1]=9;a[3][2]=0;a[3][3]=0;a[3][4]=7;a[3][5]=0;a[3][6]=8;a[3][7]=0;a[3][8]=3;
		a[4][0]=0;a[4][1]=0;a[4][2]=0;a[4][3]=0;a[4][4]=2;a[4][5]=0;a[4][6]=0;a[4][7]=0;a[4][8]=0;
		a[5][0]=4;a[5][1]=0;a[5][2]=5;a[5][3]=0;a[5][4]=8;a[5][5]=0;a[5][6]=0;a[5][7]=7;a[5][8]=0;
		a[6][0]=0;a[6][1]=0;a[6][2]=0;a[6][3]=0;a[6][4]=0;a[6][5]=4;a[6][6]=0;a[6][7]=0;a[6][8]=9;
		a[7][0]=5;a[7][1]=0;a[7][2]=1;a[7][3]=0;a[7][4]=3;a[7][5]=0;a[7][6]=0;a[7][7]=0;a[7][8]=8;
		a[8][0]=0;a[8][1]=6;a[8][2]=0;a[8][3]=7;a[8][4]=5;a[8][5]=0;a[8][6]=0;a[8][7]=0;a[8][8]=0;
	
		//set value into b-array
		for (int i=0;i<81;i++) {
			b[i]="1,2,3,4,5,6,7,8,9";}

		Sync_A_to_B();
		
		for (int a=0;a<19;a++) {
			RowCleanup();
			ColumnCleanUp();
			all_box_cleanup();
			all_row_unique_values();
			all_column_unique_values();
			all_box_unique_values();
			
			
			Sync_B_to_A();	
			
			if(current.equals("")) {
				current=merge_b_array();			
			}
			else
			{
				previous=current;
				current=merge_b_array();
				if(current.indexOf(",")<0)
				{
					System.out.println("Number of iterations"+a);
					printSudoku();
					a=19;
				}
			}
		}
	}
	
	public String merge_b_array() {
		return String.join("", b);
	}
	
	public void all_row_unique_values()
	{
		row1_unique_values();row4_unique_values();row7_unique_values();
		row2_unique_values();row5_unique_values();row8_unique_values();
		row3_unique_values();row6_unique_values();row9_unique_values();
	}
	
	public void row1_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=0;i<9;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		
		if(value1==1){row1_setValues(1);}
		if(value2==1){row1_setValues(2);}
		if(value3==1){row1_setValues(3);}
		if(value4==1){row1_setValues(4);}
		if(value5==1){row1_setValues(5);}
		if(value6==1){row1_setValues(6);}
		if(value7==1){row1_setValues(7);}
		if(value8==1){row1_setValues(8);}
		if(value9==1){row1_setValues(9);}

	}
	public void row1_setValues(int value)
	{
		for(int i=0;i<9;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}	
	public void row2_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=9;i<18;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row2_setValues(1);}
		if(value2==1){row2_setValues(2);}
		if(value3==1){row2_setValues(3);}
		if(value4==1){row2_setValues(4);}
		if(value5==1){row2_setValues(5);}
		if(value6==1){row2_setValues(6);}
		if(value7==1){row2_setValues(7);}
		if(value8==1){row2_setValues(8);}
		if(value9==1){row2_setValues(9);}
	}

	public void row2_setValues(int value)
	{
		for(int i=9;i<18;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	public void row3_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=18;i<27;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row3_setValues(1);}
		if(value2==1){row3_setValues(2);}
		if(value3==1){row3_setValues(3);}
		if(value4==1){row3_setValues(4);}
		if(value5==1){row3_setValues(5);}
		if(value6==1){row3_setValues(6);}
		if(value7==1){row3_setValues(7);}
		if(value8==1){row3_setValues(8);}
		if(value9==1){row3_setValues(9);}
	}

	public void row3_setValues(int value)
	{
		for(int i=18;i<27;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	public void row4_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=27;i<36;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row4_setValues(1);}
		if(value2==1){row4_setValues(2);}
		if(value3==1){row4_setValues(3);}
		if(value4==1){row4_setValues(4);}
		if(value5==1){row4_setValues(5);}
		if(value6==1){row4_setValues(6);}
		if(value7==1){row4_setValues(7);}
		if(value8==1){row4_setValues(8);}
		if(value9==1){row4_setValues(9);}
	}

	public void row4_setValues(int value)
	{
		for(int i=27;i<36;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	public void row5_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=36;i<45;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row5_setValues(1);}
		if(value2==1){row5_setValues(2);}
		if(value3==1){row5_setValues(3);}
		if(value4==1){row5_setValues(4);}
		if(value5==1){row5_setValues(5);}
		if(value6==1){row5_setValues(6);}
		if(value7==1){row5_setValues(7);}
		if(value8==1){row5_setValues(8);}
		if(value9==1){row5_setValues(9);}
	}

	public void row5_setValues(int value)
	{
		for(int i=36;i<45;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	public void row6_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=45;i<54;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row6_setValues(1);}
		if(value2==1){row6_setValues(2);}
		if(value3==1){row6_setValues(3);}
		if(value4==1){row6_setValues(4);}
		if(value5==1){row6_setValues(5);}
		if(value6==1){row6_setValues(6);}
		if(value7==1){row6_setValues(7);}
		if(value8==1){row6_setValues(8);}
		if(value9==1){row6_setValues(9);}
	}

	public void row6_setValues(int value)
	{
		for(int i=45;i<54;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	public void row7_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=54;i<63;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row7_setValues(1);}
		if(value2==1){row7_setValues(2);}
		if(value3==1){row7_setValues(3);}
		if(value4==1){row7_setValues(4);}
		if(value5==1){row7_setValues(5);}
		if(value6==1){row7_setValues(6);}
		if(value7==1){row7_setValues(7);}
		if(value8==1){row7_setValues(8);}
		if(value9==1){row7_setValues(9);}
	}

	public void row7_setValues(int value)
	{
		for(int i=54;i<63;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	public void row8_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=63;i<72;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row8_setValues(1);}
		if(value2==1){row8_setValues(2);}
		if(value3==1){row8_setValues(3);}
		if(value4==1){row8_setValues(4);}
		if(value5==1){row8_setValues(5);}
		if(value6==1){row8_setValues(6);}
		if(value7==1){row8_setValues(7);}
		if(value8==1){row8_setValues(8);}
		if(value9==1){row8_setValues(9);}
	}

	public void row8_setValues(int value)
	{
		for(int i=63;i<72;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	
	public void row9_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=72;i<81;i++)
		{
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a))
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){row9_setValues(1);}
		if(value2==1){row9_setValues(2);}
		if(value3==1){row9_setValues(3);}
		if(value4==1){row9_setValues(4);}
		if(value5==1){row9_setValues(5);}
		if(value6==1){row9_setValues(6);}
		if(value7==1){row9_setValues(7);}
		if(value8==1){row9_setValues(8);}
		if(value9==1){row9_setValues(9);}
	}

	public void row9_setValues(int value)
	{
		for(int i=72;i<81;i++)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}

	
	public void all_column_unique_values() 
	{
		column1_unique_values();column2_unique_values();column3_unique_values();
		column4_unique_values();column5_unique_values();column6_unique_values();
		column7_unique_values();column8_unique_values();column9_unique_values();	
	}
	
	public void Sync_B_to_A()
	{
		for ( int f=0;f<81;f++)
		{
			int[] temp_array=ConvertNumberToPosition(f);
			if(b[f].length()==1) {
				a[temp_array[0]][temp_array[1]]=Integer.parseInt(b[f]);
			}
		}
	}
	
	public void column1_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=0;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column1_setValues(1);}
		if(value2==1){column1_setValues(2);}
		if(value3==1){column1_setValues(3);}
		if(value4==1){column1_setValues(4);}
		if(value5==1){column1_setValues(5);}
		if(value6==1){column1_setValues(6);}
		if(value7==1){column1_setValues(7);}
		if(value8==1){column1_setValues(8);}
		if(value9==1){column1_setValues(9);}
	}
	
	public void column1_setValues(int value)
	{
		for(int i=0;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column2_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=1;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column2_setValues(1);}
		if(value2==1){column2_setValues(2);}
		if(value3==1){column2_setValues(3);}
		if(value4==1){column2_setValues(4);}
		if(value5==1){column2_setValues(5);}
		if(value6==1){column2_setValues(6);}
		if(value7==1){column2_setValues(7);}
		if(value8==1){column2_setValues(8);}
		if(value9==1){column2_setValues(9);}
	}
	
	public void column2_setValues(int value)
	{
		for(int i=1;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column3_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=2;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column3_setValues(1);}
		if(value2==1){column3_setValues(2);}
		if(value3==1){column3_setValues(3);}
		if(value4==1){column3_setValues(4);}
		if(value5==1){column3_setValues(5);}
		if(value6==1){column3_setValues(6);}
		if(value7==1){column3_setValues(7);}
		if(value8==1){column3_setValues(8);}
		if(value9==1){column3_setValues(9);}
	}
	
	public void column3_setValues(int value)
	{
		for(int i=2;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column4_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=3;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column4_setValues(1);}
		if(value2==1){column4_setValues(2);}
		if(value3==1){column4_setValues(3);}
		if(value4==1){column4_setValues(4);}
		if(value5==1){column4_setValues(5);}
		if(value6==1){column4_setValues(6);}
		if(value7==1){column4_setValues(7);}
		if(value8==1){column4_setValues(8);}
		if(value9==1){column4_setValues(9);}
	}
	
	public void column4_setValues(int value)
	{
		for(int i=3;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column5_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=4;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column5_setValues(1);}
		if(value2==1){column5_setValues(2);}
		if(value3==1){column5_setValues(3);}
		if(value4==1){column5_setValues(4);}
		if(value5==1){column5_setValues(5);}
		if(value6==1){column5_setValues(6);}
		if(value7==1){column5_setValues(7);}
		if(value8==1){column5_setValues(8);}
		if(value9==1){column5_setValues(9);}
	}
	
	public void column5_setValues(int value)
	{
		for(int i=4;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column6_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=5;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column6_setValues(1);}
		if(value2==1){column6_setValues(2);}
		if(value3==1){column6_setValues(3);}
		if(value4==1){column6_setValues(4);}
		if(value5==1){column6_setValues(5);}
		if(value6==1){column6_setValues(6);}
		if(value7==1){column6_setValues(7);}
		if(value8==1){column6_setValues(8);}
		if(value9==1){column6_setValues(9);}
	}
	
	public void column6_setValues(int value)
	{
		for(int i=5;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column7_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=6;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column7_setValues(1);}
		if(value2==1){column7_setValues(2);}
		if(value3==1){column7_setValues(3);}
		if(value4==1){column7_setValues(4);}
		if(value5==1){column7_setValues(5);}
		if(value6==1){column7_setValues(6);}
		if(value7==1){column7_setValues(7);}
		if(value8==1){column7_setValues(8);}
		if(value9==1){column7_setValues(9);}
	}
	
	public void column7_setValues(int value)
	{
		for(int i=6;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column8_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=7;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column8_setValues(1);}
		if(value2==1){column8_setValues(2);}
		if(value3==1){column8_setValues(3);}
		if(value4==1){column8_setValues(4);}
		if(value5==1){column8_setValues(5);}
		if(value6==1){column8_setValues(6);}
		if(value7==1){column8_setValues(7);}
		if(value8==1){column8_setValues(8);}
		if(value9==1){column8_setValues(9);}
	}
	
	public void column8_setValues(int value)
	{
		for(int i=7;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	
	public void column9_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for ( int i=8;i<81;i+=9)
		{			
			String position_value=b[i];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
				{
					case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
					case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
					case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
				}
			}
		}
		if(value1==1){column9_setValues(1);}
		if(value2==1){column9_setValues(2);}
		if(value3==1){column9_setValues(3);}
		if(value4==1){column9_setValues(4);}
		if(value5==1){column9_setValues(5);}
		if(value6==1){column9_setValues(6);}
		if(value7==1){column9_setValues(7);}
		if(value8==1){column9_setValues(8);}
		if(value9==1){column9_setValues(9);}
	}
	
	public void column9_setValues(int value)
	{
		for(int i=8;i<81;i+=9)
		{
			String temp=b[i];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(i);
				a[temp_array[0]][temp_array[1]]=value;
				b[i]=String.valueOf(value);
			}
		}
	}
	public void all_box_unique_values()
	{
		box1_unique_values();box2_unique_values();box3_unique_values();
		box4_unique_values();box5_unique_values();box6_unique_values();
		box7_unique_values();box8_unique_values();box9_unique_values();
	}
	public void box1_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box1[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box1_setValues(1);}
		if(value2==1){box1_setValues(2);}
		if(value3==1){box1_setValues(3);}
		if(value4==1){box1_setValues(4);}
		if(value5==1){box1_setValues(5);}
		if(value6==1){box1_setValues(6);}
		if(value7==1){box1_setValues(7);}
		if(value8==1){box1_setValues(8);}
		if(value9==1){box1_setValues(9);}
	}//end of box1 unique values
	
	public void box1_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box1[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box2_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box2[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box2_setValues(1);}
		if(value2==1){box2_setValues(2);}
		if(value3==1){box2_setValues(3);}
		if(value4==1){box2_setValues(4);}
		if(value5==1){box2_setValues(5);}
		if(value6==1){box2_setValues(6);}
		if(value7==1){box2_setValues(7);}
		if(value8==1){box2_setValues(8);}
		if(value9==1){box2_setValues(9);}
	}//end of box2 unique values
	
	public void box2_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box2[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box3_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box3[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box3_setValues(1);}
		if(value2==1){box3_setValues(2);}
		if(value3==1){box3_setValues(3);}
		if(value4==1){box3_setValues(4);}
		if(value5==1){box3_setValues(5);}
		if(value6==1){box3_setValues(6);}
		if(value7==1){box3_setValues(7);}
		if(value8==1){box3_setValues(8);}
		if(value9==1){box3_setValues(9);}
	}//end of box3 unique values
	
	public void box3_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box3[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box4_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box4[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box4_setValues(1);}
		if(value2==1){box4_setValues(2);}
		if(value3==1){box4_setValues(3);}
		if(value4==1){box4_setValues(4);}
		if(value5==1){box4_setValues(5);}
		if(value6==1){box4_setValues(6);}
		if(value7==1){box4_setValues(7);}
		if(value8==1){box4_setValues(8);}
		if(value9==1){box4_setValues(9);}
	}//end of box4 unique values
	
	public void box4_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box4[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box5_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box5[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box5_setValues(1);}
		if(value2==1){box5_setValues(2);}
		if(value3==1){box5_setValues(3);}
		if(value4==1){box5_setValues(4);}
		if(value5==1){box5_setValues(5);}
		if(value6==1){box5_setValues(6);}
		if(value7==1){box5_setValues(7);}
		if(value8==1){box5_setValues(8);}
		if(value9==1){box5_setValues(9);}
	}//end of box5 unique values
	
	public void box5_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box5[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box6_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box6[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box6_setValues(1);}
		if(value2==1){box6_setValues(2);}
		if(value3==1){box6_setValues(3);}
		if(value4==1){box6_setValues(4);}
		if(value5==1){box6_setValues(5);}
		if(value6==1){box6_setValues(6);}
		if(value7==1){box6_setValues(7);}
		if(value8==1){box6_setValues(8);}
		if(value9==1){box6_setValues(9);}
	}//end of box6 unique values
	
	public void box6_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box6[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box7_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box7[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box7_setValues(1);}
		if(value2==1){box7_setValues(2);}
		if(value3==1){box7_setValues(3);}
		if(value4==1){box7_setValues(4);}
		if(value5==1){box7_setValues(5);}
		if(value6==1){box7_setValues(6);}
		if(value7==1){box7_setValues(7);}
		if(value8==1){box7_setValues(8);}
		if(value9==1){box7_setValues(9);}
	}//end of box7 unique values
	
	public void box7_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box7[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box8_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box8[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box8_setValues(1);}
		if(value2==1){box8_setValues(2);}
		if(value3==1){box8_setValues(3);}
		if(value4==1){box8_setValues(4);}
		if(value5==1){box8_setValues(5);}
		if(value6==1){box8_setValues(6);}
		if(value7==1){box8_setValues(7);}
		if(value8==1){box8_setValues(8);}
		if(value9==1){box8_setValues(9);}
	}//end of box8 unique values
	
	public void box8_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box8[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void box9_unique_values()
	{
		int value1,value2,value3,value4,value5,value6,value7,value8,value9;
		value1=value2=value3=value4=value5=value6=value7=value8=value9=0;
		for (int i=0;i<9;i++)
		{
			int position=box9[i];
			String position_value=b[position];
			List<String> temp_array=ConvertStringToArray(position_value);
			for(String a:temp_array)
			{
				switch(Integer.parseInt(a)) 
					{
						case 1: value1++;break;case 2: value2++;break;case 3: value3++;break;
						case 4: value4++;break;case 5: value5++;break;case 6: value6++;break;
						case 7: value7++;break;case 8: value8++;break;case 9: value9++;break;
					}
			}
		}
		if(value1==1){box9_setValues(1);}
		if(value2==1){box9_setValues(2);}
		if(value3==1){box9_setValues(3);}
		if(value4==1){box9_setValues(4);}
		if(value5==1){box9_setValues(5);}
		if(value6==1){box9_setValues(6);}
		if(value7==1){box9_setValues(7);}
		if(value8==1){box9_setValues(8);}
		if(value9==1){box9_setValues(9);}
	}//end of box9 unique values
	
	public void box9_setValues(int value) 
	{
		for(int j=0;j<9;j++)
		{
			int position=box9[j];
			String temp=b[position];
			if(String.valueOf(temp).contains(String.valueOf(value))==true)
			{
				int temp_array[]=ConvertNumberToPosition(position);
				a[temp_array[0]][temp_array[1]]=value;
				b[position]=String.valueOf(value);
			}
		}
	}
	
	public void row_unique_values() {}

	public void all_box_cleanup()
	{
		box1_cleanup();box2_cleanup();box3_cleanup();
		box4_cleanup();box5_cleanup();box6_cleanup();
		box7_cleanup();box8_cleanup();box9_cleanup();
	}
	
	public void box1_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box1[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box1[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box1_cleanup
	
	public void box2_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box2[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box2[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box2_cleanup
	
	public void box3_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box3[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box3[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box3_cleanup
	
	public void box4_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box4[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box4[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box4_cleanup

	
	public void box5_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box5[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box5[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box5_cleanup
	
	public void box6_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box6[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box6[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box6_cleanup
	
	public void box7_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box7[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box7[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box7_cleanup
	
	public void box8_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box8[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box8[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box8_cleanup
	
	public void box9_cleanup()
	{
		for (int i=0;i<9;i++)
		{
			int position=box9[i];
			
			int[] array_position_2d=ConvertNumberToPosition(position);
			int position_value=a[array_position_2d[0]][array_position_2d[1]];
			
			if(position_value>0)
			{
				for(int j=0;j<9;j++)
				{
					int position1=box9[j];
					if(position!=position1)
					{
						String csv_from_b_array=b[position1];
						List<String> temp_array=ConvertStringToArray(csv_from_b_array);
						temp_array.remove(String.valueOf(position_value));	
						b[position1]=temp_array.stream().map(n -> n.toString()).collect(Collectors.joining(","));
					}					
				}
			}
		}
	}//end of box9_cleanup
	
	
	public int[] ConvertNumberToPosition(int number) {
		int divide=number/9;
		int modulus=number%9;
		
		return new int[] {divide,modulus} ;
	}
	public void RowCleanup() 
	{
		for (int line=0;line<9;line++) 
		{
			for (int column=0;column<9;column++) 
			{
				int position=line*9+column; //position of b - array
				int position_value=a[line][column];//value from a-multi dimesnional array
				
				//Clean up the line
				
				if(position_value!=0)
				{
					for (int column1=0;column1<9;column1++)
					{
						int position1=(line*9) + column1;
						if(position1!=position)
						{
							String position_value1=b[position1];
							List<String> temp_array=ConvertStringToArray(position_value1);
							temp_array.remove(String.valueOf(position_value));
							String commaSeparatedNumbers = temp_array.stream()
								     .map(n -> n.toString())
								     .collect(Collectors.joining(","));
							b[position1]=commaSeparatedNumbers;
						}
					}
				}
			}
		}
	}//end of RowCleanup() 
	
	public void ColumnCleanUp()
	{
		for (int line=0;line<9;line++) 
		{
			for (int column=0;column<9;column++) 
			{
				int position=line*9+column; //position of b - array
				int position_value=a[line][column];//value from a-multi dimesnional array
				
				//clean up the column
				if(position_value!=0) 
				{
					for (int column1=0;column1<9;column1++) {
						int position1=(column1*9) + column;
						if(position1!=position)
						{
							String position_value1=b[position1];
							List<String> temp_array=ConvertStringToArray(position_value1);
							temp_array.remove(String.valueOf(position_value));
							String commaSeparatedNumbers = temp_array.stream()
								     .map(n -> n.toString())
								     .collect(Collectors.joining(","));
							b[position1]=commaSeparatedNumbers;
						}
					}
				}
			}
		}
	}
	
	public void Sync_A_to_B()
	{
		for (int line=0;line<9;line++) 
		{
			for (int column=0;column<9;column++) 
			{
				int position=line*9+column; //position of b - array
				int position_value=a[line][column];//value from a-multi dimesnional array
				
				//match from A-> B
				if(position_value!=0)
				{
					b[position]=String.valueOf(position_value);
				}
			}
		}
	}//end of Sync_A_and_B()
	
	
	public void printSudoku()
	{
		for (int i=0;i<9;i++) 
		{
			for (int j=0;j<9;j++) 
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public void printSudokuSolver()
	{
		for (int i=0;i<81;i++)
		{
			System.out.print(b[i]);
			if((i+1)%9==0)
			{
				System.out.println("");
			}
			else
			{
				System.out.print(" | ");
			}
		}
	}
	
	public static String RemoveAllButOne(String input,int a_array)
	{
//		System.out.println(Arrays.asList(input));
//		System.out.println(a_array);
		
		List<String> input1=ConvertStringToArray(input);
//		System.out.println(Arrays.asList(input1));
		if(a_array!=0)
		{
			for (int i=1;i<=9;i++)
			{
				if(i!=a_array)
				{input1.remove(String.valueOf(i));}
			}
		}
//		System.out.println(Arrays.asList(input1));
		return String.join(",", input1);
		
	}

	public static List<String> ConvertStringToArray(String  input)
	{

		List<String> result=new LinkedList<String>(Arrays.asList(input.split("\\s*,\\s*")));
//		System.out.println(result);
		return result;
	}
	
	public static void printarray(int[][] a)
	{
		int a1[][]=a;
		for (int[] x : a1)
		{
		   for (int y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}
	}
	
}
