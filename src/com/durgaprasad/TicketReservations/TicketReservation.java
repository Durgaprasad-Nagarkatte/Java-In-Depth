package com.durgaprasad.TicketReservations;

import java.util.*;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    // This getter is used only by the junit test case.
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    /**
     * Returns true if passenger could be added into either confirmedList or
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     *
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        if ((confirmedList.size() == CONFIRMEDLIST_LIMIT) &&  (waitingList.size() == WAITINGLIST_LIMIT)){
            return false;
        }
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if(confirmedList.size() < CONFIRMEDLIST_LIMIT){
            confirmedList.add(passenger);
        }
        else{
            waitingList.add(passenger);
        }
        return true;
    }

    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method
     * will be tested separately by the uploaded test scripts.

     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList. Use poll() method (not remove()) to extract the passenger
     * from waitingList.
     */
    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> iterator = confirmedList.iterator();
        boolean isPresent = removePassenger(iterator, confirmationNumber);

        if(isPresent){
            if(!waitingList.isEmpty()){
                Passenger temp = waitingList.poll();
                confirmedList.add(temp);
            }
        }
        else{
            iterator = waitingList.iterator();
            isPresent = removePassenger(iterator, confirmationNumber);
        }
        return isPresent;
    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while(iterator.hasNext()){
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber() == confirmationNumber){
                iterator.remove();
                return  true;
            }
        }
        return false;
    }

}