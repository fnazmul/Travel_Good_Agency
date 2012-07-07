/*
 *
 *
 */

package DATABASE;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import ws.niceview.types.Hotel;
import ws.niceview.types.HotelList;
import ws.niceview.types.SearchHotel;
import ws.niceview.types.HotelAddress;

/**
 *
 * @author
 */

public class HotelDummyData {

    ArrayList<Hotel> hotelDatabase;
    ArrayList<String> places;


    public HotelDummyData()
    {
        places = new ArrayList<String>();
        hotelDatabase= new ArrayList<Hotel>();        

        places.add("London");
        places.add("Copenhagen");
        places.add("Brussels");
        places.add("Paris");
        places.add("Amsterdam");
        places.add("Bonn");
        places.add("Helsinki");
        places.add("Oslo");
        places.add("Stockholm");
        places.add("Barcelona");
        places.add("Berlin");

        if (hotelDatabase.isEmpty()){
            for (String place: places){

                int index = hotelDatabase.indexOf(place);
                HotelAddress tempAddress = new HotelAddress();
                tempAddress.setCity(place);
                tempAddress.setStreet(place + " Avenue");

                Hotel tempHotel = new Hotel();
                tempHotel.setHotelName(place + " City Hotel");
                tempHotel.setHotelAddress(tempAddress);

                Random rand = new Random();
                tempHotel.setHotelBookingNo("Hotel" + index);//rand.nextInt(100));

                tempHotel.setHotelPrice(rand.nextInt(500));

                if(index>5)
                    tempHotel.setHotelCreditGurantee(false);
                else
                    tempHotel.setHotelCreditGurantee(true);
                
                tempHotel.setHotelReservationService("NiceView");
                
                hotelDatabase.add(tempHotel);
            }
        }
    }


    public Hotel getHotel(String bookingNo)
    {
        Hotel tempHotel = null;
        for (Hotel hotel : hotelDatabase ){
            if ( hotel.getHotelBookingNo().equalsIgnoreCase(bookingNo) )
                tempHotel = hotel;
        }
        return tempHotel;
    }

    
    public HotelList getHotels(SearchHotel input)
    {
        List<Hotel> findList = new ArrayList<Hotel>();
        HotelList hotelList = new HotelList();

        for (Hotel hotel : hotelDatabase )
            if (hotel.getHotelAddress().getCity().equalsIgnoreCase(input.getCity())){
                findList.add(hotel);
                //hotelList.getHotelList().add(hotel);
            }
        hotelList.getHotelList().addAll(findList);

        return hotelList;
    }
 
}
