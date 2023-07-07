package rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.DBconnection;

public class RentUsecase {
    private List<RentModel> rentList;

    public RentUsecase() {
        this.rentList = new ArrayList<>();
    }

        List<RentModel> getRentList() {
        List<RentModel> rentList = new ArrayList<>();
        
        try (Connection connection = DBconnection.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM rents");
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                LocalDate rentDate = resultSet.getDate("rent_date").toLocalDate();
                LocalDate returnDate = resultSet.getDate("return_date").toLocalDate();
                int movieId = resultSet.getInt("movie_id");
                String renter = resultSet.getString("renter");
                
                RentModel rent = new RentModel(id, rentDate, returnDate, movieId, renter);
                rentList.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rentList;
    }

    public void addRent(RentModel rent) {
        rentList.add(rent);
    }

    public void returnRent(int rentId) {
        RentModel rentToReturn = null;
        for (RentModel rent : rentList) {
            if (rent.getId() == rentId) {
                rentToReturn = rent;
                break;
            }
        }
        if (rentToReturn != null) {
            rentList.remove(rentToReturn);
        }
    }

    
}
