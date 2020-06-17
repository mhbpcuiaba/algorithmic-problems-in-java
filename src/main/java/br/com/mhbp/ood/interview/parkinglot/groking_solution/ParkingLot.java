package br.com.mhbp.ood.interview.parkinglot.groking_solution;

import br.com.mhbp.ood.interview.parkinglot.groking_solution.enums.VehicleType;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private String name;
    private Address address;
    private ParkingRate parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;

    private ConcurrentHashMap<String, EntrancePanel> entrancePanels = new ConcurrentHashMap();
    private ConcurrentHashMap<String, ExitPanel> exitPanels = new ConcurrentHashMap();
    private ConcurrentHashMap<String, ParkingFloor> parkingFloors = new ConcurrentHashMap();

    // all active parking tickets, identified by their ticketNumber
    private ConcurrentHashMap<String, ParkingTicket> activeTickets = new ConcurrentHashMap();

    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
    // similarly exit panels will also use this object to close parking tickets
    private static ParkingLot parkingLot = null;

    // private constructor to restrict for singleton
    private ParkingLot(String name, Address address, ParkingRate parkingRate, int maxCompactCount, int maxLargeCount, int maxMotorbikeCount, int maxElectricCount) {
        this.name = name;
        // 1. initialize variables: read name, address and parkingRate from database
        // 2. initialize parking floors: read the parking floor map from database,
        //  this map should tell how many parking spots are there on each floor. This
        //  should also initialize max spot counts too.
        // 3. initialize parking spot counts by reading all active tickets from database
        // 4. initialize entrance and exit panels: read from database
        this.address = address;
        this.parkingRate = parkingRate;
        this.maxCompactCount = maxCompactCount;
        this.maxLargeCount = maxLargeCount;
        this.maxMotorbikeCount = maxMotorbikeCount;
        this.maxElectricCount = maxElectricCount;
    }

    // static method to get the singleton instance of StockExchange
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot("MHBP parking lot", new Address(), new ParkingRate(), 100, 50, 50, 50);
        }
        return parkingLot;
    }

    // note that the following method is 'synchronized' to allow multiple entrances
    // panels to issue a new parking ticket without interfering with each other
    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
        if (this.isFull(vehicle.getType())) {
            throw new ParkingFullException();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
        ticket.saveInDB();
        // if the ticket is successfully saved in the database, we can increment the parking spot count
        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public boolean isFull(VehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType.MOTORBIKE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    // increment the parking spot count based on the vehicle type
    private void incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORBIKE) {
            motorbikeSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }

    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!parkingFloors.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }

    public void addParkingFloor(ParkingFloor floor) {
        /* store in database */ }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
        /* store in database */ }

    public void addExitPanel(ExitPanel exitPanel) {
        /* store in database */ }
}
