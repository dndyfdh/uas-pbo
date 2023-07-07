package rent;

import java.util.List;

public class RentListView {
    public void displayRentList(List<RentModel> rentList) {
        if (rentList.isEmpty()) {
            System.out.println("No rents available.");
        } else {
            System.out.println("Rent List:");
            for (RentModel rent : rentList) {
                System.out.println("Rent ID: " + rent.getId());
                System.out.println("Rent Date: " + rent.getRentDate());
                System.out.println("Return Date: " + rent.getReturnDate());
                System.out.println("Movie ID: " + rent.getMovieId());
                System.out.println("Renter: " + rent.getRenter());
                System.out.println("------------");
            }
        }
    }
    
    public List<RentModel> getRentList() {
        RentUsecase rentUsecase = new RentUsecase();
        return rentUsecase.getRentList();
    }
}
