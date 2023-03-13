package prog2.exercise4.flight.booking.system;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;


public class FlightBooking {
    enum BookingClass{
        FIRST,BUSINESS,ECONOMY
    }
    enum TripType{
        ONE_WAY,RETURN

    }
    enum TripSource{
        BEIJING, SHANGHAI, OULU, NANJING, PARIS,HELSINKI
    }
    enum TripDestination{
        BEIJING, SHANGHAI, OULU, NANJING, PARIS,HELSINKI
    }
    enum SourceAirport{
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport,
        Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport,
        Paris_Charles_de_Gaulle_Airport
    }
    enum Destinationairport{
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport,
        Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport,
        Paris_Charles_de_Gaulle_Airport
    }
    private final String flightCompany = "Flights-of-Fancy";
    private String passengerFullName;
    private String flightID;
    private TripSource tripSource ;
    private SourceAirport sourceAirport ;
    private TripDestination tripDestination;
    private Destinationairport destinationAirport;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    private String ticketNumber;
    private BookingClass bookingClass;
    private TripType tripType;
    private Destinationairport destinationairport;
    private String classification;


    public FlightBooking (String passengerFullName,LocalDate departureDate,LocalDate returnDate,int childPassengers,int adultPassengers){
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        setTotalPassengers( childPassengers, adultPassengers);
    }
    public BookingClass getBookingClass(){
        return bookingClass;
    }
    public void setBookingClass(String _book){
        switch (_book){
            case "1":
                this.bookingClass = BookingClass.FIRST;
                break;
            case "2":
                this.bookingClass = BookingClass.BUSINESS;
                break;
            case "3":
                this.bookingClass = BookingClass.ECONOMY;
                break;
            default:
                System.out.println("Please enter the correct number");
                break;
        }

    }
    public void setTripType(String _type){
        switch (_type) {
            case "1":
                this.tripType = TripType.ONE_WAY;
                break;
            case "2":
                this.tripType = TripType.RETURN;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }

    public void setTripSource(String _source)
    {
        switch (_source){
            case "1":
                this.tripSource = TripSource.NANJING;
                this.sourceAirport = SourceAirport.Nanjing_Lukou_International_Airport;
                break;
            case "2":
                this.tripSource = TripSource.BEIJING;
                this.sourceAirport = SourceAirport.Beijing_Capital_International_Airport;
                break;
            case "3":
                this.tripSource = TripSource.OULU;
                this.sourceAirport = SourceAirport.Oulu_Airport;
                return;
            case "4":
                this.tripSource = TripSource.HELSINKI;
                this.sourceAirport = SourceAirport.Helsinki_Airport;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }
    public void setTripDestination(String _source,String _destination)
    {
        switch (_destination){
            case "1":
                this.tripDestination = TripDestination.NANJING;
                this.destinationairport = Destinationairport.Nanjing_Lukou_International_Airport;
                break;
            case "2":
                this.tripDestination = TripDestination.BEIJING;
                this.destinationairport = Destinationairport.Beijing_Capital_International_Airport;
                break;
            case "3":
                this.tripDestination = TripDestination.OULU;
                this.destinationairport = Destinationairport.Oulu_Airport;
                break;
            case "4":
                this.tripDestination = TripDestination.HELSINKI;
                this.destinationairport = Destinationairport.Helsinki_Airport;
                break;
            default:
                System.out.println("Please enter the correct number");
        }
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate){
            Period p = Period.between(departureDate,returnDate);
            if (p.getDays() < 2 && p.getMonths() <=0 &&p.getYears()<=0) {
                this.returnDate = departureDate.plusDays(2);
            } else
                this.returnDate = returnDate;

    }

    public static int daysBetween(LocalDate date1str, LocalDate date2str) throws ParseException {
        int count = 0;
        if("".equals(date1str) || date1str == null || "".equals(date2str) || date2str == null) {
            return count;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = format.parse(String.valueOf(date1str));
        Date date2 = format.parse(String.valueOf(date2str));
        count = Math.abs((int) ((date1.getTime() - date2.getTime()) / (1000*3600*24)));
        return count;
    }
    public void setClassification(String _source,String _destination)
    {
      String x = _source +  _destination;
      if (x.equals("NANJINGBEIJING")||x.equals("BEIJINGNANJING")||x.equals("OULUHELSINKI")||x.equals("HELSINKIOULU"))
      {
         this.classification = "domestic";
      }
      else
          this.classification = "international";
    }


    public String getFlightCompany()
    {
        return flightCompany;
    }
    public TripSource getTripSource()
    {
        return tripSource;
    }
    public TripDestination getTripDestination()
    {
        return tripDestination;
    }

    public String getPassengerFullName()
    {
        return passengerFullName;
    }

    public LocalDate getDepartureDate(){
        return departureDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }


    public int getChildPassengers(){
        return childPassengers;
    }

    public int getAdultPassengers(){
        return adultPassengers;
    }

    public int getTotalPassengers()
    {
        return totalPassengers;
    }
    public void setTotalPassengers(int childPassengers,int adultPassengers){
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public double getDepartingTicketPrice()
    {
        return departingTicketPrice;
    }
    public void setDepartingTicketPrice(int childPassengers,int adultPassengers)
    {
        setClassification(tripSource.toString(),tripDestination.toString());
        switch (bookingClass) {
            case FIRST:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers+adultPassengers) *345 +250;
                else
                    this.departingTicketPrice = (childPassengers+adultPassengers) *375 +250;
                break;
            case BUSINESS:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers+adultPassengers) *345 +150;
                else
                    this.departingTicketPrice = (childPassengers+adultPassengers) *375 +150;
                break;
            case ECONOMY:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers+adultPassengers) *345 +50;
                else
                    this.departingTicketPrice = (childPassengers+adultPassengers) *375 +50;
            default:
                break;
        }

    }
    public double getReturnTicketPrice()
    {
        return returnTicketPrice;
    }
    public void setReturnTicketPrice(){
        switch (tripType){
            case ONE_WAY:
                this.returnTicketPrice = 0;
                break;
            case RETURN:
                this.returnTicketPrice = departingTicketPrice;
                break;
            default:
                break;
        }
    }
    public double getTotalTicketPrice()
    {
        return totalTicketPrice;
    }
    public void setTotalTicketPrice(){
        this.totalTicketPrice = departingTicketPrice + returnTicketPrice;
    }
    public String getTicketNumber()
    {
        setTicketNumber();
        return ticketNumber;
    }
    public void setTicketNumber()
    {   setClassification(tripSource.toString(),tripDestination.toString());
        Random rnd = new Random();
        int number = rnd.nextInt(1000,9999);
        String m = String.valueOf(number);
        switch (bookingClass){
            case FIRST:
                if (tripType.equals(TripType.ONE_WAY))
                {
                    if (classification.equals("domestic"))
                        this.ticketNumber = "11" + "F" + m + "DOM";
                    else
                        this.ticketNumber = "11" + "F" + m + "INT";
                }
                else{
                    if (classification.equals("domestic"))
                        this.ticketNumber = "22" + "F" + m + "DOM";
                    else
                        this.ticketNumber = "22" + "F" + m + "INT";
                }
                break;
            case BUSINESS:
                if (tripType.equals(TripType.ONE_WAY))
                {
                    if (classification.equals("international"))
                        this.ticketNumber = "11" + "B" + m + "DOM";
                    else
                        this.ticketNumber = "11" + "B" + m + "INT";
                }
                else{
                    if (classification.equals("domestic"))
                        this.ticketNumber = "22" + "B" + m + "DOM";
                    else
                        this.ticketNumber = "22" + "B" + m + "INT";
                }
                break;
            case ECONOMY:
                if (tripType.equals(TripType.ONE_WAY))
                {
                    if (classification.equals("international"))
                        this.ticketNumber = "11" + "E" + m + "DOM";
                    else
                        this.ticketNumber = "11" + "E" + m + "INT";
                }
                else{
                    if (classification.equals("domestic"))
                        this.ticketNumber = "22" + "E" + m + "DOM";
                    else
                        this.ticketNumber = "22" + "E" + m + "INT";
                }
                break;
            default:
                break;
        }
    }
    public String toString()
    {
        String x = "Dear " + passengerFullName+". Thank you for booking your flight with "+ flightCompany+".\nFollowing are the details of your booking and the trip: \nTicket Number:"
                +getTicketNumber()+"\nFrom " +getTripSource()+ " to "+getTripDestination() +"\nDate of departure: "+departureDate+"\nDate of return: "+getReturnDate()+"(Changed from old returningDate to new returningDate)\nTotal passengers:"+
                totalPassengers+"\nTotal ticket price in Euros: "+totalTicketPrice;

        String y = "Dear " + passengerFullName+". Thank you for booking your flight with "+ flightCompany+".\nFollowing are the details of your booking and the trip: \nTicket Number:"
                +getTicketNumber()+"\nFrom " +getTripSource()+ " to "+getTripDestination() +"\nDate of departure: "+departureDate+"\nDate of return: "+getReturnDate()+"(Changed from old returningDate to new returningDate)\nTotal passengers:"+
                totalPassengers+"\nTotal ticket price in Euros: "+totalTicketPrice+"\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was \n" +
                "less than two days apart from your departure date.";
        Period p = Period.between(departureDate,returnDate);
        if (p.getDays() < 2 && p.getMonths() <=0 &&p.getYears()<=0)
        {
            return y;
        }
        else
            return x;

    }



}
