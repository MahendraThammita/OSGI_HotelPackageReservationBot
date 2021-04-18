package com.sa.room_booking_publisher;

public interface ITableView {
	
	  public void setRightAlign(boolean rightAlign);
	  
	  public void setShowVerticalLines(boolean showVerticalLines);
	  
	  public void setHeaders(String... headers);
	  
	  public void addRow(String... cells);
	  
	  public void print();
	  	  
}
