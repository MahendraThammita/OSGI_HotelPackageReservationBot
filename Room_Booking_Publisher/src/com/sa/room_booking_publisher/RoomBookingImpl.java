/**
 * 
 */
package com.sa.room_booking_publisher;

/**
 * @author akila liyanage
 *
 */
public class RoomBookingImpl implements IRoomBooking{
	
	public RoomBookingImpl() {
		// TODO Auto-generated constructor stub
		
		System.out.println("Hi welcome to the Room Booking service, please proceed with the relevent information askig hereafter. Thank you");
	}

	@Override
	public RoomBookingImpl getUserName() {
		// TODO Auto-generated method stub
		
		return this;
		
	}

	@Override
	public RoomBookingImpl headCount() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public RoomBookingImpl getNightCount() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public RoomBookingImpl getChildrenCount() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public RoomBookingImpl checkInDate() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public RoomBookingImpl checkOutDate() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public void lifeCycleMethod() {
		// TODO Auto-generated method stub
		//channing the methods
		
		new RoomBookingImpl().getUserName().headCount().getChildrenCount().checkInDate().checkOutDate();
		
	}

	


}
